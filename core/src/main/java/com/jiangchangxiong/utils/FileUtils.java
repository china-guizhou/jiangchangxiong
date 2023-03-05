package com.jiangchangxiong.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.io.FileUtil;

/**
 * 
 *
 * @since  Mar 5, 2023
 * @author jiangchangxiong
 */
public class FileUtils extends FileUtil {
	
	/**
     * 获取
     *  年/月/日/文件  策略下的上床文件路径，带/后缀
     *
     * @param basePath
     * @return
     */
    public static String getCurrentUploadPath(String basePath, String separator) {
        String currentDate = DateUtils.format(LocalDateTime.now(), DatePattern.NORM_DATE_PATTERN);
        String[] dateSplit = currentDate.split("-");
        String year = dateSplit[0];
        String month = dateSplit[1];
        String day = dateSplit[2];
       
        return basePath.concat(separator).concat(year)
                .concat(separator).concat(month).concat(separator)
                .concat(day).concat(separator);
    }

    /**
     * 获取
     *  年/月/日/文件  策略下的上床文件路径，带/后缀
     *
     * @param basePath
     * @return
     */
    public static String getCurrentDownloadPath(String basePath, String suffix) {
        return basePath.concat(suffix);
    }

    /**
     * 如果路径不存在，就一步一步创建，返回路径所代表的{@link File}对象
     *
     * @param path  路径
     * @return      {@link File}
     */
    public static File mkPath(String path) throws IOException {
        File dest = new File(path);
        if (!dest.exists()) {
            dest.getParentFile().mkdirs();
            dest.createNewFile();
        }
        return dest;
    }

    /**
     * 将数据copy到目标文件
     *
     * @param src   源数据
     * @param dest  目标文件
     */
    public static long copyByte(InputStream src, OutputStream dest) throws IOException {
        byte[] temp = new byte[8192];
        long nread = 0L;
        int n;
        while ((n = src.read(temp)) > 0) {
            dest.write(temp, 0, n);
            nread += n;
        }
        dest.flush();
        return nread;
    }

    /**
     * 将路径按照顺序拼接在一起
     *
     * @param base      基础路径
     * @param optional
     * @return
     */
    public static String join(String base, String ...optional) {
        if (!StrUtils.isBlank(base)) {
            return null;
        }
        Path p = Paths.get(base, optional);
        return p.toString();
    }

    /**
     * 获取文件的后缀名
     * 就简单的获取文件名称的后缀
     * 复杂应该获取文件的类型来判断类型
     *
     * @param fileName：文件名称
     * @return          后缀
     */
    public static String getSimpleSuffix(String fileName) {
        if (StrUtils.isBlank(fileName)) {
            return "";
        }
        String suffix = "";
        int i = fileName.lastIndexOf(".");
        // 如果不是-1表示该字符串中存在.
        if (i != -1) {
            suffix = fileName.substring(i + 1);
        }
        return suffix;
    }
    
}
