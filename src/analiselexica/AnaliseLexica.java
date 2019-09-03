/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiselexica;

import tabela.TabelaPalavraReservada;

/**
 *
 * @author jean
 */
public class AnaliseLexica {
    
    private TabelaPalavraReservada tabelaPalavraReservada;
    private String code;
    private String lexema;
    private String erro;
    private int nextCharacter;
    private int linha,coluna;
    private Token token;

    public AnaliseLexica(String code) {
        this.code = code;
        this.code += "\n";
        nextCharacter = 0;
        lexema = new String();
        erro = new String();
        linha = 0;
        coluna = 0;
        tabelaPalavraReservada = new TabelaPalavraReservada();
        tabelaPalavraReservada.inicializaTabela();
    }
    
    public void nextToken(){
    
        int estado = 0;
        Character characterAtual;
        boolean flag = true;
        lexema = "";
        
        if(nextCharacter < code.length()-1)
            while(flag){

                characterAtual = proxCharacter();
                
                if(characterAtual == null)  break;
                
                coluna++;
                
                switch(estado){

                    case 0:

                        if(characterAtual.equals('{')) estado = 1;
                        
                        else if(characterAtual.equals('/')){
                            lexema += characterAtual;
                            estado = 2;
                        }
                        else if(Character.isDigit(characterAtual)){
                            lexema += characterAtual;
                            estado = 4;
                        }

                        else if(characterAtual.equals('+')){
                            lexema += characterAtual;
                            estado = 6;
                        }
                        else if(characterAtual.equals('-')){
                            lexema += characterAtual;
                            estado = 7;
                        }
                        else if(characterAtual.equals('*')){
                            lexema += characterAtual;
                            estado = 8;
                        }
                        
                        else if(characterAtual.equals(';')){
                            lexema += characterAtual;
                            estado = 9;
                        }
                        
                        else if(characterAtual.equals(',')){
                            lexema += characterAtual;
                            estado = 10;
                        }
                        
                        else if(characterAtual.equals('<')){
                            lexema += characterAtual;
                            estado = 11;
                        }
                        
                        else if(characterAtual.equals('>')){
                            lexema += characterAtual;
                            estado = 12;
                        }
                        
                        else if(characterAtual.equals(':')){
                            lexema += characterAtual;
                            estado = 13;
                        }
                        
                        else if(characterAtual.equals('=')){
                            lexema += characterAtual;
                            estado = 18;
                        }
                        
                        else if(characterAtual.equals('(')){
                            lexema += characterAtual;
                            estado = 19;
                        }
                        
                        else if(characterAtual.equals(')')){
                            lexema += characterAtual;
                            estado = 20;
                        }       
                        
                        else if(isAlphabetic(characterAtual)){
                            lexema += characterAtual;
                            estado = 21;
                        }
                        
                        else if(characterAtual.equals('\n')){
                            linha++;
                            coluna = 0;
                        }
                        
                        else if(characterAtual.equals(' ')){
                            estado = 22;
                        }
                        
                        else if(characterAtual.equals('\t')){
                            estado = 24;
                        }
                        
                        else if(characterAtual.equals('}')){
                            lexema+=characterAtual;
                            estado = 25;
                        }
                        else if(characterAtual.equals('.')){
                            lexema+=characterAtual;
                            estado = 26;
                        }
                        /*simbolo desconhecido*/
                        else{
                            lexema += characterAtual;
                            estado = 23;
                        }
                        
                    break;

                    case 1:

                        if(characterAtual.equals('}')) estado = 0;
                        

                    break;

                    case 2:

                        if(characterAtual.equals('/')) {
                            lexema = "";
                            estado = 3;
                        }
                        else{
                            nextCharacter--;
                            coluna--;
                            setErro("");
                            setToken(Token.DIV);
                            break;
                        }
                    break;

                    case 3:

                        if(characterAtual.equals('\n')){
                            estado = 0;
                            coluna = 0;
                            linha++;
                        }

                    break;
                    
                    case 4:
                        
                        if(!Character.isDigit(characterAtual)){
                            if(characterAtual.equals('.')){
                                lexema += characterAtual;
                                estado = 5;
                            }
                            else{
                                nextCharacter--;
                                coluna--;
                                setErro("");
                                setToken(Token.NUM_INTEIRO);                                
                                flag = false;
                            }
                        }
                        else lexema += characterAtual;
                        
                    break;
                    
                    case 5:
                        
                        if(!Character.isDigit(characterAtual)){
                            nextCharacter--;
                            coluna--;

                            setErro("");
                            setToken(Token.NUM_REAL);
                            flag = false;
                        }
                        else{
                            lexema += characterAtual;
                        }
                        
                    break;
                    
                    case 6:                      
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.OP_SOMA);
                        flag = false;
                    break;                        
                    
                    case 7:
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.OP_SUB);
                        flag = false;
                    break;
                        
                    case 8:
                        
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.OP_MULT);
                        flag = false;
                       
