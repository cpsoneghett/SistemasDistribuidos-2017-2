package com.soneghett.runnable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkerRunnable implements Runnable {

	protected Socket clientSocket = null;
	protected String serverText = null;

	public WorkerRunnable( Socket clientSocket, String serverText ) {
		this.clientSocket = clientSocket;
		this.serverText = serverText;
	}

	@Override
	public void run() {
		try {
			InputStream input = clientSocket.getInputStream();
			OutputStream output = clientSocket.getOutputStream();
			long time = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
			output.write( ( "HTTP/1.1 200 OK\n\nWorkerRunnable: " + this.serverText + " - " + sdf.format( new Date( time ) ) ).getBytes() );
			output.close();
			input.close();
			System.out.println( "Request processada em: " + time );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}
