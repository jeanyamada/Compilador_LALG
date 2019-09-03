/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisesintatica;

import analiselexica.AnaliseLexica;
import analiselexica.Token;
import analisesemantica.RegraSemantica;
import java.util.Stack;
import tabela.TabelaSintaticaPreditiva;
import gui.Principal;
import tabela.TabelaIdentificadores;
/**
 *
 * @author jean
 */
public class AnaliseSintatica {
        

    private final AnaliseLexica analiseLexica;
    private final TabelaSintaticaPreditiva tabelaSintaticaPreditiva;
    private final TabelaIdentificadores tabelaIdentificadores;
    
    public AnaliseSintatica(String code) {
        analiseLexica = new AnaliseLexica(code);

        tabelaSintaticaPreditiva = new TabelaSintaticaPreditiva();
        
        tabelaIdentificadores = new TabelaIdentificadores();
        
        tabelaSintaticaPreditiva.inicializaTabela();
    }
    
    public void analiseSintatica(){
        Stack stack = new Stack();
        Stack stackExec = new Stack();
        Stack ids = new Stack();
        RegraSemantica regraSemantica = null;
        
        stack.push(Producao.PGM);
        analiseLexica.nextToken();
        
        Principal.clearTableLexico();
        Principal.clearTableSintatico();
        
        while(!stack.empty()){           
           
            //printStack(stack);
            Principal.insereTableSintatico((Stack) stack.clone(),analiseLexica.getLexema(),"");
            
            if(analiseLexica.getToken().equals(Token.FINISH_CODE)){
                 while(!stack.empty())
                    stack.pop();
                    Principal.insereTableSintatico((Stack) stack.clone(),"","LINHA: "+Integer.toString(analiseLexica.getLinha()) +"  ERRO: código incompleto");
            }
            
            else{           
                if(analiseLexica.getToken().equals(Token.SIMB_DESCONHECIDO)){
                    Principal.insereTableLexico(analiseLexica.getLexema(),"",Integer.toString(analiseLexica.getLinha()),Integer.toString(analiseLexica.getColuna()-analiseLexica.getLexema().length()),Integer.toString(analiseLexica.getColuna()-1),"simbolob desconhecido: "+analiseLexica.getLexema());
                    analiseLexica.nextToken();
                }
                else{
                    
                    if(stack.peek() instanceof RegraSemantica){
                        switch((RegraSemantica)stack.peek()){
                            case ADICIONA_ID_BUFFER:
                                regraSemantica = RegraSemantica.ADICIONA_ID_BUFFER;
                            break;
                            case ARMAZENA_ID_PROCEDURE:
                                regraSemantica = RegraSemantica.ARMAZENA_ID_PROCEDURE;
                            break;                           
                            case ARAMZENA_ID_PROGRAM:
                                regraSemantica = RegraSemantica.ARAMZENA_ID_PROGRAM;
                            break;
                            case  ATRIBUI_TIPO_IDS:
                                regraSemantica = RegraSemantica.ATRIBUI_TIPO_IDS;
                            break;
                            default:
                                regraSemantica = RegraSemantica.RETIRA_ID_BUFFER;
                            break;                            
                        }
                        stack.pop();
                    }
                    
                    if(stack.peek().equals(Producao.VAZIO)){
                        stack.pop();
                    }
                    
                    if((stack.peek() instanceof Token) && tabelaSintaticaPreditiva.containsTerminal((Token) stack.peek()) && tabelaSintaticaPreditiva.containsTerminal(analiseLexica.getToken())){
                        
                        Principal.insereTableLexico(analiseLexica.getLexema(),analiseLexica.getToken().name(),Integer.toString(analiseLexica.getLinha()),Integer.toString(analiseLexica.getColuna()-analiseLexica.getLexema().length()),Integer.toString(analiseLexica.getColuna()-1),"");
            
                        if(stack.peek().equals(analiseLexica.getToken())){
                            
                            if(regraSemantica != null){
                                
                                switch(regraSemantica){

                                    case ADICIONA_ID_BUFFER:
                                        ids.add(analiseLexica.getLexema());
                                    break;
                                    case ARMAZENA_ID_PROCEDURE:
                                        tabelaIdentificadores.insereProcTabela(analiseLexica.getLexema().hashCode());
                                    break;                           
                                    case ARAMZENA_ID_PROGRAM:
                                        tabelaIdentificadores.insereProcTabela(analiseLexica.getLexema().hashCode());
                                    break;
                                    case  ATRIBUI_TIPO_IDS:
                                        while(!ids.isEmpty()){
  
                                        }
                                    break;                 
                                }
                                regraSemantica = null;
                            }
                            
                            analiseLexica.nextToken();
                        }
                        else{
                            Principal.insereTableSintatico(null,"","LINHA: "+ Integer.toString(analiseLexica.getLinha())+" COLUNA: "+Integer.toString(analiseLexica.getColuna() - analiseLexica.getLexema().length())+"  ERRO: espesrava simbolos: "+ stack.peek().toString());
                            System.out.println("\n\nERRO TERMINAIS DIFERENTES       LINHA: "+ Integer.toString(analiseLexica.getLinha())+" COLUNA: "+Integer.toString(analiseLexica.getColuna() - analiseLexica.getLexema().length())+" \n\n");
 
                        }
                        
                        stack.pop();
                        
                    }
                    else{
                        
                        Stack stackAux = (Stack) tabelaSintaticaPreditiva.getProducao(analiseLexica.getToken(),(Producao) stack.peek());
                        
                        
                        if(stackAux == null){
                            Principal.insereTableSintatico(null,"","LINHA: "+ Integer.toString(analiseLexica.getLinha())+" COLUNA: "+Integer.toString(analiseLexica.getColuna() - analiseLexica.getLexema().length())+"  ERRO: "+ ErroSintatico.Erro((Producao) stack.peek()));
                            analiseLexica.nextToken();
                        }
                        else{
                        
                            Producao producao = (Producao) stack.pop();
                            
                            stackAux = (Stack) stackAux.clone();
                            
                            while(!stackAux.empty())   stack.push(stackAux.pop());
                            
                            if(stack.peek().equals(Producao.SINC)){
                                Principal.insereTableSintatico(null,"","LINHA: "+ Integer.toString(analiseLexica.getLinha())+" COLUNA: "+Integer.toString(analiseLexica.getColuna() - analiseLexica.getLexema().length())+"  ERRO: "+ ErroSintatico.Erro(producao));
                                stack.pop();
                            }

                        }

                    }
                }
            }
        }
    }
    
    public void printStack(Stack stack){
        Stack stackAux = (Stack) stack.clone();
        
        while(!stackAux.empty()) System.out.print(stackAux.pop().toString()+" ");
        System.out.print("            "+analiseLexica.getLexema());
        System.out.println();
            
    }
}

