package kviz.etf.bg.ac.rs.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kviz.etf.bg.ac.rs.response.PmuResponse;
import kviz.etf.bg.ac.rs.user.dto.UserDto;
import kviz.etf.bg.ac.rs.user.dto.UserProfileDto;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import kviz.etf.bg.ac.rs.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@Tag(name = "User Controller", description = "Rest APIs related to users.")
@AllArgsConstructor
@CrossOrigin(origins = "*") // Dopušta CORS samo za ovaj origin
public class UserController {

    final UserService userService;

    @GetMapping(value = "/getUser/{userId}")
    @Operation(summary = "Getting user by id.")
    public PmuResponse<UserDto> getUserById(@PathVariable Integer userId){

        UserDto userDto = userService.getUserById(userId);

        PmuResponse<UserDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(userDto != null);
        pmuResponse.setDto(userDto);

        return pmuResponse;
    }

    @PostMapping(value = "/authenticateUser")
    @Operation(summary = "Authenticating user.")
    public PmuResponse<UserDto> authenticateUser(@RequestBody UserDto userDto){

        UserDto userDtoResponse = userService.authenticateUser(userDto.getUsername(), userDto.getPassword());

        PmuResponse<UserDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(userDtoResponse != null);
        pmuResponse.setDto(userDtoResponse);

        return pmuResponse;
    }

    @PostMapping(value = "/addUser")
    @Operation(summary = "Adding user.")
    public PmuResponse<UserDto> addUser(@RequestBody UserDto userDto){

        UserDto userDtoResponse = userService.addUser(userDto);

        PmuResponse<UserDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(userDtoResponse != null);
        pmuResponse.setDto(userDto);

        return pmuResponse;
    }

    @DeleteMapping(value = "/deleteUser/{userId}")
    @Operation(summary = "Deleting user.")
    public PmuResponse<String> deleteUser(@PathVariable Integer userId){

        String message = userService.deleteUser(userId);

        PmuResponse<String> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(message.equals("Success."));
        pmuResponse.setDto(message);

        return pmuResponse;
    }

    @PostMapping(value = "/changePassword")
    @Operation(summary = "Changing user's password.")
    public PmuResponse<String> changePassword(@RequestBody UserDto userDto){

        String message = userService.changePassword(userDto);

        PmuResponse<String> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(message.equals("Success."));
        pmuResponse.setDto(message);

        return pmuResponse;
    }

    @GetMapping(value = "/getUserInfoForProfile/{userId}")
    @Operation(summary = "Getting user info by user id.")
    public PmuResponse<UserProfileDto> getUserInfoForProfile(@PathVariable Integer userId){

        UserProfileDto userEntity = userService.getUserInfoForProfile(userId);

        PmuResponse<UserProfileDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(userEntity != null);
        pmuResponse.setDto(userEntity);

        return pmuResponse;
    }
}
