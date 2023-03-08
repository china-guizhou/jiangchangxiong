package com.jiangchangxiong.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jiangchangxiong.starter.mp.core.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiang
 * @since 2023-03-02
 */
@Setter
@Getter
@TableName("sys_log")
public class Log extends BaseEntity {

	private static final long serialVersionUID = 6459431984176846222L;

}
