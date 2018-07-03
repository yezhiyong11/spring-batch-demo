package com.lakala.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.task.TaskExecutor;
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
public class MutiThreadMessagesItemProcessor implements ItemProcessor<UserDto, Message> {
    private TaskExecutor taskExecutor;

    public Message process(UserDto user) throws Exception {
        taskExecutor.execute(new Runnable() {
            @SuppressWarnings("static-access")
            public void run() {
                try {
                    Thread current = Thread.currentThread();
                    System.out.println("@process: " + "  " + current.getId());
                    System.out.println("@getName: " + current.getName());
                    System.out.println("@activeCount: " + current.activeCount());
                    System.out.println("@getId: " + current.getId());
                    System.out.println("@toString: " + current.toString());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        if (!StringUtils.hasText(user.getName())) {
            throw new RuntimeException("The user name is required!");
        }
        Message m = new Message();
        m.setUser(user);
        m.setContent("Hello " + user.getName() + ",please pay promptly at end of this month.");
        return m;
    }

}
