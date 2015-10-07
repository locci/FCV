package predatorprey;

import javax.swing.JFrame;


public class Janela extends JFrame 
{
    private GridPainel painel;
   
    public Janela()
    {
            painel = new GridPainel();         
            
            this.getContentPane().add(painel);
            setTitle("Predator and Pray");
            setSize(800,650);             
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
    }

    public void loop()
    {
      
        
        
    }
}
