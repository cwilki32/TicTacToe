package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    //        The game should display the “board” grid in the console
    //create a separate GridLayout to build and hold the Grid
//        The game should allow a user to choose where to put their mark on the board (x’s or o’s)
    //scanner
//        The game should have the computer place their mark after a player’s turn
    //how do we control turns? random
    //probably should have an opponent class
//        The game should check for 3 in a row marks to declare a winner
    //what constitutes a win
    //123, 456, 789, 159, 753, 258, 369, 147
//        The game should determine randomly if the player is using x’s or o’s as their mark
//        Whoever (player or computer) is assigned x’s should play first
//        The game should ask you to play again once complete
//        The game should track your wins and loses
    //scoreboard
//        The game should detect a tie when the board is full but there is no winner

    //Will move from main to here for game later

    static String[] board;
    static String turn;

    public Random rand = new Random();
    private int x;
    Scanner scanner = new Scanner(System.in);


    // CheckWinner method will
    // decide the combination
    // of three box given below.
    static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "draw";
            }
        }

        // To enter the X Or O at the exact place on board.
        System.out.println(
                turn + "'s turn; enter a slot number to place "
                        + turn + " in:");
        return null;
    }

    // To print out the board.
    /* |---|---|---|
       | 1 | 2 | 3 |
       |-----------|
       | 4 | 5 | 6 |
       |-----------|
       | 7 | 8 | 9 |
       |---|---|---|*/

    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    public String getOpponentMove() {
        x = rand.nextInt(10);
        if (!(x > 0 && x <= 9 )) {
            x = rand.nextInt(10);
        }
        if (board[x - 1].equals(String.valueOf(x))) {
            board[x - 1] = turn;

            if (turn.equals("O")) {
                turn = "X";

            } else {
//                turn = "X";
                x = rand.nextInt(10);
            }
            printBoard();
        } else {
            x = rand.nextInt(10);
        }

        return turn;
    }

    public String getPlayerMove() {
        x = scanner.nextInt();
        if (!(x > 0 && x <= 9)) {
            System.out.println("Invalid input, please try again");

        }
        if (board[x - 1].equals(String.valueOf(x))) {
            board[x - 1] = turn;

            if (turn.equals("X")) {
                turn = "O";

            } else {
                turn = "X";
            }
            printBoard();
        } else {
            System.out.println("Slot taken, try again:");
        }

        return turn;
    }

//                int slotChoice;
//                slotChoice = scanner.nextInt();
//                if (!(slotChoice > 0 && slotChoice <= 9)) {
//                    System.out.println("Invalid input, please try again");
//                    continue;
//
//                }
//                if (board[slotChoice - 1].equals(String.valueOf(slotChoice))) {
//                    board[slotChoice - 1] = turn;
//
//                    if (turn.equals("X")) {
//                        turn = "O";
//
//                    } else {
//                        turn = "X";
//                    }
//                    printBoard();
//                    winner = checkWinner();
//                } else {
//                    System.out.println("Slot taken, try again:");
//                }
////        }
//        if (winner.equalsIgnoreCase("draw")) {
//            System.out.println("Its a draw! Thanks for playing.");
////            playAgain = true;
//            winner = null;
//        } else {
//            System.out.println("Congratulations! " + winner + "'s won!");
////            playAgain = true;
//            winner = null;
}
