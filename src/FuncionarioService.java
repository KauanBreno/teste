import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }
}
