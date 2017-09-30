package tcl_analyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Parser {

    final static Map<String, List<List<String>>> GRAMMAR = new HashMap<String, List<List<String>>>() {
        {
            put("ELSEIF", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_ELSEIF");
                            add("CUERPO_INST");
                            add("}");
                            add("ELSE");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ELSE");
                        }
                    });
                }
            });
            put("CASE_LOOP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_CASE");
                            add("CUERPO_LOOP");
                            add("}");
                            add("CASE2_LOOP");
                        }
                    });
                }
            });
            put("CUERPO_LOOP_FUNC", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("BREAK");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("CONTINUE");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("DECLARACION");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("GETS");
                            add(";");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("PUTS");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("RETURN_LOOP");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("IF_LOOP_FUNC");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("SWITCH_LOOP_FUNC");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("FOR_FUNCION");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("WHILE_FUNCION");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("AGRUP");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("INICIO_ELSE", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("else");
                            add("{");
                        }
                    });
                }
            });
            put("EXPRESION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("TERM");
                            add("AUX_EXPR");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("OP_UNARIO");
                            add("EXPRESION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("(");
                            add("EXPRESION");
                            add(")");
                        }
                    });
                }
            });
            put("CUERPO_LOOP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("DECLARACION");
                            add("CUERPO_LOOP");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("FOR");
                            add("CUERPO_LOOP");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("GETS");
                            add(";");
                            add("CUERPO_LOOP");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("IF_LOOP");
                            add("CUERPO_LOOP");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("PUTS");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("WHILE");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("SWITCH_LOOP");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("BREAK");
                            add("CUERPO_LOOP");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("CONTINUE");
                            add("CUERPO_LOOP");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("AGRUP");
                            add("CUERPO_LOOP");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("SWITCH_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_SWITCH");
                            add("CASE_FUNCION");
                            add("}");
                        }
                    });
                }
            });
            put("INICIO_CASE", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("case");
                            add("valor_entero");
                            add("{");
                        }
                    });
                }
            });
            put("AUX_EXPR", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("OP_BINARIO");
                            add("EXPRESION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("FOR_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_FOR");
                            add("CUERPO_LOOP_FUNC");
                            add("}");
                        }
                    });
                }
            });
            put("INICIO_FOR", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("for");
                            add("{");
                            add("set");
                            add("identificador");
                            add("ASIG_FOR");
                            add("}");
                            add("{");
                            add("EXPRESION");
                            add("}");
                            add("{");
                            add("incr");
                            add("identificador");
                            add("INCREMENTO");
                            add("}");
                            add("{");
                        }
                    });
                }
            });
            put("BREAK", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("break");
                            add(";");
                        }
                    });
                }
            });
            put("WHILE_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_WHILE");
                            add("CUERPO_LOOP_FUNC");
                            add("}");
                        }
                    });
                }
            });
            put("CASE2_LOOP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_CASE");
                            add("CUERPO_LOOP");
                            add("}");
                            add("CASE2_LOOP");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("DEFAULT_LOOP");
                        }
                    });
                }
            });
            put("VAL_INDICE", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("VALOR");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("AGRUP");
                        }
                    });
                }
            });
            put("ELSE", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_ELSE");
                            add("CUERPO_INST");
                            add("}");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("INICIO", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("DECLARACION_FUNCION");
                            add("MODULO_PPAL");
                        }
                    });
                }
            });
            put("ELSE_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_ELSE");
                            add("CUERPO_FUNCION");
                            add("}");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("ELSE_LOOP_FUNC", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_ELSE");
                            add("CUERPO_LOOP_FUNC");
                            add("}");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("IF", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_IF");
                            add("CUERPO_INST");
                            add("}");
                            add("ELSEIF");
                        }
                    });
                }
            });
            put("DEFAULT_LOOP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_DEFAULT");
                            add("CUERPO_LOOP");
                            add("}");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("IF_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_IF");
                            add("CUERPO_FUNCION");
                            add("}");
                            add("ELSEIF_FUNCION");
                        }
                    });
                }
            });
            put("R2", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("ASIGNACION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("INICIO_SWITCH", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("switch");
                            add("$");
                            add("identificador");
                            add("INDICE");
                            add("{");
                        }
                    });
                }
            });
            put("ARGS_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("{");
                            add("identificador");
                            add("}");
                            add("ARGS_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("FOR", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_FOR");
                            add("CUERPO_LOOP");
                            add("}");
                        }
                    });
                }
            });
            put("DEFAULT_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_DEFAULT");
                            add("CUERPO_FUNCION");
                            add("}");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("OP_UNARIO", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("-");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("!");
                        }
                    });
                }
            });
            put("CASE", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_CASE");
                            add("CUERPO_INST");
                            add("}");
                            add("CASE2");
                        }
                    });
                }
            });
            put("RETURN_LOOP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("return");
                            add("R2");
                            add(";");
                            add("CUERPO_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("INDICE", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("(");
                            add("VAL_INDICE");
                            add(")");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("SWITCH_LOOP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_SWITCH");
                            add("CASE_LOOP");
                            add("}");
                        }
                    });
                }
            });
            put("AGRUP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("[");
                            add("AUX_AGRUP");
                        }
                    });
                }
            });
            put("AUX_AGRUP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("EXPR");
                            add("]");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("identificador");
                            add("PARAM_FUNC");
                            add("]");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("GETS");
                            add("]");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("array");
                            add("AUX_ARRAY");
                        }
                    });
                }
            });
            put("CASE_LOOP_FUNC", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_CASE");
                            add("CUERPO_LOOP_FUNC");
                            add("}");
                            add("CASE2_LOOP_FUNC");
                        }
                    });
                }
            });
            put("MODULO_PPAL", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("DECLARACION");
                            add("MODULO_PPAL");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("FOR");
                            add("MODULO_PPAL");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("GETS");
                            add(";");
                            add("MODULO_PPAL");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("IF");
                            add("MODULO_PPAL");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("PUTS");
                            add("MODULO_PPAL");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("WHILE");
                            add("MODULO_PPAL");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("SWITCH");
                            add("MODULO_PPAL");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("AGRUP");
                            add("MODULO_PPAL");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("SWITCH", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_SWITCH");
                            add("CASE");
                            add("}");
                        }
                    });
                }
            });
            put("CASE2_LOOP_FUNC", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_CASE");
                            add("CUERPO_LOOP_FUNC");
                            add("}");
                            add("CASE2_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("DEFAULT_LOOP_FUNC");
                        }
                    });
                }
            });
            put("AUX_ARRAY", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("size");
                            add("identificador");
                            add("]");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("exists");
                            add("identificador");
                            add("]");
                        }
                    });
                }
            });
            put("INICIO_ELSEIF", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("elseif");
                            add("{");
                            add("EXPRESION");
                            add("}");
                            add("then");
                            add("{");
                        }
                    });
                }
            });
            put("ASIG_FOR", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("valor_entero");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("$");
                            add("identificador");
                            add("INDICE");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("EXPR");
                        }
                    });
                }
            });
            put("CASE2_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_CASE");
                            add("CUERPO_FUNCION");
                            add("}");
                            add("CASE2_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("DEFAULT_FUNCION");
                        }
                    });
                }
            });
            put("TERM", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("$");
                            add("identificador");
                            add("INDICE");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("AGRUP");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("VALOR");
                        }
                    });
                }
            });
            put("CASE2", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_CASE");
                            add("CUERPO_INST");
                            add("}");
                            add("CASE2");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("DEFAULT");
                        }
                    });
                }
            });
            put("INICIO_WHILE", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("while");
                            add("{");
                            add("EXPRESION");
                            add("}");
                            add("{");
                        }
                    });
                }
            });
            put("ELSEIF_LOOP_FUNC", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_ELSEIF");
                            add("CUERPO_LOOP_FUNC");
                            add("}");
                            add("ELSE_LOOP_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ELSE_LOOP_FUNC");
                        }
                    });
                }
            });
            put("RETURN", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("return");
                            add("R2");
                            add(";");
                            add("CUERPO_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("OP_BINARIO", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add(">");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("<");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add(">=");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("<=");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("eq");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("==");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ne");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("!=");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("&&");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("||");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("+");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("-");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("*");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("/");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("%");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("**");
                        }
                    });
                }
            });
            put("EXPR", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("expr");
                            add("{");
                            add("EXPRESION");
                            add("}");
                        }
                    });
                }
            });
            put("SWITCH_LOOP_FUNC", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_SWITCH");
                            add("CASE_LOOP_FUNC");
                            add("}");
                        }
                    });
                }
            });
            put("CASE_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_CASE");
                            add("CUERPO_FUNCION");
                            add("}");
                            add("CASE2_FUNCION");
                        }
                    });
                }
            });
            put("PUTS", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("puts");
                            add("ASIGNACION");
                            add(";");
                        }
                    });
                }
            });
            put("DEFAULT_LOOP_FUNC", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_DEFAULT");
                            add("CUERPO_LOOP_FUNC");
                            add("}");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("ELSEIF_LOOP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_ELSEIF");
                            add("CUERPO_LOOP");
                            add("}");
                            add("ELSE_LOOP");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ELSE_LOOP");
                        }
                    });
                }
            });
            put("ELSE_LOOP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_ELSE");
                            add("CUERPO_LOOP");
                            add("}");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("DECLARACION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("set");
                            add("identificador");
                            add("INDICE");
                            add("ASIGNACION");
                            add(";");
                        }
                    });
                }
            });
            put("CUERPO_INST", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("DECLARACION");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("FOR");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("GETS");
                            add(";");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("IF");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("PUTS");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("WHILE");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("SWITCH");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("AGRUP");
                            add("CUERPO_INST");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("INICIO_DEFAULT", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("default");
                            add("{");
                        }
                    });
                }
            });
            put("CONTINUE", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("continue");
                            add(";");
                        }
                    });
                }
            });
            put("INICIO_IF", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("if");
                            add("{");
                            add("EXPRESION");
                            add("}");
                            add("then");
                            add("{");
                        }
                    });
                }
            });
            put("INCREMENTO", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("valor_entero");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("IF_LOOP_FUNC", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_IF");
                            add("CUERPO_LOOP_FUNC");
                            add("}");
                            add("ELSEIF_LOOP_FUNC");
                        }
                    });
                }
            });
            put("ELSEIF_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_ELSEIF");
                            add("CUERPO_FUNCION");
                            add("}");
                            add("ELSE_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ELSE_FUNCION");
                        }
                    });
                }
            });
            put("CUERPO_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("DECLARACION");
                            add("CUERPO_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("PUTS");
                            add("CUERPO_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("GETS");
                            add(";");
                            add("CUERPO_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("IF_FUNCION");
                            add("CUERPO_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("FOR_FUNCION");
                            add("CUERPO_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("WHILE_FUNCION");
                            add("CUERPO_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("SWITCH_FUNCION");
                            add("CUERPO_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("RETURN");
                            add("CUERPO_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("AGRUP");
                            add("CUERPO_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("AUX_PARAM", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("ASIGNACION");
                            add("}");
                            add("PARAM_FUNC");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("EXPR");
                            add("}");
                            add("PARAM_FUNC");
                        }
                    });
                }
            });
            put("WHILE", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_WHILE");
                            add("CUERPO_LOOP");
                            add("}");
                        }
                    });
                }
            });
            put("ASIGNACION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("VALOR");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("$");
                            add("identificador");
                            add("INDICE");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("AGRUP");
                        }
                    });
                }
            });
            put("GETS", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("gets");
                            add("stdin");
                        }
                    });
                }
            });
            put("DEFAULT", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_DEFAULT");
                            add("CUERPO_INST");
                            add("}");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("IF_LOOP", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("INICIO_IF");
                            add("CUERPO_LOOP");
                            add("}");
                            add("ELSEIF_LOOP");
                        }
                    });
                }
            });
            put("VALOR", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("valor_string");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("valor_entero");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("valor_double");
                        }
                    });
                }
            });
            put("DECLARACION_FUNCION", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("proc");
                            add("identificador");
                            add("{");
                            add("ARGS_FUNCION");
                            add("}");
                            add("{");
                            add("CUERPO_FUNCION");
                            add("}");
                            add("DECLARACION_FUNCION");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
            put("PARAM_FUNC", new ArrayList<List<String>>() {
                {
                    add(new LinkedList<String>() {
                        {
                            add("{");
                            add("AUX_PARAM");
                        }
                    });
                    add(new LinkedList<String>() {
                        {
                            add("ε");
                        }
                    });
                }
            });
        }
    };

    final static Map<String, List<Set<String>>> PREDICT = new HashMap<String, List<Set<String>>>() {
        {
            put("ELSEIF", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("elseif");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("$");
                            add("else");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("switch");
                        }
                    });
                }
            });
            put("CASE_LOOP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("case");
                        }
                    });
                }
            });
            put("CUERPO_LOOP_FUNC", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("break");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("continue");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("set");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("gets");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("break");
                            add("continue");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("return");
                            add("switch");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("if");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("switch");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("for");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("while");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("[");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("break");
                            add("continue");
                            add("for");
                            add("[");
                            add("while");
                            add("}");
                            add("gets");
                            add("if");
                            add("return");
                            add("switch");
                        }
                    });
                }
            });
            put("INICIO_ELSE", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("else");
                        }
                    });
                }
            });
            put("EXPRESION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("valor_string");
                            add("valor_double");
                            add("$");
                            add("valor_entero");
                            add("[");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("!");
                            add("-");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("(");
                        }
                    });
                }
            });
            put("CUERPO_LOOP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("set");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("for");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("gets");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("if");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("while");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("switch");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("break");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("continue");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("[");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("}");
                        }
                    });
                }
            });
            put("SWITCH_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("switch");
                        }
                    });
                }
            });
            put("INICIO_CASE", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("case");
                        }
                    });
                }
            });
            put("AUX_EXPR", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("==");
                            add("&&");
                            add("||");
                            add("**");
                            add("<=");
                            add("%");
                            add("*");
                            add("+");
                            add("eq");
                            add("-");
                            add("/");
                            add("ne");
                            add("<");
                            add("!=");
                            add(">");
                            add(">=");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add(")");
                            add("}");
                        }
                    });
                }
            });
            put("FOR_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("for");
                        }
                    });
                }
            });
            put("INICIO_FOR", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("for");
                        }
                    });
                }
            });
            put("BREAK", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("break");
                        }
                    });
                }
            });
            put("WHILE_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("while");
                        }
                    });
                }
            });
            put("CASE2_LOOP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("case");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("default");
                            add("}");
                        }
                    });
                }
            });
            put("VAL_INDICE", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("valor_string");
                            add("valor_double");
                            add("valor_entero");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("[");
                        }
                    });
                }
            });
            put("ELSE", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("else");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("$");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("switch");
                        }
                    });
                }
            });
            put("INICIO", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("proc");
                            add("set");
                            add("$");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("switch");
                        }
                    });
                }
            });
            put("ELSE_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("else");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("return");
                            add("switch");
                        }
                    });
                }
            });
            put("ELSE_LOOP_FUNC", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("else");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("break");
                            add("continue");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("return");
                            add("switch");
                        }
                    });
                }
            });
            put("IF", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("if");
                        }
                    });
                }
            });
            put("DEFAULT_LOOP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("default");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("}");
                        }
                    });
                }
            });
            put("IF_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("if");
                        }
                    });
                }
            });
            put("R2", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("valor_string");
                            add("valor_double");
                            add("$");
                            add("valor_entero");
                            add("[");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add(";");
                        }
                    });
                }
            });
            put("INICIO_SWITCH", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("switch");
                        }
                    });
                }
            });
            put("ARGS_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("{");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("}");
                        }
                    });
                }
            });
            put("FOR", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("for");
                        }
                    });
                }
            });
            put("DEFAULT_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("default");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("}");
                        }
                    });
                }
            });
            put("OP_UNARIO", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("-");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("!");
                        }
                    });
                }
            });
            put("CASE", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("case");
                        }
                    });
                }
            });
            put("RETURN_LOOP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("return");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("break");
                            add("continue");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("return");
                            add("switch");
                        }
                    });
                }
            });
            put("INDICE", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("(");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("&&");
                            add("||");
                            add("**");
                            add("<=");
                            add("valor_string");
                            add("[");
                            add("==");
                            add("$");
                            add("%");
                            add(")");
                            add("*");
                            add("+");
                            add("eq");
                            add("-");
                            add("/");
                            add("valor_double");
                            add("valor_entero");
                            add("ne");
                            add("{");
                            add(";");
                            add("<");
                            add("!=");
                            add("}");
                            add(">");
                            add(">=");
                        }
                    });
                }
            });
            put("SWITCH_LOOP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("switch");
                        }
                    });
                }
            });
            put("AGRUP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("[");
                        }
                    });
                }
            });
            put("AUX_AGRUP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("expr");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("identificador");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("gets");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("array");
                        }
                    });
                }
            });
            put("CASE_LOOP_FUNC", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("case");
                        }
                    });
                }
            });
            put("MODULO_PPAL", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("set");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("for");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("gets");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("if");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("while");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("switch");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("[");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("$");
                        }
                    });
                }
            });
            put("SWITCH", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("switch");
                        }
                    });
                }
            });
            put("CASE2_LOOP_FUNC", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("case");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("default");
                            add("}");
                        }
                    });
                }
            });
            put("AUX_ARRAY", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("size");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("exists");
                        }
                    });
                }
            });
            put("INICIO_ELSEIF", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("elseif");
                        }
                    });
                }
            });
            put("ASIG_FOR", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("valor_entero");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("$");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("expr");
                        }
                    });
                }
            });
            put("CASE2_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("case");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("default");
                            add("}");
                        }
                    });
                }
            });
            put("TERM", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("$");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("[");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("valor_string");
                            add("valor_double");
                            add("valor_entero");
                        }
                    });
                }
            });
            put("CASE2", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("case");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("default");
                            add("}");
                        }
                    });
                }
            });
            put("INICIO_WHILE", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("while");
                        }
                    });
                }
            });
            put("ELSEIF_LOOP_FUNC", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("elseif");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("set");
                            add("break");
                            add("for");
                            add("while");
                            add("gets");
                            add("switch");
                            add("puts");
                            add("else");
                            add("continue");
                            add("[");
                            add("if");
                            add("}");
                            add("return");
                        }
                    });
                }
            });
            put("RETURN", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("return");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("return");
                            add("switch");
                        }
                    });
                }
            });
            put("OP_BINARIO", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add(">");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("<");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add(">=");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("<=");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("eq");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("==");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("ne");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("!=");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("&&");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("||");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("+");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("-");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("*");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("/");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("%");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("**");
                        }
                    });
                }
            });
            put("EXPR", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("expr");
                        }
                    });
                }
            });
            put("SWITCH_LOOP_FUNC", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("switch");
                        }
                    });
                }
            });
            put("CASE_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("case");
                        }
                    });
                }
            });
            put("PUTS", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("puts");
                        }
                    });
                }
            });
            put("DEFAULT_LOOP_FUNC", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("default");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("}");
                        }
                    });
                }
            });
            put("ELSEIF_LOOP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("elseif");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("break");
                            add("else");
                            add("continue");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("switch");
                        }
                    });
                }
            });
            put("ELSE_LOOP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("else");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("break");
                            add("continue");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("switch");
                        }
                    });
                }
            });
            put("DECLARACION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("set");
                        }
                    });
                }
            });
            put("CUERPO_INST", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("set");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("for");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("gets");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("if");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("while");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("switch");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("[");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("}");
                        }
                    });
                }
            });
            put("INICIO_DEFAULT", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("default");
                        }
                    });
                }
            });
            put("CONTINUE", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("continue");
                        }
                    });
                }
            });
            put("INICIO_IF", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("if");
                        }
                    });
                }
            });
            put("INCREMENTO", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("valor_entero");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("}");
                        }
                    });
                }
            });
            put("IF_LOOP_FUNC", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("if");
                        }
                    });
                }
            });
            put("ELSEIF_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("elseif");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("else");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("return");
                            add("switch");
                        }
                    });
                }
            });
            put("CUERPO_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("set");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("gets");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("if");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("for");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("while");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("switch");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("}");
                            add("return");
                            add("switch");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("[");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("for");
                            add("[");
                            add("while");
                            add("}");
                            add("gets");
                            add("if");
                            add("return");
                            add("switch");
                        }
                    });
                }
            });
            put("AUX_PARAM", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("valor_string");
                            add("valor_double");
                            add("$");
                            add("valor_entero");
                            add("[");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("expr");
                        }
                    });
                }
            });
            put("WHILE", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("while");
                        }
                    });
                }
            });
            put("ASIGNACION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("valor_string");
                            add("valor_double");
                            add("valor_entero");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("$");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("[");
                        }
                    });
                }
            });
            put("GETS", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("gets");
                        }
                    });
                }
            });
            put("DEFAULT", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("default");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("}");
                        }
                    });
                }
            });
            put("IF_LOOP", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("if");
                        }
                    });
                }
            });
            put("VALOR", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("valor_string");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("valor_entero");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("valor_double");
                        }
                    });
                }
            });
            put("DECLARACION_FUNCION", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("proc");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("puts");
                            add("set");
                            add("$");
                            add("for");
                            add("[");
                            add("while");
                            add("gets");
                            add("if");
                            add("switch");
                        }
                    });
                }
            });
            put("PARAM_FUNC", new ArrayList<Set<String>>() {
                {
                    add(new HashSet<String>() {
                        {
                            add("{");
                        }
                    });
                    add(new HashSet<String>() {
                        {
                            add("]");
                        }
                    });
                }
            });
        }
    };

    public static void main(String[] args) {
        
    }
}
