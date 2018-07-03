package com.lakala.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.util.StringUtils;

import com.lakala.batch.dto.UserDto;
import com.lakala.batch.entity.Message;

/**
 * 
 ************************************************************
 * @类名 : MessagesItemProcessor.java
 *
 * @DESCRIPTION :
 * @AUTHOR : liaopin
 * @DATE : 2018年5月7日
 ************************************************************
 */
public class MessagesItemProcessor implements ItemProcessor<UserDto, Message> {

    public Message process(UserDto user) throws Exception {
        if (!StringUtils.hasText(user.getName())) {
            throw new RuntimeException("The user name is required!");
        }
        Message m = new Message();
        m.setUser(user);
        m.setContent("Hello " + user.getName() + ",这是处理数据的processor");
        return m;
    }

}
