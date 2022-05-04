package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void listener() {
        int x, y;
        do {
            System.out.println("Input your X Y coordinates");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        field[y][x] = 'X';
    }

    public static char[][] field;
//123
    public static void create_field() {
        field = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = '.';
            }
        }
    }

    public static void print_field() {
        for (int i = 0; i <= 3; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) return false;
        if (field[y][x] == '.') return true;
        return false;
    }

    public static Random rand = new Random();

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(3);
            y = rand.nextInt(3);
        } while (!isCellValid(x, y));
        System.out.println("computer: " + (x + 1) + " " + (y + 1));
        field[y][x] = '0';
    }

    public static boolean checkWin(char symb) {
        if (field[0][0] == symb && field[0][1] == symb && field[0][2] == symb) return true;
        if (field[1][0] == symb && field[1][1] == symb && field[1][2] == symb) return true;
        if (field[2][0] == symb && field[2][1] == symb && field[2][2] == symb) return true;
        if (field[0][0] == symb && field[1][0] == symb && field[2][0] == symb) return true;
        if (field[0][1] == symb && field[1][1] == symb && field[2][1] == symb) return true;
        if (field[0][2] == symb && field[1][2] == symb && field[2][2] == symb) return true;
        if (field[0][0] == symb && field[1][1] == symb && field[2][2] == symb) return true;
        if (field[2][0] == symb && field[1][1] == symb && field[0][2] == symb) return true;
        return false;
    }
    public static boolean checkWin2(char symb)
    {
        for(int i=0;i<3;i++)
        {
            if (field[i][0] == symb && field[i][1] == symb && field[i][2] == symb) return true;
            if (field[0][i] == symb && field[1][i] == symb && field[2][i] == symb) return true;
        }
        if (field[0][0] == symb && field[1][1] == symb && field[2][2] == symb) return true;
        if (field[0][2] == symb && field[1][1] == symb && field[2][0] == symb) return true;
        return false;
    }

    public static void main(String[] args) {
        create_field();
        print_field();
        while (true) {
            listener();
            print_field();
            if (checkWin2('X')) {
                System.out.println("Human won");
                break;
            }
            if (isMapFull()) {
                System.out.println("draw");
                break;
            }
            aiTurn();
            print_field();
            if (checkWin2('0')) {
                System.out.println("computer won");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("game over");
    }

    public static boolean isMapFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == '.') return false;
            }
        }
        return true;
    }
}
