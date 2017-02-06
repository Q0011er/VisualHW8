import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by buran9 on 28.01.2017.
 */

public class MyWindow extends JFrame{
    Map jpMap;
    Font btnFont = new Font("Times New Roman", Font.PLAIN, 16);

    public MyWindow() {
        setSize(505,587);
        setResizable(false);
        setLocation(800, 200);
        setTitle("Java-1 Unit-8");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jpMap=new Map();
        jpMap.startNewGame(3);
        add(jpMap, BorderLayout.CENTER);
        final JPanel jpBottom = new JPanel(new CardLayout());
        jpBottom.setPreferredSize(new Dimension(1, 60));
        add(jpBottom, BorderLayout.SOUTH);


        JPanel jpStartExit = new JPanel(new GridLayout());
        JButton jbStart = new JButton("Start new GAME");
        jbStart.setFont(btnFont);
        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpSelectPlayers");
            }
        });
        jpStartExit.add(jbStart);
        JButton jbExit = new JButton("Exit GAME");
        jbExit.setFont(btnFont);
        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jpStartExit.add(jbExit);
        jpBottom.add(jpStartExit, "jpStartExit");

        JPanel jpSelectPlayers = new JPanel (new GridBagLayout());
        JButton jbHumanVsHuman = new JButton("Human VS Human");
        jbHumanVsHuman.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpSelectMap");
        }

        });
        JButton jbHumanVsAi = new JButton ("Homan vs AI");
        jbHumanVsAi.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpSelectMap");
            }
        });
        jpSelectPlayers.add(jbHumanVsHuman);
        jpSelectPlayers.add(jbHumanVsAi);
        jpBottom.add(jpSelectPlayers, "jpSelectPlayers");

        JPanel jpSelectMap = new JPanel(new GridLayout());
        JButton jbSM3x3l3 = new JButton("Поле: 3x3 Серия: 3");
        JButton jbSM5x5l4 = new JButton("Поле: 5x5 Серия: 4");
        JButton jbSM10x10l5 = new JButton ("Поле: 10x10 Серия: 5");
        jpSelectMap.add(jbSM3x3l3);
        jbSM3x3l3.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpStartExit");
                createMap (3);
            }
        });
        jpSelectMap.add(jbSM5x5l4);
        jbSM5x5l4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpBottom.getLayout()).show(jpBottom,"jpStartExit");
                createMap(5);
            }
        });
        jpSelectMap.add(jbSM10x10l5);
        jbSM10x10l5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpStartExit");
                createMap(10);
            }
        });
        jpBottom.add(jpSelectMap, "jpSelectMap");
        ((CardLayout)jpBottom.getLayout()).show(jpBottom, "jpStartExit");
        setVisible(true);
    }

    public void createMap (int size) {
        jpMap.startNewGame(size);
    }
}
