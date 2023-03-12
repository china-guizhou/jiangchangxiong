package com.jiangchangxiong.modules.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.jiangchangxiong.common.R;
import com.jiangchangxiong.modules.system.entity.User;
import com.jiangchangxiong.modules.system.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang
 * @since  2023-03-11
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;


    @PostMapping("/page")
    public R<List<User>> page() {
        List<User> users = new ArrayList<>();
        User u = new User();
        u.setAccount("afasg");
        u.setUsername(StpUtil.getLoginIdAsString());
        users.add(u);
        return R.success(users);
    }

}
