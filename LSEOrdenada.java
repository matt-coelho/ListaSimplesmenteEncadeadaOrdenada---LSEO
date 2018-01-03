package pkgLSEOrdenada;
import java.util.Scanner;
public class LSEOrdenada {
	private static class Lista{
		public int num;
		public Lista prox;
	}//fim private static class lista
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int op = 0;
		Lista inicio = null;
		Lista fim = null;
		Lista anterior;
		Lista aux;
		do{
			System.out.print("\tMenu\n=====================================\nLista Simplesmente Encadeada Ordenada\n=====================================\n1 - Inserir\n2 - Consultar toda lista\n3 - Remover da Lista\n4 - Esvaziar Lista\n5 - Endereço (hash) do elemento\n6 - Sair\nDigite sua opção: ");
			op = entrada.nextInt();
			if(op<1 || op> 6){
				System.out.println("Opção inxistente!");
			}//fim op <1>6
			//##############################################################################################
			if(op == 1){
				System.out.println("Digite o valor a ser inserido");
				Lista novo = new Lista();
				novo.num = entrada.nextInt();
				if(inicio == null){
					inicio = novo;
					fim = novo;
					novo.prox = null;
				}//fim if == null
				else{
					anterior = null;
					aux = inicio;
					while(aux != null && novo.num > aux.num){
						anterior = aux;
						aux = aux.prox;
					}//fim while aux != null && novo.num > aux.num
					if(anterior == null){
						novo.prox = inicio;
						inicio = novo;
					}// fim if anterior == null
					else if(aux == null){
						fim.prox = novo;
						fim = novo;
						fim.prox = null;
					}//fim else if aux == null
					else{
						anterior.prox = novo;
						novo.prox = aux;
					}//fim else>else if aux == null
				}//fim else>if inicio == null
				System.out.println("O número "+novo.num+" foi inserido com sucesso a lista!");
			}//fim op == 1
			//##############################################################################################
			if(op == 2){
				if(inicio == null){
					System.out.println("A lista está vazia!");
				}//fim if inicio == null
				else{
					aux = inicio;
					while(aux != null){
						System.out.print(aux.num+", ");
						aux = aux.prox;
					}//fim while aux != null
					System.out.println("\n");
				}//fim else inicio == null
			}//fim op == 2
			//##############################################################################################
			if(op == 3){
				if(inicio == null){
					System.out.println("A lista está vazia!");
				}//fim if inicio == null
				else{
					aux = inicio;
					anterior = null;
					int achou = 0;
					System.out.println("Digite o valor a ser removido");
					int numero = entrada.nextInt();
					while(aux != null){
						if(aux.num == numero){
							achou++;
							if(aux == inicio){
								inicio = aux.prox;
								aux = inicio;
							}//fim aux == numero
							else if(aux == fim){
								anterior.prox = null;
								fim = anterior;
								aux = null;
							}//fim else if aux == fim
							else{
								anterior.prox = aux.prox;
								aux = aux.prox;
							}//fim else>else if aux == fim
						}//fim if aux == inicio
						else{
							anterior = aux;
							aux = aux.prox;
						}//fim else>if aux.num== numero
					}//fim while aux != null
					if(achou == 0){
						System.out.println("Número não encontrado!");
					}//fim achou == 0
					else if(achou == 1){
						System.out.println("O número foi removido uma vez!");
					}//fim else if achou == 1
					else{
						System.out.println("O número foi removido "+achou+" vezes!");
					}//fim else>else if achou 1
				}//fim else inicio == null
			}//fim op == 3
			//##############################################################################################
			if(op == 4){
				if(inicio == null){
					System.out.println("A lista já está vazia!");
				}//fim if inicio == null
				else{
					inicio = null;
					System.out.println("A lista foi esvaziada!");
				}//fim else>if inicio == null
			}//fim op == 4
			//##############################################################################################
			if(op == 5){
				if(inicio == null){
					System.out.println("A lista está vazia!");
				}//fim if inicio == null
				else{
					System.out.println("Digite o valor");
					int numero = entrada.nextInt();
					aux = inicio;
					int cont = 0;
					while(aux != null){
						cont++;
						if(aux.num == numero){
							System.out.println("Valor encontrado na posição "+cont+" e seu hash é "+aux.hashCode());
							aux = aux.prox;
						}//fim if aux.num == numero
						else{
							aux = aux.prox;
						}
					}//fim while aux != null
				}//fim else>if inicio == null
			}//fim op == 5
			//##############################################################################################
		}while(op != 6);//fim do while op != 6
		entrada.close();
		inicio = null;
		System.err.println("===================\nFim do programa !!!\n===================");
	}//fim public void main 
}//fim class