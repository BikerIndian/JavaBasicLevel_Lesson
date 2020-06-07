package lesson08.xogame.logic;

import lesson08.xogame.Buf;
import lesson08.xogame.Configure;

public class Human {
    private Buf buf = new Buf();
    private Configure configure = new Configure();
    private CoreGame coreGame = new CoreGame();
    private AiGame aiGame = new AiGame();

    public boolean turn(int y, int x){
        Win win = new Win();


        if (configure.isDebug()){
            System.out.println("Hm = "+y+" "+x);
        }

        if (coreGame.isCellValid(y,x)){
            buf.setHumanY(y);
            buf.setHumanX(x);
            buf.setMapDot(y,x,configure.getDOT_X());
            // Если человек не выиграл то играет Ai
            if (!win.checkWin(configure.getDOT_X())){
                if (buf.isFull()){
                    coreGame.mess("Ничья");
                    buf.setGameFinished(true);
                }else {
                    aiGame.aiTurn();
                }

            }else {
                buf.setGameFinished(true);
                coreGame.mess("Ты победил!");
            }


            return true;
        }



        return false;
    }
}
