
package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.dynalink.linker.LinkerServices;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

/**
 *
 * @author user
 */
public class MouseLisener implements NativeMouseListener, Runnable{
    public static boolean clicked = false;
    private int tDoX = 0;
    private int tDoY = 0;
    private int tDoX2 = 0;
    private int tDoY2 = 0;

    public void settDoX2(int tDoX2) {
        this.tDoX2 = tDoX2;
    }

    public void settDoY2(int tDoY2) {
        this.tDoY2 = tDoY2;
    }

    public int gettDoX2() {
        return tDoX2;
    }

    public int gettDoY2() {
        return tDoY2;
    }

    public static void setClicked(boolean clicked) {
        MouseLisener.clicked = clicked;
    }

    public void settDoX(int tDoX) {
        this.tDoX = tDoX;
    }

    public void settDoY(int tDoY) {
        this.tDoY = tDoY;
    }

    public static boolean isClicked() {
        return clicked;
    }

    public int gettDoX() {
        return this.tDoX;
    }

    public int gettDoY() {
        return this.tDoY;
    }
    public boolean checkLick()
    {
        boolean check = false;
        
        return check;
    }
    public static void main(String agrs[])
    {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            Logger.getLogger(MouseLisener.class.getName()).log(Level.SEVERE, null, ex);
        }
        GlobalScreen.addNativeMouseListener(new MouseLisener());
        
        System.out.println("le quang sang");
        // set deable all exception
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.ALL);
        // Don't forget to disable the parent handlers.
        logger.setUseParentHandlers(false);
    }
    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {
            System.out.println(clicked);
            clicked = true;
            System.out.println("("+e.getX()+","+e.getY()+")");
    }
    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        if(e.getButton()==1)
        {
            //clicked = true;
            System.out.println("Left");
            System.out.println("("+e.getX()+","+e.getY()+")");
        }
        else if(e.getButton()==2)
        {
            System.out.print("Right");
        }
        else
        {
            System.out.print("Middle");
        }
    }
    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
        if(e.getButton()==1)
        {
          System.out.println("Left");
          //System.out.println("("+e.getX()+","+e.getY()+")");
        }
        else if(e.getButton()==2)
        {
            System.out.print("Right");
        }
        else
        {
            System.out.print("Middle");
        }
        //System.out.println(e.getButton());
    }

    @Override
    public void run() {
        System.out.println("Mose");
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
