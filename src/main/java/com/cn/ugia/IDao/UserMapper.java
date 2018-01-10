package com.cn.ugia.IDao;

import org.springframework.stereotype.Repository;

import com.cn.ugia.domain.User;


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
}