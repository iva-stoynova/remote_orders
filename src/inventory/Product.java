/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

/**
 *
 * @author Iwa Stojnowa
 */
public class Product implements Comparable{
    public static int count;
    private String id;   
    private Category productCategory;
    private int reorderLevel;

   
    public Product(String id, Category productCategory, int reorderLevel) {
        count++;
        this.id = "P-" + count;
        setProductCategory(productCategory);
        setReorderLevel(reorderLevel);
    }

    public Product(Category category, int randomNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
     public String getId() {
        return id;
    }

    
    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getProductCategory() + " " + this.getReorderLevel();
    }    
    
    public int compareTo(Object o){
        try {
            Product p2 = (Product) o;
            return (this.getId().equals(p2.getId()) ? 0 : -1);
        } catch (ClassCastException e) {
            return -1;
        }
    }
}
