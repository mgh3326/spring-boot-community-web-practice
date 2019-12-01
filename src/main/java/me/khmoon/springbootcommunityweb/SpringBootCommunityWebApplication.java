package me.khmoon.springbootcommunityweb;

import me.khmoon.springbootcommunityweb.domain.Board;
import me.khmoon.springbootcommunityweb.domain.User;
import me.khmoon.springbootcommunityweb.domain.enums.BoardType;
import me.khmoon.springbootcommunityweb.repository.BoardRepository;
import me.khmoon.springbootcommunityweb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootCommunityWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootCommunityWebApplication.class, args);
  }

  @Bean
  public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) throws Exception {
    return (args) -> {
      User user = userRepository.save(User.builder()
              .name("havi")
              .password("test")
              .email("havi@gmail.com")
              .createdDate(LocalDateTime.now())
              .build());

      IntStream.rangeClosed(1, 200).forEach(index ->
              boardRepository.save(Board.builder()
                      .title("게시글"+index)
                      .subTitle("순서"+index)
                      .content("컨텐츠")
                      .boardType(BoardType.free)
                      .createdDate(LocalDateTime.now())
                      .updatedDate(LocalDateTime.now())
                      .user(user).build())
      );
    };
  }
}
