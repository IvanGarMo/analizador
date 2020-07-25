/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3clasesjava;

/**
 *
 * @author Han-S
 */
public class SintDescNRP {

    public final int NODIS = 5000;

    private final  Pila _pila;
    /*private final String[] _vts = {"", "id", "=", ";", "+", "-", "*", "/", "num", "(", ")", "$"};
    private final String[] _vns = {"", "A", "A'", "E", "E'", "T", "T'", "F"};
    
    //La primera columna es el número de producción, la segunda es el No de Yes y los otros son tokens (posición en el arreglo, núm negativos)
    //y variables terminales (posición en el arreglo, núm positivo)
    private final int[][] _prod = {
    {1, 5, -1, -2, 3, -3, 2}, // A->id = E ; A' 
    {2, 5, -1, -2, 3, -3, 2}, // A'->id = E ; A' 
    {2, 0, 0, 0, 0, 0, 0}, // A'->£
    {3, 2, 5, 4, 0, 0, 0}, // E->T E' 
    {4, 3, -4, 5, 4, 0, 0}, // E'->+ T E' 
    {4, 3, -5, 5, 4, 0, 0}, // E'->- T E' 
    {4, 0, 0, 0, 0, 0, 0}, // E'->£
    {5, 2, 7, 6, 0, 0, 0}, // T->F T' 
    {6, 3, -6, 7, 6, 0, 0}, // T'->* F T' 
    {6, 3, -7, 7, 6, 0, 0}, // T'->/ F T' 
    {6, 0, 0, 0, 0, 0, 0}, // T'->£
    {7, 1, -1, 0, 0, 0, 0}, // F->id 
    {7, 1, -8, 0, 0, 0, 0}, // F->num 
    {7, 3, -9, 3, -10, 0, 0} // F->( E ) 
};
    
    //3 columnas: primera vns, la segunda los vts y la tercera el número de la producción
    private final int[][] _m = {
    {1, 1, 0},
    {2, 1, 1},
    {2, 11, 2},
    {3, 1, 3},
    {3, 8, 3},
    {3, 9, 3},
    {4, 4, 4},
    {4, 5, 5},
    {4, 3, 6},
    {4, 10, 6},
    {5, 1, 7},
    {5, 8, 7},
    {5, 9, 7},
    {6, 6, 8},
    {6, 7, 9},
    {6, 4, 10},
    {6, 5, 10},
    {6, 3, 10},
    {6, 10, 10},
    {7, 1, 11},
    {7, 8, 12},
    {7, 9, 13}
    };*/
    
