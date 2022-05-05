package kr.datasolution.msa.frontend.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDto {
    /** 게시물 ID*/
    private int id;
    /** 사용자 이름*/
    private String NM;
}
