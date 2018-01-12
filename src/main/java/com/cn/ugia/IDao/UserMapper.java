package com.cn.ugia.IDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.ugia.domain.User;
import com.cn.ugia.util.Page;


public interface UserMapper {
    /**
     *
     * @mbggenerated 2018-01-09
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-01-09
     */
    int insert(User record);

    /**
     *
     * @mbggenerated 2018-01-09
     */
    int insertSelective(User record);

    /**
     *
     * @mbggenerated 2018-01-09
     */
    User selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-01-09
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbggenerated 2018-01-09
     */
    int updateByPrimaryKey(User record);
    
    List<User> listUser();
    List<User> listUser(Page page);
    int total();
    void saveUser(User user);
}