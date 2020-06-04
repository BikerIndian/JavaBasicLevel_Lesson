package lesson07.XoGame;

import java.util.Random;

public class AiGame {
    private Buf buf = new Buf();
    private  Configure configure = new  Configure();
    private CoreGame coreGame = new CoreGame();

    private Random random = new Random();


    public void aiTurn() {

        if (!aiSly()) { // Если сработал ИИ то дальше не идем
            aiRandom();
        }

        if (new Win().checkWin(configure.getDOT_O())){
            coreGame.mess("Компьютер победил!");
        }

        coreGame.updateView(); // Обновляем JFrame
    }

    private void aiRandom() {
        int x, y;
        int helpAi=0;

        // Поставить рядом
        do {
            y = random.nextInt(3)+buf.getHumanY() -1;
            x = random.nextInt(3)+buf.getHumanX() -1;
            helpAi++;
        } while (!coreGame.isCellValid(y, x) && helpAi < 100); // Выйти если не удалось поставить рядом


        // Поставить в любом месте
        while (!coreGame.isCellValid(y, x) && helpAi >= 100){
            x = random.nextInt(configure.getSIZE());
            y = random.nextInt(configure.getSIZE());
        }


        buf.setMapDot(y,x,configure.getDOT_O());


        if (configure.isDebug()){
            System.out.println("Ai random = "+y+" "+x);
        }
    }

    // Лукавый
    private boolean aiSly() {

        for (int y = 0; y < configure.getSIZE(); y++) {
            for (int x = 0; x < configure.getSIZE(); x++) {

                if (coreGame.isHorizon(x) && aiSlyCheck(y,x,"Horizon")){
                    return true;
                }

                if (coreGame.isDiagonal(y, x) && aiSlyCheck(y,x,"Diagonal")){
                    return true;
                }

                if (coreGame.isVertical(y) && aiSlyCheck(y,x,"Vertical")){
                    return true;
                }

                if (coreGame.isSecondaryDiagonal(y, x) && aiSlyCheck(y,x,"SecondaryDiagonal")){
                    return true;
                }

            }
        }

        return false;
    }


    private boolean aiSlyCheck(int y, int x,String type) {

        boolean isHumanYX = false;
        boolean isDOT_X = false;

        int checkY, checkX;
        for (int i = 0; i < configure.getSIZE_CELL_WIN(); i++) {

             checkY = getCheckY(y,i,type);
             checkX = getCheckX(x,i,type);


            // Если есть О то выход

            if (buf.getChar(checkY,checkX) == configure.getDOT_O() ){
                return false;
            }

            if (buf.getHumanY() == checkY && checkX == buf.getHumanX()){
                isHumanYX = true;
            } else if (buf.getChar(checkY,checkX)  == configure.getDOT_X() ){
                isDOT_X = true;
            }

        }

        if (isHumanYX && isDOT_X){

            for (int i = 0; i < configure.getSIZE_CELL_WIN(); i++) {

                checkY = getCheckY(y,i,type);
                checkX = getCheckX(x,i,type);

                if (coreGame.isCellValid(checkY, checkX)){

                    buf.setMapDot(checkY,checkX,configure.getDOT_O());


                    if (configure.isDebug()){
                        System.out.println("Ai ["+type+"] = "+ checkY+" "+checkX);
                    }

                    return true;
                }
            }
        }
        return false;
    }



    private int getCheckY(int y, int i, String type) {

        if (type.equals("Horizon")) {
            return y;
        }

        if (type.equals("Diagonal")) {
            return y+i;
        }


        if (type.equals("Vertical")) {
            return y+i;
        }

        if (type.equals("SecondaryDiagonal")) {
            return y-i;
        }
        return 0;
    }

    private int getCheckX(int x, int i, String type) {
        if (type.equals("Horizon")) {
            return x+i;
        }

        if (type.equals("Diagonal")) {
            return x+i;
        }

        if (type.equals("Vertical")) {
            return x;
        }

        if (type.equals("SecondaryDiagonal")) {
            return x+i;
        }
        return 0;
    }

    /*
*/
}
