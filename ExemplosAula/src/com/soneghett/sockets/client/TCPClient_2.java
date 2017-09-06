package com.soneghett.sockets.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient_2 {

	public static void main( String args[] ) {
		Socket s = null;
		try {
			int serverPort = 7896;
			s = new Socket( args[ 1 ], serverPort );
			ObjectOutputStream out = new ObjectOutputStream( s.getOutputStream() );
			ObjectInputStream in = new ObjectInputStream( s.getInputStream() );
			out.writeObject( args[ 0 ] );
			out.flush();
			String data = (String) in.readObject();
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
