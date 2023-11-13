package application;// Método principal (main)

import entities.CadastroClientes;
import entities.Cliente;
import entities.TipoCliente;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CadastroClientes cadastro = new CadastroClientes();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            // Menu de opções atualizado
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Ver todos os clientes");
            System.out.println("2 - Adicionar um novo cliente");
            System.out.println("3 - Remover um cliente");
            System.out.println("4 - Buscar cliente por nome");
            System.out.println("5 - Buscar cliente por CPF");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastro.listarTodosClientes();
                    break;
                case 2:
                    // Adicionar um novo cliente
                    System.out.print("Informe o CPF do cliente: ");
                    String cpf = scanner.next();
                    System.out.print("Informe o nome do cliente: ");
                    String nome = scanner.next();
                    System.out.print("Informe a data de nascimento do cliente: ");
                    String dataNascimento = scanner.next();
                    System.out.print("Informe o tipo de cliente (IDOSO, EMPREENDEDOR, TRABALHADOR): ");
                    TipoCliente tipo = TipoCliente.valueOf(scanner.next().toUpperCase());
                    System.out.print("Informe o valor do empréstimo: ");
                    double valorEmprestimo = scanner.nextDouble();

                    cadastro.criarCliente(cpf, nome, dataNascimento, tipo, valorEmprestimo);
                    break;

                case 3:
                    // Remover um cliente
                    System.out.print("Informe o CPF do cliente a ser removido: ");
                    String cpfRemover = scanner.next();
                    cadastro.removerCliente(cpfRemover);
                    break;
                case 4:
                    // Buscar cliente por nome
                    System.out.print("Informe o nome do cliente a ser buscado: ");
                    String nomeBuscar = scanner.next();
                    List<Cliente> clientesPorNome = cadastro.buscarClientePorNome(nomeBuscar);
                    cadastro.exibirClientesEncontrados(clientesPorNome);
                    break;
                case 5:
                    // Buscar cliente por CPF
                    System.out.print("Informe o CPF do cliente a ser buscado: ");
                    String cpfBuscar = scanner.next();
                    Cliente clientePorCPF = cadastro.buscarClientePorCPF(cpfBuscar);
                    cadastro.exibirClienteEncontrado(clientePorCPF);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


}