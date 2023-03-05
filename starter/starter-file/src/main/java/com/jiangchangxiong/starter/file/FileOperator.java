package com.jiangchangxiong.starter.file;

import com.jiangchangxiong.starter.file.domain.DownloadParam;
import com.jiangchangxiong.starter.file.domain.DownloadResult;
import com.jiangchangxiong.starter.file.domain.UploadParam;
import com.jiangchangxiong.starter.file.domain.UploadResult;

/**
 * 统一暴露的文件操作接口
 * 包含抽象的文件操作方法
 * 文件验证、加密登操作
 *
 * @author JiangChangXiong
 * @since  2021-11-26
 */
public abstract class FileOperator {

    /**
     * 上传文件
     *
     *
     * @param param 上传参数封装
     * @return  {@link UploadResult}上传结果
     */
    public abstract UploadResult upload(UploadParam param);


    /**
     * 下载文件
     *
     * @param param 下载文件参数
     * @return  {@link DownloadResult}下载结果
     */
    public abstract DownloadResult download(DownloadParam param);

    /**
     * 删除文件
     *
     * @param param 删除文件参数
     */
    public abstract void remove(DownloadParam param);

    /**
     * 批量下载文件
     *
     * @param param 下载文件参数
     * @param uuid
     * @param originalFileName
     * @return  {@link DownloadResult}下载结果
     */
    public abstract String batchDownload(DownloadParam param, String uuid, String originalFileName);
}
