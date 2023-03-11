package com.jiangchangxiong.addons.mp.core;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Extract the main fields(id, createTime)
 *
 * @author Jiang
 * @since  2023-03-02
 */
@Data
public class BaseEntity implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
