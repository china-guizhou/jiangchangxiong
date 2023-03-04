package com.jiangchangxiong.starter.file.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 文件上传的参数
 *
 * @author JiangChangXiong
 * @since  2021-11-26
 */
@Getter
@Setter
public class UploadParam {

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件后缀
     */
    private String fileExt;

    /**
     * 文件后缀
     */
    private String fileType;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 文件类型
     */
    private String contentType;

    /**
     * 文件数据
     */
    private byte[] tempFile;

    /**
     * 是否加密
     */
    private boolean encrypted;

}
