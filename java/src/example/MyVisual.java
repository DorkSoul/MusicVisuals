package example;

import ie.tudublin.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;
    Circles cir;
    Squares squ;
    TurnAngle tur;

    int which = 0;

    public void settings()
    {
        size(1024, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Shatter Me.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        cir = new Circles(this);
        squ = new Squares(this);
        tur = new TurnAngle(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

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
    }

    public void draw()
    {
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
                wf.render();   
                break;
            }   
            case 1:
            {
                abv.render(); 
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
               break;
            }
        }
    }
}
