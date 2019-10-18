import java.util.Scanner;

public class Estacionamento {
	public static void main(String[] args) {
		// Fila de entrada e duas garagens.
		Fila<String> fe = new Fila<>();
		Pilha<String> g1 = new Pilha<>();
		Pilha<String> g2 = new Pilha<>();

		Scanner sc = new Scanner(System.in);
		while (true) {
			String[] solicitacao = sc.nextLine().split(" ");
			if (solicitacao[0].equals("FIM"))
				break;
			else if (solicitacao[0].equals("ESTACIONA")) {
				// Tirar primeiro carro da FE.
				String carro = fe.desenfileirar();
				// Estaciona em G1.
				g1.empilhar(carro);
				// Exibe mensagem.
				System.out.printf("%s: FE -> G1\n", carro);
			} else if (solicitacao[0].equals("ENTRA")) {
				// Chegou um carro. Entra na fila de entrada.
				fe.enfileirar(solicitacao[1]);
			} else if (solicitacao[0].equals("SAI")) {
				// Um carro é solicitado.
				String carro = solicitacao[1];

				// Remove carros bloqueando o carro em G1.
				String carro2 = g1.desempilhar();
				while (!carro2.equals(carro)) {
					g2.empilhar(carro2);
					System.out.printf("%s: G1 -> G2\n", carro2);
					carro2 = g1.desempilhar();
				}

				// Carro sairá agora.
				System.out.printf("%s: G1 -> SAIDA\n", carro);

				// Manobra todos os carros de G2 para G1.
				while (!g2.vazia()) {
					// Retira carro de G2.
					String carro3 = g2.desempilhar();
					// Estaciona em G1.
					g1.empilhar(carro3);
					// Exibe mensagem.
					System.out.printf("%s: G2 -> G1\n", carro3);
				}
			}
		}
	}
}
