package lesson08.xogame;

import lesson08.xogame.logic.HumanVsHuman;

public class Buf {
    private Configure configure = new Configure();

    private static char[][] map;
    private static boolean gameFinished =false;


    public void initMap() {

        new HumanVsHuman().clear();

        if (configure.isDebug()){
            System.out.println("configure.getSIZE() = " + configure.getSIZE()+ ", win = "+ configure.getSIZE_CELL_WIN());

        }
          map = new char[configure.getSIZE()][configure.getSIZE()];
        for (int i = 0; i < configure.getSIZE(); i++) {
            for (int j = 0; j < configure.getSIZE(); j++) {
                map[i][j] = configure.getDOT_EMPTY();
            }
        }
        this.gameFinished = false;
    }

    private static int humanY, humanX;

    public  int getHumanY() {
        return humanY;
    }

    public  void setHumanY(int humanY) {
        Buf.humanY = humanY;
    }

    public  int getHumanX() {
        return humanX;
    }

    public  void setHumanX(int humanX) {
        Buf.humanX = humanX;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMapDot(int y,int x , char dot){
        this.map[y][x] = dot;
    };


    public char getChar(int y, int x){
        return map[y][x];
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public boolean isFull(){
        for (int i = 0; i < configure.getSIZE(); i++) {
            for (int j = 0; j < configure.getSIZE(); j++) {
                if(map[i][j] == configure.getDOT_EMPTY()){
                    return false;
                }
            }
        }
        return true;
    }

}
