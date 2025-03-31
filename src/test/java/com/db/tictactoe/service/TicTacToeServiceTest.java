package com.db.tictactoe.service;

import com.db.tictactoe.model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeServiceTest {

    private TicTacToeService ticTacToeService;

    private Board board;

    @BeforeEach
    void setUp() {
        ticTacToeService = new TicTacToeService();
        board = new Board();
        board.setSize(3);
    }

    @Test
    void checkWinningBoard_shouldReturn0 () {
        board.setBoard(new Integer [][] {{0,0,0},{1,0,1},{1,1,0}});

        Integer result = ticTacToeService.checkWinningBoard(board);

        assertEquals(0, result);
    }

    @Test
    void checkWinningBoard_shouldReturn1 () {
        board.setBoard(new Integer [][]{{0,0,1},{0,0,1},{1,1,1}});

        Integer result = ticTacToeService.checkWinningBoard(board);

        assertEquals(1, result);
    }


    @Test
    void checkWinningBoard_shouldReturnNull () {

        board.setBoard(new Integer [][]{{0,1,0},{1,0,1},{1,0,1}});

        Integer result = ticTacToeService.checkWinningBoard(board);

        assertNull(result);
    }

    @Test
    void checkWinningBoard_shouldReturnNullWhenNotValid () {

        board.setBoard(new Integer [][]{{0,null,0},{1,0,1},{1,0,1}});

        Integer result = ticTacToeService.checkWinningBoard(board);

        assertNull(result);
    }


    @Test
    void checkRow_shouldReturnNoWinner () {
        board.setBoard(new Integer [][]{{0,1,0},{1,0,1},{1,1,0}});

        Integer result = ticTacToeService.checkRows(board);

        assertNull(result);
    }

    @Test
    void checkRow_shouldReturnWinner0 () {
        board.setBoard(new Integer [][]{{0,0,0},{1,0,1},{1,1,0}});

        Integer result = ticTacToeService.checkRows(board);

        assertEquals(0, result);
    }

    @Test
    void checkColumns_shouldReturnNoWinner () {
        board.setBoard(new Integer [][]{{0,1,0},{1,0,1},{1,1,0}});

        Integer result = ticTacToeService.checkColumns(board);

        assertNull(result);
    }

    @Test
    void checkColumns_shouldReturnWinner1 () {
        board.setBoard(new Integer [][]{{1,0,0},{1,0,1},{1,1,0}});

        Integer result = ticTacToeService.checkColumns(board);

        assertEquals(1, result);
    }


    @Test
    void checkDiagonals_shouldReturnWinner0_leftDiagonal () {
        board.setBoard(new Integer [][]{{0,0,0},{1,0,1},{1,1,0}});

        Integer result = ticTacToeService.checkDiagonals(board);

        assertEquals(0, result);
    }

    @Test
    void checkDiagonals_shouldReturnWinner1_rightDiagonal () {
        board.setBoard(new Integer [][]{{0,0,1},{1,1,1},{1,1,1}});

        Integer result = ticTacToeService.checkDiagonals(board);

        assertEquals(1, result);
    }

    @Test
    void checkDiagonals_shouldReturnNull () {
        board.setBoard(new Integer [][]{{1,0,1},{1,0,1},{0,1,0}});

        Integer result = ticTacToeService.checkDiagonals(board);

        assertNull(result);
    }
}
