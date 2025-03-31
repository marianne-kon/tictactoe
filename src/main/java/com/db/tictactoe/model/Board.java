package com.db.tictactoe.model;

import lombok.Data;

@Data
public class Board {

    private Integer[][] board;
    private int size;

}
