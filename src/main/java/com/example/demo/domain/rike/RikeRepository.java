package com.example.demo.domain.rike;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


public interface RikeRepository extends JpaRepository<Rike, Integer> {


    @Query(value = "SELECT r FROM Rike r WHERE r.boardId = ?1 and r.userId = ?2")
    Optional<Rike> findRikeByBoardIdAndUserId(@RequestParam Integer boardId, @RequestParam Integer userId);

}
