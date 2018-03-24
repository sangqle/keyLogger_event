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
        Webcam webcam = Webcam.getDefault(); // step1 initilize webcam object
        webcam.setViewSize(WebcamResolution.VGA.getSize()); // set size full frame of webcam.
        //webcam.setViewSize(new Dimension(1280, 720)); // erro
        webcam.open(); // step1 
        String temp1 = Integer.toString(screen++); // String file name for not similar
        String path = "D://Photo//"+temp1+".jpg"; // secondary to check
        //String path = "D://SangB1699999//New folder//New folder (4)//New folder (3)//New folder (2)//New folder//Photo//"+temp1+".png";
        ImageIO.write(webcam.getImage(), "JPG", new File(path)); 
        webcam.close();
        System.out.println("webcam capture: "+screen);
        
        
    }

    @Override
    public void run() {
        // gọi luồng mouse
//        MouseLisener mouse = new MouseLisener(); // khởi tạo luồng bắt chuộc
//            Thread tMouse = new Thread(mouse);
//            tMouse.start();
        while(true)
        {
            
            try {
                if(true)
                {
                    try {
                            Screen(); // call method screen for webcam capture
                    } catch (IOException ex) {
                        Logger.getLogger(WebcamPanelExample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println("Le quang sang");
                    MouseLisener.clicked = false;
                }
                else
                {
                    Thread.sleep(4000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(WebcamPanelExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Tada i got it
        }

}
