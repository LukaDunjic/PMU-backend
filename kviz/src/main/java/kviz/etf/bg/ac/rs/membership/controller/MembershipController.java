package kviz.etf.bg.ac.rs.membership.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kviz.etf.bg.ac.rs.chatroom.dto.ChatroomDto;
import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import kviz.etf.bg.ac.rs.membership.repository.MembershipRepository;
import kviz.etf.bg.ac.rs.membership.service.MembershipService;
import kviz.etf.bg.ac.rs.response.PmuResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/membership")
@Tag(name = "Membership controller.", description = "Rest APIs related to membership.")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class MembershipController {

    final MembershipService membershipService;
    final MembershipRepository membershipRepository;

    @PostMapping(value = "/joinChatroom/{userId}/{chatroomId}")
    @Operation(summary = "Adding new membership.")
    public PmuResponse<String> joinChatroom(
            @PathVariable("userId") Integer userId,
            @PathVariable("chatroomId") Integer chatroomId
    ){
        membershipService.joinChatroom(userId, chatroomId);

        PmuResponse<String> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        pmuResponse.setDto("Success.");
        return pmuResponse;
    }

    @DeleteMapping(value = "/leaveChatroom/{userId}/{chatroomId}")
    @Operation(summary = "Deleting membership.")
    public PmuResponse<String> leaveChatroom(
            @PathVariable("userId") Integer userId,
            @PathVariable("chatroomId") Integer chatroomId
    ){
        membershipService.leaveChatroom(userId, chatroomId);

        PmuResponse<String> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        pmuResponse.setDto("Success.");
        return pmuResponse;
    }

    @GetMapping(value = "/getAllChatroomsByUserId/{userId}")
    @Operation(summary = "Getting all chatrooms for specific user.")
    public PmuResponse<List<ChatroomDto>> getAllChatroomsForUser(
            @PathVariable("userId") Integer userId
    ){
        List<ChatroomDto> chatroomDtoList = membershipService.getAllChatroomsForUser(userId);

        PmuResponse<List<ChatroomDto>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        pmuResponse.setDto(chatroomDtoList);
        return pmuResponse;
    }

    @GetMapping(value = "/getNumOfMembershipForChatroomId/{userId}")
    @Operation(summary = "Getting all chatrooms for specific user.")
    public PmuResponse<List<Integer>> getNumOfMembershipForChatroomId(
            @PathVariable("userId") Integer userId){
        List<ChatroomEntity>  chatroomEntityList = membershipRepository.getAllChatroomsForUser(userId);
        List<Integer> nums = new ArrayList<>();

        chatroomEntityList.forEach(element->{
            nums.add(membershipRepository.getNumOfMembershipForChatroomId(element.getChatroomId()));
        });

        PmuResponse<List<Integer>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        pmuResponse.setDto(nums);
        return pmuResponse;
    }
}
