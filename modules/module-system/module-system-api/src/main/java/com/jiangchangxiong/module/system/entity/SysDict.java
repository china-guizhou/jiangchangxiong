package com.jiangchangxiong.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
public class SysDict extends UpdateEntity {

	private static final long serialVersionUID = -6856478003586220396L;
}
