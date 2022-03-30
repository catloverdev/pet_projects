/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groceryStore;

/**
 *
 * @author vikto
 */
public class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public void setQuantity (int quantity){
        this.quantity = quantity;
    }

    public String getName(){
        return this.name;
    }

    public int getQuantity (){
        return this.quantity;
    }
}
