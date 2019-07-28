package com.hand.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.demo.access.dao.UserDao;
import com.hand.demo.access.vo.UserVO;
import com.hand.frame.util.PageQuery;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserVO getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

	@Override
	public void addUser(UserVO user) {
		userDao.addUser(user);
	}

	@Override
	public void update(UserVO user) {
		userDao.update(user);
	}

	@Override
	public void delete(String id) {
		userDao.delete(id);
	}

	@Override
	public List<UserVO> getUsersByLogin(PageQuery<UserVO> pageQuery) {
		int count = userDao.getUsersByLoginCount(pageQuery);
		pageQuery.setCount(count);
		if(count > 0) {
			return userDao.getUsersByLogin(pageQuery);
		}
		return null;
	}
}
