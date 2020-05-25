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
    private static int humanY, humanX;

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

        humanY = y;
        humanX = x;
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

        int helpAi=0;

        if (!aiSly()) {
            // Поставить рядом
            do {
                y = random.nextInt(3)+humanY -1;
                x = random.nextInt(3)+humanX -1;
                helpAi++;
            } while (!isCellValid(y, x) && helpAi < 100); // Выйти если не удалось поставить рядом


            // Поставить в любом месте
            while (!isCellValid(y, x) && helpAi >= 100){
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }

            map[y][x] = DOT_O;
        }
    }

    private static boolean aiSly() {

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {

                if (isHorizon(x) && aiSlyHorizon(y,x)){
                    return true;
                }

                if (isDiagonal(y, x) && aiSlyDiagonal(y,x)){
                    return true;
                }


                if (isVertical(y) && aiSlyVertical(y,x)){

                    return true;
                }

                if (isSecondaryDiagonal(y, x) && aiSlySecondaryDiagonal(y,x)){
                    return true;
                }

            }
        }

        return false;
    }



    private static boolean aiSlyHorizon(int y, int x) {

        boolean isHumanYX = false;
        boolean isDOT_X = false;

        int checkY, checkX;

        for (int i = 0; i < SIZE_CELL_WIN; i++) {

            checkY = y;
            checkX = x+i;

            // Если есть О то выход
            if (map[checkY][checkX] == DOT_O ){
                return false;
            }

            if (humanY == checkY && checkX == humanX){
                isHumanYX = true;
            } else if (map[checkY][checkX] == DOT_X ){
                isDOT_X = true;
            }

        }

        if (isHumanYX && isDOT_X){
            for (int i = 0; i < SIZE_CELL_WIN; i++) {

                checkY = y;
                checkX = x+i;

                if (isCellValid(checkY, checkX )){
                    map[checkY][checkX] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean aiSlyDiagonal(int y, int x) {

        boolean isHumanYX = false;
        boolean isDOT_X = false;

        int checkY, checkX;
        for (int i = 0; i < SIZE_CELL_WIN; i++) {

            checkY = y+i;
            checkX = x+i;

            // Если есть О то выход
            if (map[checkY][checkX] == DOT_O ){
                return false;
            }

            if (humanY == checkY && checkX == humanX){
                isHumanYX = true;
            } else if (map[checkY][checkX] == DOT_X ){
                isDOT_X = true;
            }

        }

        if (isHumanYX && isDOT_X){

            for (int i = 0; i < SIZE_CELL_WIN; i++) {
                checkY = y+i;
                checkX = x+i;

                if (isCellValid(checkY, checkX)){
                    map[checkY][checkX] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean aiSlyVertical(int y, int x) {

        boolean isHumanYX = false;
        boolean isDOT_X = false;

        int checkY, checkX;
        for (int i = 0; i < SIZE_CELL_WIN; i++) {

            checkY = y+i;
            checkX = x;

            // Если есть О то выход
            if (map[checkY][checkX] == DOT_O ){
                return false;
            }

            if (humanY == checkY && checkX == humanX){
                isHumanYX = true;
            } else if (map[checkY][checkX] == DOT_X ){
                isDOT_X = true;
            }

        }

        if (isHumanYX && isDOT_X){

            for (int i = 0; i < SIZE_CELL_WIN; i++) {
                checkY = y+i;
                checkX = x;

                if (isCellValid(checkY, checkX)){
                    map[checkY][checkX] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean aiSlySecondaryDiagonal(int y, int x) {

        boolean isHumanYX = false;
        boolean isDOT_X = false;

        int checkY, checkX;
        for (int i = 0; i < SIZE_CELL_WIN; i++) {


            checkY = y-i;
            checkX = x+i;

            // Если есть О то выход
            if (map[checkY][checkX] == DOT_O ){
                return false;
            }

            if (humanY == checkY && checkX == humanX){
                isHumanYX = true;
            } else if (map[checkY][checkX] == DOT_X ){
                isDOT_X = true;
            }

        }

        if (isHumanYX && isDOT_X){

            for (int i = 0; i < SIZE_CELL_WIN; i++) {

                checkY = y-i;
                checkX = x+i;

                if (isCellValid(checkY, checkX)){
                    map[checkY][checkX] = DOT_O;
                    return true;
                }
            }
        }
        return false;
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

                if (isHorizon(x) && checkHorizon(y,x,c)){
                    return true;
                }

                if (isDiagonal(y, x) && checkDiagonal(y,x,c)){
                    return true;
                }

                if (isVertical(y) && checkVertical(y,x,c)){
                    return true;
                }

                if (isSecondaryDiagonal(y, x) && checkSecondaryDiagonal(y,x,c)){
                    return true;
                }

            }
        }

        return false;
    }

    private static boolean isHorizon(int x){
        return x <= (SIZE-SIZE_CELL_WIN);
    }

    private static boolean isDiagonal(int y, int x){
        return y <= (SIZE-SIZE_CELL_WIN) && x <= (SIZE-SIZE_CELL_WIN) ;
    }

    private static boolean isVertical(int y){
        return y <= (SIZE-SIZE_CELL_WIN) ;
    }

    private static boolean isSecondaryDiagonal(int y, int x){
        return  y >= (SIZE_CELL_WIN-1) && x <= (SIZE-SIZE_CELL_WIN) ;
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
