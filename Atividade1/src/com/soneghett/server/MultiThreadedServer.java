package com.soneghett.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.soneghett.runnable.WorkerRunnable;

public class MultiThreadedServer implements Runnable {

	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;
	protected boolean isStoped = false;
	protected Thread runninThread = null;

	public MultiThreadedServer( int serverPort ) {
		super();
		this.serverPort = serverPort;
	}

	@Override
	public void run() {
		synchronized ( this ) {
			this.runninThread = Thread.currentThread();
		}
		openServerSocket();

		while ( !isStoped() ) {
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch ( IOException e ) {
				if ( isStoped() ) {
					System.out.println( "Servidor parado." );
					return;
				}
				throw new RuntimeException( "Erro ao aceitar conexão do cliente.", e );
			}

			new Thread( new WorkerRunnable( clientSocket, "Servidor MultiThread" ) ).start();

		}

		System.out.println( "Servidor parado" );
	}

	public synchronized void stop() {
		this.isStoped = true;
		try {
			this.serverSocket.close();
		} catch ( IOException e ) {
			throw new RuntimeException( "Erro ao fechar o servidor.", e );
		}
	}

	public synchronized boolean isStoped() {
		return this.isStoped;
	}

	private void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket( this.serverPort );
		} catch ( IOException e ) {
			throw new RuntimeException( "Não pode ser possível abrir a porta" + this.serverPort, e );
		}
	}
}
