package com.jiangchangxiong.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jiangchangxiong.starter.mp.core.CreateEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiang
 * @since 2023-03-02
 */
@Setter
@Getter
@TableName("sys_user_role_rel")
public class SysUserRole extends CreateEntity {

	private static final long serialVersionUID = -1000155542735142465L;

}
