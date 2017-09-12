package com.soneghett.sockets.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient_1 {

	public static void main( String args[] ) {
		Socket s = null;
		try {
			int serverPort = 7896;
			s = new Socket( "localhost", serverPort );
			PrintWriter out = new PrintWriter( s.getOutputStream(), true );
			BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
			out.println( "teste" );
			String data = in.readLine();
			System.out.println( "Recebido: " + data );
		} catch ( Exception e ) {
		}
		if ( s != null )
			try {
				s.close();
			} catch ( IOException _e ) {
			}
	}
}
