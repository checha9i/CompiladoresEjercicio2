/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Julio - 2018
 */

package arbol;

import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una sub instrucción de la instrucción 
 * si...entonces y que implementa la interfaz de instrucción
 * @author Erick
 */
public class SubIf implements Instruccion{
    /**
     * Bandera que indica el valor lógico retornado por la condición al ser evaluada.
     */
    private Boolean valorCondicion;
    /**
     * Bandera que indica si la sub instrucción es Else o no.
     */
    private final boolean isElse;
    /**
     * Condición de la instrucción si..entonces.
     */
    private final Operacion condicion;
    /**
     * Lista de instrucciones que serán ejecutadas si la condición se cumple.
     */
    private final LinkedList<Instruccion> listaInstrucciones;
    /**
     * Constructor para la sub instrucción If o ElseIf
     * @param a
     * @param b 
     */
    public SubIf(Operacion a, LinkedList<Instruccion> b) {
        condicion=a;
        listaInstrucciones=b;
        isElse=false;
    }
    /**
     * Constructor para la sub instrucción Else
     * @param a 
     */
    public SubIf(LinkedList<Instruccion> a) {
        condicion=null;
        listaInstrucciones=a;
        isElse=true;
    }
    /**
     * Método get utilizado para determinar si más sentencias SubIf deben 
     * ejecutarse o no en la sentencia If padre
     * @param a 
     */
    public Boolean getValorCondicion() {
        return valorCondicion || isElse;
    }
    
    /**
     * Método que ejecuta la sub instrucción de la instrucción si..entonces, 
     * es una sobreescritura del método ejecutar que se debe programar por 
     * la implementación de la interfaz instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia.
     * @return Esta instrucción retorna nulo porque no produce ningún valor en 
     * su ejecución
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        valorCondicion=((condicion==null)?false:(Boolean)condicion.ejecutar(ts));        
        if(valorCondicion || isElse){
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for(Instruccion in: listaInstrucciones){
                in.ejecutar(tablaLocal);
            }
        }
        return null;
    }
}
