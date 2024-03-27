

package com.mycompany.listaencadeada;

/**
 *
 * @author Diogo
 */
public class Run {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Lista<Integer> lista = new Lista();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.remove(2);
        lista.imprimir();
        System.out.println("get: "+lista.get(1));
        System.out.println("contem: "+lista.contains(1));
        System.out.println("indexf: "+lista.indexOf(3));
        
    }
}
