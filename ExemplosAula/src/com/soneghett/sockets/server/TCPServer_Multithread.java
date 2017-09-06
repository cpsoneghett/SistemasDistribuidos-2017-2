package com.soneghett.sockets.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.soneghett.sockets.client.AtendeCliente;

public class TCPServer_Multithread {

	@SuppressWarnings( "resource" )
	public static void main( String[] args ) {
		ServerSocket s = null;
		int serverPort = 7896;
		try {
			s = new ServerSocket( serverPort ); // Pode-se indicar máximo de clientes
		} catch ( IOException e ) {
		}
		// atende clientes sequencialmente
		while ( true ) {
			try {
				Socket c = s.accept();
				AtendeCliente ac = new AtendeCliente( c ); // Cria classe para se comunicar com cliente
				new Thread( ac ).start(); // Roda thread (chamada não bloqueante!)
			} catch ( IOException e ) {
			}
		}

	}

}
