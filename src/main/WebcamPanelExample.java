package main;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;


import static main.FullScreenCaptureExample.index;

public class WebcamPanelExample implements Runnable{
public static int screen = 0;
    public static void Screen() throws IOException{
        // TODO code application logic here
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        //webcam.setViewSize(new Dimension(1280, 720));
        webcam.open();
        String temp1 = Integer.toString(screen++);
        String path = "D://SangB1699999//Photo//"+temp1+".jpg";
        //String path = "D://SangB1699999//New folder//New folder (4)//New folder (3)//New folder (2)//New folder//Photo//"+temp1+".png";
        ImageIO.write(webcam.getImage(), "JPG", new File(path));
        webcam.close();
        System.out.println("webcam capture: "+screen);
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                try {
                    Screen(); // call method screen for webcam capture
                } catch (IOException ex) {
                    Logger.getLogger(WebcamPanelExample.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println("Le quang sang");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WebcamPanelExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
