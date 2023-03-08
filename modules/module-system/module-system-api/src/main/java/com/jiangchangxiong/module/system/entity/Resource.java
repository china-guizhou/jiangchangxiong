package com.jiangchangxiong.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jiangchangxiong.starter.mp.core.UpdateEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiang
 * @since 2023-03-02
 */
@Setter
@Getter
@TableName("sys_resource")
public class Resource extends UpdateEntity {

	private static final long serialVersionUID = 4678080862810948781L;

	@JsonSerialize(using = ToStringSerializer.class)
	private Long appId;

	private String type;

	private String name;

	private String description;

	private String icon;

	private String layout;

	private Boolean hidden;

	private Boolean blank;

	private String path;

	private String component;

	private String permission;

	private Integer sort;

	private Boolean enabled;

}
