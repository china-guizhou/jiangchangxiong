package com.jiangchangxiong.starter.file;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import com.jiangchangxiong.constants.AppConstant;
import com.jiangchangxiong.starter.file.domain.DownloadParam;
import com.jiangchangxiong.starter.file.domain.DownloadResult;
import com.jiangchangxiong.starter.file.domain.UploadParam;
import com.jiangchangxiong.starter.file.domain.UploadResult;
import com.jiangchangxiong.starter.file.sftp.SftpPool;
import com.jiangchangxiong.starter.mp.meta.UidGenerator;
import com.jiangchangxiong.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * 适用SFTP的文件操作类
 *
 * @author JiangChangXiong
 * @since  2021-11-29
 */
@Slf4j
@Component
public class SftpFileOperator extends FileOperator{

    private SftpPool pool;

    @Value("${satp.cat.file.sftp.path:}")
    private String path;

    @Value("${satp.cat.file.tempPath:}")
    private String tempPath;

    @Autowired
    private UidGenerator uidGenerator;

    public SftpFileOperator(SftpPool pool) {
        this.pool = pool;
    }

    @Override
    public UploadResult upload(UploadParam param) {
        // 从连接池获取Sftp连接
        ChannelSftp sftp = pool.borrowObject();
        UploadResult result = new UploadResult();
        result.setType(AppConstant.SFTP);
        result.setSuccess(false);
        try {
        
            String destDir = FileUtils.getCurrentUploadPath(path, "/");
            String destFileName = uidGenerator.getUid() + "." + param.getFileExt();
            mkdirs(sftp, destDir);
            // 创建目录时已经切到最底层了
//            sftp.cd(destDir);
            sftp.put(new ByteArrayInputStream(param.getTempFile()), destFileName);
            result.setSuccess(true);
            result.setDestFileName(destFileName);
            String osName = System.getProperty("os.name");
            if (!destDir.startsWith("/") && osName.startsWith("Windows")) {
                // 相对路径转换为绝对路径
                destDir = "/" + destDir;
            }
            result.setDestPath(destDir);
        } catch (SftpException e) {
            log.error("上传出现异常：{}", e.getMessage(), e);
        } finally {
            // 归还sftp连接
            pool.returnObject(sftp);
        }
        return result;
    }

    /**
     * 递归创建多级目录
     * @param dirPath 多级目录
     */
    private void mkdirs(ChannelSftp sftp, String dirPath) {
        if (dirPath != null && !dirPath.isEmpty() && sftp != null) {
            String[] dirs = Arrays.stream(dirPath.split("/")).filter(StringUtils::isNotBlank).toArray(String[]::new);
            for (String dir : dirs) {
                try {
                    sftp.cd(dir);
                } catch (Exception e) {
                    try {
                        sftp.mkdir(dir);
                    } catch (SftpException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        sftp.cd(dir);
                    } catch (SftpException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public DownloadResult download(DownloadParam param) {
        ChannelSftp sftp = pool.borrowObject();
        DownloadResult result = new DownloadResult();
        result.setSuccess(false);
        try {
            sftp.cd(param.getDestPath());
            InputStream in = sftp.get(param.getDestFileName());
            result.setSuccess(true);
            result.setFileStream(in);
        } catch (SftpException e) {
            log.error("下载出现异常: {}", e.getMessage(), e);
        } finally {
            // 归还sftp连接
            pool.returnObject(sftp);
        }
        return result;
    }

    /**
     * 批量下载文件
     *
     * @param param 下载文件参数
     * @param uuid
     * @param originalFileName
     * @return {@link String}下载结果路径
     */
    @Override
    public String batchDownload(DownloadParam param, String uuid, String originalFileName) {
        ChannelSftp sftp = pool.borrowObject();
        DownloadResult result = new DownloadResult();
        result.setSuccess(false);
        File localFile = null;
        //本地存放地址（先存放到本地,等跑完后会从本地删除）
        String localPath = FileUtils.getCurrentDownloadPath(tempPath, "/" + uuid + "/");
        File tempDir = new File(localPath);
        if (!tempDir.exists()) {
            // 文件夹不存在就创建文件夹
            tempDir.mkdirs();
        }
        // Sftp下载路径
        String sftpPathDay = param.getDestPath();
        int index;
        byte[] bytes = new byte[1024];
        try {
            sftp.cd(sftpPathDay);
            InputStream input = sftp.get(param.getDestFileName());

            localFile = new File(localPath + "/" + uidGenerator.getUid() + "-" + originalFileName);
            if (!localFile.getParentFile().exists()) {
                localFile.getParentFile().mkdirs();
                localFile.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(localFile);
            while ((index = input.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, index);
                fileOutputStream.flush();
            }
            input.close();
            fileOutputStream.close();
        }catch (SftpException | IOException e) {
            log.error("批量下载出现异常：{}", e.getMessage(), e);
        } finally {
            // 归还sftp连接
            pool.returnObject(sftp);
        }
        return localPath;
    }


    /**
     * 删除文件
     *
     * @param param 删除文件参数
     */
    @Override
    public void remove(DownloadParam param) {
        ChannelSftp sftp = pool.borrowObject();
        try {
            sftp.cd(param.getDestPath());
            sftp.rm(param.getDestFileName());
        } catch (SftpException e) {
            e.printStackTrace();
        } finally {
            // 归还sftp连接
            pool.returnObject(sftp);
        }
    }

}
