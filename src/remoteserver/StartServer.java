/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteserver;

import inventory.IOrderService;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iwa Stojnowa
 */
public class StartServer {

    private static final int PORT = 1099;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      IOrderService rs;
        try {            
            rs= new RemoteServiceImplementation();
            Registry reg= LocateRegistry.createRegistry(PORT);
            reg.rebind("IOrderServiceImpl", reg);
            System.out.println("Server started");
        } catch (RemoteException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error while starting the server");
        }
    }
    
}
