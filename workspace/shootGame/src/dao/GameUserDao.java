package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;
import entity.GameUser;

/**
 * 数据访问类：用来对game_user表进行增、删、改、查等数据访问
 */
public class GameUserDao {

	/**
	 * 按name进行查找
	 * @param name 依据的姓名作为条件
	 * @return GameUser对象
	 */
	public GameUser findByName(String name) {
		GameUser user=null;
		Connection conn=DBUtil.getConnection();
		try {
			String sql="select name,score from game_user where name=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int score=rs.getInt("score");
				user=new GameUser();
				user.setName(name);
				user.setScore(score);
			}
			DBUtil.close(conn);
		} catch (SQLException e) {
			System.out.println("按name查询失败");
			e.printStackTrace();
		}
		
		return user;
	}

	/**
	 * 在表中插入一条user记录
	 * @param user 要插入的用户
	 */
	public void insert(GameUser user) {
		Connection conn=DBUtil.getConnection();
		try {
			String sql="insert into game_user values(?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getScore());
			ps.executeUpdate();
			DBUtil.close(conn);
		} catch (SQLException e) {
			System.out.println("插入记录失败");
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 依据name进行更新数据
	 * @param user 要更新的user
	 */
	public void updateByName(GameUser user) {
		Connection conn=DBUtil.getConnection();
		try {
			String sql="update game_user set score=? where name=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, user.getScore());
			ps.setString(2, user.getName());
			ps.executeUpdate();
			DBUtil.close(conn);
		} catch (SQLException e) {
			System.out.println("按name更新失败");
			e.printStackTrace();
		}
	}

	/**
	 * 查询分数最高的前n条
	 * @param n
	 * @return GameUser用户列表
	 */
	public ArrayList<GameUser> findMaxScoreTopN(int n) {
		ArrayList<GameUser> userList=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		String sql="select * from game_user order by score desc limit ?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, n);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
				int score=rs.getInt("score");
				GameUser user=new GameUser();
				user.setName(name);
				user.setScore(score);
				userList.add(user);
			}
			DBUtil.close(conn);
		} catch (SQLException e) {
			System.out.println("查询分数最高的前n条失败");
			e.printStackTrace();
		}
		return userList;
	}
	
	
	
	
	
	
	
	
	
	

}
