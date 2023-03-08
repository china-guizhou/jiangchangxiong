package com.jiangchangxiong.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jiangchangxiong.starter.mp.core.UpdateEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jiangchangxiong
 * @since 2023-03-02
 */
@Getter
@Setter
@TableName("sys_dict")
public class Dict extends UpdateEntity {

	private static final long serialVersionUID = -6856478003586220396L;

	private String code;

	private String name;

	private Integer sort;

	private Boolean enabled;

	@JsonSerialize(using = ToStringSerializer.class)
	private Long parentId;

	private String description;

}
