package com.jiangchangxiong.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.jiangchangxiong.addons.mp.core.UpdateEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiang
 * @since 2023-03-02
 */
@Getter
@Setter
@TableName("sys_role")
public class Role extends UpdateEntity {

	private static final long serialVersionUID = -1768215267537890169L;

	private String code;

	private String name;

	private String description;

	private Boolean enabled;

	private Integer sort;

	/** 数据权限 DataScope 类的常量 */
	private String dataScope;

}
