package test;


import util.CriaBanco;

/*
 * @author Saulo de Tarso
 * 
 * Essa classe é responsável por chamar outras classes,
 * fazendo uma inserção de forma automatizada.
 * É necesssário que se faça a criação do banco antes
 * de serem chamados as funções de inserção.
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
