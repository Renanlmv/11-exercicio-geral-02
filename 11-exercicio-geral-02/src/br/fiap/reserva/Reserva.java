package br.fiap.reserva;

import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.desconto.Desconto;

public class Reserva {

    private Cliente cliente;
    private Assento assento;
    private double valorOriginal;
    private double valorFinal;

    public Reserva (Cliente cliente, Assento assento, double valorOriginal) {
        this.cliente = cliente;
        this.assento = assento;
        this.valorOriginal = valorOriginal;
        calcularDesconto();
    }

    private void calcularDesconto() {
        // instanceof vê se a classe extende ou implementa
        if (cliente instanceof Desconto) {
            // casting da variável pertencente à superclasse Cliente
            // para a interface Desconto
            valorFinal = ((Desconto) cliente).aplicarDesconto(valorOriginal);
        }
    }

    public String toString() {
        String aux = "DADOS DA RESERVA\n";
        aux += "Cliente: " + cliente.getNome() + "\n";
        aux += "Assento: " + assento.getNumero();
        return aux;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }
}
