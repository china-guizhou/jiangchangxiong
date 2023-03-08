package com.jiangchangxiong.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jiangchangxiong.starter.mp.core.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiang
 * @since 2023-03-02
 */
@Setter
@Getter
@TableName("sys_role_resource_rel")
public class RoleResource extends BaseEntity {

	private static final long serialVersionUID = -5242157265530656170L;

	@JsonSerialize(using = ToStringSerializer.class)
	private Long roleId;

	@JsonSerialize(using = ToStringSerializer.class)
	private Long resourceId;

}
