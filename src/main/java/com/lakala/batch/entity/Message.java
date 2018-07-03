
package com.lakala.batch.entity;

import com.lakala.batch.dto.UserDto;

/**
 * 
 ************************************************************
 * @类名 : Message.java
 *
 * @DESCRIPTION :
 * @AUTHOR : liaopin
 * @DATE : 2018年5月7日
 ************************************************************
 */
public class Message {
    private Long id;
    private UserDto user;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
