package com.wodder;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorldServer implements HelloWorld {
    private static Registry r;
    private static HelloWorld stub;
    private static final HelloWorld classVar = new HelloWorldServer();
    public HelloWorldServer() {
        super();
    }

    @Override
    public String greeting(String name) throws RemoteException {
        return "Hello, " + name;
    }

  public static void main(String[] args) {
    if (System.getSecurityManager() == null) {
        System.setSecurityManager(new SecurityManager());
    }
    try {
        String name = "HelloWorld";
        HelloWorld stub = (HelloWorld) UnicastRemoteObject.exportObject(classVar, 55000);
        Registry r = LocateRegistry.getRegistry();
        r.rebind(name, stub);
        System.out.println("HelloWorld up and running, waiting for requests...");
    } catch (Exception e) {
        System.err.println("Unable to bind and start");
        e.printStackTrace();
    }
  }
}
