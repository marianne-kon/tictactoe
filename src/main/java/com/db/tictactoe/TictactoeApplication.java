package com.db.tictactoe;

import com.db.tictactoe.model.Board;
import com.db.tictactoe.service.TicTacToeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TictactoeApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TictactoeApplication.class, args);

        TicTacToeService ticTacToeService = context.getBean(TicTacToeService.class);

        Board board = new Board();
        board.setBoard(new Integer[][]{{0, 1, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 0}, {0, 0, 0, 1}});
        board.setSize(4);

        Integer winner = ticTacToeService.checkWinningBoard(board);

        if (winner.equals(0)) {
            System.out.println("O won");
        } else if (winner.equals(1)) {
            System.out.println("X won");
        } else {
            System.out.println("No winner");
        }
    }

}
