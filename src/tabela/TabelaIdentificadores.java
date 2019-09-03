/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import analisesemantica.Atributos;
import java.util.HashMap;

/**
 *
 * @author jean
 */
public class TabelaIdentificadores {
    private final HashMap<Integer,HashMap> tabelaIdentificadores;

    public TabelaIdentificadores() {
        tabelaIdentificadores = new HashMap<>();
    }
    
    public boolean insereVarTabela(Integer key,Integer value){
        
        if(tabelaIdentificadores.get(key).containsKey(value)) return false;
        
        tabelaIdentificadores.get(key).put(value,new Atributos());
        
        return true;
    }
    
    public boolean insereProcTabela(Integer key){
        
        if(tabelaIdentificadores.containsKey(key)) return false;
        
        tabelaIdentificadores.put(key,new HashMap());
        
        return true;
    }
    
    public boolean buscaVarTabela(Integer key,Integer value){
        return tabelaIdentificadores.get(key).containsKey(value);
    }
    
    public boolean buscaProcTabela(Integer key){
        return tabelaIdentificadores.containsKey(key);
    }
    
}