                    break;
                    case 9:
                        
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.SIMB_PONTO_VIRGULA);
                        flag = false;
                        
                    break;
                    
                    case 10:
                        
                        nextCharacter--;
                        coluna--;
                        setErro("");                        
                        setToken(Token.SIMB_VIRGULA);
                        flag = false;
                        
                    break;

                    case 11:
                        
                        switch (characterAtual) {
                            case '=':
                                lexema += characterAtual;
                                estado = 14;
                                break;
                            case '>':
                                lexema += characterAtual;
                                estado = 15;
                                break;
                            default:
                                nextCharacter--;
                                coluna--;
                                setErro("");
                                setToken(Token.SIMB_MENOR);
                                flag = false;
                        }
                        
                    break;
                    
                    case 12:
                        
                        if(characterAtual.equals('=')){
                            lexema += characterAtual;
                            estado = 16;
                        }
                        else{
                            nextCharacter--;
                            coluna--;
                            setErro("");
                            setToken(Token.SIMB_MAIOR);
                            flag = false;
                        }
                    break;

                    case 13:
                        
                        if(characterAtual.equals('=')){
                            lexema += characterAtual;
                            estado = 17;
                        }
                        else{
                            nextCharacter--;
                            coluna--;
                            setErro("");
                            setToken(Token.SIMB_DEFINETIPO);
                            flag = false;
                        }   
                        
                    break;
                    
                    case 14:                        
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.SIMB_MENORIGUAL);
                        flag = false;
                    break;
                    
                    case 15:
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.SIMB_DIFERENTE);
                        flag = false;
                    break;
                    
                    case 16:
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.SIMB_MAIORIGUAL);
                        flag = false;
                        
                    break;
                    case 17:
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.SIMB_ATRIBUICAO);
                        flag = false;
                    break;
                    
                    case 18:
                        
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.SIMB_IGUAL);
                        flag = false;
                    break;
                        
                    case 19:
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.SIMB_AP);
                        flag = false;
                    break;
                        
                    case 20:
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken(Token.SIMB_FP);
                        flag = false;
                    break;
                    
                    case 21:
                
                        if(isAlphabetic(characterAtual) || Character.isDigit(characterAtual)){
                           lexema += characterAtual;
                        }
                        else {
                           nextCharacter--;
                           coluna--;
                           setErro("");
                           if(tabelaPalavraReservada.buscaPalavraReservada(lexema)){

                               setToken(tabelaPalavraReservada.getTokenPalavraReservada(lexema));
                               flag = false;
                           }
                           else{
                               if(lexema.length() > 10)
                                   setErro("Limite excedido");
                               else setErro("");
                               
                               setToken(Token.ID);
                               flag = false;
                           }
                        }
                            
                        
                    break;
                    
                    case 22:
                        
                        if(!characterAtual.equals(' ')){
                            nextCharacter--;
                            coluna--;
                            estado = 0;
                        }
                        
                    break;

                    
                    case 23:
                        
                        nextCharacter--;
                        coluna--;
                        setErro("Simbolo desconhecido");
                        setToken(Token.SIMB_DESCONHECIDO);
                        flag = false;
                        
                    break;
                    
                    case 24:
                        
                        if(!characterAtual.equals('\t')){
                            nextCharacter--;
                            coluna--;
                            estado = 0;
                        }
                        
                    break;
                    
                    case 25:
                        
                        nextCharacter--;
                        coluna--;
                        setErro("Esperava { ");
                        setToken(Token.SIMB_DESCONHECIDO);
                        flag = false;
                    break;
                        
                    case 26:
                        nextCharacter--;
                        coluna--;
                        setErro("");
                        setToken( Token.SIMB_PONTO);
                        flag = false;
                    break;
                }
            }
        else setToken(Token.FINISH_CODE);
    }
    
    private Character proxCharacter(){
        if(nextCharacter == code.length()) return null;
        return code.charAt(nextCharacter++);
    }
    
        
    private boolean isAlphabetic(Character character){
       if((character > 96 && character < 123) || (character > 64 && character < 91) || character.equals('_'))
           return true;
       return false;
    }
   

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the lexema
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * @param lexema the lexema to set
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    /**
     * @return the nextCharacter
     */
    public int getNextCharacter() {
        return nextCharacter;
    }

    /**
     * @param nextCharacter the nextCharacter to set
     */
    public void setNextCharacter(int nextCharacter) {
        this.nextCharacter = nextCharacter;
    }

    /**
     * @return the linha
     */
    public int getLinha() {
        return linha;
    }

    /**
     * @return the coluna
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * @return the erro
     */
    public String getErro() {
        return erro;
    }

    /**
     * @param erro the erro to set
     */
    public void setErro(String erro) {
        this.erro = erro;
    }

    /**
     * @return the token
     */
    public Token getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(Token token) {
        this.token = token;
    }
    
}
