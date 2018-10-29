package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    private Connection cn;

    public void Conectar() throws Exception {       //Metodo con los datos de acceso
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "DEVIDA", "devida");
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public static void main(String[] args) throws Exception {
        Dao dao = new Dao();
        dao.Conectar();
        if (dao.getCn() != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("error");
        }
    }
}
