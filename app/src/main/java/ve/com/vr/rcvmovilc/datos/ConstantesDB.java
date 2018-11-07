package ve.com.vr.rcvmovilc.datos;

public class ConstantesDB {
    //Informacion General
    public static final String DB_NAME = "db_venresp_movil.db";
    public static final int DB_VERSION = 1;

    //DECLARACION DE ESTRUCTURAS DE TABLAS

    //TABLA CLIENTES
    public static final String TABLA_CLIENTES = "tbl_clientes";
    public static final String ID_CL_LC = "_idcl";
    public static final String ID_CL = "id_cl";
    public static final String TP_CL = "tp_cl";
    public static final String CD_CL = "cd_cl";
    public static final String NB_CL = "nb_cl";
    public static final String AP_CL = "ap_cl";
    public static final String RZ_CL = "rz_cl";
    public static final String SX_CL = "sx_cl";
    public static final String FC_CL = "fc_cl";
    public static final String EM_CL = "em_cl";
    public static final String PW_CL = "pw_cl";
    public static final String TF_CL = "tf_cl";
    public static final String DR_CL = "dr_cl";
    public static final String ES_CL = "es_cl";

    public static final String TABLA_CLIENTES_CREATE_SQL =
            "CREATE TABLE  " + TABLA_CLIENTES + "(" +
                    ID_CL_LC + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ID_CL + " INTEGER NOT NULL," +
                    TP_CL + " TEXT NOT NULL," +
                    CD_CL + " TEXT NOT NULL," +
                    NB_CL + " TEXT," +
                    AP_CL + " TEXT," +
                    RZ_CL + " TEXT," +
                    SX_CL + " TEXT," +
                    FC_CL + " TEXT," +
                    EM_CL + " TEXT NOT NULL," +
                    PW_CL + " TEXT NOT NULL," +
                    TF_CL + " TEXT," +
                    DR_CL + " TEXT," +
                    ES_CL + " TEXT);";

    public static final String TABLA_CLIENTES_DROP_SQL =
            "DROP TABLE IF EXISTS " + TABLA_CLIENTES  + ";";

    //TABLA VEHICULOS
    public static final String TABLA_VEHICULOS  = "tbl_vehiculos";
    public static final String ID_VH_LC = "_idvh";
    public static final String ID_VH = "id_vh";
    public static final String PL_VH = "pl_vh";
    public static final String SE_CA_VH = "se_ca_vh";
    public static final String AN_VH = "an_vh";
    public static final String PE_VH = "pe_vh";
    public static final String NR_PU_VH = "nr_pu_vh";
    public static final String CL_VH = "cl_vh";
    public static final String DS_MC = "ds_mc";
    public static final String DS_MD = "ds_md";
    public static final String DS_TP_VH = "ds_tp_vh";
    public static final String DS_CL_VH = "ds_cl_vh";
    public static final String DS_USO = "ds_uso";
    public static final String ES_VH = "es_vh";

    public static final String TABLA_VEHICULOS_CREATE_SQL =
            "CREATE TABLE  " + TABLA_VEHICULOS + "(" +
                    ID_VH_LC + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ID_VH + " INTEGER NOT NULL," +
                    PL_VH + " TEXT NOT NULL," +
                    SE_CA_VH + " TEXT NOT NULL," +
                    AN_VH + " TEXT," +
                    PE_VH + " TEXT," +
                    NR_PU_VH + " TEXT," +
                    CL_VH + " TEXT," +
                    DS_MC + " TEXT," +
                    DS_MD + " TEXT NOT NULL," +
                    DS_TP_VH + " TEXT NOT NULL," +
                    DS_CL_VH + " TEXT," +
                    DS_USO + " TEXT," +
                    ES_VH + " TEXT);";

    public static final String TABLA_VEHICULOS_DROP_SQL =
            "DROP TABLE IF EXISTS " + TABLA_VEHICULOS  + ";";

    //TABLA CONTRATOS
    public static final String TABLA_CONTRATOS   = "tbl_contratos";
    public static final String ID_CO_LC = "_idco";
    public static final String ID_CO = "id_co";
    public static final String ID_CL_CO = "id_cl";
    public static final String ID_VH_CO = "id_vh";
    public static final String CD_CO = "cd_co";
    public static final String SR_CO = "sr_co";
    public static final String FC_IN_CO = "fc_in_co";
    public static final String FC_FI_CO = "fc_fi_co";
    public static final String DS_OF = "ds_of";
    public static final String DS_PQ = "ds_pq";
    public static final String MT_CB = "mt_cb";
    public static final String ES_CO = "es_co";

    public static final String TABLA_CONTRATOS_CREATE_SQL =
            "CREATE TABLE  " + TABLA_CONTRATOS + "(" +
                    ID_CO_LC + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ID_CO + " INTEGER NOT NULL," +
                    ID_CL_CO + " INTEGER NOT NULL," +
                    ID_VH_CO + " INTEGER NOT NULL," +
                    CD_CO + " TEXT NOT NULL," +
                    SR_CO + " TEXT NOT NULL," +
                    FC_IN_CO + " TEXT NOT NULL," +
                    FC_FI_CO + " TEXT NOT NULL," +
                    DS_OF + " TEXT NOT NULL," +
                    DS_PQ + " TEXT NOT NULL," +
                    MT_CB + " INTEGER NOT NULL," +
                    ES_CO + " TEXT NOT NULL);";

    public static final String TABLA_CONTRATOS_DROP_SQL =
            "DROP TABLE IF EXISTS " + TABLA_CONTRATOS  + ";";

    //TABLA CONFIGURACION
    public static final String TABLA_CONFIGURACIONES   = "tbl_configuraciones";
    public static final String ID_CF_LC = "_idcf";
    public static final String CD_CF = "cd_cf";
    public static final String DS_CF = "ds_cf";
    public static final String VL_CF = "vl_cf";
    public static final String ES_CF = "es_cf";

    public static final String TABLA_CONFIGURACIONES_CREATE_SQL =
            "CREATE TABLE  " + TABLA_CONFIGURACIONES + "(" +
                    ID_CF_LC + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    CD_CF + " TEXT NOT NULL," +
                    DS_CF + " TEXT NOT NULL," +
                    VL_CF + " TEXT NOT NULL," +
                    ES_CF + " TEXT NOT NULL);";

    public static final String TABLA_CONFIGURACIONES_DROP_SQL =
            "DROP TABLE IF EXISTS " + TABLA_CONFIGURACIONES + ";";


}



