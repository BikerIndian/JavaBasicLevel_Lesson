package lesson08.xogame.view;

import lesson08.xogame.BattleMap;
import lesson08.xogame.logic.CoreGame;
import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_POS_X = 400;
    static final int WINDOW_POS_Y = 400;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;

    private SettingsWindow settingsWindow;
    private BattleMap battleMap;
    private CoreGame coreGame = new CoreGame();

    public GameWindow() {
        coreGame.setViewGame(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");

        // Расположение в центре
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

        settingsWindow = new SettingsWindow(this);
        battleMap = new BattleMap(this);
        add(battleMap, BorderLayout.CENTER);


        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton buttonStartNewGame = new JButton("Старт");
        buttonStartNewGame.setBackground(Color.cyan);
        panel.add(buttonStartNewGame);

        JButton buttonExit = new JButton("Выход");
        buttonExit.setBackground(Color.PINK);
        panel.add(buttonExit);

        buttonExit.addActionListener(e -> {
            System.exit(0);
        });

        buttonStartNewGame.addActionListener(e -> {
            settingsWindow.setVisible(true);
        });

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
//        System.out.printf("gameMode: %d, fieldSizeX: %d, fieldSizeY: %d, dotsToWin: %d\n", gameMode, fieldSizeX, fieldSizeY, dotsToWin);
    battleMap.startNewGame(gameMode, fieldSizeX, fieldSizeY, dotsToWin);

    }

    public void mess(String mess){
        JDialog dialog = new JDialog(this, "Конец игры");
        // Определение способа завершения работы диалогового окна
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
        dialog.setSize(250, 150);
        dialog.getRootPane().setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 10));;

        // Расположение в центре
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - dialog.getWidth()) / 2;
        int y = (screenSize.height - dialog.getHeight()) / 2;
        dialog.setLocation(x, y);

        JLabel label = new JLabel(mess);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        dialog.add(label);
        dialog.setVisible(true);

    }
}
