package client;

import java.rmi.RemoteException;
import java.util.Random;
import java.util.random.RandomGenerator;

import controller.*;
import reading.Reading;


public class SensorManagerThread extends Thread{
	
	private IController controller;
	
	public SensorManagerThread(IController c) {
		this.controller = c;
	}
	
	public void run() {
		String type;
		
		//Random rnd = new Random();
		//int number = rnd.nextInt(2);
		
		if(new Random().nextInt(2) == 0) {
			type = new String("temperature");
		}else {
			type = new String("pressure");
		}
		
		int value = 1 + (new Random().nextInt(50));
		
		Reading reading = new Reading(type, value);
		
		try {
			System.out.println("[CLIENT THREAD] Invio richiesta di lettura al controller...");
			controller.sensorRead(reading);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
