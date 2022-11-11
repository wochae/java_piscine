package com.example.demo.domain.rike;

import com.example.demo.domain.rike.dto.RikeReq;
import com.example.demo.domain.rike.dto.RikeRes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@AllArgsConstructor
public class RikeService {

    private final RikeRepository rikeRepository;

    @Transactional
    public void rikeUp(Rike rike) {
        Rike r = new Rike(rike.getBoardId(), rike.getUserId());
        rikeRepository.save(r);

    }
    @Transactional
    public void rikeDown(Rike rike) {
        Rike r = new Rike(rike.getBoardId(), rike.getUserId());
        rikeRepository.delete(r);

    }

    @Transactional
    public Rike isExistsRike(RikeReq req) {
        Optional<Rike> rike = rikeRepository.findRikeByBoardIdAndUserId(req.getBoardId(), req.getUserId());
        return rike.orElse(null);
    }
}
