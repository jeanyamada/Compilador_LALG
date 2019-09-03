/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import analiselexica.Token;
import java.util.HashMap;

/**
 *
 * @author jean
 */
public class TabelaPalavraReservada {
    
    private final HashMap<Integer,Token> tabelaPalavraReservada;

    public TabelaPalavraReservada() {
         tabelaPalavraReservada = new HashMap<>();
    }

    
    public void insereTabela(Integer key,Token palavraReservada){
        tabelaPalavraReservada.put(key,palavraReservada);
    }
    
    public void inicializaTabela(){        
        
        insereTabela("program".hashCode(),Token.PROGRAM);
        insereTabela("var".hashCode(),Token.VAR);
        insereTabela("procedure".hashCode(),Token.PROCEDURE);        
        insereTabela("integer".hashCode(),Token.ID);
        insereTabela("boolean".hashCode(),Token.ID);
        insereTabela("real".hashCode(),Token.ID);
        insereTabela("read".hashCode(),Token.ID);
        insereTabela("write".hashCode(),Token.ID);
        insereTabela("true".hashCode(),Token.ID);
        insereTabela("false".hashCode(),Token.ID);
        insereTabela("begin".hashCode(),Token.BEGIN);
        insereTabela("end".hashCode(),Token.END);
        insereTabela("if".hashCode(),Token.IF);       
        insereTabela("then".hashCode(),Token.THEN);
        insereTabela("else".hashCode(),Token.ELSE);
        insereTabela("while".hashCode(),Token.WHILE);
        insereTabela("do".hashCode(),Token.DO);
        insereTabela("div".hashCode(),Token.DIV);
        insereTabela("end".hashCode(),Token.END);
        insereTabela("or".hashCode(),Token.OR);
        insereTabela("not".hashCode(),Token.NOT);
        insereTabela("int".hashCode(),Token.PALAVRA_RESERVADA_INT);
        insereTabela("int".hashCode(),Token.AND);
    }
    
    public boolean buscaPalavraReservada(String palavra){
        return tabelaPalavraReservada.containsKey(palavra.hashCode());
    }
    
    public Token getTokenPalavraReservada(String palavra){
        return tabelaPalavraReservada.get(palavra.hashCode());
    }
}
