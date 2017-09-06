package com.soneghett.sockets.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AtendeCliente implements Runnable {

	Socket c;
	PrintWriter out = null;
	BufferedReader in = null;

	public AtendeCliente( Socket cliente ) throws IOException {
		super();
		this.c = cliente;
		this.out = new PrintWriter( c.getOutputStream(), true );
		this.in = new BufferedReader( new InputStreamReader( c.getInputStream() ) );
	}

	public void run() {
		try {
			String msg = in.readLine();
			out.println( msg );
			in.close();
			out.close();
			c.close();
		} catch ( Exception e ) {
			if ( c != null )
				try {
					c.close();
				} catch ( IOException e2 ) {
				}
		}
	}
}
