package kviz.etf.bg.ac.rs.user.service;

import kviz.etf.bg.ac.rs.user.adapter.UserAdapter;
import kviz.etf.bg.ac.rs.user.dto.UserDto;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import kviz.etf.bg.ac.rs.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepository userRepository;

    public UserDto authenticateUser(String username, String password){
        UserEntity userEntity = userRepository.authenticateUser(username, password);
        if(userEntity != null){
            return UserAdapter.convertEntityToDto(userEntity);
        }
        return null;
    }

    public UserDto getUserById(Integer userId){
        UserEntity userEntity = userRepository.getUserById(userId);
        if(userEntity!=null){
            return UserAdapter.convertEntityToDto(userEntity);
        }
        return null;
    }

    public UserDto addUser(UserDto userDto){

        UserEntity userEntity = UserAdapter.convertDtoToEntity(userDto);

        UserEntity userEntity1 = userRepository.getUserByUsername(userEntity.getUsername());
        if(userEntity1!=null) {
            return null;
        }

        UserEntity userEntity2 = userRepository.save(userEntity);
        return UserAdapter.convertEntityToDto(userEntity2);
    }

    public String deleteUser(Integer userId){

        UserEntity userEntity = userRepository.getUserById(userId);
        if(userEntity==null) {
            return "User does not exists.";
        }
        userRepository.deleteById(userId);
        return "Success.";
    }

    public String changePassword(UserDto userDto){
        UserEntity userEntity = UserAdapter.convertDtoToEntity(userDto);

        UserEntity userEntity1 = userRepository.getUserByUsername(userEntity.getUsername());
        if(userEntity1==null) {
            return "User does not exists.";
        }
        userRepository.save(userEntity);
        return "Success.";
    }

}
