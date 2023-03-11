package com.jiangchangxiong.addons.file.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;

/**
 * @author JiangChangXiong
 * @since  2021-11-26
 */
@Getter
@Setter
public class DownloadResult {

    private boolean success;

    private InputStream fileStream;

}
