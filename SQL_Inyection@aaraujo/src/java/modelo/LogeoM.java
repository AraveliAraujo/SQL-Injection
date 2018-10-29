package modelo;

public class LogeoM {
    private String CodEmple, DniEmple, Template = "Template.xhtml",
            UserEmple, PsswEmple,
            Identidad;
    private int LevelEmple;

    public String getCodEmple() {
        return CodEmple;
    }

    public void setCodEmple(String CodEmple) {
        this.CodEmple = CodEmple;
    }

    public String getDniEmple() {
        return DniEmple;
    }

    public void setDniEmple(String DniEmple) {
        this.DniEmple = DniEmple;
    }

    public String getUserEmple() {
        return UserEmple;
    }

    public void setUserEmple(String UserEmple) {
        this.UserEmple = UserEmple;
    }

    public String getPsswEmple() {
        return PsswEmple;
    }

    public void setPsswEmple(String PsswEmple) {
        this.PsswEmple = PsswEmple;
    }


    public String getIdentidad() {
        return Identidad;
    }

    public void setIdentidad(String Identidad) {
        this.Identidad = Identidad;
    }

    public String getTemplate() {
        return Template;
    }

    public void setTemplate(String Template) {
        this.Template = Template;
    }

    public int getLevelEmple() {
        return LevelEmple;
    }

    public void setLevelEmple(int LevelEmple) {
        this.LevelEmple = LevelEmple;
    }

    
}
