package ve.com.vr.rcvmovilc.model;

import java.util.Date;

public class Contrato {
    private long id_co_lc;
    private long id_co;
    private long id_cl_co;
    private long id_vh_co;
    private String cd_co;
    private String sr_co;
    private Date fc_in_co;
    private Date fc_fi_co;
    private String ds_of;
    private String ds_pq;
    private double mt_cb;
    private String es_co;

    public Contrato() {
    }

    public Contrato(long id_co, long id_cl_co, long id_vh_co, String cd_co, String sr_co, Date fc_in_co, Date fc_fi_co, String ds_of, String ds_pq, double mt_cb, String es_co) {
        this.setId_co(id_co);
        this.setId_cl_co(id_cl_co);
        this.setId_vh_co (id_vh_co);
        this.setCd_co(cd_co);
        this.setSr_co( sr_co);
        this.setFc_in_co(fc_in_co);
        this.setFc_fi_co(fc_fi_co);
        this.setDs_of(ds_of);
        this.setDs_pq(ds_pq);
        this.setMt_cb(mt_cb);
        this.setEs_co(es_co);
    }

    public long getId_co_lc() {
        return id_co_lc;
    }

    public void setId_co_lc(long id_co_lc) {
        this.id_co_lc = id_co_lc;
    }

    public long getId_co() {
        return id_co;
    }

    public void setId_co(long id_co) {
        this.id_co = id_co;
    }

    public long getId_cl_co() {
        return id_cl_co;
    }

    public void setId_cl_co(long id_cl_co) {
        this.id_cl_co = id_cl_co;
    }

    public long getId_vh_co() {
        return id_vh_co;
    }

    public void setId_vh_co(long id_vh_co) {
        this.id_vh_co = id_vh_co;
    }

    public String getCd_co() {
        return cd_co;
    }

    public void setCd_co(String cd_co) {
        this.cd_co = cd_co;
    }

    public String getSr_co() {
        return sr_co;
    }

    public void setSr_co(String sr_co) {
        this.sr_co = sr_co;
    }

    public Date getFc_in_co() {
        return fc_in_co;
    }

    public void setFc_in_co(Date fc_in_co) {
        this.fc_in_co = fc_in_co;
    }

    public Date getFc_fi_co() {
        return fc_fi_co;
    }

    public void setFc_fi_co(Date fc_fi_co) {
        this.fc_fi_co = fc_fi_co;
    }

    public String getDs_of() {
        return ds_of;
    }

    public void setDs_of(String ds_of) {
        this.ds_of = ds_of;
    }

    public String getDs_pq() {
        return ds_pq;
    }

    public void setDs_pq(String ds_pq) {
        this.ds_pq = ds_pq;
    }

    public double getMt_cb() {
        return mt_cb;
    }

    public void setMt_cb(double mt_cb) {
        this.mt_cb = mt_cb;
    }

    public String getEs_co() {
        return es_co;
    }

    public void setEs_co(String es_co) {
        this.es_co = es_co;
    }

    @Override
    public String toString() {
        return  "Contrato{" +
                "id_co_lc=" + this.getId_co_lc() +
                ", id_co=" + this.getId_co() +
                ", id_cl_co='" + this.getId_cl_co() + '\'' +
                ", id_vh_co='" + this.getId_vh_co() + '\'' +
                ", cd_co='" + this.getCd_co() + '\'' +
                ", sr_co='" + this.getSr_co() + '\'' +
                ", fc_in_co='" + this.getFc_in_co() + '\'' +
                ", fc_fi_co='" + this.getFc_fi_co() + '\'' +
                ", ds_of='" + this.getDs_of() + '\'' +
                ", ds_pq='" + this.getDs_pq() + '\'' +
                ", mt_cb='" + this.getMt_cb() + '\'' +
                ", es_co='" + this.getEs_co() + '\'' +
                '}';
    }
}
