package com.jiangchangxiong.addons.file.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取文件的参数
 *
 * @author JiangChangXiong
 * @since  2021-11-26
 */
@Getter
@Setter
public class DownloadParam {

    private String destFileName;

    private String destPath;

    private byte[] data;

}
