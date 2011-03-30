package test;


import util.CriaBanco;

/*
 * @author Saulo de Tarso
 * 
 * Essa classe � respons�vel por chamar outras classes,
 * fazendo uma inser��o de forma automatizada.
 * � necesss�rio que se fa�a a cria��o do banco antes
 * de serem chamados as fun��es de inser��o.
 */

public class AllInserts {
	public static void main(String[] args) {
		CriaBanco.main(args);
		InsereGerente.main(args);
		InsereDesenvolvedor.main(args);
		InsereProjeto.main(args);
		InsereEstorias.main(args);
		InsereTarefas.main(args);
		InsereSprint.main(args);
		InsereReuniao.main(args);
	}
}
