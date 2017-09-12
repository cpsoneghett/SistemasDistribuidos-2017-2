package com.soneghett.sockets.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer_1 {

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
				PrintWriter out = new PrintWriter( c.getOutputStream(), true );
				BufferedReader in = new BufferedReader( new InputStreamReader( c.getInputStream() ) );
				String msg = in.readLine();
				System.out.print( msg + "\n" );
				out.println( msg );
				in.close();
				out.close();
				c.close();
			} catch ( Exception e ) {
			}
		}
	}
}
