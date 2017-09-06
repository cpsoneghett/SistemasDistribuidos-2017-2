package com.soneghett.main;

import com.soneghett.server.MultiThreadedServer;

public class Main {

	public static void main( String[] args ) {
		
		MultiThreadedServer server = new MultiThreadedServer( 9000 );
		
		new Thread( server ).start();

		try {
			Thread.sleep( 20 * 1000 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		System.out.println( "Parando servidor..." );
		server.stop();

	}

}
