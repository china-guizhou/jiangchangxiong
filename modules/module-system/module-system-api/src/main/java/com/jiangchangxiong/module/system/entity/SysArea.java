package com.jiangchangxiong.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jiangchangxiong.starter.mp.core.UpdateEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiang
 * @since 2023-03-03
 */
@Getter
@Setter
@TableName("sys_area")
public class SysArea extends UpdateEntity {

	private static final long serialVersionUID = 6784156695659168217L;

	private String code;

	private String name;

}
