package com.soneghett.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Mensageiro extends Remote {

	public void sendMsg( String msg ) throws RemoteException;

	public String readMsg() throws RemoteException;

}
