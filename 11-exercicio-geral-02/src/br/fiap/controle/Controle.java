package br.fiap.controle;

import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.cliente.PessoaFisica;
import br.fiap.cliente.PessoaJuridica;
import br.fiap.reserva.Reserva;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

public class Controle {
    private static List<Cliente> listaCliente = new ArrayList<>();
    private static List<Assento> listaAssento = new ArrayList<>();
    private static List<Reserva> listaReserva = new ArrayList<>();

    static {
        listaCliente.add(new PessoaFisica("Renan","123","555869"));
        listaCliente.add(new PessoaJuridica("Fiapinho","234","555234"));
        listaCliente.add(new PessoaJuridica("Luri","345","555345"));
    }

    public void menu() {
        int opcao;

        while(true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));
                switch(opcao) {
                    case 1:
                        reservar();
                        break;
                    case 2:
                        pesquisar();
                        break;
                    case 3:
                        cancelar();
                        break;
                    case 4:
                        return;
                    default:
                        showMessageDialog(null, "Opção inválida");
                }
            }
            catch(NumberFormatException e) {
                showMessageDialog(null, "você deve digitar um número");
            }
        }
    }

    private void reservar() {

    }

    private void pesquisar() {
        String identificador;

        identificador = showInputDialog("CPF/CNPJ para busca:");
        for (Reserva reserva : listaReserva) {
            if (reserva.getCliente().getIdentificador().equals(identificador)) {
                // toString() está implícito
                showMessageDialog(null, reserva);
                return;
            }
        }
        showMessageDialog(null, "Reserva não encontrada!");
    }

    private void cancelar() {

    }



    private String gerarMenu() {
        String aux = "SISTEMA DE RESERVA DE PASSAGEM AÉREA\n";
        aux += "1. Reservar\n";
        aux += "2. Pesquisar reserva\n";
        aux += "3. Cancelar reserva\n";
        aux += "4. Finalizar";
        return aux;
    }
}
