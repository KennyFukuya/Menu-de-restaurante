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
public abstract class Produtos implements Cardapio{
    private String name;
    private int stock,code;
    private float price;

    public Produtos(int code,int stock) {
        this.code = code;
        this.stock = stock;
    }
    
    
    public String disponibilidade(){
        if(getStock()==Disponibilidade.FALSE.getValor()){ //ENUM PARA SABER SE TEM ESTOQUE
            return " infelizmente nao ";
        }else
            return " ";
    }
    
    public void order() {
        if(getStock()>Disponibilidade.FALSE.getValor()){ //ENUM PARA SABER SE TEM ESTOQUE
           setStock(getStock()-1);
        }else{
            System.out.println("\nERRO: Sem estoque!!!\n");
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
