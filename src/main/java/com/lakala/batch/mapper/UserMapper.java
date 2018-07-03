/**
 * 
 */
package com.lakala.batch.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.lakala.batch.dto.UserDto;

/**
 ************************************************************
 * @类名 : UserMapper.java
 *
 * @DESCRIPTION :
 * @AUTHOR : liaopin
 * @DATE : 2018年5月7日
 ************************************************************
 */
public class UserMapper implements FieldSetMapper<UserDto> {

    public UserDto mapFieldSet(FieldSet fieldSet) throws BindException {
        UserDto u = new UserDto();
        u.setName(fieldSet.readString(0));
        u.setAge(fieldSet.readInt(1));
        return u;
    }

}
