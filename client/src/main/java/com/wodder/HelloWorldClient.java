package com.wodder;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloWorldClient {

  public static void main(String[] args) {
    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new SecurityManager());
    }
    try {
        if (args.length > 0) {
            String name = "HelloWorld";
            Registry r = LocateRegistry.getRegistry();
            HelloWorld hw = (HelloWorld) r.lookup(name);

            for (String s : args) {
                String result = hw.greeting(s);
                System.out.println(result);
            }
        } else {
            System.out.println("No names provided to greet...");
        }
    } catch (Exception e) {
        System.err.println("Couldn't invoke remote method...");
        e.printStackTrace();
    }
  }
}
