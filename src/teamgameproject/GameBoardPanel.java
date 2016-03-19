/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgameproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author rwb5529
 */
public class GameBoardPanel extends JPanel {

    private int xAxis = 10;
    private int yAxis = 10;
    private boolean isUnitSelected = false;
    private GameBoardSpace currentSpace = null;
    private GameBoardSpace newSpace = null;
    private Unit currentUnit = null;

    private ArrayList<Unit> units;
    private ArrayList<Unit> darkUnits;
    
    private int numUnits;
    private int numDarkUnits;
    
    private GameBoardSpace[][] boardSpaces = new GameBoardSpace[xAxis][yAxis];

    private MyJPanel mjp;
    
    public GameBoardPanel() {
        super();

        
 

        
        init();
    }
    
    public void init(){
        
        units = new ArrayList<Unit>();
        darkUnits = new ArrayList<Unit>();
        
        
        GridLayout grid = new GridLayout(0, 10);
        setBorder(new LineBorder(Color.GREEN));
        setLayout(grid);
        Insets buttonSeperation = new Insets(0, 0, 0, 0);
        for (int i = 0; i < boardSpaces.length; i++) {
            for (int j = 0; j < boardSpaces[i].length; j++) {
                GameBoardSpace space = new GameBoardSpace(j, i, this, mjp);
                space.setMargin(buttonSeperation);
                ImageIcon spaceIcon = new ImageIcon("src/images/grass.png");
                space.setIcon(spaceIcon);

                boardSpaces[j][i] = space;
                this.add(boardSpaces[j][i]);
                
            }
        }

         /*
        Created methods to create units instead of repeating the same code multiple times
        Ex: AdvancedUnits.Peon p = new AdvancedUnits.Peon();
        boardSpaces[x][y].setUnit(p);
        boardSpaces[x][y].setIsOccupied(true);
        boardSpaces[x][y].displayUnitImg();
        boardSpaces[x][y].setToolTipText(p.getStats());
        becomes createPeon(x, y)
        Refactored by: Shifan Zheng on February 26
        */
        createPeon(2, 0);
        createPeon(2, 3);
        createPeon(2, 4);
        createPeon(2, 5);
        createPeon(2, 6);
        createPeon(2, 9);
        createWizard(0, 2);
        createWizard(0, 7);
        createKnight(1, 1);
        createKnight(1, 2);
        createKnight(1, 7);
        createKnight(1, 8);

        createDarkPeon(7, 0);
        createDarkPeon(7, 3);
        createDarkPeon(7, 4);
        createDarkPeon(7, 5);
        createDarkPeon(7, 6);
        createDarkPeon(7, 9);
        createDarkWizard(9, 2);
        createDarkWizard(9, 7);
        createDarkKnight(8, 1);
        createDarkKnight(8, 2);
        createDarkKnight(8, 7);
        createDarkKnight(8, 8);
        
        numUnits = units.size();
        numDarkUnits = darkUnits.size();
    }
    
    public void restartGame(){
        this.removeAll();
        
        init();
        
        repaint();
        revalidate();
    }

    public int getNumUnits(){
        return this.numUnits;
    }
    
    public int getNumDarkUnits(){
        return this.numDarkUnits;
    }
    
    public void setNumUnits(int numUnits){
        this.numUnits = numUnits;
    }
    
    public void setNumDarkNumUnits(int numDarkUnits){
        this.numDarkUnits = numDarkUnits;
    }
    
    public GameBoardSpace getGameBoardSpace(int x, int y) {
        return boardSpaces[x][y];
    }

    public GameBoardSpace getCurrentSpace() {
        return currentSpace;
    }

    public void setCurrentSpace(GameBoardSpace currentSpace) {
        this.currentSpace = currentSpace;
    }

    public GameBoardSpace getNewSpace() {
        return newSpace;
    }

    public void setNewSpace(GameBoardSpace newSpace) {
        this.newSpace = newSpace;
    }

    public Unit getCurrentUnit() {
        return currentUnit;
    }

    public void setCurrentUnit(Unit currentUnit) {
        this.currentUnit = currentUnit;
    }

    public boolean getIsUnitSelected() {
        return isUnitSelected;
    }

    public void setIsUnitSelected(boolean isUnitSelected) {
        this.isUnitSelected = isUnitSelected;
    }

    public void setGameBoardSpace(int x, int y, GameBoardSpace space) {
        this.boardSpaces[x][y] = space;
    }

    public void createPeon(int x, int y) {
        AdvancedUnits.Peon p = new AdvancedUnits.Peon();
        boardSpaces[x][y].setUnit(p);
        boardSpaces[x][y].setIsOccupied(true);
        boardSpaces[x][y].displayUnitImg();
        boardSpaces[x][y].setToolTipText(p.getStats());
        units.add(p);
        
    }

    public void createDarkPeon(int x, int y) {
        AdvancedUnits.DarkPeon dp = new AdvancedUnits.DarkPeon();
        boardSpaces[x][y].setUnit(dp);
        boardSpaces[x][y].setIsOccupied(true);
        boardSpaces[x][y].displayUnitImg();
        boardSpaces[x][y].setToolTipText(dp.getStats());
        darkUnits.add(dp);
    }

    public void createWizard(int x, int y) {
        AdvancedUnits.Wizard w = new AdvancedUnits.Wizard();
        boardSpaces[x][y].setUnit(w);
        boardSpaces[x][y].setIsOccupied(true);
        boardSpaces[x][y].displayUnitImg();
        boardSpaces[x][y].setToolTipText(w.getStats());
        units.add(w);
    }

    public void createDarkWizard(int x, int y) {
        AdvancedUnits.DarkWizard dw = new AdvancedUnits.DarkWizard();
        boardSpaces[x][y].setUnit(dw);
        boardSpaces[x][y].setIsOccupied(true);
        boardSpaces[x][y].displayUnitImg();
        boardSpaces[x][y].setToolTipText(dw.getStats());
        darkUnits.add(dw);
    }

    public void createKnight(int x, int y) {
        AdvancedUnits.Knight k = new AdvancedUnits.Knight();
        boardSpaces[x][y].setUnit(k);
        boardSpaces[x][y].setIsOccupied(true);
        boardSpaces[x][y].displayUnitImg();
        boardSpaces[x][y].setToolTipText(k.getStats());
        units.add(k);
    }

    public void createDarkKnight(int x, int y) {
        AdvancedUnits.DarkKnight dk = new AdvancedUnits.DarkKnight();
        boardSpaces[x][y].setUnit(dk);
        boardSpaces[x][y].setIsOccupied(true);
        boardSpaces[x][y].displayUnitImg();
        boardSpaces[x][y].setToolTipText(dk.getStats());
        darkUnits.add(dk);
    }

}
