package vttp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client 
{
    public static void main( String[] args )
    {
     
        String request = "";

        try {
            Socket socket = new Socket("task02.chuklee.com", 80);
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();

            ObjectOutputStream ous = new ObjectOutputStream(os);
            ObjectInputStream ois = new ObjectInputStream(is);
          

            request = ois.readUTF();

            ous.writeUTF(requestID(request));
            ous.writeUTF("Lim Hong Yew");
            ous.writeUTF("hongyew.lim@protonmail.com");
            ous.writeFloat(calculateMean(request));
            ous.flush();
            
            Boolean answer = ois.readBoolean();
            System.out.println(answer);

            if (answer) {
                System.out.println("SUCCESS");
                System.exit(1);
            } else if (!answer) {
                System.out.println(ois.readUTF());
                System.out.println("FAILED");
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 

    }

    public static Float calculateMean(String request) {
        String[] requestArray = request.split(" ");
        String requestId = requestArray[0];
        String list = requestArray[1];
        String[] listArray = list.split(",");
        Float[] floatArray = null;

        if (listArray !=null) {
            floatArray = new Float[listArray.length];

    
        for (int i = 0; i < listArray.length; i++) {
            floatArray[i] = Float.parseFloat(listArray[i]);
            } 
        }

        Float total = 0F;

        for (int i = 0; i < floatArray.length; i++) {
            total += floatArray[i];
        }

        System.out.println("Total: " + total);

        Float average = total/ (floatArray.length);

        System.out.println("The average is: " + average);

        return average;
    }

    public static String requestID(String request){
    
        String[] requestArray = request.split(" ");
        String requestId = requestArray[0];
        return requestId;
    }
}

