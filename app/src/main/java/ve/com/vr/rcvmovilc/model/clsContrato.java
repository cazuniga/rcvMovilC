package ve.com.vr.rcvmovilc.model;

import java.util.Date;

public class clsContrato {
    private long id_co      ;
    private String cd_co    ;   // Codigo contrato
    private Date fc_co      ;   // fecha de inicio contrato
    private String fe_fi_co ;   // Fecha de Fin contrato
    private String Es_co    ;   // Estado contrato
    private String Sr_co    ;   // Serie Contrato
    private clsVehiculo vehiculo;
    private clsCliente cliente;
    private clsPaquete paquete;
    private clsOficina oficina;

    public long getId_co() {
        return id_co;
    }

    public void setId_co(long id_co) {
        this.id_co = id_co;
    }

    public String getCd_co() {
        return cd_co;
    }

    public void setCd_co(String cd_co) {
        this.cd_co = cd_co;
    }

    public Date getFc_co() {
        return fc_co;
    }

    public void setFc_co(Date fc_co) {
        this.fc_co = fc_co;
    }

    public String getFe_fi_co() {
        return fe_fi_co;
    }

    public void setFe_fi_co(String fe_fi_co) {
        this.fe_fi_co = fe_fi_co;
    }

    public String getEs_co() {
        return Es_co;
    }

    public void setEs_co(String es_co) {
        Es_co = es_co;
    }

    public String getSr_co() {
        return Sr_co;
    }

    public void setSr_co(String sr_co) {
        Sr_co = sr_co;
    }

    public clsVehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(clsVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public clsCliente getCliente() {
        return cliente;
    }

    public void setCliente(clsCliente cliente) {
        this.cliente = cliente;
    }

    public clsPaquete getPaquete() {
        return paquete;
    }

    public void setPaquete(clsPaquete paquete) {
        this.paquete = paquete;
    }

    public clsOficina getOficina() {
        return oficina;
    }

    public void setOficina(clsOficina oficina) {
        this.oficina = oficina;
    }
}
