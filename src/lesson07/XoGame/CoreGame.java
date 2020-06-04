package lesson07.XoGame;

import lesson07.XoGame.View.ViewGame;

public class CoreGame {
    private Configure configure = new Configure();
    private Buf buf = new Buf();
    private char[][] map = buf.getMap();
    private static ViewGame viewGame;

    // Проверка на возможность установки X или Y
    public boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= configure.getSIZE() || y >= configure.getSIZE()) {
            return false;
        }
        return map[y][x] == configure.getDOT_EMPTY();
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

    // JFrame
    public void setViewGame(ViewGame viewGame) {
        this.viewGame = viewGame;
    }

    public void updateView(){
        this.viewGame.updateView();
    }
    public void mess(String mess){
        this.viewGame.mess(mess);
    }
}
