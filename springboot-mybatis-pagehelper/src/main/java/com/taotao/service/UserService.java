package com.taotao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.PageBean;
import com.taotao.entity.UserEntity;
import com.taotao.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public PageBean<UserEntity> findUserByPage(Integer page, Integer pageSize) {

		PageHelper.startPage(page, pageSize);
		
		
		List<UserEntity> all = userMapper.getAll();
		System.out.println(all.toString());
		
		PageInfo<UserEntity> info =new PageInfo<>(all);
		
		PageBean<UserEntity> pageBean = new PageBean<>(page,pageSize,(int) info.getTotal());
	
		pageBean.setItems(info.getList());
		
		return pageBean;
	}
	
}
