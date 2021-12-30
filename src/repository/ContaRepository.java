package repository;

public interface ContaRepository {
    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, ContaRepository contaDestino);

    void imprimirExtrato();
}
