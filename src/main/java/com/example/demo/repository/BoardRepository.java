package com.example.demo.repository;

import com.example.demo.domain.Board;


import java.util.List;


public interface BoardRepository {
    Board save_board(Board board);
    List<Board> findAll_board();
}
