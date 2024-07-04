import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    private JTextField Cedula;
    private JButton ok;
    private JLabel Nombre;
    public JPanel mainPane;

    public form1() {
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024A";
                String user = "root";
                String password = "123456";
                try (Connection connection = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la BD");
                    System.out.print("\nIngrese el número de cédula: ");
                    String cedula = Cedula.getText();
                    String query = "SELECT * FROM estudiantes where cedula = '" + cedula + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()){
                        Nombre.setText(resultSet.getString("nombre")+" "+resultSet.getString("bimestreUno")+" "+resultSet.getString("bimestreDos"));

                    }

                }
                catch (SQLException e1){
                    System.out.println("El error es: "+ e1.getMessage());
                }
            }
        });
    }
}
