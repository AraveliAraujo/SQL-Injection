package servicios;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@Named(value = "validacionesC")
@SessionScoped
public class ValidacionesC implements Serializable {

    public void negativo(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        String a = String.valueOf(arg2);
        if (Float.valueOf(a) < 0) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Valor Incorrecto"));
        }
    }

    public void produccion(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        String b = String.valueOf(arg2);
        if (Float.valueOf(b) < 0) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "No se puede cosechar más de lo que se tiene en verde"));
        }if (Float.valueOf(b) < 0) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Los valores no pueden ser negativos"));
        }
    }
    
    public void nulos(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        String c = String.valueOf(arg2);
        if (Float.valueOf(c) < 1) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Campo Obligatorio"));
        }
    }
    
}
