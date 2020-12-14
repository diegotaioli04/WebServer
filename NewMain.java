/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

/**
 *
 * @author Diego
 */
public class NewMain {

    static final int PORT = 8080;
    static final boolean verbose = true;
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
		try {
			ServerSocket serverConnect = new ServerSocket(PORT);
			System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");
			
			// we listen until user halts server execution
			while (true) {
				JavaHTTPServer myServer = new JavaHTTPServer(serverConnect.accept(), verbose);
				
				if (verbose) {
					System.out.println("Connecton opened. (" + new Date() + ")");
				}
				
				// create dedicated thread to manage the client connection
				//Thread thread = new Thread(myServer);
				//thread.start();
                                myServer.avvia();
			}
			
		} catch (IOException e) {
			System.err.println("Server Connection error : " + e.getMessage());
		}
	}
    
}
