package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.common.PageBean;
import com.taotao.entity.UserEntity;
import com.taotao.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "user接口", tags = "user接口")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("users")
	@ApiOperation(value = "获取所有user", notes = "获取所有user")
	public PageBean<UserEntity> findUser(@RequestParam(defaultValue="2")Integer page,
			@RequestParam(defaultValue="3")Integer pageSize){
		
		PageBean<UserEntity> pageBean = userService.findUserByPage(page,pageSize);
		return pageBean;
	}
}
