package Recursos;

public class nodoLG {
    //Variables comunes.
    private Object dato;
    private nodoLG Liga;
    private int sw;
    
    //Constructor de la clase.
    public nodoLG(){
        dato = null;
        Liga = null;        
    } 
    
    //Actualiza el dato del nodo.
    public void asignaDato(Object x){
       dato = x;
    }
    
    //Retorna el dato almacena en el nodo.
    public Object retornaDato(){
       return dato;
    }
    
    //Actualiza el campo de liga del nodo.
    public void asignaLiga(nodoLG l){
       Liga = l;
    }
   
    //Retorna el dato almacenado en el campo de liga.
    public nodoLG retornaLiga(){
       return Liga;
    }
   
    //Actualiza el valor del suiche.
    public void asignaSW(int x){
        sw = x;
    }
    
    //Retorna el valor del suiche.
    public int retornaSW(){
        return sw;
    }
}
