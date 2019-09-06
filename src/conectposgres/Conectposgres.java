
package conectposgres;

import java.sql.*;
public class Conectposgres {

    
    public static void main(String[] args) {
       String url = "jdbc:postgresql://localhost:5432/postgres";
       String usuario = "postgres";
       String contraseña = "posgres";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            java.sql.Statement st = conexion.createStatement();
            String sql 
                    = "SELECT gla_id, gla_nombre, gla_apellido FROM gladiadores";
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
            String id = result.getString("gla_id");
            String nombre = result.getString("gla_nombre");
            String apellido = result.getString("gla_apellido");
                System.out.print("ID: " + id + "NOMBRE: " + nombre + "APELLIDO: " + apellido  );
                
            }
            result.close();
            st.close();
            conexion.close();
        } catch (Exception e) {
            System.out.print("ERROR EN LA CONEXION" + e.getMessage());
        }
    }
    
}
