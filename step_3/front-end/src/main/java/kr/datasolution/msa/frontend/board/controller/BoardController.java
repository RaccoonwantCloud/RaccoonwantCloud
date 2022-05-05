package kr.datasolution.msa.frontend.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.service.BoardService;
import kr.datasolution.msa.frontend.board.service.TestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 게시물 관련 처리 Controller Layer
 */
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    /** 게시물 관련 처리 Service Layer 연결 */
    private final BoardService boardService;
    final TestApiService testApiService;

    /**
     * 게시물 목록 조회 화면 이동
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 목록 조회 화면 경로
     */
    @GetMapping("")
    public String getViewBoardMain(ModelMap map) {
    //  map.put("list", boardService.getBoardList());
        map.put("list", boardService.getBoardList2());

        return "board/main";
    }
    /**
     * 게시물 상세 조회 화면 이동
     * @param id 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 경로
     */
    @GetMapping("{id}")
    public String getViewBoard(
            @PathVariable("id") int id,
            ModelMap map) {
        //map.put("info", boardService.getBoard(id));
        // Mono<BoardDto> MNDto = boardService.getBoard2(id);
        BoardDto boardDto =  boardService.getBoard2(id).block();
        map.put("info", boardDto);
        return "board/info";
    }


    @GetMapping("new")
    public String getViewBoardNew() {
        return "board/new";
    }

    /**
     * 게시물 수정 화면 이동
     * @param id 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 수정 화면 경로
     */
    @GetMapping("{id}/edit")
    public String getViewBoardEdit(
            @PathVariable("id") int id,
            ModelMap map) {
        BoardDto boardDto =  boardService.getBoard2(id).block();
        map.put("info", boardDto);
        return "board/edit";
    }

    /**
     * 게시물 등록 처리
     * @param boardDto 게시물 등록 데이터
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 호출
     */
    @PostMapping("")
    public String addBoard(
            @ModelAttribute BoardDto boardDto,
            ModelMap map) {
       boardService.addBoard2(boardDto);
        return "redirect:/board";
    }

    /**
     * 게시물 수정 처리
     * @param boardDto 게시물 수정 데이터
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 호출
     */
     @PutMapping("{id}")
     public String modBoard(
     @PathVariable("id") int id,
     @ModelAttribute BoardDto boardDto,
     ModelMap map) {
     boardDto.setId(id);
     boardService.modBoard2(boardDto);

     return "redirect:/board/" + id;
     }

    @Operation(summary = "게시판삭제",description = "설명")
    @DeleteMapping("{id}")
    public String removeBoard(
            @PathVariable("id") int id) {
        boardService.removeBoard2(id);
        return "redirect:/board";
    }
}
