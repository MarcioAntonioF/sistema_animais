package sistema_animais;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AnimalDAO dao = new AnimalDAO();
        dao.criarTabela();

        int op = -1;

        while (op != 0) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar Animal");
            System.out.println("2 - Consultar Animais");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {

                System.out.println("Tipo (1 - Cachorro | 2 - Gato): ");
                int tipo = sc.nextInt();
                sc.nextLine();

                Animal a;

                if (tipo == 1) {
                    a = new Cachorro();
                    System.out.print("Raça: ");
                    ((Cachorro)a).raca = sc.nextLine();

                } else {
                    a = new Gato();
                    System.out.print("Cor do Pelo: ");
                    ((Gato)a).corPelo = sc.nextLine();
                }

                System.out.print("Nome: ");
                a.nome = sc.nextLine();

                System.out.print("Idade: ");
                a.idade = sc.nextInt();
                sc.nextLine();

                dao.salvar(a);

                System.out.println("Animal cadastrado!");

            } else if (op == 2) {
                System.out.println("\n=== ANIMAIS CADASTRADOS ===");
                dao.listar().forEach(System.out::println);
            }
        }

        sc.close();
    }
}
