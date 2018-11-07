package ve.com.vr.rcvmovilc.model;

public class clsVehiculo {
    private long      id_vh;
    private String    pl_vh;
    private Integer   an_vh;
    private String    co_vh;
    private Integer   pe_vh;
    private String    sc_vh;
    private clsMarca  Marca;
    private clsModelo Modelo;
    private clsClase  Clase;
    private clsTipo   Tipo;


    public long getId_vh() {
        return id_vh;
    }

    public void setId_vh(long id_vh) {
        this.id_vh = id_vh;
    }

    public String getPl_vh() {
        return pl_vh;
    }

    public void setPl_vh(String pl_vh) {
        this.pl_vh = pl_vh;
    }

    public Integer getAn_vh() {
        return an_vh;
    }

    public void setAn_vh(Integer an_vh) {
        this.an_vh = an_vh;
    }

    public String getCo_vh() {
        return co_vh;
    }

    public void setCo_vh(String co_vh) {
        this.co_vh = co_vh;
    }

    public Integer getPe_vh() {
        return pe_vh;
    }

    public void setPe_vh(Integer pe_vh) {
        this.pe_vh = pe_vh;
    }

    public String getSc_vh() {
        return sc_vh;
    }

    public void setSc_vh(String sc_vh) {
        this.sc_vh = sc_vh;
    }

    public clsMarca getMarca() {
        return Marca;
    }

    public void setMarca(clsMarca marca) {
        Marca = marca;
    }

    public clsModelo getModelo() {
        return Modelo;
    }

    public void setModelo(clsModelo modelo) {
        Modelo = modelo;
    }

    public clsClase getClase() {
        return Clase;
    }

    public void setClase(clsClase clase) {
        Clase = clase;
    }

    public clsTipo getTipo() {
        return Tipo;
    }

    public void setTipo(clsTipo tipo) {
        Tipo = tipo;
    }
}
