package kr.datasolution.msa.userback.user.mapper;

import kr.datasolution.msa.userback.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**사용자 전체조회*/
    List<UserDto> findAll();
    /**사용자 검색*/
    UserDto findById(int id);
    /**사용자 등록*/
    void save(UserDto userDto);



}
