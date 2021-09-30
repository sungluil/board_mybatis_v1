package com.example.board_mybatis_v1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class BoardMybatis {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long no;

    private String title;

    private String contents;

    private String writer;

    private LocalDate createTime;

    private LocalDate mofityTime;



    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getMofityTime() {
        return mofityTime;
    }

    public void setMofityTime(LocalDate mofityTime) {
        this.mofityTime = mofityTime;
    }
}
