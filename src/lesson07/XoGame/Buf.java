package lesson07.XoGame;

public class Buf {
    private Configure configure = new Configure();

    private static char[][] map;


    public void initMap() {
        map = new char[configure.getSIZE()][configure.getSIZE()];
        for (int i = 0; i < configure.getSIZE(); i++) {
            for (int j = 0; j < configure.getSIZE(); j++) {
                map[i][j] = configure.getDOT_EMPTY();
            }
        }
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


}
