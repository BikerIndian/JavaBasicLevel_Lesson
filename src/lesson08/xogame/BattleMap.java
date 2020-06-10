package lesson08.xogame;

import lesson08.xogame.logic.Human;
import lesson08.xogame.logic.HumanVsHuman;
import lesson08.xogame.view.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    private Configure configure = new Configure();
    private Buf buf = new Buf();
    private Human human = new Human();
    private HumanVsHuman humanVsHuman = new HumanVsHuman();

    private int gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int dotsToWin;

    private int cellHeight;
    private int cellWidth;

    private boolean isInit = false;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isInit) {
                    mouseReleasedUpdate(e);
                }
            }
        });
    }

    private void mouseReleasedUpdate(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        // Выбор режима игры
        if(!buf.isGameFinished()){
            if (0 == gameMode ){
                human.turn(cellY,cellX);
            } else if (1 == gameMode){
                humanVsHuman.turn(cellY,cellX);
            }

           // Logic.setHumanCoords(cellX, cellY);
        }

        if (configure.isDebug()){
            System.out.printf("mouseReleasedUpdate %d %d \n", cellX, cellY);
        }


        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }


        for (int i = 0; i < configure.getSIZE(); i++) {
            for (int j = 0; j < configure.getSIZE(); j++) {
                if(buf.getChar(i,j)==configure.getDOT_X()){
                    drawX((Graphics2D) g, j, i);
                }
                if(buf.getChar(i,j)==configure.getDOT_O()){
                    drawO((Graphics2D) g, j, i);
                }
            }
        }



    }

    // Рендер O
    private void drawO(Graphics2D g, int cellX, int cellY) {
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(10.0f));  // толщина
        g.drawOval(cellX * cellWidth+(cellWidth/4),cellY * cellHeight+(cellHeight/4),cellWidth/2,cellHeight/2);
    }

    // Рендер X
    private void drawX(Graphics2D g, int cellX, int cellY) {

        g.setColor(Color.red);
        g.setStroke(new BasicStroke(10.0f));  // толщина


        // [\]
        g.drawLine(
                cellX * cellWidth+(cellWidth/4),
                cellY * cellHeight+(cellHeight/4),
                (cellX + 1) * cellWidth-(cellWidth/4),
                (cellY + 1) * cellHeight-(cellHeight/4));

        // [/]
        g.drawLine(
                cellX * cellWidth+(cellWidth/4),
                (cellY + 1) * cellHeight-(cellHeight/4),
                (cellX + 1) * cellWidth-(cellWidth/4),
                cellY * cellHeight+(cellHeight/4));
    }


    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.dotsToWin = dotsToWin;

        isInit = true;
        repaint();
    }
}
