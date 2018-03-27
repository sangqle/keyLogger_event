package main;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jnativehook.GlobalScreen;

public class WebcamPanelExample implements Runnable {

    public static int screen = 0;
    public static boolean checkWebCam = true;
    public static String str = null; // file name

    public static void Screen() throws IOException {
        // TODO code application logic here
        Webcam webcam = Webcam.getDefault(); // step1 initilize webcam object
        webcam.setViewSize(WebcamResolution.VGA.getSize()); // set size full frame of webcam.
        //webcam.setViewSize(new Dimension(640, 480)); // erro
        webcam.open(); // step1 
        //String temp1 = Integer.toString(screen++); // String file name for not similar
        str = currentTime.takeTime();
        String path = "D://Photo//" + str + ".jpg"; // secondary to check
        //String path = "D://SangB1699999//New folder//New folder (4)//New folder (3)//New folder (2)//New folder//Photo//"+temp1+".png";
        ImageIO.write(webcam.getImage(), "JPG", new File(path));
        webcam.close();
        System.out.println("webcam capture: " + screen);
         // set deable all exception
         Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
         logger.setLevel(Level.ALL);
         // Don't forget to disable the parent handlers.
         logger.setUseParentHandlers(false);
    }
    @Override
    public void run() {
        while (true) {
            if (checkWebCam == false) {
                Thread.currentThread().interrupt(); // desloy current thread if not have webcam
            }
            try {
                if (MouseLisener.checkLick() == true) {
                    try {
                        Screen(); // call method screen for webcam capture
                        MouseLisener.clicked = false;
                        Thread.sleep(30000); // sau khi chụp đợi 10 giây nữa mới chụp tiếp. nếu có click chuot
                    } catch (IOException ex) {
                        Logger.getLogger(WebcamPanelExample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println("Le quang sang");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(WebcamPanelExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Tada i got it
    }

}
