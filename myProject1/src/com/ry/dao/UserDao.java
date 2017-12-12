package com.ry.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ry.pojo.Fun;
import com.ry.pojo.User;

@Component("userDao")
public interface UserDao {
	int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByUserAccount(String userAccount);
    
    List<User> selectAll();
    
    Long selectCount();
    
    void callProcedure(Map map);
	
	
}
