package kviz.etf.bg.ac.rs.membership.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kviz.etf.bg.ac.rs.membership.service.MembershipService;
import kviz.etf.bg.ac.rs.response.PmuResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/membership")
@Tag(name = "Membership controller.", description = "Rest APIs related to membership.")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class MembershipController {

    final MembershipService membershipService;
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
}
