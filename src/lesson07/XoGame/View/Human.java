package lesson07.XoGame.View;

import lesson07.XoGame.*;

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
                aiGame.aiTurn();
            }else {
                coreGame.mess("Ты победил!");
            }


            return true;
        }else {
            //System.out.println(" Нельзя поставить");
            return false;
        }

    }
}
