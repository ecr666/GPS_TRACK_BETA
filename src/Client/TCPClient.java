/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Vimukthi
 */
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String argv[]) throws Exception {
        String sentence="make vimukthi capital";
        String modifiedSentence;
        
        /* router ip= 172.20.10.1   => connection refused
         * 172.20.10.2
         * localhost
         * 
         */
        
        try (Socket clientSocket = new Socket("127.0.0.1", 4321)) {
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println(modifiedSentence);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}

