package com.soneghett.sockets.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main( String[] args ) {
		DatagramSocket aSocket = null;

		try {
			aSocket = new DatagramSocket();
			byte[] m = args[ 0 ].getBytes();
			InetAddress aHost = InetAddress.getByName( args[ 1 ] );
			int serverPort = 7896;
			DatagramPacket request = new DatagramPacket( m, m.length, aHost, serverPort );
			aSocket.send( request );

			byte[] buffer = new byte[ 1000 ];
			DatagramPacket reply = new DatagramPacket( buffer, buffer.length );
			aSocket.receive( reply );
			System.out.println( "Resposta: " + new String( reply.getData() ) );

		} catch ( IOException e ) {
			if ( aSocket != null )
				try {
					aSocket.close();
				} catch ( Exception e2 ) {
				}
		}

	}

}
