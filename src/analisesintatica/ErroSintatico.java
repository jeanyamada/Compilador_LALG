/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisesintatica;

/**
 *
 * @author jean
 */
public class ErroSintatico {
    public static String Erro(Producao producao){
        switch(producao){
            case PGM: return "Esperava program";
            case BLC: return "Esperava simbolos: var procedure begin";
            case J: return "Esperava simbolos: procedure begin";
            case TP: return "Esperava simbolos: id";
            case PDV: return "Esperava simbolos: var";
            case T: return "Esperava simbolos: ;";
            case T1: return "Esperava simbolos : procedure begin";
            case DV: return "Esperava simbolos: id";
            case LID: return "Esperava simbolos: id";
            case Ç: return "Esperava simbolos : :";
            case PDS: return "Esperava simbolos: begin";
            case K: return "Esperava simbolos: procedure begin";
            case DP: return "Esperava simbolos: procedure";
            case U: return "Esperava simbolos: id";
            case U1: return "Esperava simbolos: ;";
            case PF: return "Esperava simbolos: (";
            case V: return "Esperava simbolos: id var";
            case V1: return "Esperava simbolos: )";
            case SPF: return "Esperava simbolos: id,var";
            case B: return "Esperava simbolos: id,var";
            case CC: return "Esperava simbolos: begin";
            case CMD: return "Esperava simbolos: id begin if while";
            case E: return "Esperava simbolos: := (";
            case S: return "Esperava simbolos: ; end else";
            case CMDC:  return "Esperava simbolos: if";
            case C: return "Esperava simbolos: ; else";
            case CMDS: return "Esperava simbolos: id begin if while";
            case CMDR: return "Esperava simbolos: while";
            case EXP: return "Esperava simbolos: + - id nm ( not";
            case N: return "Esperava simbolos: ; end else then do ) ,";
            case P: return  "Esperava simbolos: = <> = >= < <>";
            case RL: return "Esperava simbolos: = <> < <= >= >";
            case EXPS: return "Esperava simbolos: + - id nm ( not";
            case Z: return "Esperava simbolos: id nm ( not";
            case Z1: return "Esperava simbolos: = <> < <= >= > ; end else then do ) ,";
            case W: return "Esperava simbolos: + -";
            case Y: return "Esperava simbolos: + - or";
            case TRM: return "Esperava simbolos: + - id nm ( not";
            case M: return "Esperava simbolos: + - = <> < <= >= > ; end else then do ) ,";
            case H: return "Esperava simbolos: * div and";
            case FTR: return "Esperava simbolos: id nm ( not";
            case LE: return "Esperava simbolos: + - id nm ( not";
            case I: return "Esperava simbolos: )";
            
            default: return "";
        }
    }
}
