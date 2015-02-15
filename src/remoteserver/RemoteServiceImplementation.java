/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteserver;

import inventory.IOrderService;
import inventory.Product;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Iwa Stojnowa
 */
public class RemoteServiceImplementation extends UnicastRemoteObject implements IOrderService{
   
    private ProductStore store;

    public RemoteServiceImplementation() throws RemoteException{
        super();
        store = new ProductStore();
    }
           
    public List<Product> retrieveProducts() throws RemoteException {
        return store.getProducts();
    }

   
    public void orderQuantity(String clientId, Product p, int qty) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
