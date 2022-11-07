package com.example.demo.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    @Query("SELECT b FROM Board b ORDER BY b.id DESC")
    List<Board> findAllDesc();

    @Query("SELECT b FROM Board b WHERE b.user.id = ?1")
    List<Board> findBoardsByUserId(@RequestParam Integer userId);

    @Query("SELECT b FROM Board b Where b.user.userName = ?1")
    List<Board> findBoardsByUserName(@RequestParam String userName);
}
