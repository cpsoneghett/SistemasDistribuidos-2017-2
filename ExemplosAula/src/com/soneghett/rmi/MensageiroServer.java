package com.soneghett.rmi;

import java.rmi.Naming;

public class MensageiroServer {

	public static void main( String[] args ) {
		try {
			Mensageiro m = new MensageiroImpl();
			Naming.bind( "rmi://localhost/MensageiroService", m );

		} catch ( Exception e ) {
			System.out.println( "Problema: " + e );
		}
	}

}
