package com.example.demo.domain;

import jdk.jfr.DataAmount;

import java.util.Date;


public class Board {
    private Long seq;           //pk
    private String title;       //제목
    private String writer;      //작성자
    private String content;     //내용


    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}