package com.db.tictactoe.service;

import com.db.tictactoe.model.Board;
import org.springframework.stereotype.Service;

@Service
public class TicTacToeService {

    public Integer checkWinningBoard(Board board) {

        if (!isValidBoard(board)) {
            return null;
        }
        Integer winnerLine = checkRows(board);

        if (winnerLine != null) {
            return winnerLine;
        }

        Integer winnerColumn = checkColumns(board);

        if (winnerColumn != null) {
            return winnerColumn;
        }

        return checkDiagonals(board);
    }

    public boolean isValidBoard(Board board) {

        Integer[][] grid = board.getBoard();
        int size = board.getSize();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == null || (grid[row][col] != 0 && grid[row][col] != 1)) {
                    return false;
                }
            }
        }
        return true;

    }

    public Integer checkRows(Board board) {
        for (int i = 0; i < board.getSize(); i++) {

            Integer[] row = board.getBoard()[i];
            int firstCell = row[0];
            boolean isWinningRow = true;
            for (Integer cell : row) {
                if (cell != firstCell) {
                    isWinningRow = false;
                    break;
                }
            }

            if (isWinningRow) {
                return firstCell;
            }
        }

        return null;
    }

    public Integer checkColumns(Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            int firstCell = board.getBoard()[0][0];
            boolean isWinningColumn = true;
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getBoard()[j][i] != firstCell) {
                    isWinningColumn = false;
                    break;
                }
            }

            if (isWinningColumn) {
                return firstCell;
            }
        }

        return null;
    }

    public Integer checkDiagonals(Board board) {
        int leftDiagonal = board.getBoard()[0][0];
        int rightDiagonal = board.getBoard()[0][board.getSize() - 1];

        boolean isLeftWinningDiagonal = true;
        boolean isRightWinningDiagonal = true;

        for (int i = 0; i < board.getSize(); i++) {
            if (leftDiagonal != board.getBoard()[i][i]) {
                isLeftWinningDiagonal = false;
            }

            if (rightDiagonal != board.getBoard()[i][board.getSize() - i - 1]) {
                isRightWinningDiagonal = false;
            }
        }

        if (isLeftWinningDiagonal) {
            return leftDiagonal;
        } else if (isRightWinningDiagonal) {
            return rightDiagonal;
        } else {
            return null;
        }
    }

}
