package com.soneghett.rmi;

import java.rmi.Naming;

public class MensageiroClient {

	public static void main( String[] args ) {
		try {
			Mensageiro m = (MensageiroImpl) Naming.lookup( "rmi://localhost/MensageiroService" );
			System.out.println( m.readMsg() );
			m.sendMsg( "Hello!" );
		} catch ( Exception e ) {
			System.out.println( "Excecao: " + e );
		}
	}

}
