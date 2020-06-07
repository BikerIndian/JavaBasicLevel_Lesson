package lesson08.xogame.logic;

import lesson08.xogame.Buf;
import lesson08.xogame.Configure;

public class HumanVsHuman {
    private Win win = new Win();
    private CoreGame coreGame = new CoreGame();
    private Configure configure = new Configure();
    private Buf buf = new Buf();

    private  static boolean human1Turn = true;
    private  static boolean human2Turn = false;
    public void turn(int y, int x) {


        if (coreGame.isCellValid(y,x)){
            if (human1Turn && !human2Turn) {
                buf.setMapDot(y,x,configure.getDOT_X());

                human1Turn = false;
                human2Turn = true;
                checkWin();
                return;
            }

            if (!human1Turn && human2Turn) {
                buf.setMapDot(y,x,configure.getDOT_O());

                human1Turn = true;
                human2Turn = false;
                checkWin();
            }

        }
    }

    private void checkWin() {
        if (win.checkWin(configure.getDOT_X())){
            buf.setGameFinished(true);
            coreGame.mess("Выиграл 1 игрок");
        }

        if (win.checkWin(configure.getDOT_O())){
            buf.setGameFinished(true);
            coreGame.mess("Выиграл 2 игрок");
        }

        if (buf.isFull()){
            buf.setGameFinished(true);
            coreGame.mess("Ничья");
        }
    }
}
