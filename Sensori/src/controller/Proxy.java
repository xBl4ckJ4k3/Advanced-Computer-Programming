package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import actuator.IActuator;

public class Proxy implements IActuator{
	
	private int port;
	
	public Proxy(int port) {
		this.port = port;
	}

	
	public boolean execute(String action) {
		// TODO Auto-generated method stub
		
		try {
			Socket socket = new Socket(InetAddress.getLocalHost(), port);
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			
			dataOut.writeUTF("execute");
			dataOut.writeUTF(action);
			//dataOut.close();
			
			boolean esito = dataIn.readBoolean();
			System.out.println("[PROXY] execute eseguita con esito "+esito);
			//dataIn.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	
}
