package lesson07.XoGame;

import lesson07.XoGame.View.ViewGame;

public class XoGame {
    private Buf buf;
    private ViewGame viewGame;

    public static void main(String[] args) {
        new XoGame().startGame();
    }


    public void startGame(){
        this.buf  = new Buf();
        this.buf.initMap();

        this.viewGame = new ViewGame();





/*
        while (true){

        }
            printMap();
            humanTurn();

            if(checkWin(DOT_X)){
                System.out.println("Ты победил!");
                break;
            }

            if(isFull()){
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();

            if(checkWin(DOT_O)){
                System.out.println("Компьютер победил!");
                break;
            }

            if(isFull()){
                System.out.println("Ничья");
                break;
            }
        }

  */
    }
}
