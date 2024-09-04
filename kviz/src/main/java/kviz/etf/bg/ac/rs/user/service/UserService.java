package kviz.etf.bg.ac.rs.user.service;

import kviz.etf.bg.ac.rs.section_ownership.SectionOwnershipEntity;
import kviz.etf.bg.ac.rs.section_ownership.SectionOwnershipRepository;
import kviz.etf.bg.ac.rs.sections.model.SectionEntity;
import kviz.etf.bg.ac.rs.sections.repository.SectionRepository;
import kviz.etf.bg.ac.rs.user.adapter.UserAdapter;
import kviz.etf.bg.ac.rs.user.dto.UserDto;
import kviz.etf.bg.ac.rs.user.dto.UserProfileDto;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import kviz.etf.bg.ac.rs.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepository userRepository;
    final SectionOwnershipRepository sectionOwnershipRepository;
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

    public UserProfileDto getUserInfoForProfile(Integer userId){
        if(userId == null || userId<0){
            return null;
        }
        UserEntity userEntity = userRepository.getUserById(userId);
        List<SectionEntity> sectionEntityList = sectionOwnershipRepository.getSectionsByUserId(userId);

        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setUserDto(UserAdapter.convertEntityToDto(userEntity));
        userProfileDto.setChatroomCount(userEntity.getChatroomEntityList().size());
        userProfileDto.setSectionCount(sectionEntityList.size());//TODO:promeni kad dodas ownership nad sekcijom
        //get broj sekcija koje je napravio to kasnije
        //get chatroom owner

        return userProfileDto;
    }
}
