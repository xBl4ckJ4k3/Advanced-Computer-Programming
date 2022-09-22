package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import reading.Reading;
import actuator.*;

public class ControllerImpl extends UnicastRemoteObject implements IController{

	private static final long serialVersionUID = -3387210113701538404L;

	private Vector<IActuator> actuators;
	
	protected ControllerImpl() throws RemoteException {
		super();
		actuators = new Vector<IActuator>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean sensorRead(Reading r) throws RemoteException{
		// TODO Auto-generated method stub
		
		String s = r.getType() +"#"+ r.getData();
		boolean result = false;
		
		int i=0;
		while(!result && i<actuators.size()){
			result = actuators.get(i).execute(s);
			i++;
		}
		return result;
	}

	@Override
	public void addActuator(int port) throws RemoteException{
		// TODO Auto-generated method stub
		Proxy proxy = new Proxy(port);
		actuators.add(proxy);
		System.out.println("[CONTROLLER] Actuator aggiunto!");
		
	}



}
