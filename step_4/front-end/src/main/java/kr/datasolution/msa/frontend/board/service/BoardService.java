package kr.datasolution.msa.frontend.board.service;

import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 게시물 관련 처리 Service Layer
 */
@Component
@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService{
   private final BoardMapper boardMapper;

   private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:9090/boord")
         //  .baseUrl("http://localhost:8082/boord/")
           .build();

/*


    public BoardService(WebClient.Builder weBuilder){
        this.webClient = WebClient.builder().baseUrl("http//localhost:8082").build();
    }
*/

   // private  final WebClient webClient = builder.build();



    /**
     * 전체 게시물 리스트 조회
     * @return 전체 게시물 리스트
     */
    public List<BoardDto> getBoardList() {
         return boardMapper.findAll();
        // return  webClient.get().uri("").retrieve().bodyToFlux(BoardDto.class);
    }
    public List<BoardDto> getBoardList2() {
        return webClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(BoardDto.class)
                .toStream()
                .collect(Collectors.toList());
    }
    /**
     * 지정 게시물 상세 조회
     * @param id 게시물 ID
     * @return 지정 게시물
     */
    public BoardDto getBoard(int id) {
        return boardMapper.findById(id);
    }
    public Mono<BoardDto> getBoard2(int id) {
        return webClient.get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(BoardDto.class);
                }


    /**
     * 게시물 등록 처리
     * @param boardDto 게시물 등록 데이터
     */
    public void addBoard(BoardDto boardDto) {
        int count = boardMapper.save(boardDto);
        log.info("BOARD INSERT COUNT : {}", count);
    }

    public Void addBoard2(BoardDto boardDto){
        return webClient.post()
                .uri("")
                .bodyValue(boardDto)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    /**
     * 게시물 수정 처리
     * @param boardDto 게시물 수정 데이터
     */
    public void modBoard(BoardDto boardDto) {
        int count = boardMapper.update(boardDto);
        log.info("BOARD UPDATE COUNT : {}", count);
    }

    public Void modBoard2(int id, BoardDto boardDto){
        boardMapper.findById(id);
        return webClient.put()
                .uri("/"+id)
                .body(Mono.just(boardDto), PostMapping.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    /**
     * 게시물 삭제 처리
     * @param id 게시물 ID
     */
    public void removeBoard(int id) {
        int count = boardMapper.deleteById(id);
        log.info("BOARD DELETE COUNT : {}", count);
    }

    public Void removeBoard2(int id){
        return webClient.delete()
                .uri("/"+id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}
