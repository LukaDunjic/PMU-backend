package kviz.etf.bg.ac.rs.user.dto;

import lombok.Data;

@Data
public class UserDto {
    Integer userId;
    String username;
    String password;
    String name;
    String surname;
}
