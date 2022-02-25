package com.company;


import java.util.Scanner;
import java.util.Arrays;

import static com.company.TicTacToe.*;

public class Main {

    public static void main(String[] args) {
//        Create a new project in IntelliJ
        TicTacToe newGame = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to Tic Tac Toe");

        newGame.printBoard();
        System.out.println("X will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int slotChoice;
            slotChoice = scanner.nextInt();
            if (!(slotChoice > 0 && slotChoice <= 9)) {
                System.out.println("Invalid input, please try again");
                continue;

            }
            if (board[slotChoice - 1].equals(String.valueOf(slotChoice))) {
                board[slotChoice - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                printBoard();
                winner = checkWinner();
            } else {
                System.out.println("Slot taken, try again:");
            }
        }
        if(winner.equalsIgnoreCase("draw")) {
            System.out.println("Its a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s won!");
        }
    }
}
