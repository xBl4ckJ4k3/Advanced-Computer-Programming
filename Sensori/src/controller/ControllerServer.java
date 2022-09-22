package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ControllerServer{
	
	public static void main(String[] args) {
		
		try {
			IController controller = new ControllerImpl();
			Registry rmiregistry = LocateRegistry.getRegistry();
			rmiregistry.rebind("mycontroller", controller);
			
			System.out.println("[CONTROLLER] Controller registrato sul registry");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
