grammar TCL_Grammar;
INICIO	:	DECLARACION_FUNCION MODULO_PPAL  ;
DECLARACION_FUNCION	:	'proc' 'identificador' '{' ARGS_FUNCION '}' '{' CUERPO_FUNCION '}' DECLARACION_FUNCION |  ;
ARGS_FUNCION	:	'{' 'identificador' '}' ARGS_FUNCION |  ;
CUERPO_FUNCION	:	DECLARACION CUERPO_FUNCION | PUTS CUERPO_FUNCION | GETS ';' CUERPO_FUNCION | IF_FUNCION CUERPO_FUNCION | FOR_FUNCION CUERPO_FUNCION | WHILE_FUNCION CUERPO_FUNCION | SWITCH_FUNCION CUERPO_FUNCION | RETURN CUERPO_FUNCION | AGRUP_INST ';' CUERPO_FUNCION |  ;
IF_FUNCION	:	INICIO_IF CUERPO_FUNCION '}' ELSEIF_FUNCION  ;
ELSEIF_FUNCION	:	INICIO_ELSEIF CUERPO_FUNCION '}' ELSEIF_FUNCION | ELSE_FUNCION  ;
ELSE_FUNCION	:	INICIO_ELSE CUERPO_FUNCION '}' |  ;
SWITCH_FUNCION	:	INICIO_SWITCH CASE_FUNCION '}'  ;
CASE_FUNCION	:	INICIO_CASE CUERPO_FUNCION '}' CASE2_FUNCION  ;
CASE2_FUNCION	:	INICIO_CASE CUERPO_FUNCION '}' CASE2_FUNCION | DEFAULT_FUNCION  ;
DEFAULT_FUNCION	:	INICIO_DEFAULT CUERPO_FUNCION '}' |  ;
FOR_FUNCION	:	INICIO_FOR CUERPO_LOOP_FUNC '}'  ;
WHILE_FUNCION	:	INICIO_WHILE CUERPO_LOOP_FUNC '}'  ;
CUERPO_LOOP_FUNC	:	BREAK CUERPO_LOOP_FUNC | CONTINUE CUERPO_LOOP_FUNC | DECLARACION CUERPO_LOOP_FUNC | GETS ';' CUERPO_LOOP_FUNC | PUTS CUERPO_LOOP_FUNC | RETURN_LOOP CUERPO_LOOP_FUNC | IF_LOOP_FUNC CUERPO_LOOP_FUNC | SWITCH_LOOP_FUNC CUERPO_LOOP_FUNC | FOR_FUNCION CUERPO_LOOP_FUNC | WHILE_FUNCION CUERPO_LOOP_FUNC | AGRUP_INST ';' CUERPO_LOOP_FUNC |  ;
IF_LOOP_FUNC	:	INICIO_IF CUERPO_LOOP_FUNC '}' ELSEIF_LOOP_FUNC  ;
ELSEIF_LOOP_FUNC	:	INICIO_ELSEIF CUERPO_LOOP_FUNC '}' ELSEIF_LOOP_FUNC | ELSE_LOOP_FUNC  ;
ELSE_LOOP_FUNC	:	INICIO_ELSE CUERPO_LOOP_FUNC '}' |  ;
SWITCH_LOOP_FUNC	:	INICIO_SWITCH CASE_LOOP_FUNC '}'  ;
CASE_LOOP_FUNC	:	INICIO_CASE CUERPO_LOOP_FUNC '}' CASE2_LOOP_FUNC  ;
CASE2_LOOP_FUNC	:	INICIO_CASE CUERPO_LOOP_FUNC '}' CASE2_LOOP_FUNC | DEFAULT_LOOP_FUNC  ;
DEFAULT_LOOP_FUNC	:	INICIO_DEFAULT CUERPO_LOOP_FUNC '}' |  ;
MODULO_PPAL	:	DECLARACION MODULO_PPAL | FOR MODULO_PPAL | GETS ';' MODULO_PPAL | IF MODULO_PPAL | PUTS MODULO_PPAL | WHILE MODULO_PPAL | SWITCH MODULO_PPAL | AGRUP_INST ';' MODULO_PPAL |  ;
DECLARACION	:	'set' 'identificador' INDICE_ASIG ASIGNACION ';'  ;
INDICE_ASIG	:	'(' VAL_INDICE ')' |  ;
GETS	:	'gets' 'stdin'  ;
PUTS	:	'puts' ASIGNACION ';'  ;
IF	:	INICIO_IF CUERPO_INST '}' ELSEIF  ;
ELSEIF	:	INICIO_ELSEIF CUERPO_INST '}' ELSEIF | ELSE  ;
ELSE	:	INICIO_ELSE CUERPO_INST '}' |  ;
SWITCH	:	INICIO_SWITCH CASE '}'  ;
CASE	:	INICIO_CASE CUERPO_INST '}' CASE2  ;
CASE2	:	INICIO_CASE CUERPO_INST '}' CASE2 | DEFAULT  ;
DEFAULT	:	INICIO_DEFAULT CUERPO_INST '}' |  ;
CUERPO_INST	:	DECLARACION CUERPO_INST | FOR CUERPO_INST | GETS ';' CUERPO_INST | IF CUERPO_INST | PUTS CUERPO_INST | WHILE CUERPO_INST | SWITCH CUERPO_INST | AGRUP_INST ';' CUERPO_INST |  ;
FOR	:	INICIO_FOR CUERPO_LOOP '}'  ;
WHILE	:	INICIO_WHILE CUERPO_LOOP '}'  ;
CUERPO_LOOP	:	DECLARACION CUERPO_LOOP | FOR CUERPO_LOOP | GETS ';' CUERPO_LOOP | IF_LOOP CUERPO_LOOP | PUTS CUERPO_LOOP | WHILE CUERPO_LOOP | SWITCH_LOOP CUERPO_LOOP | BREAK CUERPO_LOOP | CONTINUE CUERPO_LOOP | AGRUP_INST ';' CUERPO_LOOP |  ;
IF_LOOP	:	INICIO_IF CUERPO_LOOP '}' ELSEIF_LOOP  ;
ELSEIF_LOOP	:	INICIO_ELSEIF CUERPO_LOOP '}' ELSEIF_LOOP | ELSE_LOOP  ;
ELSE_LOOP	:	INICIO_ELSE CUERPO_LOOP '}' |  ;
SWITCH_LOOP	:	INICIO_SWITCH CASE_LOOP '}'  ;
CASE_LOOP	:	INICIO_CASE CUERPO_LOOP '}' CASE2_LOOP  ;
CASE2_LOOP	:	INICIO_CASE CUERPO_LOOP '}' CASE2_LOOP | DEFAULT_LOOP  ;
DEFAULT_LOOP	:	INICIO_DEFAULT CUERPO_LOOP '}' |  ;
AGRUP_INST	:	'[' AUX_AGRUP_INST  ;
AUX_AGRUP_INST	:	EXPR ']' | 'identificador' PARAM_FUNC ']' | GETS ']' | 'array' AUX_ARRAY  ;
AGRUP	:	'[' AUX_AGRUP  ;
AUX_AGRUP	:	EXPR ']' | 'identificador' PARAM_FUNC ']' | GETS ']' | 'array' AUX_ARRAY  ;
AUX_ARRAY	:	'size' 'identificador' ']' | 'exists' 'identificador' ']'  ;
PARAM_FUNC	:	'{' AUX_PARAM |  ;
AUX_PARAM	:	VALOR_PARAM '}' PARAM_FUNC | EXPR '}' PARAM_FUNC  ;
VALOR_PARAM	:	VALOR | '$' 'identificador' INDICE_PARAM | AGRUP  ;
INDICE_PARAM	:	'(' VAL_INDICE ')' |  ;
ASIGNACION	:	VALOR | '$' 'identificador' INDICE | AGRUP  ;
INDICE	:	'(' VAL_INDICE ')' |  ;
VAL_INDICE	:	VALOR | AGRUP  ;
VALOR	:	'valor_string' | 'valor_entero' | 'valor_double'  ;
INCREMENTO	:	'valor_entero' |  ;
BREAK	:	'break' ';'  ;
CONTINUE	:	'continue' ';'  ;
RETURN	:	'return' R2 ';'  ;
RETURN_LOOP	:	'return' R2 ';'  ;
R2	:	ASIGNACION |  ;
EXPR	:	'expr' '{' EXPRESION '}'  ;
ASIG_FOR	:	'valor_entero' | '$' 'identificador' INDICE_FOR | EXPR  ;
INDICE_FOR	:	'(' VAL_INDICE ')' |  ;
INDICE_SWITCH	:	'(' VAL_INDICE ')' |  ;
INICIO_IF	:	'if' '{' EXPRESION '}' 'then' '{'  ;
INICIO_ELSEIF	:	'elseif' '{' EXPRESION '}' 'then' '{'  ;
INICIO_ELSE	:	'else' '{'  ;
INICIO_FOR	:	'for' '{' 'set' 'identificador' ASIG_FOR '}' '{' EXPRESION '}' '{' 'incr' 'identificador' INCREMENTO '}' '{'  ;
INICIO_WHILE	:	'while' '{' EXPRESION '}' '{'  ;
INICIO_SWITCH	:	'switch' '$' 'identificador' INDICE_SWITCH '{'  ;
INICIO_CASE	:	'case' 'valor_entero' '{'  ;
INICIO_DEFAULT	:	'default' '{'  ;
EXPRESION	:	TERM AUX_EXPR | OP_UNARIO EXPRESION | '(' EXPRESION ')' AUX_EXPR  ;
AUX_EXPR	:	OP_BINARIO EXPRESION |  ;
TERM	:	'$' 'identificador' INDICE_TERM | AGRUP | VALOR  ;
INDICE_TERM	:	'(' VAL_INDICE ')' |  ;
OP_UNARIO	:	'-' | '!'  ;
OP_BINARIO	:	'>' | '<' | '>=' | '<=' | 'eq' | '==' | 'ne' | '!=' | '&&' | '||' | '+' | '-' | '*' | '/' | '%' | '**'  ;