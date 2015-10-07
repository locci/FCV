/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorprey;

/**
 *
 * @author alexandreloccimartins
 */
public class Bresenham {
    
    public final int KMAXPATHLENGTH = 10000;    
    public int nextCol;
    public int nextRow;
    public int endCol;
    public int endRow;
    public int deltaRow;
    public int deltaCol;
    public int stepCol;
    public int stepRow;
    public int currentStep;
    public int fraction;
    public int[] pathRow = new int[KMAXPATHLENGTH];
    public int[] pathCol = new int[KMAXPATHLENGTH];

    public Bresenham(int startCol, int startRow, int colEnd, int rowEnd) {
        
        nextCol = startCol;
        nextRow = startRow;
        endRow = rowEnd;
        endCol = colEnd;
        deltaRow = rowEnd - startRow;
        deltaCol = colEnd - startCol;
        currentStep = 0;
        
        
    }
    
    public void buildPath() {
        
               
        //Bresenham br = new Bresenham(startX, startY, endX, endY);
        
        for (int i = 0; i < KMAXPATHLENGTH; i++) {
            
           pathCol[i] = -1;
           pathRow[i] = -1;
            
        }
        
        currentStep = 0;
        
        if(deltaRow < 0) {
            stepRow = -1;
        } else {
            stepRow = 1;
        }
        
        if(deltaCol < 0) {
            stepCol = -1;
        } else {
            stepCol = 1;
        }
        
        deltaRow = Math.abs(deltaRow * 2);
        deltaCol = Math.abs(deltaCol * 2);
        pathRow[currentStep] = nextRow;
        pathCol[currentStep] = nextCol;
        currentStep++;
        
        if (deltaCol > deltaRow) {
            
            fraction = deltaRow * 2 - deltaCol;
            
            while(nextCol != endCol){
                
                if (fraction >= 0) {
                    nextRow = nextRow + stepRow;
                    fraction = fraction - deltaCol;
                } 
                
                nextCol = nextCol + stepCol;                
                fraction = fraction + deltaRow;
                pathRow[currentStep] = nextRow;
                pathCol[currentStep] = nextCol;
                System.out.println(currentStep + " " + pathCol[currentStep] + " " + pathRow[currentStep]);
                currentStep++;

            }
            
            
        } else {
           
            
            fraction = deltaCol * 2 - deltaRow;
            
            while(nextRow != endRow){
                
                if (fraction >= 0) {
                    nextCol = nextCol + stepCol;
                    fraction = fraction - deltaRow;
                }
                
                nextRow = nextRow + stepRow;
                fraction = fraction - deltaCol;
                pathRow[currentStep] = nextRow;
                pathCol[currentStep] = nextCol;
                currentStep++;

            }
            
        }
        
        
        
    } 
    
    
}
