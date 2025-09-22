package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String word = "pizza";

        ArrayList<Character> wordState = new ArrayList<Character>();
        int wrongGuesses = 0;

        for(int i = 0; i < word.length(); i++){
            wordState.add('_');
        }
        System.out.println("*************************");
        System.out.println("Welcome to Java Hangman!");
        System.out.println("*************************");

        while (wrongGuesses <= 6) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.print("Word: ");
            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.println("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (wordState.contains(guess)) {
                System.out.println("You already guessed that letter!");
                continue;
            }

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct guess!");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong guess! Remaining: " + (6 - wrongGuesses));
            }

            if (!wordState.contains('_')) {
                System.out.println("Congratulations! You guessed the word: " + word + " 🎉");
                break;
            }
        }

        if (wrongGuesses >= 6) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("Game over! The word was: " + word);
        }
        scanner.close();
    }
    static String getHangmanArt(int wrongGuesses){

        return switch(wrongGuesses){
            case 0 -> """
                    
                    
                    
                    """;
            case 1 -> """
                       o
                    
                    
                    """;
            case 2 -> """
                       o
                       |
                    
                    """;
            case 3 -> """
                       o
                      /|
                    
                    """;
            case 4 -> """
                       o
                      /|\\
                    
                    """;
            case 5 -> """
                       o
                      /|\\
                      /
                    """;
            case 6 -> """
                       o
                      /|\\
                      / \\
                    """;
            default -> "";
        };
    }
}