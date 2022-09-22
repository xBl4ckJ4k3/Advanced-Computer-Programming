package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import controller.IController;
import reading.Reading;

public class SensorManager {
	public static void main(String[] args) {
		Thread threads[] = new Thread[10];
		
		try {
			// RECUPERO RIFERIMENTO OGGETTO REMOTO
			Registry rmiregistry = LocateRegistry.getRegistry();
			IController controller = (IController)rmiregistry.lookup("mycontroller");
			
			
			for(int i=0; i<10; i++) {
				threads[i] = new SensorManagerThread(controller);
				threads[i].start();
			}
			
			for(int j=0; j<10; j++) {
				threads[j].join();
			}
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
