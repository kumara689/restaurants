package org.gov.tech.restaurants.dto;

import lombok.Data;
import org.gov.tech.restaurants.model.User;
import org.springframework.beans.BeanUtils;

@Data
public class UserDto {
    private String id;
    private String name;

    public static UserDto modelToDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public static User dtoToModel(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
}
