package kviz.etf.bg.ac.rs.user.dto;

import lombok.Data;

@Data
public class UserProfileDto {
    private UserDto userDto;
    private Integer chatroomCount;
    private Integer sectionCount;
}
