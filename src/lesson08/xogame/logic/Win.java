package lesson08.xogame.logic;

import lesson08.xogame.Buf;
import lesson08.xogame.Configure;

public class Win {
    private Configure configure = new Configure();
    private CoreGame coreGame = new CoreGame();
    private Buf buf = new Buf();

    public  boolean checkWin(char c){

        for (int y = 0; y < configure.getSIZE(); y++) {
            for (int x = 0; x < configure.getSIZE(); x++) {

                if (coreGame.isHorizon(x) && checkHorizon(y,x,c)){
                    return true;
                }

                if (coreGame.isDiagonal(y, x) && checkDiagonal(y,x,c)){
                    return true;
                }

                if (coreGame.isVertical(y) && checkVertical(y,x,c)){
                    return true;
                }

                if (coreGame.isSecondaryDiagonal(y, x) && checkSecondaryDiagonal(y,x,c)){
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
    private  boolean checkHorizon(int y, int x, char c) {

        for (int i = 0; i < configure.getSIZE_CELL_WIN(); i++) {
            if (buf.getChar(y,x+i) != c ){
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
    private  boolean checkDiagonal(int y, int x, char c) {

        for (int i = 0; i < configure.getSIZE_CELL_WIN(); i++) {
            if  (buf.getChar(y+i,x+i)!= c ){
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
    private  boolean checkVertical(int y, int x, char c) {

        for (int i = 0; i < configure.getSIZE_CELL_WIN(); i++) {
            if (buf.getChar(y+i,x) != c ){
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
    private  boolean checkSecondaryDiagonal(int y, int x, char c) {

        for (int i = 0; i < configure.getSIZE_CELL_WIN(); i++) {
            if (buf.getChar(y-i,x+i) != c ){
                return false;
            }
        }
        return true;
    }


}
