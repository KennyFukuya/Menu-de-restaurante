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
public class Bebidas extends Produtos {
    private String brand;

    public Bebidas(int code, int stock) {
        super(code, stock);
        setName("");
    }
    
    
    public void addItem(String drinkName, float drinkPrice,String drinkBrand, int drinkStock){
        setName(drinkName);
        setBrand(drinkBrand);
        setPrice(drinkPrice);
        setStock(drinkStock);
    }
   
    @Override
    public void removeItem() {
        setName("");
        setBrand(null);
        setPrice(0f);
    }
    
    @Override
    public String showItems() {
        if(!"".equals(getName())){
            return "\nCodigo: "+getCode()+"\nNome: "+getName()+"\nMarca: "+getBrand()+"\nPreco: R$ "+getPrice()+
                    "\nEstoque: "+getStock()+"\n";
        } return "";
    }
    
    @Override
    public String showItemsUser() {
        if(!"".equals(getName())){
            return "\nCodigo: "+getCode()+"\nNome: "+getName()+"\nMarca: "+getBrand()+"\nPreco: R$ "+getPrice()+"\n";
        } return "";
    }
    
    public void changeItem(String drinkName,String drinkBrand,float drinkPrice, int drinkStock) { //overloading
        setName(drinkName);
        setPrice(drinkPrice);
        setBrand(drinkBrand);
        setStock(drinkStock);
    }
    
    public void changeItem(float drinkPrice){ //overloading
        setPrice(drinkPrice);
    }
    
    public void changeItem(int drinkStock){ //overloading
        setStock(drinkStock);
    }
    
    @Override
    public String description() {
        if(!"".equals(getName())){
            return "\nA bebida "+getName()+" da marca "+getBrand()+" com valor de R$ "+getPrice()+
                " e"+disponibilidade()+"possuimos no estoque!!!\n";
        }else{
            return "\nERRO: Produto invalido!!!\n"; 
        }
    }
    
    public String describeOrder(){
        return "A compra do produto "+getName()+" da marca "+getBrand()+" de preco R$ "
                +getPrice()+" e de codigo "+getCode()+" foi realizada com sucesso!!!\n";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
