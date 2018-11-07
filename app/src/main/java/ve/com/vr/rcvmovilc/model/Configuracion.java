package ve.com.vr.rcvmovilc.model;

public class Configuracion {
    private long   id_cf_lc;
    private String cd_cf;
    private String ds_cf;
    private String vl_cf;
    private String es_cf;

    public Configuracion() {}

    public Configuracion(String cd_cf, String ds_cf, String vl_cf, String es_cf) {
        this.cd_cf = cd_cf;
        this.ds_cf = ds_cf;
        this.vl_cf = vl_cf;
        this.es_cf = es_cf;
    }

    public long getId_cf_lc() {
        return id_cf_lc;
    }

    public void setId_cf_lc(long id_cf_lc) {
        this.id_cf_lc = id_cf_lc;
    }

    public String getCd_cf() {
        return cd_cf;
    }

    public void setCd_cf(String cd_cf) {
        this.cd_cf = cd_cf;
    }

    public String getDs_cf() {
        return ds_cf;
    }

    public void setDs_cf(String ds_cf) {
        this.ds_cf = ds_cf;
    }

    public String getVl_cf() {
        return vl_cf;
    }

    public void setVl_cf(String vl_cf) {
        this.vl_cf = vl_cf;
    }

    public String getEs_cf() {
        return es_cf;
    }

    public void setEs_cf(String es_cf) {
        this.es_cf = es_cf;
    }

    @Override
    public String toString() {
        return  "Configuracion{" +
                "id_cf_lc=" + this.getId_cf_lc() +
                ", cd_cf=" + this.getCd_cf() +
                ", ds_cf='" + this.getDs_cf() + '\'' +
                ", vl_cf='" + this.getVl_cf() + '\'' +
                ", es_cf='" + this.getEs_cf() + '\'' +
                '}';
    }

}
