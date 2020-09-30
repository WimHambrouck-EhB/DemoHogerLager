package org.example.demohogerlager;

import java.util.Random;

public class Game {

    public enum PlayType {LOWER, EQUAL, HIGHER}

    private int score;
    private int currentNumber;
    private Random random;

    public Game() {
        random = new Random();
        currentNumber = getRandomNumber();
    }

    private int getRandomNumber() {
        return random.nextInt(12) + 1;
    }

    private PlayType getAnswer(int userGuess) {
        if (currentNumber > userGuess) {
            return PlayType.HIGHER;
        } else if (currentNumber < userGuess) {
            return PlayType.LOWER;
        } else {
            return PlayType.EQUAL;
        }
    }

    public PlayType play(int userGuess) {
        PlayType playType = getAnswer(userGuess);

        if (playType.equals(PlayType.EQUAL)) {
            score++;
            currentNumber = getRandomNumber();
        }

        return playType;
    }

    public int getScore() {
        return score;
    }
}
