package example;

import processing.core.PApplet;

// This is an example of a visual that renders the waveform

// most unchanged from given example just added lerping

public class WaveForm
{
    MyVisual mv;
    float cy = 0;
    float curr = 0;
    float prev = 0;
    int t = 0;
    int r = 0;

    public WaveForm(MyVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
    }

    public void render()
    {
        mv.colorMode(PApplet.HSB);

        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );
            
            curr = PApplet.lerp(prev, mv.getAudioBuffer().get(i), 0.1f);
            mv.line(i+i, (cy - cy * curr), i+i, (cy + cy * curr));
            prev = curr;
        }
           
        
        
    }
}