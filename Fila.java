import java.util.Arrays;

public class FilaSeq<T> implements Fila<T> {
	private T[] itens;
	private int ini;
	private int fim;
	private int tamanho;

	public FilaSeq() {
		ini = 0;
		fim = -1;
		tamanho = 0;
		itens = (T[]) new Object[10];
	}

	public void enfileirar(T item) {
		if (cheia()) {
			System.out.println("A fila esta cheia nao foi possivel colocar " + item);
		} else {
			fim = (fim + 1) % itens.length;
			itens[fim] = item;
			++tamanho;
		}
	}

	public T desenfileirar() {
		T item = itens[ini];
		itens[ini] = null;
		ini = (ini + 1) % itens.length;
		tamanho--;
		return item;
	}

	public T primeiro() {
		return itens[ini];
	}

	public boolean vazia() {
		return tamanho == 0;
	}

	public boolean cheia() {
		boolean cheia = true;
		if (tamanho == itens.length) {
			return cheia;
		}
		return cheia = false;
	}

	public int tamanho() {
		return tamanho;
	}

	public void exibir() {
		System.out.println(Arrays.toString(itens));
	}

}
