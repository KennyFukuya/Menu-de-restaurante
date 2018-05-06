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
public interface Cardapio {
    public abstract void removeItem();
    public abstract String showItems();
    public abstract String description();
    public abstract String showItemsUser();
}
