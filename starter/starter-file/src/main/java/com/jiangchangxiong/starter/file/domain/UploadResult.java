package com.jiangchangxiong.starter.file.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 文件上传返回结果
 *
 * @author JiangChangXiong
 * @since  2021-11-26
 */
@Getter
@Setter
public class UploadResult {

    /**
     * 上传结果
     */
    private boolean success;

    /**
     * 文件上传类型 LOCAL SFTP
     */
    private String type;

    /**
     * 源文件名
     */
    private String srcFileName;

    /**
     * 目标文件名
     */
    private String destFileName;

    /**
     * 目标文件路径
     */
    private String destPath;

    /**
     * 用于将文件存储到数据库中
     */
    private byte[] data;

}
