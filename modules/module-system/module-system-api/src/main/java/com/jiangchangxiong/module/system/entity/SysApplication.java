package com.jiangchangxiong.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jiangchangxiong.starter.mp.core.UpdateEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jiangchangxiong
 * @since  2023-03-02
 */
@Getter
@Setter
@TableName("sys_application")
public class SysApplication extends UpdateEntity {

	private static final long serialVersionUID = -41212512411L;
	
	/** unique code */
	private String code;
	
	private String name;
	
	/**  */
	private String publicKey;
	
	private String privateKey;
	
	private Boolean enabled;
	
	@TableLogic(value = "0", delval = "1")
	private Integer isDeleted;
	
}
