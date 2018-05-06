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
public enum Enumerador {
    FALSE(0),BEBIDAS(6),COMIDAS(8),CODECOMIDAS(9),CODEBEBIDAS(15);
    
    private final int valor;
    Enumerador(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
}
