package com.jiangchangxiong.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.jiangchangxiong.addons.mp.core.UpdateEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiang
 * @since 2023-03-02
 */
@Setter
@Getter
@TableName("sys_parameter")
public class Parameter extends UpdateEntity {

	private static final long serialVersionUID = -2443440164128695029L;

	private String code;

	private String name;

	private Integer sort;

	private String description;

	private Boolean enabled;

}
