import java.util.Scanner;

public class Estacionamento {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fila fila = new Fila();
		Pilha pilha = new Pilha(3);
		Pilha pilha2 = new Pilha(3);
		int contador = -1;
		int cont = -1;
		while (true) {
			String[] solicitacao = sc.nextLine().split(" ");
			if (solicitacao[0].equals("FIM"))
				break;
			else if (solicitacao[0].equals("ESTACIONA")) {
				contador = contador + 1;
				System.out.println(fila.itens[contador] + ": FE -> G1");
				pilha.empilha(fila.desenfileirar());
				
			} else if (solicitacao[0].equals("ENTRA")) {
				fila.enfileirar(solicitacao[1]);
			} else if (solicitacao[0].equals("SAI")) {
				for(int i = pilha.topo; i >= 0; i--)
				{
					if(pilha.vet[i].equals(solicitacao[1]))
					{
						pilha.desempilha();
					}
					else
					{
						System.out.println(pilha.desempilhar()+ ": G1 -> G2");
						pilha2.empilha(pilha.desempilha());
					}
				}
				for(int i = pilha2.topo;  i >= 0 ; i--)
				{
					System.out.println(pilha2.desempilhar()+ ": G2 -> G1");
					pilha.empilha(pilha2.desempilha());
				}
					pilha.mostrar();
			}
		}
	}
}
