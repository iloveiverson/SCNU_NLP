package com.nlp.mapper;

import com.nlp.model.User;

/**
 * Created by WSnL on 2017/8/16.
 */
public interface UserMapper {
    int add(User user);
    User findOne(User user);
}
