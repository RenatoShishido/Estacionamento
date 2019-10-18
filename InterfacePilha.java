public interface InterfacePilha<T> {
    void empilhar(T itens);

    T desempilhar();

    T topo();

    boolean vazia();

    int tamanho();
}
