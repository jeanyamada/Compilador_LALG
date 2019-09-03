/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import analiselexica.Token;
import analisesemantica.RegraSemantica;
import analisesintatica.Producao;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author jean
 */
public class TabelaSintaticaPreditiva {

    private final HashMap<Token, HashMap> tabelaSintaticaPreditiva;

    public TabelaSintaticaPreditiva() {
        tabelaSintaticaPreditiva = new HashMap<>();
    }

    public Stack getProducao(Token terminal, Producao naoTerminal) {
        if (containsNaoTerminal(terminal, naoTerminal)) {
            return  (Stack) tabelaSintaticaPreditiva.get(terminal).get(naoTerminal);
        }
        return null;
    }

    public boolean containsNaoTerminal(Token terminal, Producao naoTerminal) {
        if (containsTerminal(terminal)) {
            return tabelaSintaticaPreditiva.get(terminal).containsKey(naoTerminal);
        }
        return false;
    }

    public boolean containsTerminal(Token terminal) {
        return tabelaSintaticaPreditiva.containsKey(terminal);
    }

    public void inicializaTabela() {

        HashMap<Producao, Stack> hashMap;
        Stack stack;

        tabelaSintaticaPreditiva.put(Token.PROGRAM, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.VAR, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.PROCEDURE, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.BEGIN, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.ID, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.NUM_INTEIRO, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.NUM_REAL, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.IF, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.ELSE, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.WHILE, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.NOT, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.DIV, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.AND, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.END, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_PONTO_VIRGULA, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_DEFINETIPO, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_VIRGULA, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_AP, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_FP, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.OP_SOMA, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.OP_SUB, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_IGUAL, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_DIFERENTE, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_MENOR, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_MENORIGUAL, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_MAIOR, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_MAIORIGUAL, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.OP_MULT, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_ATRIBUICAO, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.THEN, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.DO, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.OR, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.READ, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.WRITE, new HashMap<>());
        tabelaSintaticaPreditiva.put(Token.SIMB_PONTO, new HashMap<>());

        hashMap = tabelaSintaticaPreditiva.get(Token.PROGRAM);

        stack = new Stack();
        stack.push(Token.PROGRAM);
        /*armazena id da categoria program*/  
        stack.push(RegraSemantica.ARAMZENA_ID_PROGRAM);
        stack.push(Token.ID);        
        stack.push(Token.SIMB_PONTO_VIRGULA);
        stack.push(Producao.BLC);
        stack.push(Token.SIMB_PONTO);
        hashMap.put(Producao.PGM, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.VAR);

        stack = new Stack();
        stack.push(Producao.PDV);
        stack.push(Producao.J);
        hashMap.put(Producao.BLC, stack);

        stack = new Stack();
        stack.push(Token.VAR);
        stack.push(Producao.DV);
        stack.push(Producao.T);
        hashMap.put(Producao.PDV, stack);

        stack = new Stack();
        stack.push(Producao.SPF);
        stack.push(Producao.V1);
        hashMap.put(Producao.V, stack);

        stack = new Stack();
        stack.push(Producao.B);
        stack.push(Token.SIMB_DEFINETIPO);
        stack.push(Producao.TP);
        hashMap.put(Producao.SPF, stack);

        stack = new Stack();
        stack.push(Token.VAR);
        stack.push(Producao.LID);
        hashMap.put(Producao.B, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.PROCEDURE);

        stack = new Stack();
        stack.push(Producao.J);
        hashMap.put(Producao.BLC, stack);

        stack = new Stack();
        stack.push(Producao.PDS);
        stack.push(Producao.CC);
        hashMap.put(Producao.J, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.T1, stack);

        stack = new Stack();
        stack.push(Producao.K);
        stack.push(Producao.PDS);
        hashMap.put(Producao.PDS, stack);

        stack = new Stack();
        stack.push(Producao.DP);
        stack.push(Token.SIMB_PONTO_VIRGULA);
        hashMap.put(Producao.K, stack);

        stack = new Stack();
        stack.push(Token.PROCEDURE);
        stack.push(Producao.U);
        stack.push(Token.SIMB_PONTO_VIRGULA);
        stack.push(Producao.BLC);
        hashMap.put(Producao.DP, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.PDV, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.T, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.BEGIN);
        stack = new Stack();
        stack.push(Producao.J);
        hashMap.put(Producao.BLC, stack);

        stack = new Stack();
        stack.push(Producao.CC);
        hashMap.put(Producao.J, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.T1, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.PDS, stack);

        stack = new Stack();
        stack.push(Token.BEGIN);
        stack.push(Producao.CMDS);
        stack.push(Token.END);
        hashMap.put(Producao.CC, stack);
        
        stack = new Stack();
        stack.push(Producao.CC);
        hashMap.put(Producao.CMD, stack);
        
        stack = new Stack();
        stack.push(Producao.CMD);
        stack.push(Token.SIMB_PONTO_VIRGULA);
        stack.push(Producao.CMDS);
        hashMap.put(Producao.CMDS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.PDV, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.T, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.K, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.ID);

        stack = new Stack();
        /*atribui tipo a ids no buffer*/
        stack.push(RegraSemantica.ATRIBUI_TIPO_IDS);
        stack.push(Token.ID);
        /*retira variaveiz do buffer*/
        stack.push(RegraSemantica.RETIRA_ID_BUFFER);
        hashMap.put(Producao.TP, stack);

        stack = new Stack();
        stack.push(Producao.DV);
        stack.push(Producao.T);
        hashMap.put(Producao.T1, stack);

        stack = new Stack();
        stack.push(Producao.LID);
        stack.push(Token.SIMB_DEFINETIPO);
        stack.push(Producao.TP);
        hashMap.put(Producao.DV, stack);

        stack = new Stack();
        /*armazena id em buffer*/
        stack.push(RegraSemantica.ADICIONA_ID_BUFFER);
        stack.push(Token.ID);
       
        stack.push(Producao.Ç);
        hashMap.put(Producao.LID, stack);

        stack = new Stack();
        /*armazena id em buffer*/
        stack.push(RegraSemantica.ARMAZENA_ID_PROCEDURE);        
        stack.push(Token.ID);

        stack.push(Producao.U1);
        hashMap.put(Producao.U, stack);

        stack = new Stack();
        stack.push(Producao.SPF);
        stack.push(Producao.V1);
        hashMap.put(Producao.V, stack);

        stack = new Stack();
        stack.push(Producao.B);
        stack.push(Token.SIMB_DEFINETIPO);
        stack.push(Producao.TP);
        hashMap.put(Producao.SPF, stack);

        stack = new Stack();
        stack.push(Producao.LID);
        hashMap.put(Producao.B, stack);

        stack = new Stack();
        stack.push(Token.ID);
        stack.push(Producao.E);
        hashMap.put(Producao.CMD, stack);
        
        stack = new Stack();
        stack.push(Producao.CMD);
        stack.push(Token.SIMB_PONTO_VIRGULA);
        stack.push(Producao.CMDS);
        hashMap.put(Producao.CMDS, stack);

        stack = new Stack();
        stack.push(Producao.Z);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.TRM);
        stack.push(Producao.Z1);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.FTR);
        stack.push(Producao.M);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Token.ID);
        hashMap.put(Producao.FTR, stack);

        stack = new Stack();
        stack.push(Producao.EXP);
        stack.push(Producao.I);
        hashMap.put(Producao.LE, stack);

        stack = new Stack();
        stack.push(Producao.EXPS);
        stack.push(Producao.N);
        hashMap.put(Producao.EXP, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.W, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Y, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.H, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.NUM_INTEIRO);

        stack = new Stack();
        stack.push(Producao.EXPS);
        stack.push(Producao.N);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.Z);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.TRM);
        stack.push(Producao.Z1);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.FTR);
        stack.push(Producao.M);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Token.NUM_INTEIRO);
        hashMap.put(Producao.FTR, stack);

        stack = new Stack();
        stack.push(Producao.EXP);
        stack.push(Producao.I);
        hashMap.put(Producao.LE, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.W, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Y, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.H, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.NUM_REAL);
        stack = new Stack();
        stack.push(Producao.EXPS);
        stack.push(Producao.N);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.Z);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.TRM);
        stack.push(Producao.Z1);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.FTR);
        stack.push(Producao.M);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Token.NUM_REAL);
        hashMap.put(Producao.FTR, stack);

        stack = new Stack();
        stack.push(Producao.EXP);
        stack.push(Producao.I);
        hashMap.put(Producao.LE, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.W, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Y, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.H, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.IF);

        stack = new Stack();
        stack.push(Producao.CMD);
        stack.push(Token.SIMB_PONTO_VIRGULA);
        stack.push(Producao.CMDS);
        hashMap.put(Producao.CMDS, stack);

        stack = new Stack();
        stack.push(Producao.CMDC);
        hashMap.put(Producao.CMD, stack);

        stack = new Stack();
        stack.push(Token.IF);
        stack.push(Producao.EXP);
        stack.push(Token.THEN);
        stack.push(Producao.CMD);
        stack.push(Producao.C);
        hashMap.put(Producao.CMDC, stack);
        
        
        hashMap = tabelaSintaticaPreditiva.get(Token.ELSE);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.S, stack);

        stack = new Stack();
        stack.push(Token.ELSE);
        stack.push(Producao.CMD);
        hashMap.put(Producao.C, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.CC, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.CMD, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.E, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.CMDC, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.CMDS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.E, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.CMDR, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);
       
        hashMap = tabelaSintaticaPreditiva.get(Token.WHILE);
        
        stack = new Stack();
        stack.push(Producao.CMDR);
        hashMap.put(Producao.CMD, stack);

        stack = new Stack();
        stack.push(Producao.CMD);
        stack.push(Producao.CMDS);
        hashMap.put(Producao.CMDS, stack);
        
        stack = new Stack();
        stack.push(Token.WHILE);
        stack.push(Producao.EXP);
        stack.push(Token.DO);
        stack.push(Producao.CMD);
        hashMap.put(Producao.CMDR, stack);
        
        hashMap = tabelaSintaticaPreditiva.get(Token.NOT);
        
        stack = new Stack();
        stack.push(Producao.EXPS);
        stack.push(Producao.N);
        hashMap.put(Producao.EXP, stack);
        
        stack = new Stack();
        stack.push(Producao.Z);
        hashMap.put(Producao.EXPS, stack);
        
        stack = new Stack();
        stack.push(Producao.TRM);
        stack.push(Producao.Z1);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.FTR);
        stack.push(Producao.M);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Token.NOT);
        stack.push(Producao.FTR);
        hashMap.put(Producao.FTR, stack);

        stack = new Stack();
        stack.push(Producao.EXP);
        stack.push(Producao.I);
        hashMap.put(Producao.LE, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.RL, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.W, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Y, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.H, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.DIV);
        
        stack = new Stack();
        stack.push(Producao.H);
        stack.push(Producao.TRM);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Token.DIV);
        hashMap.put(Producao.H, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.AND);
        
        stack = new Stack();
        stack.push(Producao.H);
        stack.push(Producao.TRM);
        hashMap.put(Producao.M, stack);
        
        stack = new Stack();
        stack.push(Token.AND);
        hashMap.put(Producao.H, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.END);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.S, stack);
        
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.CMDS, stack);
        
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);
                
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.E, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_PONTO_VIRGULA);
        
        stack = new Stack();
        stack.push(Token.SIMB_PONTO_VIRGULA);
        stack.push(Producao.T1);
        hashMap.put(Producao.T, stack);
        
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.U1, stack);

        stack = new Stack();
        stack.push(Token.SIMB_PONTO_VIRGULA);
        stack.push(Producao.V);
        hashMap.put(Producao.V1, stack);
  
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.S, stack);
        
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.C, stack);
        
        
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.BLC, stack);
 
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TP,stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.J, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.DV, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.DP, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.U, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.PF, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.SPF, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.CC, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.CMD, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.E, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.CMDC, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.CMDR, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_DEFINETIPO);
        
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Ç, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.LID, stack);
 
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.B, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_VIRGULA);
        
        stack = new Stack();
        stack.push(Token.SIMB_VIRGULA);
        stack.push(Producao.LID);
        hashMap.put(Producao.Ç, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Token.SIMB_VIRGULA);
        stack.push(Producao.LE);
        hashMap.put(Producao.I, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.P, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_AP);
        
        stack = new Stack();
        stack.push(Producao.PF);
        hashMap.put(Producao.U1, stack);

        stack = new Stack();
        stack.push(Token.SIMB_AP);
        stack.push(Producao.V);
        stack.push(Token.SIMB_FP);
        hashMap.put(Producao.PF, stack);

        stack = new Stack();
        stack.push(Producao.S);
        hashMap.put(Producao.E, stack);

        stack = new Stack();
        stack.push(Token.SIMB_AP);
        stack.push(Producao.LE);
        stack.push(Token.SIMB_FP);
        hashMap.put(Producao.S, stack);

        stack = new Stack();
        stack.push(Producao.EXPS);
        stack.push(Producao.N);
        hashMap.put(Producao.EXP, stack);
       
        stack = new Stack();
        stack.push(Producao.Z);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.TRM);
        stack.push(Producao.Z1);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.FTR);
        stack.push(Producao.M);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Token.SIMB_AP);
        stack.push(Producao.EXP);
        stack.push(Token.SIMB_FP);
        hashMap.put(Producao.FTR, stack);
        
        stack = new Stack();
        stack.push(Producao.EXP);
        stack.push(Producao.I);
        hashMap.put(Producao.LE, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.W, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Y, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.H, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_FP);
        
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.V1, stack);
        
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.I, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.V, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.SPF, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.LE, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.OP_SOMA);
        
        stack = new Stack();
        stack.push(Producao.EXPS);
        stack.push(Producao.N);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.W);
        stack.push(Producao.Z);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.Y);
        stack.push(Producao.Z);
        hashMap.put(Producao.Z1, stack);

        stack = new Stack();
        stack.push(Token.OP_SOMA);
        hashMap.put(Producao.W, stack);

        stack = new Stack();
        stack.push(Producao.W);
        hashMap.put(Producao.Y, stack);

        stack = new Stack();
        stack.push(Producao.FTR);
        stack.push(Producao.M);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.EXP);
        stack.push(Producao.I);
        hashMap.put(Producao.LE, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.H, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.OP_SUB);
        
        stack = new Stack();
        stack.push(Producao.EXPS);
        stack.push(Producao.N);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.W);
        stack.push(Producao.Z);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.Y);
        stack.push(Producao.Z);
        hashMap.put(Producao.Z1, stack);

        stack = new Stack();
        stack.push(Token.OP_SUB);
        hashMap.put(Producao.W, stack);

        stack = new Stack();
        stack.push(Producao.W);
        hashMap.put(Producao.Y, stack);

        stack = new Stack();
        stack.push(Producao.FTR);
        stack.push(Producao.M);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.EXP);
        stack.push(Producao.I);
        hashMap.put(Producao.LE, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.H, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_IGUAL);
        
        stack = new Stack();
        stack.push(Producao.P);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.RL);
        stack.push(Producao.EXPS);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Token.SIMB_IGUAL);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);
 
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_DIFERENTE);
        
        
        stack = new Stack();
        stack.push(Producao.P);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.RL);
        stack.push(Producao.EXPS);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Token.SIMB_DIFERENTE);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);
 
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_MENOR);
        
        
        stack = new Stack();
        stack.push(Producao.P);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.RL);
        stack.push(Producao.EXPS);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Token.SIMB_MENOR);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);
 
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_MENORIGUAL);
        
        
        stack = new Stack();
        stack.push(Producao.P);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.RL);
        stack.push(Producao.EXPS);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Token.SIMB_MENORIGUAL);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);
 
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_MAIOR);
        
        
        stack = new Stack();
        stack.push(Producao.P);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.RL);
        stack.push(Producao.EXPS);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Token.SIMB_MAIOR);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);
 
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_MAIORIGUAL);
        
        
        stack = new Stack();
        stack.push(Producao.P);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.RL);
        stack.push(Producao.EXPS);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Token.SIMB_MAIORIGUAL);
        hashMap.put(Producao.RL, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);
 
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXPS, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.OP_MULT);
        
        stack = new Stack();
        stack.push(Producao.H);
        stack.push(Producao.TRM);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Token.OP_MULT);
        hashMap.put(Producao.H, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);


        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_ATRIBUICAO);
        
        stack = new Stack();
        stack.push(Token.SIMB_ATRIBUICAO);
        stack.push(Producao.EXP);
        hashMap.put(Producao.E, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.THEN);
        
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Producao.EXPS);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.DO);
        
        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.M, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.N, stack);

        stack = new Stack();
        stack.push(Producao.VAZIO);
        hashMap.put(Producao.Z1, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.EXP, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Producao.EXPS);
        hashMap.put(Producao.P, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.Z, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.TRM, stack);

        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.FTR, stack);

        hashMap = tabelaSintaticaPreditiva.get(Token.OR);
        stack = new Stack();
        stack.push(Token.OR);
        hashMap.put(Producao.Y, stack);


        hashMap = tabelaSintaticaPreditiva.get(Token.READ);
        
        stack = new Stack();
        stack.push(Token.READ);
        stack.push(Token.SIMB_AP);
        stack.push(Producao.LID);
        stack.push(Token.SIMB_FP);
        hashMap.put(Producao.CMD, stack);


        hashMap = tabelaSintaticaPreditiva.get(Token.WRITE);
        
        stack = new Stack();
        stack.push(Token.WRITE);
        stack.push(Token.SIMB_AP);
        stack.push(Producao.LID);
        stack.push(Token.SIMB_FP);
        hashMap.put(Producao.CMD, stack);
        
        hashMap = tabelaSintaticaPreditiva.get(Token.SIMB_PONTO);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.BLC, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.J, stack);
        
        stack = new Stack();
        stack.push(Producao.SINC);
        hashMap.put(Producao.CC, stack);
    }
}
