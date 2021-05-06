package example;

import processing.core.*;

public class Circles {
    MyVisual mv;

    float cx;
    float cy;
    float t = 0;

    public Circles(MyVisual mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        
        mv.noStroke();
        
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            mv.fill(PApplet.map(i, 0, mv.getBands().length, 255, 0), 255, 255);

            if(i >= 0 && i <=2)
            {
                cx = (mv.width/3)/2;
                cy = ((mv.height/3)/2)+((mv.height/3)*t);
                mv.circle(cx, cy, -mv.getSmoothedBands()[i] * 0.2f);
                t++;
            }

            if(i >= 3 && i <=5)
            {
                cx = ((mv.width/3)/2)+(mv.width/3);
                cy = ((mv.height/3)/2)+((mv.height/3)*(t-3));
                mv.circle(cx, cy, -mv.getSmoothedBands()[i] * 0.2f);
                t++;
            }

            if(i >= 6 && i <=8)
            {
                cx = ((mv.width/3)/2)+((mv.width/3)*2);
                cy = ((mv.height/3)/2)+((mv.height/3)*(t-6));
                mv.circle(cx, cy, -mv.getSmoothedBands()[i] * 0.2f);
                t++;
            }
        }
        t = 0;
    }
}
