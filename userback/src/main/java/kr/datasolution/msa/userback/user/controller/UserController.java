package kr.datasolution.msa.userback.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.datasolution.msa.userback.user.dto.UserDto;
import kr.datasolution.msa.userback.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @Operation(summary = "전체조회",description = "설명")
    @GetMapping("")
    public List<UserDto> getViewBoardMain() {
        return userService.getUserList();
    }

    @Operation(summary = "유저검색",description = "설명")
    @GetMapping("{id}")
    public UserDto getViewBoard(
            @PathVariable("id") int id) {return userService.getUser(id);}

    @Operation(summary = "유저등록",description = "설명")
    @PostMapping("")
    public void addBoard(
            @RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }
    
}
