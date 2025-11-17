package sistema_animais;

public class Animal {

    public String nome;
    public Integer idade;

    public void envelhecer() {
        this.idade += 1;
    }

    public String exibirInfo() {
        return "Nome: " + this.nome + ", Idade: " + this.idade;
    }
}
