/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Iwa Stojnowa
 */
public interface IOrderService extends Remote{
    public List<Product> retrieveProducts() throws RemoteException;
    public void orderQuantity(String clientId, Product p, int qty) throws RemoteException;    
}