    /*private final String[] _vts={ "", "id", "=", ";", "cad", "car", "+", "-", "*", "/", "num", "(", ")", "leer", ",", "[", "]", "visua", "$" };
    private final String[] _vns={ "", "R", "R'", "A", "A'", "E", "E'", "T", "T'", "F", "L", "X", "X''", "X'", "O", "O''", "O'", "V", "W", "W''", "W'" };
    private int[][] _prod={{1,2,3,2,0},          // R->A R' 
                           {1,2,10,2,0},          // R->L R' 
                           {1,2,17,2,0},          // R->V R' 
                           {2,2,3,2,0},          // R'->A R' 
                           {2,2,10,2,0},          // R'->L R' 
                           {2,2,17,2,0},          // R'->V R' 
                           {2,0,0,0,0},          // R'->£
                           {3,3,-1,-2,4},          // A->id = A' 
                           {4,2,5,-3,0},          // A'->E ; 
                           {4,2,-4,-3,0},          // A'->cad ; 
                           {4,2,-5,-3,0},          // A'->car ; 
                           {5,2,7,6,0},          // E->T E' 
                           {6,3,-6,7,6},          // E'->+ T E' 
                           {6,3,-7,7,6},          // E'->- T E' 
                           {6,0,0,0,0},          // E'->£
                           {7,2,9,8,0},          // T->F T' 
                           {8,3,-8,9,8},          // T'->* F T' 
                           {8,3,-9,9,8},          // T'->/ F T' 
                           {8,0,0,0,0},          // T'->£
                           {9,1,-1,0,0},          // F->id 
                           {9,1,-10,0,0},          // F->num 
                           {9,3,-11,5,-12},          // F->( E ) 
                           {10,3,-13,11,-3},          // L->leer X ; 
                           {11,2,-1,12,0},          // X->id X'' 
                           {12,2,14,13,0},          // X''->O X' 
                           {12,1,13,0,0},          // X''->X' 
                           {13,3,-14,-1,12},          // X'->, id X'' 
                           {13,0,0,0,0},          // X'->£
                           {14,2,-15,15,0},          // O->[ O'' 
                           {15,3,-1,-16,16},          // O''->id ] O' 
                           {15,3,-10,-16,16},          // O''->num ] O' 
                           {16,2,-15,15,0},          // O'->[ O'' 
                           {16,0,0,0,0},          // O'->£
                           {17,3,-17,18,-3},          // V->visua W ; 
                           {18,2,-1,19,0},          // W->id W'' 
                           {18,2,-4,20,0},          // W->cad W' 
                           {18,2,-5,20,0},          // W->car W' 
                           {18,2,-10,20,0},          // W->num W' 
                           {19,2,14,20,0},          // W''->O W' 
                           {19,1,20,0,0},          // W''->W' 
                           {20,2,-14,18,0},          // W'->, W 
                           {20,0,0,0,0}          // W'->£
                          };
      private int[][] _m={{1,1,0},
                         {1,13,1},
                         {1,17,2},
                         {2,1,3},
                         {2,13,4},
                         {2,17,5},
                         {2,18,6},
                         {3,1,7},
                         {4,1,8},
                         {4,10,8},
                         {4,11,8},
                         {4,4,9},
                         {4,5,10},
                         {5,1,11},
                         {5,10,11},
                         {5,11,11},
                         {6,6,12},
                         {6,7,13},
                         {6,3,14},
                         {6,12,14},
                         {7,1,15},
                         {7,10,15},
                         {7,11,15},
                         {8,8,16},
                         {8,9,17},
                         {8,6,18},
                         {8,7,18},
                         {8,3,18},
                         {8,12,18},
                         {9,1,19},
                         {9,10,20},
                         {9,11,21},
                         {10,13,22},
                         {11,1,23},
                         {12,15,24},
                         {12,14,25},
                         {12,3,25},
                         {13,14,26},
                         {13,3,27},
                         {14,15,28},
                         {15,1,29},
                         {15,10,30},
                         {16,15,31},
                         {16,14,32},
                         {16,3,32},
                         {17,17,33},
                         {18,1,34},
                         {18,4,35},
                         {18,5,36},
                         {18,10,37},
                         {19,15,38},
                         {19,14,39},
                         {19,3,39},
                         {20,14,40},
                         {20,3,41}
                        };*/
    
