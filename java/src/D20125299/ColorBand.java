package example;

import D20125299.MyVisual;
import processing.core.*;

public class ColorBand {
    MyVisual mv;

    float squ;
    float cx = 0;
    float cy = 0;
    float curr = 0;
    float prev = 0;
    float xWidth = 0;
    float xColor = 0;
    float br = 0;
    float colorLerp = 0;

    public ColorBand(MyVisual mv)
    {
        this.mv = mv; 
        cy = this.mv.height / 2;
    }

    public void render()
    {
        mv.colorMode(PApplet.HSB);

        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            //set size of squares
            squ = mv.width/(100);
            mv.noStroke();

            //split audio into sections of each square
            xWidth = PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, mv.width/2);

            for(int n = 0; n <= ((mv.height/2)/squ); n++)
            {
                //change color and iteration progresses
                xColor = PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255);

                //used for lerping between current and previous note
                curr = PApplet.lerp(prev, mv.getAudioBuffer().get(i), 0.05f);

                //change brightness as amplitude of note changes
                br = PApplet.map(Math.abs(curr), 0f, 0.7f, 0f, 255f);

                mv.fill(xColor, 255, br);

                //draw squares to screen
                mv.square((mv.width/2)-(squ/2)+xWidth, (mv.height/2)-(squ/2)+(n*squ), squ);
                mv.square((mv.width/2)-(squ/2)-xWidth, (mv.height/2)-(squ/2)-(n*squ), squ);
                mv.square((mv.width/2)-(squ/2)+xWidth, (mv.height/2)-(squ/2)-(n*squ), squ);
                mv.square((mv.width/2)-(squ/2)-xWidth, (mv.height/2)-(squ/2)+(n*squ), squ);
            }
            //used for lerping
            prev = curr;
        }
           
    }
}
