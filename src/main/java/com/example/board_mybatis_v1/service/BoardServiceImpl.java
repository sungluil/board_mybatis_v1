package com.example.board_mybatis_v1.service;

import com.example.board_mybatis_v1.domain.BoardMybatis;
import com.example.board_mybatis_v1.dto.BoardDTO;
import com.example.board_mybatis_v1.repository.BoardMybatisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{

    private final BoardMybatisRepository repository;

    @Override
    public List<BoardMybatis> findAll() {
        return repository.findAll();
    }

    @Override
    public void insert() {
        BoardDTO boardDTO = BoardDTO
                .builder()
                .no(3L)
                .contents("aa")
                .createTime(LocalDate.now())
                .mofityTime(LocalDate.now())
                .writer("길동")
                .build();
        repository.insert(boardDTO);
        throw new IllegalArgumentException("error");
    }
}
