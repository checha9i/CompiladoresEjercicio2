/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Julio - 2018
 */

package arbol;

import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción si...entonces y que implementa
 * la interfaz de instrucción
 * @author Erick
 */
public class If implements Instruccion{
    /**
     * Lista de instrucciones SubIf que serán ejecutadas.
     */
    private final LinkedList<Instruccion> subIfs;
    
    /**
     * Constructor utilizado cuando la sentencia solamente tiene un if
     * @param a 
     */
    public If(SubIf a) {
        subIfs=new LinkedList<>();
        subIfs.add(a);
    }
    /**
     * Constructor utilizado cuando la sentencia tiene un if seguido de uno o muchos elseif
     * @param a
     * @param b 
     */
    public If(SubIf a, LinkedList<SubIf> b) {
        subIfs=new LinkedList<>();
        subIfs.add(a);
        subIfs.addAll(b);
    }
    /**
     * Constructor utilizado cuando la sentencia tiene un if seguido de uno o muchos elseif seguido de un else
     * @param a
     * @param b
     * @param c 
     */
    public If(SubIf a, LinkedList<SubIf> b, SubIf c) {
        subIfs=new LinkedList<>();
        subIfs.add(a);
        subIfs.addAll(b);
        subIfs.add(c);
    }
    /**
     * Constructor utilizado cuando la sentencia tiene un if seguido de else
     * @param a
     * @param b 
     */
    public If(SubIf a, SubIf b) {
        subIfs=new LinkedList<>();
        subIfs.add(a);
        subIfs.add(b);
    }
    /**
     * Método que ejecuta la instrucción si..entonces, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia.
     * @return Estra instrucción retorna nulo porque no produce ningún valor en 
     * su ejecución
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        //Ejecutar SubIfs
        for(Instruccion in: subIfs){
            in.ejecutar(ts);
            if(((SubIf)in).getValorCondicion())
                return null;
        }
        return null;
    }
}
