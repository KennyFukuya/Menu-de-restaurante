/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/**
 *
 * @author kenny
 */
public class Comidas extends Produtos {
    private int size;

    public Comidas(int code, int stock) {
        super(code, stock);
        setName("");
    }
    
    
    public void addItem(String foodName,int foodSize,float foodPrice,int foodStock){
        setName(foodName);
        setPrice(foodPrice);
        setSize(foodSize);
        setStock(foodStock);
    }
    
    @Override
    public void removeItem() {
        setName("");
        setPrice(0f);
        setSize(0);
    }
    
    @Override
    public String showItems() {
        if(!"".equals(getName())){
            return "\nCodigo: "+getCode()+"\nNome: "+getName()+"\nPreco: R$ "+getPrice()+"\nServe: "+getSize()+
                    "\nEstoque: "+getStock()+"\n";
        } return "";
    }
    
    @Override
    public String showItemsUser() {
        if(!"".equals(getName())){
            return "\nCodigo: "+getCode()+"\nNome: "+getName()+"\nServe: "+getSize()+"\nPreco: R$ "+getPrice()+"\n";
        } return "";
    }

    public void changeItem(String foodName,int foodSize,float foodPrice, int foodStock) { //overloading
        setName(foodName);
        setPrice(foodPrice);
        setSize(foodSize);
        setStock(foodStock);
    }
    
    public void changeItem(float foodPrice){  //overloading
        setPrice(foodPrice);
    }
    
    public void changeItem(int foodStock){  //overloading
        setStock(foodStock);
    }

    @Override
    public String description() {
        if(!"".equals(getName())){
            return "\nO prato "+getName()+" com valor de R$ "+getPrice()+" serve "
                    +getSize()+" pessoa(s) e"+disponibilidade()+"possuimos no estoque!!!\n";
        }else{
            return "\nERRO: Produto invalido!!!\n";
        }
    }
    
    public String describeOrder(){
        return "A compra do produto "+getName()+" que serve "+getSize()+" pessoa(s) e custa R$ "
                +getPrice()+" e de codigo "+getCode()+" foi realizada com sucesso!!!\n";
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
