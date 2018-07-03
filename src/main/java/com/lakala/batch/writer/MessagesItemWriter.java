
package com.lakala.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.lakala.batch.entity.Message;

/**
 * 
 ************************************************************
 * @类名 : MessagesItemWriter.java
 *
 * @DESCRIPTION :
 * @AUTHOR : liaopin
 * @DATE : 2018年5月7日
 ************************************************************
 */
public class MessagesItemWriter implements ItemWriter<Message> {

    public void write(List<? extends Message> messages) throws Exception {
        System.out.println("写结果");
        for (Message m : messages) {
            System.out.println(m.getContent());
        }
    }
}