     private String[] _vts={ "", "class", "id", "{", "}", "int", "char", "double", "float", "short", "long", "string", "boolean", "object", ";", "num", "car", "cad", "new", "(", ")", "[", "]", "=", "if", "true", "false", "for", "++", "--", "while", "do", "public", "private", "protected", "static", "synchronized", "void", "+=", "-=", "/=", "==", ">=", "<=", "!=", "+", "-", "*", "/", "$" };
     private String[] _vns={ "", "S", "Z", "Z'", "U", "U'", "A", "A''", "A'", "T", "B", "B'", "C", "D", "D'", "E", "F", "F''", "F'", "G", "H", "I", "J", "J'", "K", "L", "M", "N", "O", "P", "Q", "R", "R'", "Y", "W", "X", "V" };
     private int[][] _prod={{1,5,-1,-2,-3,2,-4,0,0,0,0,0,0},          // S->class id { Z } 
                           {2,2,26,3,0,0,0,0,0,0,0,0,0},          // Z->M Z' 
                           {3,2,26,3,0,0,0,0,0,0,0,0,0},          // Z'->M Z' 
                           {3,0,0,0,0,0,0,0,0,0,0,0,0},          // Z'->£
                           {4,2,31,5,0,0,0,0,0,0,0,0,0},          // U->R U' 
                           {4,2,25,5,0,0,0,0,0,0,0,0,0},          // U->L U' 
                           {4,2,24,5,0,0,0,0,0,0,0,0,0},          // U->K U' 
                           {4,2,21,5,0,0,0,0,0,0,0,0,0},          // U->I U' 
                           {4,2,16,5,0,0,0,0,0,0,0,0,0},          // U->F U' 
                           {4,2,6,5,0,0,0,0,0,0,0,0,0},          // U->A U' 
                           {5,1,4,0,0,0,0,0,0,0,0,0,0},          // U'->U 
                           {5,0,0,0,0,0,0,0,0,0,0,0,0},          // U'->£
                           {6,3,9,10,7,0,0,0,0,0,0,0,0},          // A->T B A'' 
                           {6,2,15,6,0,0,0,0,0,0,0,0,0},          // A->E A 
                           {7,2,13,8,0,0,0,0,0,0,0,0,0},          // A''->D A' 
                           {7,0,0,0,0,0,0,0,0,0,0,0,0},          // A''->£
                           {7,1,6,0,0,0,0,0,0,0,0,0,0},          // A''->A 
                           {8,0,0,0,0,0,0,0,0,0,0,0,0},          // A'->£
                           {8,1,6,0,0,0,0,0,0,0,0,0,0},          // A'->A 
                           {9,1,-5,0,0,0,0,0,0,0,0,0,0},          // T->int 
                           {9,1,-6,0,0,0,0,0,0,0,0,0,0},          // T->char 
                           {9,1,-7,0,0,0,0,0,0,0,0,0,0},          // T->double 
                           {9,1,-8,0,0,0,0,0,0,0,0,0,0},          // T->float 
                           {9,1,-9,0,0,0,0,0,0,0,0,0,0},          // T->short 
                           {9,1,-10,0,0,0,0,0,0,0,0,0,0},          // T->long 
                           {9,1,-11,0,0,0,0,0,0,0,0,0,0},          // T->string 
                           {9,1,-12,0,0,0,0,0,0,0,0,0,0},          // T->boolean 
                           {9,1,-13,0,0,0,0,0,0,0,0,0,0},          // T->object 
                           {10,3,-2,34,11,0,0,0,0,0,0,0,0},          // B->id W B' 
                           {11,2,12,-14,0,0,0,0,0,0,0,0,0},          // B'->C ; 
                           {11,0,0,0,0,0,0,0,0,0,0,0,0},          // B'->£
                           {12,1,-15,0,0,0,0,0,0,0,0,0,0},          // C->num 
                           {12,1,-16,0,0,0,0,0,0,0,0,0,0},          // C->car 
                           {12,1,-17,0,0,0,0,0,0,0,0,0,0},          // C->cad 
                           {12,1,-2,0,0,0,0,0,0,0,0,0,0},          // C->id 
                           {13,3,-18,9,14,0,0,0,0,0,0,0,0},          // D->new T D' 
                           {14,3,-19,-20,-14,0,0,0,0,0,0,0,0},          // D'->( ) ; 
                           {14,4,-21,-15,-22,-14,0,0,0,0,0,0,0},          // D'->[ num ] ; 
                           {15,6,33,-21,-22,-2,-23,13,0,0,0,0,0},          // E->Y [ ] id = D 
                           {16,3,-24,-19,17,0,0,0,0,0,0,0,0},          // F->if ( F'' 
                           {17,3,20,-20,18,0,0,0,0,0,0,0,0},          // F''->H ) F' 
                           {17,3,19,-20,18,0,0,0,0,0,0,0,0},          // F''->G ) F' 
                           {18,1,4,0,0,0,0,0,0,0,0,0,0},          // F'->U 
                           {18,3,-3,4,-4,0,0,0,0,0,0,0,0},          // F'->{ U } 
                           {19,1,-25,0,0,0,0,0,0,0,0,0,0},          // G->true 
                           {19,1,-26,0,0,0,0,0,0,0,0,0,0},          // G->false 
                           {20,4,33,35,33,-14,0,0,0,0,0,0,0},          // H->Y X Y ; 
                           {21,11,-27,-19,6,-14,20,-14,22,-20,-3,4,-4},          // I->for ( A ; H ; J ) { U } 
                           {22,2,33,23,0,0,0,0,0,0,0,0,0},          // J->Y J' 
                           {23,2,-28,-14,0,0,0,0,0,0,0,0,0},          // J'->++ ; 
                           {23,2,-29,-14,0,0,0,0,0,0,0,0,0},          // J'->-- ; 
                           {24,7,-30,-19,20,-20,-3,4,-4,0,0,0,0},          // K->while ( H ) { U } 
                           {25,8,-31,-3,4,-4,-30,-19,20,-20,0,0,0},          // L->do { U } while ( H ) 
                           {26,7,27,28,29,30,-3,4,-4,0,0,0,0},          // M->N O P Q { U } 
                           {27,1,-32,0,0,0,0,0,0,0,0,0,0},          // N->public 
                           {27,1,-33,0,0,0,0,0,0,0,0,0,0},          // N->private 
                           {27,1,-34,0,0,0,0,0,0,0,0,0,0},          // N->protected 
                           {28,1,-35,0,0,0,0,0,0,0,0,0,0},          // O->static 
                           {28,1,-36,0,0,0,0,0,0,0,0,0,0},          // O->synchronized 
                           {29,1,9,0,0,0,0,0,0,0,0,0,0},          // P->T 
                           {29,1,-37,0,0,0,0,0,0,0,0,0,0},          // P->void 
                           {30,1,-2,0,0,0,0,0,0,0,0,0,0},          // Q->id 
                           {31,5,33,36,33,-14,32,0,0,0,0,0,0},          // R->Y V Y ; R' 
                           {32,0,0,0,0,0,0,0,0,0,0,0,0},          // R'->£
                           {32,1,31,0,0,0,0,0,0,0,0,0,0},          // R'->R 
                           {33,1,-2,0,0,0,0,0,0,0,0,0,0},          // Y->id 
                           {33,1,-15,0,0,0,0,0,0,0,0,0,0},          // Y->num 
                           {33,1,-6,0,0,0,0,0,0,0,0,0,0},          // Y->char 
                           {33,1,-17,0,0,0,0,0,0,0,0,0,0},          // Y->cad 
                           {34,1,-23,0,0,0,0,0,0,0,0,0,0},          // W->= 
                           {34,1,-38,0,0,0,0,0,0,0,0,0,0},          // W->+= 
                           {34,1,-39,0,0,0,0,0,0,0,0,0,0},          // W->-= 
                           {34,1,-40,0,0,0,0,0,0,0,0,0,0},          // W->/= 
                           {35,1,-41,0,0,0,0,0,0,0,0,0,0},          // X->== 
                           {35,1,-42,0,0,0,0,0,0,0,0,0,0},          // X->>= 
                           {35,1,-43,0,0,0,0,0,0,0,0,0,0},          // X-><= 
                           {35,1,-44,0,0,0,0,0,0,0,0,0,0},          // X->!= 
                           {36,1,-45,0,0,0,0,0,0,0,0,0,0},          // V->+ 
                           {36,1,-46,0,0,0,0,0,0,0,0,0,0},          // V->- 
                           {36,1,-47,0,0,0,0,0,0,0,0,0,0},          // V->* 
                           {36,1,-48,0,0,0,0,0,0,0,0,0,0}          // V->/ 
                          };
      private int[][] _m={{1,1,0},
                         {2,32,1},
                         {2,33,1},
                         {2,34,1},
                         {3,32,2},
                         {3,33,2},
                         {3,34,2},
                         {3,4,3},
                         {4,2,4},
                         {4,15,4},
                         {4,6,4},
                         {4,17,4},
                         {4,31,5},
                         {4,30,6},
                         {4,27,7},
                         {4,24,8},
                         {4,5,9},
                         {5,31,10},
                         {5,30,10},
                         {5,27,10},
                         {5,24,10},
                         {5,2,10},
                         {5,15,10},
                         {5,6,10},
                         {5,17,10},
                         {5,5,10},
                         {5,7,10},
                         {5,8,10},
                         {5,9,10},
                         {5,10,10},
                         {5,11,10},
                         {5,12,10},
                         {5,13,10},
                         {5,4,11},
                         {6,5,12},
                         {6,6,12},
                         {6,7,12},
                         {6,8,12},
                         {6,9,12},
                         {6,10,12},
                         {6,11,12},
                         {6,12,12},
                         {6,13,12},
                         {6,2,13},
                         {6,15,13},
                         {7,18,14},
                         {7,31,15},
                         {7,30,15},
                         {7,27,15},
                         {7,24,15},
                         {7,2,15},
                         {7,15,15},
                         {7,6,15},
                         {7,17,15},
                         {7,5,15},
                         {7,7,15},
                         {7,8,15},
                         {7,9,15},
                         {7,10,15},
                         {7,11,15},
                         {7,12,15},
                         {7,13,15},
                         {7,14,15},
                         {7,4,15},
                         {8,31,17},
                         {8,30,17},
                         {8,27,17},
                         {8,24,17},
                         {8,2,17},
                         {8,15,17},
                         {8,6,17},
                         {8,17,17},
                         {8,5,17},
                         {8,7,17},
                         {8,8,17},
                         {8,9,17},
                         {8,10,17},
                         {8,11,17},
                         {8,12,17},
                         {8,13,17},
                         {8,14,17},
                         {8,4,17},
                         {9,5,19},
                         {9,6,20},
                         {9,7,21},
                         {9,8,22},
                         {9,9,23},
                         {9,10,24},
                         {9,11,25},
                         {9,12,26},
                         {9,13,27},
                         {10,2,28},
                         {11,15,29},
                         {11,16,29},
                         {11,17,29},
                         {11,2,29},
                         {11,18,30},
                         {11,5,30},
                         {11,6,30},
                         {11,7,30},
                         {11,8,30},
                         {11,9,30},
                         {11,10,30},
                         {11,11,30},
                         {11,12,30},
                         {11,13,30},
                         {11,31,30},
                         {11,30,30},
                         {11,27,30},
                         {11,24,30},
                         {11,14,30},
                         {11,4,30},
                         {12,15,31},
                         {12,16,32},
                         {12,17,33},
                         {12,2,34},
                         {13,18,35},
                         {14,19,36},
                         {14,21,37},
                         {15,2,38},
                         {15,15,38},
                         {15,6,38},
                         {15,17,38},
                         {16,24,39},
                         {17,2,40},
                         {17,15,40},
                         {17,6,40},
                         {17,17,40},
                         {17,25,41},
                         {17,26,41},
                         {18,31,42},
                         {18,30,42},
                         {18,27,42},
                         {18,24,42},
                         {18,2,42},
                         {18,15,42},
                         {18,6,42},
                         {18,17,42},
                         {18,5,42},
                         {18,7,42},
                         {18,8,42},
                         {18,9,42},
                         {18,10,42},
                         {18,11,42},
                         {18,12,42},
                         {18,13,42},
                         {18,3,43},
                         {19,25,44},
                         {19,26,45},
                         {20,2,46},
                         {20,15,46},
                         {20,6,46},
                         {20,17,46},
                         {21,27,47},
                         {22,2,48},
                         {22,15,48},
                         {22,6,48},
                         {22,17,48},
                         {23,28,49},
                         {23,29,50},
                         {24,30,51},
                         {25,31,52},
                         {26,32,53},
                         {26,33,53},
                         {26,34,53},
                         {27,32,54},
                         {27,33,55},
                         {27,34,56},
                         {28,35,57},
                         {28,36,58},
                         {29,5,59},
                         {29,6,59},
                         {29,7,59},
                         {29,8,59},
                         {29,9,59},
                         {29,10,59},
                         {29,11,59},
                         {29,12,59},
                         {29,13,59},
                         {29,37,60},
                         {30,2,61},
                         {31,2,62},
                         {31,15,62},
                         {31,6,62},
                         {31,17,62},
                         {32,31,63},
                         {32,30,63},
                         {32,27,63},
                         {32,24,63},
                         {32,2,63},
                         {32,15,63},
                         {32,6,63},
                         {32,17,63},
                         {32,5,63},
                         {32,7,63},
                         {32,8,63},
                         {32,9,63},
                         {32,10,63},
                         {32,11,63},
                         {32,12,63},
                         {32,13,63},
                         {32,4,63},
                         {33,2,65},
                         {33,15,66},
                         {33,6,67},
                         {33,17,68},
                         {34,23,69},
                         {34,38,70},
                         {34,39,71},
                         {34,40,72},
                         {35,41,73},
                         {35,42,74},
                         {35,43,75},
                         {35,44,76},
                         {36,45,77},
                         {36,46,78},
                         {36,47,79},
                         {36,48,80}
                        };
    
