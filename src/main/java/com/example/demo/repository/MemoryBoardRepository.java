package com.example.demo.repository;

import com.example.demo.domain.Board;
import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryBoardRepository implements BoardRepository {


    private static Map<Long, Board> board_new = new HashMap<>();
    private static long sequence = 0L;



    @Override
    public Board save_board(Board board) {
        board.setSeq(++sequence);
        //board.setTitle("bb");
        board_new.put(board.getSeq(), board);
        return board;
    }
    @Override
    public List<Board> findAll_board() {
        return new ArrayList<>(board_new.values());
    }
}
