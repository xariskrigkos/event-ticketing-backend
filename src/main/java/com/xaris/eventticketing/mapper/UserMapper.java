package com.xaris.eventticketing.mapper;

import com.xaris.eventticketing.dto.user.UserDTO;
import com.xaris.eventticketing.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDto(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        return dto;
    }
}
