package kr.datasolution.msa.userback.user.service;

import kr.datasolution.msa.userback.user.dto.UserDto;
import kr.datasolution.msa.userback.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    @Autowired
    private final UserMapper userMapper;
    /** 전체 조회*/
    public List<UserDto> getUserList() {
        return userMapper.findAll();
    }

    /** 사용자 조회*/
    public UserDto getUser(int id){return userMapper.findById(id);}

    /**  사용자 등록*/
    public void addUser(UserDto userDto){userMapper.save(userDto);}
}
