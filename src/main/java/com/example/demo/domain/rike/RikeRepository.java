package com.example.demo.domain.rike;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface RikeRepository extends JpaRepository<Rike, Integer> {



    @Query(value = "SELECT r FROM Rike r WHERE r.user.id = :userId and r.board.id = :boardId")
    Optional<Rike> findRikeByUserIdAndBoardId(@Param("userId") Integer userId, @Param("boardId") Integer boardId);

}
