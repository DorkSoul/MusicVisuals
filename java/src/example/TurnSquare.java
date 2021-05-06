package example;

import processing.core.PApplet;
import java.lang.Math;

public class TurnSquare {
    MyVisual mv;

    double x;
    double y;
    double cx;
    double cy;
    double angle;
    double r;

    public TurnSquare(MyVisual mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        cx = mv.width/2.0f;
        cy = mv.height/2.0f;
        mv.noStroke();
        
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            mv.fill(PApplet.map(i, 0, mv.getBands().length, 255, 0), 255, 255);

            r = -mv.getSmoothedBands()[i] * 0.2f;
            angle = i * (360/9);

            x = cx + r * Math.cos(angle);
            y = cy + r * Math.sin(angle);

            System.out.print("double x is " + x + "\n");
            System.out.print("double x is " + y + "\n");
            

            mv.square((float)x, (float)y, -mv.getSmoothedBands()[i] * 0.3f);

            System.out.print("float x is " + (float)x + "\n");
            System.out.print("float x is " + (float)y + "\n");
            //mv.rect(a, b, c, d);
            
        }
    }
}
