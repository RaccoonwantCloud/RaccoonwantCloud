package kr.datasolution.msa.backemd.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.datasolution.msa.backemd.board.dto.BoardDto;
import kr.datasolution.msa.backemd.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시물 관련 처리 Controller Layer
 */
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    /** 게시물 관련 처리 Service Layer 연결 */
    @Autowired
    private final BoardService boardService;


    /**
     * 게시물 목록 조회 화면 이동
     * @return 게시물 목록 조회 화면 경로
     */
    @Operation(summary = "전체조회",description = "설명")
    @GetMapping("")
    public List<BoardDto> getViewBoardMain() {
        return boardService.getBoardList();
    }

    /**
     * 게시물 상세 조회 화면 이동
     * @param id 게시물 ID
     * @return 게시물 상세 조회 화면 경로
     */
    @Operation(summary = "게시판검색",description = "설명")
    @GetMapping("{id}")
    public BoardDto getViewBoard(
            @PathVariable("id") int id) {

        return boardService.getBoard(id);
    }


    /**
     * 게시물 수정 화면 이동
     * @param id 게시물 ID
     * @return 게시물 수정 화면 경로
     */
    @Operation(summary = "게시판수정",description = "설명")
    @PutMapping("{id}/edit")
    public List<BoardDto> getViewBoardEdit(
            @PathVariable("id") int id,
            @RequestBody BoardDto boardDto
            ) {
        boardService.getBoard(id);
        boardService.modBoard(boardDto);

        return boardService.getBoardList();
    }

    /**
     * 게시물 등록 처리
     * @param boardDto 게시물 등록 데이터
     * @return 게시물 상세 조회 화면 호출
     */
    @Operation(summary = "게시판등록",description = "설명")
    @PostMapping("")
    public void addBoard(
            @RequestBody BoardDto boardDto) {
        boardService.addBoard(boardDto);
    }

    /**
     * 게시물 수정 처리
     * @param boardDto 게시물 수정 데이터
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 호출

    @PutMapping("{id}")
    public String modBoard(
            @PathVariable("id") int id,
            @ModelAttribute BoardDto boardDto,
            ModelMap map) {
        boardDto.setId(id);
        boardService.modBoard(boardDto);
        return "redirect:/board/" + id;
    }
     */
    /**
     * 게시물 삭제 처리
     * @param id 삭제 대상 게시물 ID
     * @return 게시물 목록 조회 화면 호출
     */
    @Operation(summary = "게시판삭제",description = "설명")
    @DeleteMapping("{id}")
    public void removeBoard(
            @PathVariable("id") int id) {
        boardService.removeBoard(id);
    }
}
