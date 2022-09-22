package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import reading.*;

public interface IController extends Remote{
	
	boolean sensorRead(Reading r) throws RemoteException;
	void addActuator(int port) throws RemoteException;
	
}
