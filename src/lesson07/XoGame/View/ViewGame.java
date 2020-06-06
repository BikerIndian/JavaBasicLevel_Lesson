package lesson07.XoGame.View;

import lesson07.XoGame.Buf;
import lesson07.XoGame.Configure;
import lesson07.XoGame.CoreGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewGame extends JFrame {
    private Configure configure = new Configure();
    private CoreGame coreGame = new CoreGame();
    private Buf buf = new Buf();
    JButton[][] mapButton = new JButton[configure.getSIZE()][configure.getSIZE()];


    public ViewGame() {
        coreGame.setViewGame(this);


        setBounds(400, 300, 600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Игра крестики - нолики");


        // Расположение в центре
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);



        Font font = new Font("Arial", NORMAL, 20);

         setLayout(new GridLayout(configure.getSIZE(),configure.getSIZE()));



        for (int i = 0; i < configure.getSIZE(); i++) {
            for (int j = 0; j < configure.getSIZE(); j++) {
                JButton button = new JButton("");
                button.setFont(font);
                mapButton[i][j] = button;

                button.setActionCommand(""+i+" "+j);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Human human = new Human();
                        String actionCommand[] = e.getActionCommand().split(" ");
                        int y = Integer.parseInt(actionCommand[0]);
                        int x = Integer.parseInt(actionCommand[1]);
                        if (human.turn(y,x)){
                            JButton buttonAct= mapButton[y][x];
                            buttonAct.setText(""+configure.getDOT_X());
                        }

                    }
                });

                add(button);
            }
        }

        setVisible(true);
    }


    public void updateView() {
        char[][] map = buf.getMap();
        for (int y = 0; y < configure.getSIZE(); y++) {
            for (int x = 0; x < configure.getSIZE(); x++) {

                JButton buttonAct= mapButton[y][x];
                if (configure.getDOT_EMPTY() != map[y][x])
                {
                    buttonAct.setText(""+map[y][x]);
                }

            }
        }
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
