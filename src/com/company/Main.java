package com.company;


import java.util.Scanner;
import java.util.Arrays;

import static com.company.TicTacToe.*;

public class Main {

    public static void main(String[] args) {

        TicTacToe newGame = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
        boolean playAgain = true;
        int wins = 0;
        int losses = 0;
        int ties = 0;


        while (playAgain) {
            int input;
            System.out.println("Welcome to Tic Tac Toe. Enter 1) to Play 2) to Quit.");

            input = scanner.nextInt();
            if (input == 1) {

            } else if (input == 2) {
                System.out.println("Thanks for playing.");
                break;
            } else {
                System.out.println("Invalid, 1) to play or 2) to Quit");
                input = scanner.nextInt();
            }


            for (int a = 0; a < 9; a++) {
                board[a] = String.valueOf(a + 1);
            }


            newGame.printBoard();
            System.out.println("X will play first. Enter a slot number to place X in:");

            while (winner == null) {
                newGame.getPlayerMove();
                winner = checkWinner();
                newGame.getOpponentMove();
                checkWinner();

            }
            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("Its a draw! Thanks for playing.");

                ties++;
                System.out.println("Wins: " + wins + " | Losses: " + losses + " | Ties: " + ties);
                playAgain = true;
                winner = null;

            } else if (winner.equalsIgnoreCase("x")) {
                System.out.println("Congratulations! " + winner + "'s won!");

                wins++;
                System.out.println("Wins: " + wins + " | Losses: " + losses + " | Ties: " + ties);
                playAgain = true;
                winner = null;

            } else{
                if (winner.equalsIgnoreCase("o")) {
                    System.out.println("Bummer! You lost");

                    losses++;
                    System.out.println("Wins: " + wins + " | Losses: " + losses + " | Ties: " + ties);
                    playAgain = true;
                    winner = null;
                }
            }
        }
    }
}
