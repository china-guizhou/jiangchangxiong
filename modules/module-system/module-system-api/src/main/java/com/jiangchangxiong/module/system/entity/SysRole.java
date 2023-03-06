package com.jiangchangxiong.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jiangchangxiong.starter.mp.core.UpdateEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiang
 * @since 2023-03-02
 */
@Getter
@Setter
@TableName("sys_role")
public class SysRole extends UpdateEntity {

	private static final long serialVersionUID = -1768215267537890169L;

}
