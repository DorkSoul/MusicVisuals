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
        //set center point of drawing
        cx = (mv.width/2.0f);
        cy = (mv.height/2.0f)-50;
        mv.noStroke();
        
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            //map bands to color
            mv.fill(PApplet.map(i, 0, mv.getBands().length, 255, 0), 255, 255);

            //set radius and angle for each iteration
            r = -mv.getSmoothedBands()[i] * 0.20f;
            angle = i * (360/9);

            //calculate the x and y to draw square in relation to a circle around cy and cy 
            x = cx + r * Math.cos(angle);
            y = cy + (r-10) * Math.sin(angle);

            //draw squares
            mv.square((float)x, (float)y+mv.height/3.5f, -mv.getSmoothedBands()[i] * 0.2f);
           
        }
    }
}
