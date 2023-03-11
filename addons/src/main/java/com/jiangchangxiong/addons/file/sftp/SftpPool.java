package com.jiangchangxiong.addons.file.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * @author JiangChangXiong
 * @since  2021-12-02
 */
public class SftpPool {
    private GenericObjectPool<ChannelSftp> pool;

    public SftpPool(SftpFactory factory) {
        this.pool = new GenericObjectPool<>(factory, factory.getProperties().getPool());
    }

    /**
     * 获取一个sftp连接对象
     * @return sftp连接对象
     */
    public ChannelSftp borrowObject() {
        ChannelSftp channelSftp = null;
        try {
            channelSftp = pool.borrowObject();
            if (channelSftp.isClosed()) {
                if (!channelSftp.getSession().isConnected()) {
                    channelSftp.getSession().connect(2000);
                }
                channelSftp.connect(2000);
            }
            // 切换到根目录，防止获取到的不在根目录
            channelSftp.cd(channelSftp.getHome());
            return channelSftp;
        } catch (Exception e) {
            throw new RuntimeException("获取ftp连接失败", e);
        }
    }

    /**
     * 归还一个sftp连接对象
     * @param channelSftp sftp连接对象
     */
    public void returnObject(ChannelSftp channelSftp){
        if (channelSftp != null) {
            try {
                // 切换到根目录
                channelSftp.cd(channelSftp.getHome());
            } catch (SftpException e){
                e.printStackTrace();
            }
            pool.returnObject(channelSftp);
        }
    }

}
