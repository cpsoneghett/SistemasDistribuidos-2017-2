package com.soneghett.rmi;

import java.rmi.RemoteException;

public class MensageiroImpl implements Mensageiro {

	public MensageiroImpl() {
		super();
	}

	@Override
	public void sendMsg( String msg ) throws RemoteException {
		System.out.println( msg );
	}

	@Override
	public String readMsg() throws RemoteException {
		return "Voce se conectou com o servidor RMI!";
	}

}
