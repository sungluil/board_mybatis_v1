package com.example.board_mybatis_v1.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BoardDTO {
    private Long no;
    private String title;
    private String contents;
    private String writer;
    private LocalDate createTime;
    private LocalDate mofityTime;
}
