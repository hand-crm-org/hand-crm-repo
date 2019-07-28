package com.hand.demo.access.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hand.demo.access.vo.UserVO;
import com.hand.frame.util.PageQuery;

@Repository
public interface UserDao {

	/**
	 * 通过工号查询员工
	 * @param login
	 * @return
	 */
	UserVO getUserByLogin(String login);
	
	/**
	 * 新增用户
	 * @param user
	 */
	void addUser(UserVO user);
	
	/**
	 * 修改用户
	 * @param user
	 */
	void update(UserVO user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * 通过工号查询员工
	 * @param login
	 * @return
	 */
	List<UserVO> getUsersByLogin(PageQuery<UserVO> pageQuery);
	
	/**
	 * 通过工号查询员工 计数
	 * @param entity
	 * @return
	 */
	int getUsersByLoginCount(PageQuery<UserVO> pageQuery);
}
