/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sticksgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andrey
 */
public class GameField extends JPanel {

    private Cell[][] cells;
    private HorizontalBorder[][] horizontalBorders;
    private VerticalBorder[][] verticalBorders;
    private Player firstPlayer;
    private Player secondPlayer;

    public GameField() {
        setOpaque(true);
        initializeHorizontalBorders(45);
        initializeVerticalBorders(45);
        initializeCells(45);
        this.setFirstPlayer(firstPlayer);
        this.setSecondPlayer(secondPlayer);
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public HorizontalBorder[][] getHorizontalBorders() {
        return horizontalBorders;
    }

    public void setHorizontalBorders(HorizontalBorder[][] horizontalBorders) {
        this.horizontalBorders = horizontalBorders;
    }

    public VerticalBorder[][] getVerticalBorders() {
        return verticalBorders;
    }

    public void setVerticalBorders(VerticalBorder[][] verticalBorders) {
        this.verticalBorders = verticalBorders;
    }

    public void initializeCells(int cellSize) {
        cells = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new Cell(17 + (j * cellSize), 96 + i * cellSize, cellSize - 7, cellSize - 7);
                HorizontalBorder[] hB = {horizontalBorders[i][j], horizontalBorders[i + 1][j]};
                VerticalBorder[] vB = {verticalBorders[i][j], verticalBorders[i][j + 1]};
                cells[i][j].setHorizontalBorders(hB);
                cells[i][j].setVerticalBorders(vB);
            }
        }
    }

    public void initializeHorizontalBorders(int cellSize) {
        horizontalBorders = new HorizontalBorder[11][10];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                horizontalBorders[i][j] = new HorizontalBorder(Color.LIGHT_GRAY,
                        17 + (j * cellSize), 89 + i * cellSize, cellSize - 6, 8);
            }
        }
    }

    public void initializeVerticalBorders(int cellSize) {
        verticalBorders = new VerticalBorder[10][11];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                verticalBorders[i][j] = new VerticalBorder(Color.LIGHT_GRAY,
                        10 + (j * cellSize), 96 + i * cellSize, 8, cellSize - 7);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        Font scoreFont = new Font("Tahoma", Font.PLAIN, 25);
        g.setFont(scoreFont);
        g.drawString("Score", 207, 30);
        Font playersFont = new Font("Tahoma", Font.PLAIN, 20);
        g.setFont(playersFont);
        g.drawString("Player 1", 10, 63);
        g.drawString("Player 2", 396, 63);
        
        g.drawString(Integer.toString(firstPlayer.getScore()), 215, 63);
        g.drawString(Integer.toString(secondPlayer.getScore()), 251, 63);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g.setColor(cells[i][j].getColor());
                g.fillRect(cells[i][j].getX(), cells[i][j].getY(), cells[i][j].getWidth(), cells[i][j].getHeigth());
            }
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                g.setColor(horizontalBorders[i][j].getColor());
                g.fillRect(horizontalBorders[i][j].getX(), horizontalBorders[i][j].getY(),
                        horizontalBorders[i][j].getWidth(), horizontalBorders[i][j].getHeigth());
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                g.setColor(verticalBorders[i][j].getColor());
                g.fillRect(verticalBorders[i][j].getX(), verticalBorders[i][j].getY(),
                        verticalBorders[i][j].getWidth(), verticalBorders[i][j].getHeigth());
            }
        }
    }
}
