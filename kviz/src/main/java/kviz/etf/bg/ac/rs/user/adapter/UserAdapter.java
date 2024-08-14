package kviz.etf.bg.ac.rs.user.adapter;

import kviz.etf.bg.ac.rs.user.dto.UserDto;
import kviz.etf.bg.ac.rs.user.model.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter {

    public static UserDto convertEntityToDto(UserEntity userEntity){

        UserDto userDto = new UserDto();
        userDto.setUserId(userEntity.getUserid());
        userDto.setName(userEntity.getName());
        userDto.setSurname(userEntity.getSurname());
        userDto.setUsername(userEntity.getUsername());
        userDto.setPassword(userEntity.getPassword());

        return userDto;
    }

    public static UserEntity convertDtoToEntity(UserDto userDto){

        UserEntity userEntity = new UserEntity();
        userEntity.setUserid(userDto.getUserId());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setName(userDto.getName());
        userEntity.setSurname(userDto.getSurname());

        return userEntity;
    }

    public static List<UserDto> convertEntityToDtoList(List<UserEntity> userEntityList){

        List<UserDto> userDtoList = new ArrayList<>();

        userEntityList.forEach(element-> userDtoList.add(convertEntityToDto(element))
        );

        return userDtoList;
    }

    public static List<UserEntity> convertDtoToEntityList(List<UserDto> userDtoList){

        List<UserEntity> userEntityList = new ArrayList<>();

        userDtoList.forEach(element-> userEntityList.add(convertDtoToEntity(element))
        );

        return userEntityList;
    }
}
