package ve.com.vr.rcvmovilc.model;

public class clsPaquete {
    private long id_pq;    // id paquete
    private String cd_pq;  // Código paquete
    private String ds_pq;  // Descripción paquete
    private String sv_gr;  // Servicios grua cantidad
    private String mt_cb;  // Monto cobertura


    public long getId_pq() {
        return id_pq;
    }

    public void setId_pq(long id_pq) {
        this.id_pq = id_pq;
    }

    public String getCd_pq() {
        return cd_pq;
    }

    public void setCd_pq(String cd_pq) {
        this.cd_pq = cd_pq;
    }

    public String getDs_pq() {
        return ds_pq;
    }

    public void setDs_pq(String ds_pq) {
        this.ds_pq = ds_pq;
    }

    public String getSv_gr() {
        return sv_gr;
    }

    public void setSv_gr(String sv_gr) {
        this.sv_gr = sv_gr;
    }

    public String getMt_cb() {
        return mt_cb;
    }

    public void setMt_cb(String mt_cb) {
        this.mt_cb = mt_cb;
    }
}
