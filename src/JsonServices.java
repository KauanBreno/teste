import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonService {

    public void salvarComoJson(List<Funcionario> funcionarios, String caminhoArquivo) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
            sb.append("  {\n");
            sb.append("    \"nome\": \"").append(escapeJson(f.getNome())).append("\",\n");
            sb.append("    \"valorHora\": ").append(String.format("%.2f", f.getValorHora())).append(",\n");
            sb.append("    \"horasTrabalhadas\": ").append(f.getHorasTrabalhadas()).append(",\n");
            sb.append("    \"salarioBruto\": ").append(String.format("%.2f", f.calcularSalarioBruto())).append(",\n");
            sb.append("    \"descontoINSS\": ").append(String.format("%.2f", f.calcularDescontoINSS())).append(",\n");
            sb.append("    \"salarioLiquido\": ").append(String.format("%.2f", f.getSalarioLiquido())).append("\n");
            sb.append("  }");
            if (i < funcionarios.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");

        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write(sb.toString());
            System.out.println("Arquivo salvo em: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo JSON: " + e.getMessage());
        }
    }

    // simples escape para aspas no nome (evita JSON inválido)
    private String escapeJson(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
