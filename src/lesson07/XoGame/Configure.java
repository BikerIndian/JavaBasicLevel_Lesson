package lesson07.XoGame;

public class Configure {
    private boolean debug = false;
    private final int SIZE = 5;
    //    static final int DOTS_TO_WIN = 3;
    private final int SIZE_CELL_WIN = 4;

    private final char DOT_X = 'X';
    private final char DOT_O = 'O';
    private final char DOT_EMPTY = '.';

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
}
