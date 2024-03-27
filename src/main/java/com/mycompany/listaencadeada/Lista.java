/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaencadeada;

/**
 *
 * @author Diogo
 */
public class Lista<T> {
    
    private No<T> inicio;
    private No<T> fim;
    private int tam;
    
    private class No<T>{
        public No<T> proximo;
        public T dado;
        
        public No(T dado){
            this.dado = dado;
            this.proximo = null;
        }
    }
    
    public Lista(){
        this.inicio = null;
        this.fim = null;
        this.tam = 0;
    }
    
    public void add(T elemento){
        No<T> novoNo = new No<>(elemento);
        if(this.inicio == null){
            this.inicio = novoNo;
            this.fim = novoNo;
            tam++;
            return;
        }
        No<T> aux = this.inicio;
        
        this.fim.proximo = novoNo;
        this.fim = novoNo;
        tam++;
        
    }
    
    public T remove(T elemento){
        if(this.inicio == null) System.out.println("lista esá vazia");
        No<T> aux = this.inicio;
        int cont = 0;
        while(aux != null){
            if(aux.dado.equals(elemento)){
                removerPos(cont);
                return aux.dado;
            }
            cont++;
            aux = aux.proximo;
        }
        System.out.println("elemento não está presente da Lista");
        return null;
    }
    
    public T get(int pos){
        if(this.inicio == null) System.out.println("lista esá vazia");
        if(pos < 0 || pos > this.tam - 1 ) System.out.println("posição invalida");
        No<T> aux = this.inicio;
        for (int i = 0; i < pos; i++) {
            aux = aux.proximo;
        }
        return aux.dado;
    }
    
    public int size(){
        return this.tam;
    }
    
    public boolean contains(T elemento){
        if(this.inicio == null) System.out.println("lista esá vazia");
        No<T> aux = this.inicio;
        while(aux != null){
            if(aux.dado.equals(elemento)){
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }
    
    public int indexOf(T elemento){
        if(this.inicio == null) System.out.println("lista esá vazia");
        No<T> aux = this.inicio;
        int cont = 0;
        while(aux != null){
            if(aux.dado.equals(elemento)){
                return cont;
            }
            cont++;
            aux = aux.proximo;
        }
        return -1;
    }
    /*
        metodo que remove pelo posição
    */
    public void removerPos(int pos){
        if(pos < 0 || pos > this.tam - 1 ) System.out.println("posição invalida");
        No<T> aux = this.inicio;
        if(this.tam == 1){
            this.inicio = null;
            this.fim = null;
        }
        else if(pos == 0){
            removePrimeiro();
        }else if(pos == (tam -1)){
            System.out.println("fim: "+pos);
            removeUltimo();
        }else{
            removeMeio(pos);
        }
        
    }
    
    private void removePrimeiro(){
        this.inicio = this.inicio.proximo;
        this.tam--;
    }
    
    private void removeUltimo(){
        No<T> aux = this.inicio;
        for(int i = 1; i < this.tam - 1; i++){
            aux = aux.proximo;
        }
        aux.proximo = null;
        this.fim = aux;
        this.tam--;
    }
    
    private void removeMeio(int pos) {
        No<T> aux = this.inicio;
        for (int i = 0; i < pos - 1; i++) {
            aux = aux.proximo;
        }
        aux.proximo = aux.proximo.proximo;
        tam--;
    }

    
    public void imprimir(){
        No<T> aux = this.inicio;
        System.out.println("imprimindo a lista:");
        if(this.inicio == null) System.out.println("a list está vazia");
        while(aux != null){
            System.out.println(""+aux.dado);
            aux = aux.proximo;
        }
    }
}
