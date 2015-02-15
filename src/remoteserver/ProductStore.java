/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteserver;

import inventory.Category;
import inventory.Product;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Iwa Stojnowa
 */
public class ProductStore {
    private static Random random = new Random();
    private HashMap<Product,Integer> products;
    private Formatter txtFile;

    public ProductStore() {
        products = new HashMap<Product,Integer>();
        Product product;
        for (int i = 0; i < 10; i++) {
            product = new Product(Category.EBOOKS, randomNumber(10,100));
            products.put(product, Integer.SIZE);
            try {
                txtFile = new Formatter("reorder.txt");
            } catch (SecurityException e) {
                System.err.println("You don't have an access");
            } catch (FileNotFoundException fnfe){
                System.err.println("No such File");
            }
        } 
    }

    public List<Product> getProducts() {
        List<Product> lProducts = new ArrayList<Product>();
        for(Product p:products.keySet()){
            lProducts.add(p);
        }
        return lProducts;
    }
    
    public void updateProductQty(String clientId, Product p, int qty){
        int newQty = products.get(p) - qty;
        products.put(p, newQty);
        txtFile.format("Client No. %s Category: %s Reorder %s, New Order %s, Available %s",
                clientId, p.toString(), qty, newQty);
        
    }
            
    private int randomNumber(int min, int max) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return min + random.nextInt(max-min);
      
    }
    
}
