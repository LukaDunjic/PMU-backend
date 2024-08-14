package kviz.etf.bg.ac.rs.chatroom.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kviz.etf.bg.ac.rs.chatroom.dto.ChatroomDto;
import kviz.etf.bg.ac.rs.chatroom.service.ChatroomService;
import kviz.etf.bg.ac.rs.response.PmuResponse;
import kviz.etf.bg.ac.rs.user.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/chatrooms")
@Tag(name = "Chatroom controller.", description = "Rest APIs related to chatroom.")
@AllArgsConstructor
public class ChatroomController {

    final ChatroomService chatroomService;

    @GetMapping(value = "/getChatroomById/{chatroomId}")
    @Operation(summary = "Getting chatroom by chatroomId.")
    public PmuResponse<ChatroomDto> getChatroomById(@PathVariable Integer chatroomId){
        ChatroomDto chatroomDto = chatroomService.getCharoomById(chatroomId);

        PmuResponse<ChatroomDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(chatroomDto != null);
        pmuResponse.setDto(chatroomDto);

        return pmuResponse;
    }

    @PostMapping(value = "/addChatroom")
    @Operation(summary = "Adding new chatroom.")
    public PmuResponse<ChatroomDto> addChatroom(@RequestBody ChatroomDto chatroomDto){
        ChatroomDto chatroomDtoResonse = chatroomService.addChatroom(chatroomDto);

        PmuResponse<ChatroomDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(chatroomDtoResonse != null);
        pmuResponse.setDto(chatroomDto);

        return pmuResponse;
    }

    @DeleteMapping(value = "/deleteChatroomById/{chatroomId}")
    @Operation(summary = "Getting chatroom by chatroomId.")
    public PmuResponse<String> deleteChatroom(@PathVariable Integer chatroomId){
        String message = chatroomService.deleteChatroom(chatroomId);

        PmuResponse<String> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(message.equals("Success."));
        pmuResponse.setDto(message);

        return pmuResponse;
    }
}
