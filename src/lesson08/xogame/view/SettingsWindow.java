package lesson08.xogame.view;

import lesson08.xogame.Configure;
import lesson08.xogame.Buf;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_POS_X = GameWindow.WINDOW_POS_X + 50;
    private static final int WINDOW_POS_Y = GameWindow.WINDOW_POS_Y + 50;
    private static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 100;
    private static final int WINDOW_HEIGHT = 400;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    private Configure configure = new Configure();

    private GameWindow gameWindow;

    private JRadioButton radioButtonHvsAi = new JRadioButton("Человек против Ai", true);
    private JRadioButton radioButtonHvsH = new JRadioButton("Человек против Человека");
    private ButtonGroup gameMode = new ButtonGroup();

    private JSlider sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
    private JSlider sliderDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

    public SettingsWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Настрйки игры");

        // Расположение в центре
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

        setLayout(new GridLayout(8,1));

        add(new JLabel(" Выбор режима игры:"));
        add(radioButtonHvsAi);
        add(radioButtonHvsH);
        gameMode.add(radioButtonHvsAi);
        gameMode.add(radioButtonHvsH);

        add(new JLabel(" Выбор размера поля:"));
        sliderFieldSize.setMajorTickSpacing(1);
        sliderFieldSize.setPaintLabels(true);
        sliderFieldSize.setPaintTicks(true);

        add(sliderFieldSize);
        add(new JLabel(" Выбор победных ячеек:"));
        sliderDotsToWin.setMajorTickSpacing(1);
        sliderDotsToWin.setPaintLabels(true);
        sliderDotsToWin.setPaintTicks(true);
        add(sliderDotsToWin);

        sliderFieldSize.addChangeListener(e ->{
            sliderDotsToWin.setMaximum(sliderFieldSize.getValue());
        });

        JButton buttonStartNewGame = new JButton("Старт");
        buttonStartNewGame.setBackground(Color.cyan);
        add(buttonStartNewGame);

        buttonStartNewGame.addActionListener(e ->{
            setVisible(false);

            int mode;
            if(radioButtonHvsAi.isSelected()){
                mode = configure.getMODE_H_VS_A();
            } else {
                mode = configure.getMODE_H_VS_H();
            }

            int fieldSize = sliderFieldSize.getValue();
            int dotsToWin = sliderDotsToWin.getValue();

            Configure configure = new Configure();
            configure.setSIZE(fieldSize);
            configure.setSIZE_CELL_WIN(dotsToWin);
            //Logic.SIZE = fieldSize;
            //Logic.DOTS_TO_WIN = dotsToWin;

            Buf buf = new Buf();
            buf.initMap();

            //Logic.initMap();
            //Logic.gameFinished = false;

            gameWindow.startNewGame(mode,fieldSize,fieldSize,dotsToWin);
        });

        setVisible(false);
    }
}
