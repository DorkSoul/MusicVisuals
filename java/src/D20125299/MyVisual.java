package D20125299;

import example.ColorBand;
import ie.tudublin.*;

public class MyVisual extends Visual
{    
    // each visual scene
    WaveForm wf;
    Circles cir;
    Squares squ;
    TurnAngle tur;
    ColorBand cb;

    int which = 0;

    public void settings()
    {
        size(1000, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        //uncomment to select song

        //loadAudio("heroplanet.mp3");
        //loadAudio("Mi Mi Mi.mp3"); 
        loadAudio("Shatter Me.mp3"); 
        //loadAudio("Dont Stop Me Now.mp3");    

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        cir = new Circles(this);
        squ = new Squares(this);
        tur = new TurnAngle(this);
        cb = new ColorBand(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

        // 0 is default timed 60 second swap. click 1-5 for manual selection.
        if (keyCode == '0') {
            which = keyCode - '0';
        }

        if (keyCode == '1') {
            which = keyCode - '0';
        }

        if (keyCode == '2') {
            which = keyCode - '0';
        }

        if (keyCode == '3') {
            which = keyCode - '0';
        }

        if (keyCode == '4') {
            which = keyCode - '0';
        }

        if (keyCode == '5') {
            which = keyCode - '0';
        }
    }

    public void draw()
    {
        //used to count seconds to alow for auto swap
        int m = millis()/1000;

        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
       
        switch (which)
        {  
            case 0:
            {
                //Scene will swap every 60 seconds
                
                if(m <= 60){
                    wf.render();
                }

                if(m > 60 && m <= 120){
                    cir.render();
                }
        
                if(m > 120 && m <= 180){
                    squ.render();
                }
        
                if(m > 180 && m <= 240){
                    tur.render();
                }
        
                if(m > 240){
                    cb.render();
                }

                break;
            }
            case 1:
            {
                wf.render();
                break;
            }
            case 2:
            {
                cir.render();
                break;
            }
            case 3:
            {
                squ.render();
                break;
            }
            case 4:
            {
                tur.render();
               break;
            }
            case 5:
            {
                cb.render();
               break;
            }
        }
    }
}
