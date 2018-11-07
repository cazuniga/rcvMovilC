package ve.com.vr.rcvmovilc.model;

import java.util.Date;

public class Cliente {
    private long   id_cl_lc;
    private long   id_cl;
    private String tp_cl;
    private String cd_cl;
    private String nb_cl;
    private String ap_cl;
    private String rz_cl;
    private String sx_cl;
    private Date fc_cl;
    private String em_cl;
    private String pw_cl;
    private String tf_cl;
    private String dr_cl;
    private String es_cl;

    public Cliente() {}

    public Cliente(long id_cl, String tp_cl, String cd_cl, String nb_cl, String ap_cl, String rz_cl, String sx_cl, Date fc_cl, String em_cl, String pw_cl, String tf_cl, String dr_cl, String es_cl) {
        this.setId_cl(id_cl);
        this.setTp_cl(tp_cl);
        this.setCd_cl(cd_cl);
        this.setNb_cl(nb_cl);
        this.setAp_cl(ap_cl);
        this.setRz_cl(rz_cl);
        this.setSx_cl(sx_cl);
        this.setFc_cl(fc_cl);
        this.setEm_cl(em_cl);
        this.setPw_cl(pw_cl);
        this.setTf_cl(tf_cl);
        this.setDr_cl(dr_cl);
        this.setEs_cl(es_cl);
    }

    public long getId_cl_lc() {
        return id_cl_lc;
    }

    public void setId_cl_lc(long id_cl_lc) {
        this.id_cl_lc = id_cl_lc;
    }

    public long getId_cl() {
        return id_cl;
    }

    public void setId_cl(long id_cl) {
        this.id_cl = id_cl;
    }

    public String getTp_cl() {
        return tp_cl;
    }

    public void setTp_cl(String tp_cl) {
        this.tp_cl = tp_cl;
    }

    public String getCd_cl() {
        return cd_cl;
    }

    public void setCd_cl(String cd_cl) {
        this.cd_cl = cd_cl;
    }

    public String getNb_cl() {
        return nb_cl;
    }

    public void setNb_cl(String nb_cl) {
        this.nb_cl = nb_cl;
    }

    public String getAp_cl() {
        return ap_cl;
    }

    public void setAp_cl(String ap_cl) {
        this.ap_cl = ap_cl;
    }

    public String getRz_cl() {
        return rz_cl;
    }

    public void setRz_cl(String rz_cl) {
        this.rz_cl = rz_cl;
    }

    public String getSx_cl() {
        return sx_cl;
    }

    public void setSx_cl(String sx_cl) {
        this.sx_cl = sx_cl;
    }

    public Date getFc_cl() {
        return fc_cl;
    }

    public void setFc_cl(Date fc_cl) {
        this.fc_cl = fc_cl;
    }

    public String getEm_cl() {
        return em_cl;
    }

    public void setEm_cl(String em_cl) {
        this.em_cl = em_cl;
    }

    public String getPw_cl() {
        return pw_cl;
    }

    public void setPw_cl(String pw_cl) {
        this.pw_cl = pw_cl;
    }

    public String getTf_cl() {
        return tf_cl;
    }

    public void setTf_cl(String tf_cl) {
        this.tf_cl = tf_cl;
    }

    public String getDr_cl() {
        return dr_cl;
    }

    public void setDr_cl(String dr_cl) {
        this.dr_cl = dr_cl;
    }

    public String getEs_cl() {
        return es_cl;
    }

    public void setEs_cl(String es_cl) {
        this.es_cl = es_cl;
    }


    public String getNombre() {
        String _nombre="";
        if(this.getTp_cl() == "N"){
            _nombre = nb_cl + " " + ap_cl ;
        }
        else {
            if (this.getTp_cl() == "J") {
                _nombre = rz_cl;
            }
        }

        return _nombre;
    }

    @Override
    public String toString() {
        return  "Cliente{" +
                "id_cl_lc=" + this.getId_cl_lc() +
                ", id_cl=" + this.getId_cl() +
                ", tp_cl='" + this.getTp_cl() + '\'' +
                ", cd_cl='" + this.getCd_cl() + '\'' +
                ", nb_cl='" + this.getNb_cl() + '\'' +
                ", ap_cl='" + this.getAp_cl() + '\'' +
                ", rz_cl='" + this.getRz_cl() + '\'' +
                ", sx_cl='" + this.getSx_cl() + '\'' +
                ", fc_cl='" + this.getFc_cl() + '\'' +
                ", em_cl='" + this.getEm_cl() + '\'' +
                ", pw_cl='" + this.getPw_cl() + '\'' +
                ", tl_cl='" + this.getTf_cl() + '\'' +
                ", dr_cl='" + this.getDr_cl() + '\'' +
                ", es_cl='" + this.getEs_cl() + '\'' +
                '}';
    }




}
