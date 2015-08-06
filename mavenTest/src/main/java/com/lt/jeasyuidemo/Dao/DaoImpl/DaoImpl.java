package com.lt.jeasyuidemo.Dao;

import java.util.List;

import com.wyhello.jeasyuidemo.pojo.User;

public interface UserDAOImpl implements UserDao {
	
	public List<User> queryAll(){
		List<User> l = new ArrayList<User>();
			
		return 
		
}
	public void add(User u);
}

public RsMappingobject implement RsMappingObject{
	public Object mapper(ResultSet rs){
		 User user = new User();
			user.setId(rs.getInt("id"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setPhone(rs.getString("phone"));
			user.setEmail(rs.getString("email"));
	}	
}

