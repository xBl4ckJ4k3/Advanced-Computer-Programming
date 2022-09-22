package manager;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Manager {
	public static void main(String[] args) {
		try {
			Registry rmiregistry = LocateRegistry.getRegistry();
			IManager manager = new ManagerImpl();
			rmiregistry.rebind("mymanager", manager);
			
			System.out.println("[MANAGER] Manager registrato");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
