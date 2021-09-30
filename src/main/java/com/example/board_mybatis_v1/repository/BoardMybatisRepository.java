package com.example.board_mybatis_v1.repository;

import com.example.board_mybatis_v1.domain.BoardMybatis;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMybatisRepository {

    List<BoardMybatis> findAll();
}
