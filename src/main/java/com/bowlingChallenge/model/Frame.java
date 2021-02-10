package com.bowlingChallenge.model;

/**
 *
 * @author NathaliaUrdinola
 */
public class Frame {

    private int ball1;
    private int ball2;
    private int ball3;
    private char type; //Can be S - Strike, P- Spare, N-Normal

    public Frame(int ball1, int ball2, int ball3, char type) {
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.type = type;
    }

    public Frame() {
        this.ball1 = 0;
        this.ball2 = 0;
        this.type = ' ';
    }

    public int getBall1() {
        return ball1;
    }

    public void setBall1(int ball1) {
        this.ball1 = ball1;
    }

    public int getBall2() {
        return ball2;
    }

    public void setBall2(int ball2) {
        this.ball2 = ball2;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getBall3() {
        return ball3;
    }

    public void setBall3(int ball3) {
        this.ball3 = ball3;
    }

    @Override
    public String toString() {
        return "Frame{" + "ball1=" + ball1 + ", ball2=" + ball2 + ", ball3=" + ball3 + ", type=" + type + '}';
    }

    
    

    
}
