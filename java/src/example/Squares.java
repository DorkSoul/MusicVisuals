package example;

import processing.core.PApplet;
import java.lang.Math;

public class Squares {
    MyVisual mv;

    double x;
    double y;
    double cx;
    double cy;
    double angle;
    double r;

    public Squares(MyVisual mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        cx = (mv.width/2.0f);
        cy = (mv.height/2.0f);
        mv.noStroke();
        
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            mv.fill(PApplet.map(i, 0, mv.getBands().length, 255, 0), 255, 255);

            r = -mv.getSmoothedBands()[i] * 0.15f;
            angle = i * (360/9);

            x = cx + r * Math.cos(angle);
            y = cy + (r-10) * Math.sin(angle);

            mv.square((float)x, (float)y+mv.height/3.5f, -mv.getSmoothedBands()[i] * 0.2f);
           
        }
    }
}
