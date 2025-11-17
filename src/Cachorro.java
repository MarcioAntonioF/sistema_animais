package sistema_animais;

public class Cachorro extends Animal {

    public String raca;

    @Override
    public String exibirInfo() {
        return "Cachorro - Nome: " + this.nome +
               ", Idade: " + this.idade +
               ", Raça: " + this.raca;
    }
}
