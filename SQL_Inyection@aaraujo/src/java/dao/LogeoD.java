package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.LogeoM;

public class LogeoD extends Dao {

    public LogeoM validar(String user, String pass) throws Exception {
        this.Conectar();
        ResultSet rs;
        LogeoM usu;
        try {
            String sql = "SELECT * FROM VW_LOGIN WHERE USEREMP LIKE '" + user + "' AND PSSEMP LIKE '" + pass + "'";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                usu = new LogeoM();
                usu.setCodEmple(rs.getString("CODEMP"));
                usu.setUserEmple(rs.getString("USEREMP"));
                usu.setLevelEmple(rs.getInt("LEVELEMP"));
                usu.setDniEmple(rs.getString("DNIEMP"));
                usu.setPsswEmple(rs.getString("PSSEMP"));
                usu.setIdentidad(rs.getString("IDENTIDAD"));
                switch (usu.getLevelEmple()) {
                    case 1:
                        usu.setTemplate("TemplateAdmin.xhtml");
                        break;
                    case 2:
                        usu.setTemplate("TemplateUser.xhtml");
                        break;
                    case 3:
                        usu.setTemplate("TemplateUser.xhtml");
                }
            } else {
                usu = null;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return usu;
    }

}
