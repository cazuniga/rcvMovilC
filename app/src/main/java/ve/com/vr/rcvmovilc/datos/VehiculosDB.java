package ve.com.vr.rcvmovilc.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import ve.com.vr.rcvmovilc.model.Vehiculo;

public class VehiculosDB {
    private SQLiteDatabase db;
    private VehiculosDB.DBHelper dbHelper;

    public VehiculosDB(Context context) {
        dbHelper = new VehiculosDB.DBHelper(context);
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
    public long insertVehiculo(Vehiculo vehiculo) {
        this.openWriteableDB();
        long rowID = db.insert(ConstantesDB.TABLA_VEHICULOS, null, vehiculoMapperContentValues(vehiculo));
        this.closeDB();

        return rowID;
    }

    public void updateVehiculo(Vehiculo vehiculo) {
        this.openWriteableDB();
        String where = ConstantesDB.ID_VH   + "= ?";
        db.update(ConstantesDB.TABLA_VEHICULOS, vehiculoMapperContentValues(vehiculo), where, new String[]{String.valueOf(vehiculo.getId_vh() )});
        db.close();
    }

    public void deleteVehiculo(long id) {
        this.openWriteableDB();
        String where = ConstantesDB.ID_VH + "= ?";
        db.delete(ConstantesDB.TABLA_VEHICULOS, where, new String[]{String.valueOf(id)});
        this.closeDB();
    }

    public void deleteAllVehiculo() {
        this.openWriteableDB();
        db.execSQL("delete from "+ ConstantesDB.TABLA_VEHICULOS);
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+ ConstantesDB.TABLA_VEHICULOS + "'");
        this.closeDB();
    }



    public ArrayList<Vehiculo> loadVehiculos() {

        ArrayList<Vehiculo> list = new ArrayList<Vehiculo>();
        this.openReadableDB();
        String[] campos = new String[]{
                 ConstantesDB.ID_VH_LC
                ,ConstantesDB.ID_VH
                ,ConstantesDB.PL_VH
                ,ConstantesDB.SE_CA_VH
                ,ConstantesDB.AN_VH
                ,ConstantesDB.PE_VH
                ,ConstantesDB.NR_PU_VH
                ,ConstantesDB.CL_VH
                ,ConstantesDB.DS_MC
                ,ConstantesDB.DS_MD
                ,ConstantesDB.DS_TP_VH
                ,ConstantesDB.DS_CL_VH
                ,ConstantesDB.DS_USO
                ,ConstantesDB.ES_VH

        };
        Cursor c = db.query(ConstantesDB.TABLA_VEHICULOS, campos , null, null, null, null, null);

        try {
            while (c.moveToNext()) {
                Vehiculo item = new Vehiculo();
                item.setId_vh_lc(c.getInt(0));
                item.setId_vh(c.getInt(1));
                item.setPl_vh(c.getString(2));
                item.setSe_ca_vh(c.getString(3));
                item.setAn_vh(c.getInt(4));
                item.setPe_vh ( c.getInt(5));
                item.setNr_pu_vh( c.getInt(6));
                item.setCl_vh(c.getString(7));
                item.setDs_mc(c.getString(8));
                item.setDs_md(c.getString(9));
                item.setDs_tp_vh(c.getString(10));
                item.setDs_cl_vh(c.getString(11));
                item.setDs_uso(c.getString(12));
                item.setEs_vh(c.getString(13));
                list.add(item);
            }
        } finally {
            c.close();
        }
        this.closeDB();

        return list;
    }
    public Vehiculo buscarVehiculo(Long id) {
        Vehiculo item = new Vehiculo();

        this.openReadableDB();
        String where = ConstantesDB.ID_VH + "= ?";
        String[] whereArgs = {id.toString()};
        Cursor c = db.query(ConstantesDB.TABLA_VEHICULOS, null, where, whereArgs, null, null, null);

        if( c != null || c.getCount() <=0) {
            c.moveToFirst();

            item.setId_vh_lc(c.getInt(0));
            item.setId_vh(c.getInt(1));
            item.setPl_vh(c.getString(2));
            item.setSe_ca_vh(c.getString(3));
            item.setAn_vh(c.getInt(4));
            item.setPe_vh ( c.getInt(5));
            item.setNr_pu_vh( c.getInt(6));
            item.setCl_vh(c.getString(7));
            item.setDs_mc(c.getString(8));
            item.setDs_md(c.getString(9));
            item.setDs_tp_vh(c.getString(10));
            item.setDs_cl_vh(c.getString(11));
            item.setDs_uso(c.getString(12));
            item.setEs_vh(c.getString(13));

            c.close();
        }
        this.closeDB();
        return item;
    }

    private ContentValues vehiculoMapperContentValues(Vehiculo item) {
        ContentValues cv = new ContentValues();

        cv.put(ConstantesDB.ID_VH_LC, item.getId_vh_lc());
        cv.put(ConstantesDB.ID_VH,item.getId_vh());
        cv.put(ConstantesDB.PL_VH,item.getPl_vh());
        cv.put(ConstantesDB.SE_CA_VH,item.getSe_ca_vh());
        cv.put(ConstantesDB.AN_VH,item.getAn_vh());
        cv.put(ConstantesDB.PE_VH,item.getPe_vh());
        cv.put(ConstantesDB.NR_PU_VH,item.getNr_pu_vh());
        cv.put(ConstantesDB.CL_VH,item.getCl_vh());
        cv.put(ConstantesDB.DS_MC,item.getDs_mc());
        cv.put(ConstantesDB.DS_MD,item.getDs_md());
        cv.put(ConstantesDB.DS_TP_VH,item.getDs_tp_vh());
        cv.put(ConstantesDB.DS_CL_VH,item.getDs_cl_vh());
        cv.put(ConstantesDB.DS_USO,item.getDs_uso());
        cv.put(ConstantesDB.ES_VH,item.getEs_vh());


        return cv;
    }

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, ConstantesDB.DB_NAME, null, ConstantesDB.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(ConstantesDB.TABLA_VEHICULOS_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(ConstantesDB.TABLA_VEHICULOS_DROP_SQL);
        }
    }
}
