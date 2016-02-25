/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgameproject;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author rwb5529
 */
public class GameBoardPanel extends JPanel{
    
    private int xAxis = 10;
    private int yAxis = 10;
    
    
    private GameBoardSpace[][] boardSpaces = new GameBoardSpace[xAxis][yAxis];
    
    
    
    public GameBoardPanel(){
        super();
        
        
        GridLayout grid = new GridLayout(0, 10);
        setBorder(new LineBorder(Color.BLACK));
        setLayout(grid);
        
        Insets buttonSeperation = new Insets(0,0,0,0);
        for (int i = 0; i < boardSpaces.length; i++){
            for (int j = 0; j < boardSpaces[i].length; j++){
                GameBoardSpace space = new GameBoardSpace();
                space.setMargin(buttonSeperation);
                ImageIcon spaceIcon = new ImageIcon(new BufferedImage(50,50, BufferedImage.TYPE_INT_ARGB));
                space.setIcon(spaceIcon);
                
                
                space.setBackground(Color.WHITE);
                boardSpaces[j][i] = space;
                this.add(boardSpaces[j][i]);
                addActionListener(boardSpaces[j][i]);
            }
        }
        
    }
}
