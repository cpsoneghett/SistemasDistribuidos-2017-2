package com.soneghett.sockets.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer_2 {

	@SuppressWarnings( "resource" )
	public static void main( String args[] ) {
		int serverPort = 7896;
		ServerSocket s = null;
		try {
			s = new ServerSocket( serverPort ); // Pode-se indicar máximo de clientes
		} catch ( IOException e ) {
		}
		// atende clientes sequencialmente
		while ( true ) {
			try {
				Socket c = s.accept();
				ObjectInputStream in = new ObjectInputStream( c.getInputStream() );
				ObjectOutputStream out = new ObjectOutputStream( c.getOutputStream() );
				String msg = (String) in.readObject();
				out.writeObject( msg );
				out.flush();
				System.out.println( msg + "\n" );
				in.close();
				out.close();
				c.close();
			} catch ( Exception e ) {
			}
		}
	}
}
