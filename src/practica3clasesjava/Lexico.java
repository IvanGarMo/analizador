/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3clasesjava;

/**
 *
 * @author Alonso Martinez
 */
public class Lexico {

    //Número máximo de autómatas
    final int TOKREC = 12;
    final int MAXTOKENS = 500;
    String[] _lexemas;
    String[] _tokens;
    String _lexema;
    int _noTokens;
    int[] _i = {0};
    int _iniToken;
    Automata oAFD;

    //Revisa un arreglo de palabras reservadas y si la encuentra regresa falso, 
    //si no, regresa verdadero, ya que si es id
    private boolean EsId() {
        String[] palRes = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
            "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
            "finally", "float", "for", "if", "implements", "import", "int", "interface", "long",
            "native", "new", "package", "private", "protected", "public", "return", "short",
            "static", "super", "switch", "synchronized", "this", "throw", "throws", "transient",
            "try", "void", "while"
        };
        for (int i = 0; i < palRes.length; i++) {
            if (_lexema.equals(palRes[i])) {
                return false;
            }
        }
        return true;
    }

    public int NoTokens() {
        return _noTokens;
    }

    public String[] Tokens() {
        return _tokens;
    }

    public String[] Lexemas() {
        return _lexemas;
    }

    public Lexico() // constructor por defecto
    {
        _lexemas = new String[MAXTOKENS];
        _tokens = new String[MAXTOKENS];
        oAFD = new Automata();
        _i[0] = 0;
        _iniToken = 0;
        _noTokens = 0;
    }

    //Pone todo en ceros
    public void Inicia() {
        _i[0] = 0;
        _iniToken = 0;
        _noTokens = 0;
    }

    public boolean Analiza(String texto) {
        boolean recAuto;
        int noAuto;
//     int t = ;

        while (_i[0] < texto.length()) {
            recAuto = false;
            noAuto = 0;
            for (; noAuto < TOKREC && !recAuto;) {
                //Revisa si un método de la clase Autómata reconoce el token
                //si no, aumenta el número de autómata
                if (oAFD.Reconoces(texto, _iniToken, _i, noAuto)) {
                    recAuto = true;
                } else {
                    noAuto++;
                }
            }
            //Si lo reconoció, tomamos el número del autómata
            if (recAuto) {
                _lexema = texto.substring(_iniToken, _i[0]);
                switch (noAuto) {
                    //--------------  Automata  delim--------------
                    case 0: //_tokens[_noTokens] = "delim";
                        break;
                    //--------------  Automata  id--------------
                    //Si es ID, guarda el token como id, si no como palres
                    case 1:
                        if (EsId()) {
                            _tokens[_noTokens] = "id";
                        } else {
                            _tokens[_noTokens] = _lexema;
                        }
                        break;
                    //--------------  Automata  OpAsig--------------
                    case 2:
                        _tokens[_noTokens] = _lexema;
                        break;
                    //--------------  Automata  incremento--------------
                    case 3:
                        _tokens[_noTokens] = _lexema;
                        break;
                    //--------------  Automata  arit-------------- 
                    case 4:
                        _tokens[_noTokens] = _lexema;
                        break;
                    //--------------  Automata  arit-------------- 
                    case 5:
                        _tokens[_noTokens] = _lexema;
                        break;
                    //--------------  Automata  arit-------------- 
                    case 6:
                        _tokens[_noTokens] = _lexema;
                        break;

                    //--------------  Automata  num--------------
                    case 7:
                        _tokens[_noTokens] = "num";
                        break;
                    //--------------  Automata  sep--------------
                    case 8:
                        _tokens[_noTokens] = _lexema;
                        break;
                    //--------------  Automata  termInst--------------
                    case 9:
                        _tokens[_noTokens] = "cad";
                        break;
                    case 10: {
                        _tokens[_noTokens] = "Car";
                        break;
                    }
                    //----------Automata terminador de instrucciòn----------
                    case 11:
                        _tokens[_noTokens] = _lexema;
                        break;
                }
                if (noAuto != 0) {
                    _lexemas[_noTokens++] = _lexema;
                }
            } else {
                return false; //La parte de recuperación del error léxico se reemplaza por
            }       //este return false para indicar que existe un error léxico
            
            //Movemos iniToken, estamos listos para leer el siguiente token
            _iniToken = _i[0];
        }
        return true; //El análisis léxico ha sido exitoso cuando acaba el while 
    }
    
    //Añade el tipo de tokens y el lexema al arreglo
    public void Anade(String tok, String lex) {
       _tokens[_noTokens]=tok;
       _lexemas[_noTokens++]=lex;
    }
}
