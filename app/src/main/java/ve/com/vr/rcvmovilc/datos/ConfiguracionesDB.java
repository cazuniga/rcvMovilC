package ve.com.vr.rcvmovilc.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import ve.com.vr.rcvmovilc.model.Configuracion;

public class ConfiguracionesDB {
    private SQLiteDatabase db;
    private ConfiguracionesDB.DBHelper dbHelper;

    public ConfiguracionesDB(Context context) {
        dbHelper = new ConfiguracionesDB.DBHelper(context);
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
    public long insertConfiguracion(Configuracion item) {
        this.openWriteableDB();
        long rowID = db.insert(ConstantesDB.TABLA_CONFIGURACIONES, null, configuracionMapperContentValues(item));
        this.closeDB();

        return rowID;
    }

    public void updateConfiguracion(Configuracion item) {
        this.openWriteableDB();
        String where = ConstantesDB.ID_CF_LC   + "= ?";
        db.update(ConstantesDB.TABLA_CONFIGURACIONES, configuracionMapperContentValues(item), where, new String[]{String.valueOf(item.getId_cf_lc() )});
        db.close();
    }

    public void deleteConfiguracion(long id) {
        this.openWriteableDB();
        String where = ConstantesDB.ID_CF_LC + "= ?";
        db.delete(ConstantesDB.TABLA_CONFIGURACIONES, where, new String[]{String.valueOf(id)});
        this.closeDB();
    }

    public void deleteAllConfiguracion() {
        this.openWriteableDB();
        db.execSQL("delete from "+ ConstantesDB.TABLA_CONFIGURACIONES);
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+ ConstantesDB.TABLA_CONFIGURACIONES + "'");
        this.closeDB();
    }



    public ArrayList<Configuracion> loadConfiguraciones() {

        ArrayList<Configuracion> list = new ArrayList<Configuracion>();
        this.openReadableDB();
        String[] campos = new String[]{
                 ConstantesDB.ID_CF_LC
                ,ConstantesDB.CD_CF
                ,ConstantesDB.DS_CF
                ,ConstantesDB.VL_CF
                ,ConstantesDB.ES_CF
        };

        Cursor c = db.query(ConstantesDB.TABLA_CONFIGURACIONES, campos , null, null, null, null, null);

        try {
            while (c.moveToNext()) {
                Configuracion item = new Configuracion();

                item.setId_cf_lc(c.getInt(0));
                item.setCd_cf(c.getString(1));
                item.setDs_cf(c.getString(2));
                item.setVl_cf(c.getString(3));
                item.setEs_cf(c.getString(4));
                list.add(item);
            }
        } finally {
            c.close();
        }
        this.closeDB();

        return list;
    }

    public Configuracion buscarConfiguracion(String vpCd) {
        Configuracion item = new Configuracion();

        this.openReadableDB();
        String where = ConstantesDB.CD_CF + "= '?'";
        String[] whereArgs = {vpCd};

        Cursor c = db.query(ConstantesDB.TABLA_CONFIGURACIONES, null, where, whereArgs, null, null, null);

        if( c != null || c.getCount() <=0) {
            c.moveToFirst();
            item.setId_cf_lc(c.getInt(0));
            item.setCd_cf(c.getString(1));
            item.setDs_cf(c.getString(2));
            item.setVl_cf(c.getString(3));
            item.setEs_cf(c.getString(4));
            c.close();
        }
        this.closeDB();
        return item;
    }

    private ContentValues configuracionMapperContentValues(Configuracion item) {
        ContentValues cv = new ContentValues();

        cv.put(ConstantesDB.ID_CF_LC, item.getId_cf_lc());
        cv.put(ConstantesDB.CD_CF,item.getCd_cf() );
        cv.put(ConstantesDB.DS_CF,item.getDs_cf() );
        cv.put(ConstantesDB.VL_CF,item.getVl_cf() );
        cv.put(ConstantesDB.ES_CF,item.getEs_cf() );

        return cv;
    }

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, ConstantesDB.DB_NAME, null, ConstantesDB.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(ConstantesDB.TABLA_CONFIGURACIONES_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(ConstantesDB.TABLA_CONFIGURACIONES_DROP_SQL);
        }
    }
}
