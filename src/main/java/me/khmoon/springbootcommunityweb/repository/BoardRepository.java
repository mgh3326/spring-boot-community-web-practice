package me.khmoon.springbootcommunityweb.repository;

import me.khmoon.springbootcommunityweb.domain.Board;
import me.khmoon.springbootcommunityweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
  Board findByUser(User user);
}
