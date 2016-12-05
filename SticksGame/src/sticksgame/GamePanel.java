/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sticksgame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andrey
 */
public class GamePanel extends JFrame {

    private static final int WIDTH = 506;
    private static final int HEIGHT = 608;
    private GameField gameField;
    private MyListener myListener;
    private JPanel jPanel;
    private Player firstPlayer;
    private Player secondPlayer;
    private int cellSize;

    public GamePanel() {
        super("Sticks game");       
        firstPlayer = new Player(1);
        secondPlayer = new Player(2);
        gameField = new GameField();
        gameField.setFirstPlayer(firstPlayer);
        gameField.setSecondPlayer(secondPlayer);
        myListener = new MyListener(gameField, this, firstPlayer, secondPlayer);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.addMouseListener(myListener);
        jPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Color.black)));
        jPanel.setBackground(Color.WHITE);
        setContentPane(jPanel);
        jPanel.add(gameField, BorderLayout.CENTER);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
