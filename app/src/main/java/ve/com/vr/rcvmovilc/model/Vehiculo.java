package ve.com.vr.rcvmovilc.model;

public class Vehiculo {
    private long   id_vh_lc;
    private long   id_vh;
    private String pl_vh;
    private String se_ca_vh;
    private int an_vh;
    private int pe_vh;
    private int nr_pu_vh;
    private String cl_vh;
    private String ds_mc;
    private String ds_md;
    private String ds_tp_vh;
    private String ds_cl_vh;
    private String ds_uso;
    private String es_vh;

    public Vehiculo(){}

    public Vehiculo(long id_vh, String pl_vh, String se_ca_vh, int an_vh, int pe_vh, int nr_pu_vh, String cl_vh, String ds_mc, String ds_md, String ds_tp_vh, String ds_cl_vh, String ds_uso, String es_vh) {
        this.setId_vh(id_vh);
        this.setPl_vh(pl_vh);
        this.setSe_ca_vh(se_ca_vh);
        this.setAn_vh(an_vh);
        this.setPe_vh ( pe_vh);
        this.setNr_pu_vh( nr_pu_vh);
        this.setCl_vh(cl_vh);
        this.setDs_mc(ds_mc);
        this.setDs_md(ds_md);
        this.setDs_tp_vh(ds_tp_vh);
        this.setDs_cl_vh(ds_cl_vh);
        this.setDs_uso(ds_uso);
        this.setEs_vh(es_vh);
    }

    public long getId_vh_lc() {
        return id_vh_lc;
    }

    public void setId_vh_lc(long id_vh_lc) {
        this.id_vh_lc = id_vh_lc;
    }

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

    public String getSe_ca_vh() {
        return se_ca_vh;
    }

    public void setSe_ca_vh(String se_ca_vh) {
        this.se_ca_vh = se_ca_vh;
    }

    public int getAn_vh() {
        return an_vh;
    }

    public void setAn_vh(int an_vh) {
        this.an_vh = an_vh;
    }

    public int getPe_vh() {
        return pe_vh;
    }

    public void setPe_vh(int pe_vh) {
        this.pe_vh = pe_vh;
    }

    public int getNr_pu_vh() {
        return nr_pu_vh;
    }

    public void setNr_pu_vh(int nr_pu_vh) {
        this.nr_pu_vh = nr_pu_vh;
    }

    public String getCl_vh() {
        return cl_vh;
    }

    public void setCl_vh(String cl_vh) {
        this.cl_vh = cl_vh;
    }

    public String getDs_mc() {
        return ds_mc;
    }

    public void setDs_mc(String ds_mc) {
        this.ds_mc = ds_mc;
    }

    public String getDs_md() {
        return ds_md;
    }

    public void setDs_md(String ds_md) {
        this.ds_md = ds_md;
    }

    public String getDs_tp_vh() {
        return ds_tp_vh;
    }

    public void setDs_tp_vh(String ds_tp_vh) {
        this.ds_tp_vh = ds_tp_vh;
    }

    public String getDs_cl_vh() {
        return ds_cl_vh;
    }

    public void setDs_cl_vh(String ds_cl_vh) {
        this.ds_cl_vh = ds_cl_vh;
    }

    public String getDs_uso() {
        return ds_uso;
    }

    public void setDs_uso(String ds_uso) {
        this.ds_uso = ds_uso;
    }
    public String getEs_vh() {
        return es_vh;
    }

    public void setEs_vh(String es_vh) {
        this.es_vh = es_vh;
    }


    @Override
    public String toString() {
        return  "Vehiculo{" +
                "id_vh_lc=" + this.getId_vh_lc() +
                ", id_vh=" + this.getId_vh() +
                ", pl_vh='" + this.getPl_vh() + '\'' +
                ", se_ca_vh='" + this.getSe_ca_vh() + '\'' +
                ", an_vh='" + this.getAn_vh() + '\'' +
                ", pe_vh='" + this.getPe_vh() + '\'' +
                ", nr_pu_vh='" + this.getNr_pu_vh() + '\'' +
                ", cl_vh='" + this.getCl_vh() + '\'' +
                ", ds_mc='" + this.getDs_mc() + '\'' +
                ", ds_md='" + this.getDs_md() + '\'' +
                ", ds_tp_vh='" + this.getDs_tp_vh() + '\'' +
                ", ds_cl_vh='" + this.getDs_cl_vh() + '\'' +
                ", ds_uso='" + this.getDs_uso() + '\'' +
                ", es_vh='" + this.getEs_vh() + '\'' +
                '}';
    }


}
