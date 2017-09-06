package com.soneghett.sockets.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	@SuppressWarnings( { "resource", "null" } )
	public static void main( String[] args ) {
		DatagramSocket aSocket = null;
		byte[] buffer = new byte[ 1000 ];

		try {
			aSocket = new DatagramSocket( 7896 );
		} catch ( SocketException e ) {
			while ( true ) {
				try {
					DatagramPacket request = new DatagramPacket( buffer, buffer.length );
					aSocket.receive( request );

					// Resposta tem conteúdo igual à mensagem de requisição (echo)
					DatagramPacket reply = new DatagramPacket( request.getData(), request.getLength(), request.getAddress(), request.getPort() );
					aSocket.send( reply );

				} catch ( IOException e2 ) {
				}
			}
		}

	}

}
