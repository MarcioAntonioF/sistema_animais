package sistema_animais;

import java.sql.*;
import java.util.ArrayList;

public class AnimalDAO {

   private Connection conectar() throws SQLException {
    String path = "animais.db";
    System.out.println("Tentando conectar com o banco: " + new java.io.File(path).getAbsolutePath());
    Connection conn = DriverManager.getConnection("jdbc:sqlite:" + path);
    System.out.println("Conexão estabelecida!");
    return conn;
}


public void limparTabela() {
    String sql = "DELETE FROM animais"; // Comando SQL que apaga todos os registros

    try (Connection conn = conectar();
         Statement st = conn.createStatement()) {

        st.executeUpdate(sql); // Executa o comando
        System.out.println("Tabela de animais limpa com sucesso!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS animais (" +
                     "nome TEXT," +
                     "idade INTEGER," +
                     "tipo TEXT," +
                     "extra TEXT" +
                     ")";

        try (Connection conn = conectar();
             Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void salvar(Animal a) {

        String sql = "INSERT INTO animais VALUES (?,?,?,?)";

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.nome);
            ps.setInt(2, a.idade);

            if (a instanceof Cachorro) {
                ps.setString(3, "Cachorro");
                ps.setString(4, ((Cachorro)a).raca);
            } else {
                ps.setString(3, "Gato");
                ps.setString(4, ((Gato)a).corPelo);
            }

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> listar() {

        ArrayList<String> lista = new ArrayList<>();

        String sql = "SELECT * FROM animais";

        try (Connection conn = conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(
                    rs.getString("tipo") + " | " +
                    rs.getString("nome") + " | " +
                    rs.getInt("idade") + " anos | Extra: " +
                    rs.getString("extra")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
