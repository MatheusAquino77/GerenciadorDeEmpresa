import entity.Desenvolvedor;
import entity.Estagiario;
import entity.Funcionario;
import entity.Gerente;
import service.SistemaFolhaPagamento;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

        int opcao = 0;


        while (opcao != 7) {
            System.out.println("\n--- MENU DO SISTEMA ---");
            System.out.println("1. Cadastrar novo funcionario");
            System.out.println("2. Listar funcionario cadastrados");
            System.out.println("3. Buscar funcionario por matrícula");
            System.out.println("4. Editar informações do funcionario");
            System.out.println("5. Remover funcionario");
            System.out.println("6. Mostrar folhar salarial da empresa");
            System.out.println("7. Encerrar");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scan.nextInt();
            }catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("\nEntrada invalida, Tente entra com as opções selecionadas");
                continue;

            }
            try {
                switch (opcao) {

                        case 1:
                            scan.nextLine();
                            System.out.print("Nome: ");
                            String nome = scan.nextLine();

                            System.out.print("Matricula: ");

                            int matricula = scan.nextInt();

                            System.out.print("SalarioBase: ");
                            double salarioBase = scan.nextDouble();
                            scan.nextLine();

                            System.out.println("Cargo: ");
                            System.out.println("1. Gerente");
                            System.out.println("2. Desenvolvedor");
                            System.out.println("3. Estagiário");
                            System.out.print("Escolha uma opção: ");
                            int cargo = scan.nextInt();

                            if (cargo == 1) {

                                Funcionario gerente = new Gerente(nome, matricula, salarioBase);
                                boolean cadastrado = SistemaFolhaPagamento.cadastrarFuncionario(listaFuncionario, gerente);
                                if (cadastrado) {
                                    System.out.println("\nGerente cadastrado com sucesso!");
                                } else {
                                    System.out.println("Erro ao cadastrar: matrícula existente ou dados inválidos.");
                                }

                            }
                            if (cargo == 2) {
                                Funcionario desenvolvedor = new Desenvolvedor(nome, matricula, salarioBase);
                                boolean cadastrado = SistemaFolhaPagamento.cadastrarFuncionario(listaFuncionario, desenvolvedor);
                                if (cadastrado) {
                                    System.out.println("\nDesenvolvedor cadastrado com sucesso!");
                                } else {
                                    System.out.println("Erro ao cadastrar: matrícula existente ou email inválido.");
                                }
                                break;
                            }
                            if (cargo == 3) {
                                Funcionario estagiario = new Estagiario(nome, matricula, salarioBase);
                                boolean cadastrado = SistemaFolhaPagamento.cadastrarFuncionario(listaFuncionario, estagiario);
                                if (cadastrado) {
                                    System.out.println("\nEstagiario cadastrado com sucesso!");
                                } else {
                                    System.out.println("Erro ao cadastrar: matrícula existente ou email inválido.");
                                }
                            }
                            break;

                        case 2:
                            ArrayList<Funcionario> funcionarios = SistemaFolhaPagamento.listarFuncionarios(listaFuncionario);
                            if (funcionarios.isEmpty()) {
                                System.out.println("Nenhum funcionario cadastrado.");
                            } else {
                                System.out.println("\n--- Funcionarios Cadastrados ---");
                                for (Funcionario a : funcionarios) {
                                    System.out.println(a);
                                }
                            }
                            break;
                        case 3:
                            System.out.print("Informe a matrícula: ");
                            int matriculaBusca = scan.nextInt();
                            scan.nextLine();

                            Funcionario funcionarioEncontrado = SistemaFolhaPagamento.buscarPorMatricula(listaFuncionario, matriculaBusca);
                            if (funcionarioEncontrado != null) {
                                System.out.println("\nAluno encontrado:");
                                System.out.println(funcionarioEncontrado);
                            } else {
                                System.out.println("Aluno não encontrado.");
                            }
                            break;
                        case 4:
                            System.out.print("Informe a matrícula do funcionario a editar: ");
                            int matriculaEdit = scan.nextInt();
                            scan.nextLine();

                            System.out.println("O que deseja editar?");
                            System.out.println("1. Nome");
                            System.out.println("2. Salario");
                            int escolha = scan.nextInt();
                            scan.nextLine();

                            String novoNome = null;
                            double novoSalario = 0.0;

                            if (escolha == 1) {
                                System.out.print("Novo nome: ");
                                novoNome = scan.nextLine();
                            } else if (escolha == 2) {
                                System.out.print("Novo salario: ");
                                novoSalario = scan.nextDouble();
                            } else {
                                System.out.println("Opção inválida.");
                                break;
                            }

                            boolean editado = SistemaFolhaPagamento.editarSalOrName(listaFuncionario, matriculaEdit, novoNome, novoSalario);
                            System.out.println(editado ? "Informações atualizadas." : "Funcionario não encontrado.");
                            break;
                        case 5:
                            System.out.print("Informe a matrícula do aluno a remover: ");
                            int matriculaRemover = scan.nextInt();
                            scan.nextLine();

                            boolean removido = SistemaFolhaPagamento.excluirFuncionario(listaFuncionario, matriculaRemover);
                            System.out.println(removido ? "Funcionario removido com sucesso." : "Funcionario não encontrado.");
                            break;
                        case 6:
                            double folhaSalarial = SistemaFolhaPagamento.calcularFolhaSalario(listaFuncionario);
                            System.out.println("A Folha Salarial é: " + folhaSalarial);
                            break;
                        case 7:
                            System.out.println("Encerrando...");
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("\nEntrada invalida, Uso de letra no campo matricula ou no campo salario!");
            }

        }
    }
}
