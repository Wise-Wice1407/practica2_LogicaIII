package Recursos;

public class nodoLG {
    //Variables comunes.
    private Object dato;
    private nodoLG Liga;
    private int sw;
    
    //Constructor.
    public nodoLG(){
        dato = null;
        Liga = null;  
        sw = 0;
    } 
    
    //Instrucciones de asignacion y retorno.
    public void asignaDato(Object x){
       dato = x;
    }
    
    public Object retornaDato(){
       return dato;
    }
    
    public void asignaLiga(nodoLG l){
       Liga = l;
    }
   
    public nodoLG retornaLiga(){
       return Liga;
    }
   
    public void asignaSW(int x){
        sw = x;
    }
    
    public int retornaSW(){
        return sw;
    }
}
