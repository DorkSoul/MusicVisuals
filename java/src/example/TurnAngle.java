package example;

import processing.core.PApplet;
import java.lang.Math;

public class TurnAngle {
    MyVisual mv;

    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;
    double x4;
    double y4;
    float cx;
    float cy;
    double angle;
    double r;

    public TurnAngle(MyVisual mv)
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

            r = mv.getSmoothedBands()[i] * 1.0f;
            angle = (i+1) * 40;


            x1 = r * Math.cos(angle);
            y1 = r * Math.sin(angle);

            x2 = r * Math.cos(angle+90);
            y2 = r * Math.sin(angle+90);
           
            mv.quad(cx + (float)x1, cy + (float)y1, 
                    cx + (float)x2, cy + (float)y2, 
                    cx, cy, 
                    cx, cy); 
        }
    }
}
