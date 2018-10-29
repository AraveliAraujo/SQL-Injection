package controlador;

import dao.LogeoD;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.LogeoM;
import servicios.Funciones;
import servicios.SessionUtils;

@ManagedBean
@SessionScoped
public class LogeoC implements Serializable {

    LogeoM user = new LogeoM();
    private boolean btnAdd;
    private boolean edit;
    private boolean cerrar;

    public void iniciarSesion() throws Exception {
        LogeoD dao;
        try {
            dao = new LogeoD();
            String clave = Funciones.encriptar(user.getPsswEmple());
            user = dao.validar(user.getUserEmple(), clave);
            if (user == null) {     //si no existe...
                user = new LogeoM();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "Usuario/Contraseña incorrecto"));
                System.out.println(user.getDniEmple());
            } else {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", user);
                btnAddTram();
                editTram();
                cerrarTram();
                switch (user.getLevelEmple()) {
                    case 1:
                        FacesContext.getCurrentInstance().getExternalContext().redirect("./welcomePrimefaces.xhtml");
                        break;
                    case 2:
                        FacesContext.getCurrentInstance().getExternalContext().redirect("./welcomePrimefaces.xhtml");
                        break;
                    case 3:
                        FacesContext.getCurrentInstance().getExternalContext().redirect("./welcomePrimefaces.xhtml");
                        break;
                    default:    //Si no tiene privilegios niega el acceso
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "Usuario denegado"));
                        break;
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public void logout() throws Exception {
        try {
            HttpSession session = SessionUtils.getSession();
            session.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/TramiteDocumentarioOracle/faces/login.xhtml");
        } catch (IOException e) {
            throw e;
        }
    }

    public void btnAddTram() {
        if (user.getLevelEmple() == 1) {
            setBtnAdd(true);
        }
        if (user.getLevelEmple() == 2) {
            setBtnAdd(false);
        }
        if (user.getLevelEmple() == 3) {
            setBtnAdd(false);
        }
    }

    public void editTram() {
        if (user.getLevelEmple() == 1) {
            setEdit(false);
        }
        if (user.getLevelEmple() == 2) {
            setEdit(true);
        }
        if (user.getLevelEmple() == 3) {
            setEdit(false);
        }
    }

    public void cerrarTram() {
        if (user.getLevelEmple() == 1) {
            setCerrar(true);
        }
        if (user.getLevelEmple() == 2) {
            setCerrar(false);
        }
        if (user.getLevelEmple() == 3) {
            setCerrar(true);
        }
    }

    public LogeoM getUser() {
        return user;
    }

    public void setUser(LogeoM user) {
        this.user = user;
    }

    public boolean isBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(boolean btnAdd) {
        this.btnAdd = btnAdd;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isCerrar() {
        return cerrar;
    }

    public void setCerrar(boolean cerrar) {
        this.cerrar = cerrar;
    }

}
