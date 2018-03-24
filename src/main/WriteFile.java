package main;
import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile implements Runnable{
	public void writeFile(String key) throws IOException {
		try {
                        FileOutputStream fos = new FileOutputStream("D://SangB1699999//test.txt",true);
			//FileOutputStream fos = new FileOutputStream("D://SangB1699999//New folder//New folder (4)//New folder (3)//New folder (2)//New folder//test.txt", true); // if file null then create file test.txt
			//create object printwriter
			PrintWriter pw = new PrintWriter(fos); // for print in fos file
			pw.print(key);
			pw.close();
			fos.flush();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]) throws IOException
	{
		WriteFile sang = new WriteFile();
		//sang.writeFile("tran cong an");
		//System.out.println("le quang sang");
		
	}

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
