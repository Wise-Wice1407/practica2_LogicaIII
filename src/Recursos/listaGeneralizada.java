package Recursos;

import java.util.List;
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
    
    //Contruir una lista generaizada a partir de un cadena de caracteres-
    // configurada asi: {(dato,dato,(dato,dato),dato)}.
    public void contruyeLista(String s){
        //<editor-fold defaultstate="collapsed" desc="Algoritmo para contruir una listaGenralizada.">
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
        //<editor-fold defaultstate="collapsed" desc="Algoritmo recursivo para mostrar los datos en la listaGeneralizada.">
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
        //<editor-fold defaultstate="collapsed" desc="Algoritmo recursivo para mostrar altura del arbol.">
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
    
    public int gradoDelArbol(){
        //<editor-fold defaultstate="collapsed" desc="Algoritmo no recursivo para determinar el grado del arbol.">
        int g = 0, s = g;
        Stack pila = new Stack(), pilaSuma = new Stack();
        if(primero != null){
            nodoLG siguiente = primero.retornaLiga();
            while(siguiente != null){
                if(siguiente.retornaSW() == 1){
                    s = s++;                        
                    pilaSuma.push(s);
                    pila.push(siguiente);
                    s = 0;
                    siguiente = (nodoLG)siguiente.retornaDato();
                }
                else{
                    s = s++;             
                    siguiente = siguiente.retornaLiga();
                }
                while(siguiente == null && !pila.isEmpty()){
                    siguiente = (nodoLG)pila.pop();
                    siguiente = siguiente.retornaLiga();
                    if(s > g){
                        g = s;                            
                    }
                    s = (int)pilaSuma.pop();
                }
                if(s > g){
                    g = s;                            
                }
            }
        }
        return g;
        //</editor-fold>
    }
    
    public int hojasDelArbol(){
        //<editor-fold  defaultstate="collapsed" desc="Algoritmo no recursivo para determinar el total de hojas en el arbol.">
        int h = 0;
        Stack pila = new Stack(), pilaSuma = new Stack();
        if(primero != null){
            nodoLG siguiente = primero.retornaLiga();
            while(siguiente != null){
                if(siguiente.retornaSW() == 1){
                    pila.push(siguiente);
                    siguiente = (nodoLG)siguiente.retornaDato();                    
                }
                else{
                    h = h++;             
                    siguiente = siguiente.retornaLiga();
                }
                while(siguiente == null && !pila.isEmpty()){
                    siguiente = (nodoLG)pila.pop();
                    siguiente = siguiente.retornaLiga();
                }
            }
        }
        return h;
        //</editor-fold>
    }

    public int gradoDelRegistro(String d){
        //<editor-fold  defaultstate="collapsed" desc="">
        int g = 0;

        return g;
        //</editor-fold>
    }

    public int nivelDelRegistro(String d){
        //<editor-fold  defaultstate="collapsed" desc="">
        int n = 0;

        return n;
        //</editor-fold>
    }

    public List<String> ancestrosDelRegistro(String d){
        //<editor-fold  defaultstate="collapsed" desc="">
        List<String> anc = null;

        return anc;
        //</editor-fold>
    }
}
