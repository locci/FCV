package predatorprey;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Sprite
{
    private int qtdeFrames;
    private Image frames[];
    private int frameAtual;
    private String fileName;
    private int top;
    private int left;

    public Sprite(JPanel painel, String filename, int qtdeFrames)
    {
        this.fileName = filename;
        this.qtdeFrames = qtdeFrames;
        frames = new Image[qtdeFrames];
        MediaTracker tracker = new MediaTracker(painel);
        for(int i=0; i < qtdeFrames; i++)
        {
            frames[i] = Toolkit.getDefaultToolkit().getImage(filename+"/frame"+(i+1)+".png");
            tracker.addImage(frames[i],0);
        }
        try { tracker.waitForAll(); }
        catch(InterruptedException e) { }

        frameAtual = 0;
    }

    public void draw(Graphics g)
    {
        g.drawImage(frames[frameAtual], left, top, null);
    }

    public void setFrameAtual(int frameAtual)
    {
        if(frameAtual < qtdeFrames)
            this.frameAtual = frameAtual;
    }

    public void mudaFrame()
    {
        frameAtual++;
        if(frameAtual >= qtdeFrames)
            this.frameAtual = 0;
    }

    public void moveHorizontal(int dif)
    {
        left = left + dif;
    }

    public void moveVertical(int dif)
    {
        top = top + dif;
    }

    public void setPosition(int left, int top)
    {
        setLeft(left);
        setTop(top);
    }
    /**
     * @return the top
     */
    public int getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * @return the left
     */
    public int getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(int left) {
        this.left = left;
    }

    public static Image loadImage(JPanel painel, String filename)
    {
        Image image;
        MediaTracker tracker = new MediaTracker(painel);
        image = Toolkit.getDefaultToolkit().getImage(filename);
        tracker.addImage(image,0);
        try { tracker.waitForAll(); }
        catch(InterruptedException e) { }

        return image;
    }
    
}
