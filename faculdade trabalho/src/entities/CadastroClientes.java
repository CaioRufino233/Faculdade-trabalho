package entities;

import entities.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroClientes {
    // Atributos da classe CadastroClientes
    public List<Cliente> clientes = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    // Operação para criar um novo cliente
    public void criarCliente(String cpf, String nome, String dataNascimento, TipoCliente tipo, double valorEmprestimo) {
        try {
            Cliente cliente = new Cliente(cpf, nome, dataNascimento, tipo, valorEmprestimo);
            clientes.add(cliente);
        } catch (Exception e) {
            System.err.println("Erro ao criar cliente: " + e.getMessage());
        }
    }

    // Operação para ler um cliente pelo CPF
    public Cliente lerCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    // Função para listar todos os clientes
    public void listarTodosClientes() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void removerCliente(String cpf) {
        Cliente cliente = lerCliente(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public List<Cliente> buscarClientePorNome(String nome) {
        List<Cliente> clientesEncontrados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clientesEncontrados.add(cliente);
            }
        }
        return clientesEncontrados;
    }

    // Operação para buscar cliente por CPF
    public Cliente buscarClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    // Método para exibir clientes encontrados por nome
    public void exibirClientesEncontrados(List<Cliente> clientesEncontrados) {
        System.out.println("Clientes encontrados:");
        for (Cliente cliente : clientesEncontrados) {
            System.out.println(cliente);
        }
    }

    // Método para exibir cliente encontrado por CPF
    public void exibirClienteEncontrado(Cliente clienteEncontrado) {
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}