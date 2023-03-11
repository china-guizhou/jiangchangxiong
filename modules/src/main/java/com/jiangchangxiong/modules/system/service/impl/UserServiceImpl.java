package com.jiangchangxiong.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiangchangxiong.modules.system.entity.User;
import com.jiangchangxiong.modules.system.mapper.UserMapper;
import com.jiangchangxiong.modules.system.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Jiang
 * @since  2023-03-11
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
