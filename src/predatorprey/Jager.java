 package predatorprey;

/**
 *
 * @author alexandre
 */


public class Jager {
    

    public int predatorXMovie (int predatorX, int prayX) {
        
        if( predatorX > prayX) {
            
            return (predatorX - 50);
            
        } else {
            
            if( predatorX < prayX) {
                
                return (predatorX + 50);
            }
                        
        }
        
        return predatorX;
        
    }
    
    public int predatorYMovie (int predatorY, int prayY) {
        
        if( predatorY > prayY) {
            
            return (predatorY - 50);
            
        } else {
            
            if( predatorY < prayY) {
                
                return (predatorY + 50);
                
            }
                        
        }
        
        return predatorY;
        
    }
    
    public boolean catchYou(int predatorX, int prayX, int predatorY, int prayY) {
        
        return (predatorX != prayX || predatorY != prayY);
        
    }
    
}
