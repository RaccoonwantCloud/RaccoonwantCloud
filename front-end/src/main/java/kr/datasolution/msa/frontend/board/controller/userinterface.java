package kr.datasolution.msa.frontend.board.controller;

import kr.datasolution.msa.frontend.board.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "userInfo", url = "http://localhost:9090/user/")
public interface userinterface {
    @GetMapping("")
    public List<UserDto> getUser();

}
