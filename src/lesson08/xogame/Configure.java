package lesson08.xogame;

public class Configure {
    private boolean debug = false;
    private static int SIZE = 3;
    private static int SIZE_CELL_WIN = 3;
   // private int DOTS_TO_WIN = 3;


    private final char DOT_X = 'X';
    private final char DOT_O = 'O';
    private final char DOT_EMPTY = '.';

    private final int MODE_H_VS_A = 0;
    private final int MODE_H_VS_H = 1;

    public int getSIZE() {
        return SIZE;
    }

    public int getSIZE_CELL_WIN() {
        return SIZE_CELL_WIN;
    }

    public char getDOT_X() {
        return DOT_X;
    }

    public char getDOT_O() {
        return DOT_O;
    }

    public char getDOT_EMPTY() {
        return DOT_EMPTY;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setSIZE(int SIZE) {
        this.SIZE = SIZE;
    }

    public void setSIZE_CELL_WIN(int SIZE_CELL_WIN) {
        this.SIZE_CELL_WIN = SIZE_CELL_WIN;
    }

    public int getMODE_H_VS_A() {
        return MODE_H_VS_A;
    }

    public int getMODE_H_VS_H() {
        return MODE_H_VS_H;
    }





}
