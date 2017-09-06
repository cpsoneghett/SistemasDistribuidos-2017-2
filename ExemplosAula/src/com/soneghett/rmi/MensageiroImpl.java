package com.soneghett.rmi;

import java.rmi.RemoteException;

public class MensageiroImpl implements Mensageiro {

	public MensageiroImpl() {
		super();
	}

	public void sendMsg( String msg ) throws RemoteException {
		System.out.println( msg );
	}

	public String readMsg() throws RemoteException {
		return "Voce se conectou com o servidor RMI!";
	}

}
