/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sticksgame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Andrey
 */
public class MyListener implements MouseListener {

    GameField gameField;
    GamePanel gamePanel;
    Player firstPlayer;
    Player secondPlayer;

    public MyListener(GameField gamefield, GamePanel gamePanel, Player firstPlayer, Player secondPlayer) {
        this.gameField = gamefield;
        this.gamePanel = gamePanel;
        this.firstPlayer = firstPlayer;
        this.firstPlayer.setActive(true);
        this.secondPlayer = secondPlayer;
        this.secondPlayer.setActive(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int previousIndicator = 0;
        int nextIndicator = 0;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                if ((e.getX() - 6) > this.gameField.getHorizontalBorders()[i][j].getX()
                        && (e.getX() - 6) < (this.gameField.getHorizontalBorders()[i][j].getX() + this.gameField.getHorizontalBorders()[i][j].getWidth())
                        && (e.getY() - 6) > this.gameField.getHorizontalBorders()[i][j].getY()
                        && (e.getY() - 6) < (this.gameField.getHorizontalBorders()[i][j].getY() + this.gameField.getHorizontalBorders()[i][j].getHeigth())) {
                    this.gameField.getHorizontalBorders()[i][j].setColor(Color.BLACK);
                    nextIndicator++;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                if ((e.getX() - 6) > this.gameField.getVerticalBorders()[i][j].getX()
                        && (e.getX() - 6) < this.gameField.getVerticalBorders()[i][j].getX() + this.gameField.getVerticalBorders()[i][j].getWidth()
                        && (e.getY() - 6) > this.gameField.getVerticalBorders()[i][j].getY()
                        && (e.getY() - 6) < this.gameField.getVerticalBorders()[i][j].getY() + this.gameField.getVerticalBorders()[i][j].getHeigth()) {
                    this.gameField.getVerticalBorders()[i][j].setColor(Color.BLACK);
                    nextIndicator++;
                }
            }
        }

        if (this.firstPlayer.isActive()) {
            int firstInspector = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (this.gameField.getCells()[i][j].getHorizontalBorders()[0].getColor().equals(Color.BLACK)
                            && this.gameField.getCells()[i][j].getHorizontalBorders()[1].getColor().equals(Color.BLACK)
                            && this.gameField.getCells()[i][j].getVerticalBorders()[0].getColor().equals(Color.BLACK)
                            && this.gameField.getCells()[i][j].getVerticalBorders()[1].getColor().equals(Color.BLACK)
                            && this.gameField.getCells()[i][j].getColor().equals(Color.WHITE)) {
                        this.gameField.getCells()[i][j].setColor(Color.RED);
                        this.firstPlayer.increaseScore();
                        this.firstPlayer.setActive(true);
                        this.secondPlayer.setActive(false);
                        firstInspector++;
                    } else if (firstInspector == 0) {
                        if ((nextIndicator - previousIndicator) > 0) {
                            this.firstPlayer.setActive(false);
                            this.secondPlayer.setActive(true);
                            previousIndicator++;
                        }
                    }
                }
            }
            if (this.firstPlayer.isActive()) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }

        } else if (this.secondPlayer.isActive()) {
            int secondInspector = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (this.gameField.getCells()[i][j].getHorizontalBorders()[0].getColor().equals(Color.BLACK)
                            && this.gameField.getCells()[i][j].getHorizontalBorders()[1].getColor().equals(Color.BLACK)
                            && this.gameField.getCells()[i][j].getVerticalBorders()[0].getColor().equals(Color.BLACK)
                            && this.gameField.getCells()[i][j].getVerticalBorders()[1].getColor().equals(Color.BLACK)
                            && this.gameField.getCells()[i][j].getColor().equals(Color.WHITE)) {
                        this.gameField.getCells()[i][j].setColor(Color.BLUE);
                        this.secondPlayer.increaseScore();
                        this.firstPlayer.setActive(false);
                        this.secondPlayer.setActive(true);
                        secondInspector++;
                    } else if (secondInspector == 0) {
                        if ((nextIndicator - previousIndicator) > 0) {
                            this.firstPlayer.setActive(true);
                            this.secondPlayer.setActive(false);
                            previousIndicator++;
                        }
                    }
                }
            }
            if (this.firstPlayer.isActive()) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
        gamePanel.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
