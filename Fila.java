public class Fila<T> implements FilaInterface<T>
{
	public T[] itens;
	public int ini;
	public int fim;
	public int tamanho;

	public Fila() {
		ini = 0;
		fim = -1;
		tamanho = 0;
		itens = (T[]) new Object[5];
	}

	public void enfileirar(T item) {
		fim = (fim + 1) % itens.length;
		itens[fim] = item;
		++tamanho;
	}
	public T desenfileirar() {
		T item = itens[ini];
		itens[ini] = null;
		ini = (ini + 1) % itens.length;
		--tamanho;
		return item;
	}

	public T primeiro() {
		return itens[ini];
	}
	public boolean vazia() {
		return tamanho == 0;
	}

	public int tamanho() {
		return tamanho;
	}

}