public class Funcionario {
    private String nome;
    private double valorHora;
    private int horasTrabalhadas;

    public Funcionario(String nome, double valorHora, int horasTrabalhadas) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double calcularSalarioBruto() {
        return valorHora * horasTrabalhadas;
    }

    public double calcularDescontoINSS() {
        double salario = calcularSalarioBruto();
        if (salario <= 1412.00) return salario * 0.075;
        else if (salario <= 2666.68) return salario * 0.09;
        else if (salario <= 4000.03) return salario * 0.12;
        else return salario * 0.14;
    }

    public double getSalarioLiquido() {
        return calcularSalarioBruto() - calcularDescontoINSS();
    }

    public String getNome() { return nome; }
    public double getValorHora() { return valorHora; }
    public int getHorasTrabalhadas() { return horasTrabalhadas; }

    @Override
    public String toString() {
        return String.format(
            "Nome: %s | ValorHora: R$ %.2f | Horas: %d | Bruto: R$ %.2f | INSS: R$ %.2f | Líquido: R$ %.2f",
            nome, valorHora, horasTrabalhadas, calcularSalarioBruto(), calcularDescontoINSS(), getSalarioLiquido()
        );
    }
}
