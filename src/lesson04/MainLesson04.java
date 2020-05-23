package lesson04;

/*
    ФИО:  		    Свищ Владимир Сергеевич
    Факультет:      Geek University Android-разработки (478 - 12.05.2020)
    Курс: 		    Java Core. Базовый уровень
    Урок: 		    Урок 4. Крестики-нолики в процедурном стиле
    Дата правки:    23.05.2020
*/

import java.util.Random;
import java.util.Scanner;

public class MainLesson04 {
    static final int SIZE = 5;
    //    static final int DOTS_TO_WIN = 3;
    static final int SIZE_CELL_WIN = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true){
            humanTurn();
            printMap();

            if(checkWin(DOT_X)){
                System.out.println("Ты победил!");
                break;
            }

            if(isFull()){
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();

            if(checkWin(DOT_O)){
                System.out.println("Компьютер победил!");
                break;
            }

            if(isFull()){
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты вашего хода X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    /*
        4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
    */
    public static void aiTurn() {
        int x, y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean isFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }


   /*
        1. Полностью разобраться с кодом, попробовать переписать с нуля,
        стараясь не подглядывать в методичку;

        2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
        например, с использованием циклов.

        3. * Попробовать переписать логику проверки победы,
        чтобы она работала для поля 5х5 и количества фишек 4.
        Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;

   */

    public static boolean checkWin(char c){

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {

                if (x <= (SIZE-SIZE_CELL_WIN) && checkHorizon(y,x,c)){
                    return true;
                }

                if (y <= (SIZE-SIZE_CELL_WIN) && x <= (SIZE-SIZE_CELL_WIN)  && checkDiagonal(y,x,c)){
                    return true;
                }

                if (y <= (SIZE-SIZE_CELL_WIN) && checkVertical(y,x,c)){
                    return true;
                }

                if (y >= (SIZE_CELL_WIN-1) && x <= (SIZE-SIZE_CELL_WIN) && checkSecondaryDiagonal(y,x,c)){
                    return true;
                }

            }
        }

        return false;
    }


    /**
     *  Проверка по горизонтали
     *
     * @param y Координата  по y
     * @param x Координата  по x
     * @param c Проверяемый символ
     * @return
     */
    private static boolean checkHorizon(int y, int x, char c) {

        for (int i = 0; i < SIZE_CELL_WIN; i++) {
            if (map[y][x+i] != c ){
                return false;
            }
        }
        return true;
    }

    /**
     *  Проверка по диагонали
     *
     * @param y Координата  по y
     * @param x Координата  по x
     * @param c Проверяемый символ
     * @return
     */
    private static boolean checkDiagonal(int y, int x, char c) {

        for (int i = 0; i < SIZE_CELL_WIN; i++) {
            if (map[y+i][x+i] != c ){
                return false;
            }
        }
        return true;
    }

    /**
     *  Проверка по вертикали
     *
     * @param y Координата  по y
     * @param x Координата  по x
     * @param c Проверяемый символ
     * @return
     */
    private static boolean checkVertical(int y, int x, char c) {

        for (int i = 0; i < SIZE_CELL_WIN; i++) {
            if (map[y+i][x] != c ){
                return false;
            }
        }
        return true;
    }

    /**
     *  Проверка по побочная диагонали
     *
     * @param y Координата  по y
     * @param x Координата  по x
     * @param c Проверяемый символ
     * @return
     */
    private static boolean checkSecondaryDiagonal(int y, int x, char c) {

        for (int i = 0; i < SIZE_CELL_WIN; i++) {
            if (map[y-i][x+i] != c ){
                return false;
            }
        }
        return true;
    }

}
