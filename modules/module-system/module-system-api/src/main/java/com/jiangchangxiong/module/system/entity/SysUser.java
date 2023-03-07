package com.jiangchangxiong.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jiangchangxiong.starter.mp.core.UpdateEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * System User
 *
 * @author Jiang
 * @since 2023-03-02
 */
@Setter
@Getter
@TableName("sys_user")
public class SysUser extends UpdateEntity {

	private static final long serialVersionUID = 3090933552454569528L;

	/** 使用类似QQ账号那种生成从5（10000）位开始，一直递增 */
	private String account;

	private String username;

	private String nickname;

	private String realname;

	private String cardNo;

	/** 对应字典CARD_TYPE */
	private String cardType;

	private String birthday;

	private String gender;

	private String phone;

	/** 备用手机号 */
	private String alternatePhone;

	private String email;

	/** 备用邮箱 */
	private String alternateEmail;

	private String location;

	private String description;

	private Boolean enabled;

	/** 是否验证（验证邮箱） */
	private Boolean valid;

	/** 识别最近登录的设备标识码（多个用;进行分割，最多支持3个常用设备） */
//	private String deviceUid;

	/** 用户注销后 */
	@TableLogic(value = "0", delval = "1")
	private Integer isDeleted;

}
