package Recursos;

import java.util.Stack;

public class listaGeneralizada {
    //Variables comunes.
    nodoLG primero, ultimo;

    //Constructor.
    public listaGeneralizada() {        
        primero = null;
        ultimo = null;
    }

    //Instrucciones de asignacion y retorno.
    public nodoLG retornaPrimero() {
        return primero;
    }

    public void asignaPrimero(nodoLG primero) {
        this.primero = primero;
    }

    public nodoLG retornaUltimo() {
        return ultimo;
    }

    public void asignaUltimo(nodoLG ultimo) {
        this.ultimo = ultimo;
    }
    
    //Metodos principales.
    
    //Contriur una lista generaizada a partir de un cadena de caracteres 
    // configurada asi: {(dato,dato,(dato,dato),dato)}.
    public void contruyeLista(String s){
        //<editor-fold defaultstate="collapsed" desc="Algoritmo para contruir una listaGenralizada">
        primero = new nodoLG();
        ultimo = primero;
        int n = s.length();
        Stack pila = new Stack();
        for (int i = 2; i < n; i++) {            
            nodoLG x;
            switch(s.charAt(i)){
                case('('): 
                    pila.push(ultimo);
                    x = new nodoLG();
                    ultimo.asignaSW(1);
                    ultimo.asignaDato(x);
                    ultimo = x;
                    break;
                case(','): 
                    x = new nodoLG();
                    ultimo.asignaLiga(x);
                    ultimo = x;
                    break;
                case(')'): 
                    ultimo = (nodoLG)pila.pop();
                    break;
                default:
                    ultimo.asignaDato(s.charAt(i));
                    break;
            }
        }
        //</editor-fold>
    }
    
    //Construye una cadena de caracteres a partir de una lista generalizada.
    public String muestraLista(nodoLG p, String s){
        //<editor-fold defaultstate="collapsed" desc="Algoritmo recursivo para mostrar los datos en la listaGeneralizada">
        if (s.length() == 0) {
            s.concat("(");
        }
        s.concat(String.valueOf((char)p.retornaDato()));
        nodoLG siguiente = p.retornaLiga();
        while(siguiente != null){
            switch(siguiente.retornaSW()){
                case(0):
                    s.concat(",");
                    s.concat(String.valueOf((char)siguiente.retornaDato()));
                    break;
                case(1):
                    s.concat(",");
                    s.concat("(");                    
                    s.concat(muestraLista((nodoLG)siguiente.retornaDato(), s));
                    break;
            }
            siguiente = siguiente.retornaLiga();
        }
        if(siguiente == null){
            s.concat(")");
        }
        return s;
        //</editor-fold>
    }    
    
    public int alturaDelArbol(){
        //<editor-fold defaultstate="collapsed" desc="Algoritmo recursivo para mostrar altura del arbol">
        int h = 0, s;
        Stack pila = new Stack();
        if(primero != null){
            h = h++;
            s = h;
            nodoLG siguiente = primero.retornaLiga();
            while(siguiente != null){
                if(siguiente.retornaSW() == 1){
                    s = s++;                        
                    pila.push(siguiente);
                    siguiente = (nodoLG)siguiente.retornaDato();
                    break;
                }
                siguiente = siguiente.retornaLiga();
                while(siguiente == null && !pila.isEmpty()){
                    siguiente = (nodoLG)pila.pop();
                    siguiente = siguiente.retornaLiga();
                    if(s > h){
                        h = s;                            
                    }
                    s = s--;
                }
            }
        }        
        return h;
        //</editor-fold>
    }
    
    
}
