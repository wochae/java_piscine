package com.example.demo.domain.rike;

import com.example.demo.domain.rike.dto.RikeReq;
import com.example.demo.domain.rike.dto.RikeRes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
public class RikeService {

    private final RikeRepository rikeRepository;

    @Transactional
    public void rikeUp(Rike rike) {
        Rike r = new Rike(rike.getBoard(), rike.getUser());
        rikeRepository.save(r);

    }
    @Transactional
    public void rikeDown(RikeReq req) {
        Rike r = rikeRepository.findRikeByUserIdAndBoardId(req.getUserId(), req.getBoardId()).orElseThrow();
        rikeRepository.delete(r);

    }

    @Transactional
    public int checkExists(RikeReq req) {
        if (rikeRepository.findRikeByUserIdAndBoardId(req.getUserId(), req.getBoardId()).isPresent())
            return 1;
        return 0;
    }

//    public boolean findRike(RikeReq req) {
//        return rikeRepository.findRikeByBoardIdAndUserId(req.getBoardId(), req.getUserId()).orElse(null);
//    }

    @Transactional
    public List<Rike> findAllRike() {
        return rikeRepository.findAll();
    }

}
