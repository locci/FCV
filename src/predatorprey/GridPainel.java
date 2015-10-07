package predatorprey;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class GridPainel extends JPanel
{
    private java.util.Timer tempo;
    private final Image fundo;
    private final Image robo;
    private final Image spaceship;
    private final int roboPosX;
    private final int roboPosY;
    private final int shipPosX;
    private final int shipPosY;
    
    
    
            
    public GridPainel()
    {
        
        fundo = Sprite.loadImage(this, "images/fundo.jpg");
        robo = Sprite.loadImage(this, "images/robo.png");
        spaceship = Sprite.loadImage(this, "images/Jupiter2.jpg");
       
       
        
        //Exemplo
//        roboPosX = 500;
//        roboPosY = 350;
//        shipPosX = 100;
//        shipPosY = 100;
        
        roboPosX = 50;
        roboPosY = 150;
        shipPosX = 500;
        shipPosY = 350;
        
//        roboPosX = 50;
//        roboPosY = 50;
//        shipPosX = 650;
//        shipPosY = 500;
        
    }

    public void paintComponent(Graphics g)
    {
        
        Jager jg = new Jager(); 
        
        g.drawImage(fundo, 0, 0, this);
        g.drawImage(robo, roboPosX, roboPosY, this);
        g.drawImage(spaceship, shipPosX, shipPosY, this); 
        System.out.println("ship start position " + shipPosX + " " + shipPosY); 
//        moveRoboDir(g, roboPosX, roboPosY, shipPosX, shipPosY);
        Bresenham br = new Bresenham(roboPosX, roboPosY, shipPosX, shipPosY);
        br.buildPath();
        moveRoboDirBresenham(g, br.pathCol, br.pathRow);   
       

    }    
    
    public void moveRoboDir(Graphics g, int predatorX, int predatorY, int preyX, int preyY)
    {
        Jager ja = new Jager();
        
        System.out.println("robo start position " + predatorX + " " + predatorY); 
        
        while(ja.catchYou(predatorX, preyX, predatorY, preyY)){
            
            predatorX = ja.predatorXMovie(predatorX, preyX);
            predatorY = ja.predatorYMovie(predatorY, preyY);            
            g.drawImage(robo, predatorX, predatorY, this);            
            System.out.println("robo position " + predatorX + " " + predatorY);      
                        
        }
        
        System.out.println("ship end position " + shipPosX + " " + shipPosY);
        System.out.println("robo end position " + predatorX + " " + predatorY);
    }
    
    public void moveRoboDirBresenham(Graphics g, int[] pathCol, int[] pathRow)
    {
           
        for(int i=0; i < pathCol.length; i++) {
            
            if(pathCol[i] == -1) break;
            g.drawImage(robo, pathCol[i], pathRow[i], this);            
            
            
        }
                 
                        
        
    }
    
}
