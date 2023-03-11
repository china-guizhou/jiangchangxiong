package com.jiangchangxiong.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import com.jiangchangxiong.addons.mp.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiang
 * @since 2023-03-02
 */
@Setter
@Getter
@TableName("sys_user_role_rel")
public class UserRole extends BaseEntity {

	private static final long serialVersionUID = -1000155542735142465L;

	@JsonSerialize(using = ToStringSerializer.class)
	private Long userId;

	@JsonSerialize(using = ToStringSerializer.class)
	private Long roleId;

}
