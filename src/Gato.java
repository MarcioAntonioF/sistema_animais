package sistema_animais;

public class Gato extends Animal {

    public String corPelo;

    @Override
    public String exibirInfo() {
        return "Gato - Nome: " + this.nome +
               ", Idade: " + this.idade +
               ", Cor do Pelo: " + this.corPelo;
    }
}
