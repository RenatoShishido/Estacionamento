public interface FilaInterface<T>
{
	void enfileirar(T item);
	T desenfileirar();
	T primeiro();
	boolean vazia();
	int tamanho();
}