import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FuncionarioService service = new FuncionarioService();
        JsonService jsonService = new JsonService();

        System.out.println("=== Sistema de Cadastro de Funcionários (sem CPF) ===");

        while (true) {
            System.out.println("\n1 - Cadastrar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Salvar em JSON");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Valor por hora: ");
                    double valorHora = sc.nextDouble();
                    System.out.print("Horas trabalhadas: ");
                    int horas = sc.nextInt();
                    sc.nextLine();

                    Funcionario f = new Funcionario(nome, valorHora, horas);
                    service.cadastrarFuncionario(f);

                    System.out.printf("Salário bruto: R$ %.2f%n", f.calcularSalarioBruto());
                    System.out.printf("Desconto INSS: R$ %.2f%n", f.calcularDescontoINSS());
                    System.out.printf("Salário líquido: R$ %.2f%n", f.getSalarioLiquido());

                    // Salva a lista atualizada de funcionários no JSON automaticamente
                    jsonService.salvarComoJson(service.listarFuncionarios(), "funcionarios.json");
                }

                case 2 -> {
                    System.out.println("\nFuncionários cadastrados:");
                    for (Funcionario f : service.listarFuncionarios()) {
                        System.out.println(f);
                    }
                }

                case 3 -> {
                    jsonService.salvarComoJson(service.listarFuncionarios(), "funcionarios.json");
                }

                case 0 -> {
                    System.out.println("Encerrando...");
                    sc.close();
                    return;
                }

                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