    public void tienePesos() {
        for(int i=0; i<_noEnt; i++) {
            String simb = _vts[_m[i][1]];
            if(simb.equals("$")) {
                System.out.println("Tiene");
            }
        }
    }

    private final int _noVts;
    private final int _noVns;
    private final int _noProd;
    private final int _noEnt;
    private final int[] _di;
    private int _noDis;

    // Metodos 
    public SintDescNRP() // Constructor -----------------------
    {
        _pila = new Pila();
        _noVts = _vts.length;
        _noVns = _vns.length;
         _noProd = 81;
         _noEnt = 218;
        _di = new int[NODIS];
        _noDis = 0;
    }  // Fin del Constructor ---------------------------------------

    public void Inicia() // Constructor -----------------------
    {
        _pila.Inicia();
        _noDis = 0;
    }

    public int[][] Prod() {
        return _prod;
    }
    public int Analiza(Lexico oAnaLex) {
        //Apuntará al símbolo gramatical del tope de la pila
        SimbGram x; /*= new SimbGram("");*/
        //Apuntará al siguiente símbolo en w$
        String a;
        //Referencia al número de producción si necesitamos buscarlo en la tabla M
        int noProd;
        //Metemos el $
        _pila.Inicia();
        _pila.Push(new SimbGram("$"));
        //Mete el símbolo de inicio
        _pila.Push(new SimbGram(_vns[1]));
        //Mete el $ hasta el final de la tabla de reconocimiento del léxico
        oAnaLex.Anade("$", "$");
        //ae=0, porque w$ es un string (arrelgo de caracteres)
        int ae = 0;
        do {
            //Símbolo gramátical en el tope de la pila, primero será A
            x = _pila.Tope();
            //Regresa el arreglo de tokens y agarramos el elemento 0
            a = oAnaLex.Tokens()[ae];
            //Método para ver si el símbolo gramátical al que apunta x es terminal o no
            //X es un objeto de la clase símbolo gramátical, x regresa un string
            if (EsTerminal(x.Elem())) {
                //Si X==a saco al tope de la pila e incremento ae
                if (x.Elem().equals(a)) {
                    _pila.Pop();
                    ae++;
                    //Error
                } else {
                    return 0;
                }
            } else {
                //Revisa si existe esa producción, pasando a 'X' y a 'a'
                if ((noProd = BusqProd(x.Elem(), a)) >= 0) {
                    //Sí existe, sacamos el tope de la pila
                    _pila.Pop();
                    //y metemos todas las yes de la anterior producción empezando desde el final
                    MeterYes(noProd);
                    //En derivación hacia la izquierda mete el no prod
                    _di[_noDis++] = noProd;
                } else {
                    return 2;
                }
            }
            //Mientras no sea igual a $
        } while (!x.Elem().equals("$"));
        return 0;
    }

