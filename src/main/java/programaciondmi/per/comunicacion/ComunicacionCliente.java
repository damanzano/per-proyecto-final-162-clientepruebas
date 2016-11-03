package programaciondmi.per.comunicacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import programaciondmi.per.modelo.*;
import programaciondmi.per.modelo.exceptions.MalaNotaMusicalException;

public class ComunicacionCliente extends Thread {
	private Socket s;
	private boolean conectado;

	public ComunicacionCliente() {
		try {
			s = new Socket(InetAddress.getByName("127.0.0.1"), 5000);
			conectado = true;
			// enviar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (conectado) {
			// recibir();
			recibirObjeto();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void recibirObjeto() {
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream(s.getInputStream());
			Object mensaje = entrada.readObject();
			System.out.println("Se recibio: " + mensaje);

			if (mensaje instanceof Instrumento) {
				Instrumento i = (Instrumento) mensaje;

				// Crear notas musicales y enviarlas

				try {
					NotaMusical n = new NotaMusical(i, NotaMusical.DO, NotaMusical.BLANCA);
					enviarObjeto(n);
				} catch (MalaNotaMusicalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		} catch (IOException e) {
			try {
				if (entrada != null) {
					entrada.close();
				}
				s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			s = null;
			conectado = false;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enviarObjeto(Object o) {
		ObjectOutputStream salida = null;

		try {
			salida = new ObjectOutputStream(s.getOutputStream());
			salida.writeObject(o);
			System.out.println("Se envió el mensaje: " + o);
		} catch (IOException e) {
			try {
				if (salida != null) {
					salida.close();
				}
				s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			s = null;
			conectado = false;
			e.printStackTrace();
		}
	}
}