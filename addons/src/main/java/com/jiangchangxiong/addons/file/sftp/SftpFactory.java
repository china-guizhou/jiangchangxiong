package com.jiangchangxiong.addons.file.sftp;

import java.util.Properties;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jiangchangxiong.addons.file.properties.SftpProperties;

/**
 * @author JiangChangXiong
 * @since 2021-12-02
 */
public class SftpFactory extends BasePooledObjectFactory<ChannelSftp> {

	private SftpProperties properties;

	public SftpFactory(SftpProperties properties) {
		this.properties = properties;
	}

	/**
	 * 创建sftp连接
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public ChannelSftp create() throws Exception {
		try {
			JSch jsch = new JSch();
			Session sshSession = jsch.getSession(properties.getUsername(), properties.getHost(), properties.getPort());
			sshSession.setPassword(properties.getPassword());
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect(3000);
			ChannelSftp channel = (ChannelSftp) sshSession.openChannel("sftp");
			channel.connect(1000);
			return channel;
		} catch (JSchException e) {
			throw new RuntimeException("连接sfpt失败", e);
		}
	}

	@Override
	public PooledObject<ChannelSftp> wrap(ChannelSftp channelSftp) {
		return new DefaultPooledObject<>(channelSftp);
	}

	public SftpProperties getProperties() {
		return properties;
	}

	public void setProperties(SftpProperties properties) {
		this.properties = properties;
	}

	/**
	 * 销毁对象
	 *
	 * @param p
	 */
	@Override
	public void destroyObject(PooledObject<ChannelSftp> p) {
		ChannelSftp channelSftp = p.getObject();
		channelSftp.disconnect();
	}
}
