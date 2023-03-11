package com.jiangchangxiong.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiangchangxiong.modules.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jiang
 * @since  2023-03-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
