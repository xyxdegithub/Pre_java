package cn.tedu.easymall.service;

import cn.tedu.easymall.dao.UserDAO;
import cn.tedu.easymall.entity.User;
import cn.tedu.easymall.util.MD5Util;

public class UserService {
	// 单例模式
	private UserService(){};
	private static UserService instance=new UserService();
	public static UserService getInstance(){
		return instance;
	}
	
	public User login(String username,String password){
		// 调用dao方法，使用用户名查询用户数据
		User user=UserDAO.getInstance().getUserByUsername(username);
		// 查不到 直接返回null
		if(user==null){
			return null;
		}
		// 能查到- 使用用户传入的密码与查询到的密码进行比对
		// 获取查询到的盐值
		int salt=user.getSalt();
		// 基于盐值生成密码
		String newPwd=getNewPwd(salt, password);
		// 基于生成的密码得到密文
		newPwd=MD5Util.md5(newPwd);
		// 将得到的密文与查询到的密码进行比对
		if(newPwd.equals(user.getPassword())){
			// 一致 返回user
			return user;
		}
		
		// 不一致 返回null
		return null;
	}
	
	public String getNewPwd(int salt,String pwd){
		return salt*2+pwd+salt;
	}
	
	public boolean regist(User user){
		// 为用户随机生成一个盐值 1-9
		int salt=(int) Math.ceil(Math.random()*9);
		// 使用盐值对密码明文进行计算
		String newPwd=getNewPwd(salt, user.getPassword());
		// 对计算结果进行MD5加密
		newPwd=MD5Util.md5(newPwd);
		// 将盐值保存到user对象中
		user.setSalt(salt);
		// 将密文保存到user对象中
		user.setPassword(newPwd);
		
		return UserDAO.getInstance().insertUser(user);
	}
	
	public boolean changePwd(String username,String npwd){
		// 为用户随机生成一个盐值 1-9
		int salt=(int) Math.ceil(Math.random()*9);
		// 使用盐值对密码明文进行计算
		String newPwd=getNewPwd(salt, npwd);
		// 对计算结果进行MD5加密
		newPwd=MD5Util.md5(newPwd);
		// 使用User对象封装新数据
		User user=new User(username, newPwd, salt);
		
		return UserDAO.getInstance().updatePassword(user);
	}
	/**
	 * 查询用户名是否存在
	 * @param username 用户名
	 * @return true-用户名存在 false-用户名不存在
	 */
	public boolean hasUsername(String username) {
		User user=UserDAO.getInstance().getUserByUsername(username);
		return user==null?false:true;
	}

}



