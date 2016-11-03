package programaciondmi.per.main;

import programaciondmi.per.comunicacion.ComunicacionCliente;

public class ClientePrueba {
	static ComunicacionCliente com;
	
	public static void main(String[] args) {
		com = new ComunicacionCliente();
		com.start();
	}

}
