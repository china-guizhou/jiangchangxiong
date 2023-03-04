package com.jiangchangxiong.starter.mp.core;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * Extract createBy field
 *
 * @author Jiang
 * @since  2023-03-02
 */
@Data
public class CreateEntity extends BaseEntity {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

}
