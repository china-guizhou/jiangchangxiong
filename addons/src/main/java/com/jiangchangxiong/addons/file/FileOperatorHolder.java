package com.jiangchangxiong.addons.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用于在运行时获取该条数据使用的存储方式，并通过这个操作方式去获取数据
 *
 * @author Jiang
 * @since  2022-01-16
 */
@Component
@RequiredArgsConstructor
public class FileOperatorHolder {

    private final SftpFileOperator sftpFileOperator;

    private final LocalFileOperator localFileOperator;

    public FileOperator instance(String operator) {
        if ("SFTP".equals(operator)) {
            return sftpFileOperator;
        }
        // 默认使用本地存储
        return localFileOperator;
    }

}
