package com.wodder;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWorld extends Remote {

    String greeting(String name) throws RemoteException;
}