    //Recibe un string y recorre el arrelgo de terminales, si lo encuentra regresa verdadero,
    //si no falso
    public boolean EsTerminal(String x) {
        for (int i = 1; i < _noVts; i++) {
            if (_vts[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    //Recibe dos strings
    public int BusqProd(String x, String a) {
        int indiceX = 0;
        //Busca el índice de x en las variables no terminales
        for (int i = 1; i < _noVns; i++) {
            if (_vns[i].equals(x)) {
                indiceX = i;
                break;
            }
        }
        ///Busca el índice de a en las variables terminales
        int indiceA = 0;
        for (int i = 1; i < _noVts; i++) {
            if (_vts[i].equals(a)) {
                indiceA = i;
                break;
            }
        }
        //Checamos si en las entradas de la tabla m existe la entrada
        for (int i = 0; i < _noEnt; i++) {
            //Revisa si existe alguna entrada en la tabla m que tenga ese vns y ese vns
            if (indiceX == _m[i][0] && indiceA == _m[i][1]) {
                //Regresa el indice de la producción
                return _m[i][2];
            }
        }
        //-1 si no existe
        return -1;
    }

    //Recibe el número de la producción
    public void MeterYes(int noProd) {
        //Obtenemos el número de yes para esa producción especifica
        int noYes = _prod[noProd][1];
        //Recorremos desde 1 hasta el número de yes
        for (int i = 1; i <= noYes; i++) {
            //Tomamos de prod el renglón y el último
            if (_prod[noProd][noYes + 2 - i] < 0) {
                //Si es menor que cero, tomamos el índice en vts, pero antes hay que hacerlo positivo
                _pila.Push(new SimbGram(_vts[-_prod[noProd][noYes + 2 - i]]));
                //Si es mayor que 0 quiere decir que es variable sintáctica
                //no hay necesidad de hacerlo positivo
            } else {
                _pila.Push(new SimbGram(_vns[_prod[noProd][noYes + 2 - i]]));
            }
        }
    }

    public String[] Vts() {
        return _vts;
    }

    public String[] Vns() {
        return _vns;

    }

    public int[][] M() {
        return _m;

    }

    public int NoDis() {
        return _noDis;
    }

    public int[] Di() {

        return _di;

    }

    public int IndiceVn(String vn) {
        for (int i = 1; i < _noVns; i++) {
            if (_vns[i].equals(vn)) {
                return i;
            }
        }
        return 0;
    }

    public int IndiceVt(String vt) {
        for (int i = 1; i < _noVts; i++) {
            if (_vts[i].equals(vt)) {
                return i;
            }
        }
        return 0;
    }

    public int NoProd() {
        return _noProd;
    }
    
    /*public String ProdCad(int noProd) {
        //[_prod[noProd][0]] Nos sirve para obtener el número de la variable sintactica en el arreglo _vns
        String aux=""+_vns[_prod[noProd][0]]+"->";
        int noYes = _prod[noProd][1];
        if(noYes>0) {
            for(int i=2; i<=noYes+1; i++) {
                if(_prod[noProd][i]<0) {
                    aux += " "+_vts[-_prod[noProd][i]];
                } else {
                    aux += " "+_vns[_prod[noProd][i]];
                }
            }
        } else {
            aux+=" £";
        }
        return aux;
    }*/
    
    public int noVts() {
        return _noVts;
    }
    
    public int noEnt() {
        return _noEnt;
    }
}
