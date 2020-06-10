package lesson08.xogame.logic;

import lesson08.xogame.Buf;
import lesson08.xogame.Configure;
import lesson08.xogame.view.GameWindow;

public class CoreGame {
    private Configure configure = new Configure();
    private Buf buf = new Buf();
   // private char[][] map = buf.getMap();
    private static GameWindow gameWindow;

    /**
     * Проверка на возможность установки X или Y
     * @param y
     * @param x
     * @return
     */

    public boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= configure.getSIZE() || y >= configure.getSIZE()) {
            return false;
        }
        return buf.getChar(y,x) == configure.getDOT_EMPTY();
    }

    public   boolean isHorizon(int x){
        return x <= (configure.getSIZE()-configure.getSIZE_CELL_WIN());
    }

    public boolean isDiagonal(int y, int x){
        return y <= (configure.getSIZE()-configure.getSIZE_CELL_WIN()) && x <= (configure.getSIZE()-configure.getSIZE_CELL_WIN()) ;
    }

    public   boolean isVertical(int y){
        return y <= (configure.getSIZE()-configure.getSIZE_CELL_WIN()) ;
    }

    public   boolean isSecondaryDiagonal(int y, int x){
        return  y >= (configure.getSIZE_CELL_WIN()-1) && x <= (configure.getSIZE()-configure.getSIZE_CELL_WIN()) ;
    }

/*
    // JFrame
    public void setViewGame(GameView viewGame) {
        this.gameWindow = viewGame;
    }
*/
    /*
    public void updateView(){
        this.viewGame.updateView();
    }
     */
    public void mess(String mess){
        this.gameWindow.mess(mess);
    }

    public void setViewGame(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
}
