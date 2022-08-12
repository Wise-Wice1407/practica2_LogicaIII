package Recursos;

public class listaGeneralizada {

    nodoLG primero, ultimo;

    public listaGeneralizada() {        
        primero = null;
        ultimo = null;
    }

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

    public void insertaAtomo(nodoLG dato) {
        ultimo.asignaLiga(dato);
        ultimo.asignaSW(0);
        ultimo = dato;
    }

    public void insertaLista(listaGeneralizada lista) {
        nodoLG dato = new nodoLG();
        dato.asignaDato(lista);
        ultimo.asignaLiga(dato);
        ultimo.asignaSW(1);
        ultimo = dato;
    }
    
    public void contruyeLista(String s){
        primero = new nodoLG();
        ultimo = primero;
        int n = s.length();
        for (int i = 2; i < n; i++) {            
            switch(s.charAt(i)){
                case(40): ;
            }
        }
    }
}
