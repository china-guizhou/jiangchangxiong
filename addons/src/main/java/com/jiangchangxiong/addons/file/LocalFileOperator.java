package com.jiangchangxiong.addons.file;

import java.io.BufferedInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jiangchangxiong.addons.file.domain.DownloadParam;
import com.jiangchangxiong.addons.file.domain.DownloadResult;
import com.jiangchangxiong.addons.file.domain.UploadParam;
import com.jiangchangxiong.addons.file.domain.UploadResult;
import com.jiangchangxiong.addons.mp.core.UidGenerator;
import com.jiangchangxiong.constants.AppConstant;
import com.jiangchangxiong.utils.FileUtils;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jiang
 * @since 2023-02-21
 */
@Slf4j
@Component
public class LocalFileOperator extends FileOperator {

	@Value("${jcx.file.local.path:}")
	private String path;

	@Value("${jcx.file.tempPath:}")
	private String tempPath;

	@Autowired
	private UidGenerator uidGenerator;

	@Override
	public UploadResult upload(UploadParam param) {
		UploadResult result = new UploadResult();
		result.setType(AppConstant.LOCAL);
		result.setSuccess(false);

		try {
			String destDir = FileUtils.getCurrentUploadPath(path, "/");
			String destFileName = uidGenerator.getUid() + "." + param.getFileExt();
			// 创建目录
			FileUtil.mkdir(destDir);
			FileUtil.writeBytes(param.getTempFile(), destDir + "/" + destFileName);
			result.setDestFileName(destFileName);
			result.setDestPath(destDir);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("上传文件出现异常：{}", e.getMessage(), e);
		}
		return result;
	}

	@Override
	public DownloadResult download(DownloadParam param) {
		DownloadResult result = new DownloadResult();
		result.setSuccess(false);
		try {
			BufferedInputStream in = FileUtil.getInputStream(param.getDestPath() + "/" + param.getDestFileName());
			result.setFileStream(in);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("下载文件出现异常：{}", e.getMessage(), e);
		}
		return result;
	}

	@Override
	public void remove(DownloadParam param) {
		try {
			FileUtil.del(param.getDestPath() + "/" + param.getDestFileName());
		} catch (Exception e) {
			log.error("删除文件出现异常：{}", e.getMessage(), e);
		}
	}

	/**
	 * 没有批量场景，暂时不实现此
	 *
	 * @param param            下载文件参数
	 * @param uuid
	 * @param originalFileName
	 * @return
	 */
	@Override
	public String batchDownload(DownloadParam param, String uuid, String originalFileName) {
		return null;
	}
}
