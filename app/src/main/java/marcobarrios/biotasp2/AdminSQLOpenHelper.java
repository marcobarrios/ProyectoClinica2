package marcobarrios.biotasp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marco on 8/03/15.
 */
public class AdminSQLOpenHelper extends SQLiteOpenHelper {

    public AdminSQLOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table insumos(idInsumos int primary key, codigoPaciente varchar(15), idActividad int, tipoInsumo varchar(25), cantidad int, observaciones text)");
        db.execSQL("create table encuestapv(idEncuestapv int primary key, idPaciente int, idActividad, respAnsiedad, respDepresion, respEstres, respAutoestima, respComunicacion)");
        db.execSQL("create table respuestasencuestapv(idRespuestapv int primary key, idEncuestapv int, numPregunta int, respuesta int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}