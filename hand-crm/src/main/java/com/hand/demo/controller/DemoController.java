package com.hand.demo.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hand.demo.access.vo.UserVO;
import com.hand.demo.service.UserService;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@RestController
@Api("用户相关api")
public class DemoController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value="用户查询")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query", name="login", value="工号", dataType="String")
	})
	@GetMapping("/user")
	public UserVO getUser(String login) {
		return userService.getUserByLogin(login);
	}
	
	
	@ApiOperation(value="新建用户")
	@PostMapping("/add/user")
	public String addUser(@RequestBody UserVO user) {
		userService.addUser(user);
		return "OK";
	}
	
	
	@ApiOperation(value="修改用户信息")
	@PutMapping("/update/user")
	public String updateUser(@RequestBody UserVO user) {
		userService.update(user);
		return "OK";
	}
	
	
	@ApiOperation(value="删除用户")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query", name="id", value="用户id", dataType="String")
	})
	@Delete("/delete/user")
	public String deleteUser(@RequestParam(name="id")String id) {
		userService.delete(id);
		return "OK";
	}
	
	@ApiOperation(value="用户列表查询")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query", name="login", value="工号", dataType="String"),
		@ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
		@ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int")
	})
	@GetMapping("/users")
	public ServiceData getUsers(String login, int currentPage, int pageSize) {
		UserVO entity = new UserVO();
		entity.setLogin(login);
		PageQuery<UserVO> pageQuery = new PageQuery<UserVO>(entity, currentPage, pageSize);
		return  ServiceData.success(userService.getUsersByLogin(pageQuery), pageQuery.getMapOfPageQuery());
	}
}
