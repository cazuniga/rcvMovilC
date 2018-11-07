package ve.com.vr.rcvmovilc.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import ve.com.vr.rcvmovilc.model.Cliente;


public class ClientesDB {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public ClientesDB(Context context) {
        dbHelper = new DBHelper(context);
    }

    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }

    private void openWriteableDB() {
        db = dbHelper.getWritableDatabase();
    }

    private void closeDB() {
        if(db!=null){
            db.close();
        }
    }

    // CRUD...
    public long insertCliente(Cliente cliente) {
        this.openWriteableDB();
        long rowID = db.insert(ConstantesDB.TABLA_CLIENTES, null, clienteMapperContentValues(cliente));
        this.closeDB();

        return rowID;
    }

    public void updateCliente(Cliente cliente) {
        this.openWriteableDB();
        String where = ConstantesDB.ID_CL   + "= ?";
        db.update(ConstantesDB.TABLA_CLIENTES, clienteMapperContentValues(cliente), where, new String[]{String.valueOf(cliente.getId_cl() )});
        db.close();
    }

    public void deleteCliente(long id) {
        this.openWriteableDB();
        String where = ConstantesDB.ID_CL + "= ?";
        db.delete(ConstantesDB.TABLA_CLIENTES, where, new String[]{String.valueOf(id)});
        this.closeDB();
    }

    public void deleteAllCliente() {
        this.openWriteableDB();
        db.execSQL("delete from "+ ConstantesDB.TABLA_CLIENTES);
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+ ConstantesDB.TABLA_CLIENTES + "'");
        this.closeDB();
    }



    public ArrayList<Cliente> loadClientes() {

        ArrayList<Cliente> list = new ArrayList<Cliente>();

        this.openReadableDB();
        String[] campos = new String[]{
                 ConstantesDB.ID_CL_LC
                ,ConstantesDB.ID_CL
                ,ConstantesDB.TP_CL
                ,ConstantesDB.CD_CL
                ,ConstantesDB.NB_CL
                ,ConstantesDB.AP_CL
                ,ConstantesDB.RZ_CL
                ,ConstantesDB.TF_CL
                ,ConstantesDB.DR_CL
        };
        Cursor c = db.query(ConstantesDB.TABLA_CLIENTES, campos , null, null, null, null, null);

        try {
            while (c.moveToNext()) {
                Cliente cliente = new Cliente();
                cliente.setId_cl_lc(c.getInt(0));
                cliente.setId_cl(c.getInt(1));
                cliente.setTp_cl(c.getString(2));
                cliente.setCd_cl(c.getString(3));
                cliente.setNb_cl(c.getString(4));
                cliente.setAp_cl(c.getString(5));
                cliente.setRz_cl(c.getString(6));
                cliente.setTf_cl(c.getString(7));
                cliente.setDr_cl(c.getString(8));

                list.add(cliente);
            }
        } finally {
            c.close();
        }
        this.closeDB();

        return list;
    }
    public Cliente buscarCliente(Long id) {
        Cliente cliente = new Cliente();
        this.openReadableDB();
        String where = ConstantesDB.ID_CL + "= ?";
        String[] whereArgs = {id.toString()};
        Cursor c = db.query(ConstantesDB.TABLA_CLIENTES, null, where, whereArgs, null, null, null);

        if( c != null || c.getCount() <=0) {
            c.moveToFirst();
            cliente.setId_cl_lc(c.getInt(0));
            cliente.setId_cl(c.getInt(1));
            cliente.setTp_cl(c.getString(2));
            cliente.setCd_cl(c.getString(3));
            cliente.setNb_cl(c.getString(4));
            cliente.setAp_cl(c.getString(5));
            cliente.setRz_cl(c.getString(6));
            cliente.setTf_cl(c.getString(7));
            cliente.setDr_cl(c.getString(8));
            c.close();
        }
        this.closeDB();
        return cliente;
    }

    private ContentValues clienteMapperContentValues(Cliente cliente) {
        ContentValues cv = new ContentValues();
        cv.put(ConstantesDB.ID_CL, cliente.getId_cl());
        cv.put(ConstantesDB.TP_CL, cliente.getTp_cl());
        cv.put(ConstantesDB.CD_CL , cliente.getCd_cl());
        cv.put(ConstantesDB.NB_CL , cliente.getNb_cl());
        cv.put(ConstantesDB.AP_CL , cliente.getAp_cl());
        cv.put(ConstantesDB.RZ_CL , cliente.getRz_cl());
        cv.put(ConstantesDB.SX_CL , cliente.getSx_cl());
        cv.put(ConstantesDB.FC_CL , cliente.getFc_cl().toString());
        cv.put(ConstantesDB.EM_CL , cliente.getEm_cl());
        cv.put(ConstantesDB.PW_CL , cliente.getPw_cl());
        cv.put(ConstantesDB.TF_CL , cliente.getTp_cl());
        cv.put(ConstantesDB.DR_CL , cliente.getDr_cl());
        cv.put(ConstantesDB.ES_CL , cliente.getEs_cl());

        return cv;
    }

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, ConstantesDB.DB_NAME, null, ConstantesDB.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(ConstantesDB.TABLA_CLIENTES_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(ConstantesDB.TABLA_CLIENTES_DROP_SQL);
        }
    }

}
