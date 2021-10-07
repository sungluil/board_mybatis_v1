package com.example.board_mybatis_v1.service;

import com.example.board_mybatis_v1.domain.BoardMybatis;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;


public interface BoardService {

    List<BoardMybatis> findAll();

    void insert();
}
