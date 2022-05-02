package avl;

import javax.swing.JFrame;

import core.InputReader;

public class AVLInterface {
	
	private ArvoreAVL arvore;
	private ArvoreAVLRender vizualizadorArvore;
	
	public AVLInterface() {
		// inicializa a parte de renderização do graph
		arvore = new ArvoreAVL();
		vizualizadorArvore = new ArvoreAVLRender(arvore.getRaiz());
		JFrame frame = vizualizadorArvore;
		frame.setSize(ArvoreAVLRender.CANVAS_WIDTH, ArvoreAVLRender.CANVAS_HEIGHT);
		vizualizadorArvore.setVisible(true);
	}
	
	/*
	 * exibe uma mensagem de ajuda 
	 */
	
	public void help() {
		System.out.println("Comandos");
		System.out.println("I [chave] - incluir um nodo");
		System.out.println("R [chave] - remover um nodo");
		System.out.println("B [chave] - buscar um nodo");
		System.out.println("E [chave] - imprime os encaminhamentos da arvore");
		System.out.println("X - Sair do programa");
	}
	
	/*
	 * aceita o menu de operações 
	 */
	
	public void aceitar() {
		help();
		boolean running = true;
		while(running) {
			String line = InputReader.readLineWithMessage("\nComando >> ");
			
			if(line.toUpperCase().equals("X")) {
				//encera a vizualização
				vizualizadorArvore.dispose();
				break;
			}else if(line.toUpperCase().equals("E")) {
				//imprime os caminhos da arvore
				System.out.println("Pre-ordem...");
				arvore.imprimirPreOrdem();
				System.out.println("Pos-ordem...");
				arvore.imprimirPosOrdem();
				System.out.println("Em-ordem...");
				arvore.imprimirEmOrdem();
				continue;
			}
			//Validando a quantidade de paramentos inseridos
			String[] args = line.split(" ");
			if(args.length != 2) {
				System.out.println("Numero de argumentos invalido");
				continue;
			}
			//Validando se a chave for um inteiro
			int chave;
			try {
				chave = Integer.parseInt(args[1]);
			}catch(NumberFormatException e){
				System.out.println("Chave Invalida");
				continue;
			}
			//Avalia a operação a selecionada
			String op = args[0].toUpperCase();
			switch(op) {
				case "I": //Inserção
					arvore.inserir(chave);
					vizualizadorArvore.update(arvore.getRaiz());
					break;
				case "R": // Remoção
					arvore.deletar(chave);
					vizualizadorArvore.update(arvore.getRaiz());
					break;
				case "B": // Busca
					if(arvore.procurar(chave) != null) {
						System.out.println("Chave encontrada");
					}else {
						System.out.println("Chave não encontrada");
					}
					break;
				default:
					System.out.println("Operação invalida!!");
					break;
			}
			
		}
	}

}
