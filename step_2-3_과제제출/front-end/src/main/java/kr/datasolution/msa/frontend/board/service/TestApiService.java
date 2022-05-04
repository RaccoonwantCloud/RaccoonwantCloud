package kr.datasolution.msa.frontend.board.service;

import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class TestApiService {
    private final WebClient webClient;
    BoardMapper boardMapper;

    public TestApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
    }
    public BoardDto getFirstTodosTest(int id) {
        boardMapper.findById(id);
        BoardDto response =
                this.webClient.get().uri("/board/" + id)
                        .retrieve().bodyToMono(BoardDto.class)
                        .block();
        System.out.println(response.getId());
        return response;
    }


}
