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
        db.execSQL("create table datosITS(idITS int primary key, idActividad int, idParticipante int, grupo int, subgrupo int, condonesm int, condonesf int, lubricantesachet int, lubricantetubo int, impresos int, fechaprueba datetime, motivo int, diagnostico1 int, tratado1 int, tratamiento1 varchar(255), diagnostico2 int, tratado2 int, tratamiento2 varchar(255), diagnostico3 int, tratado3 int, tratamiento3 varchar(255), diagnostico4 int, tratado4 int, tratamiento4 varchar(255), comentario varchar(255))");
        db.execSQL("create table datosTVC(idTVC int primary key, idActividad int, idParticipante int, grupo int, subgrupo int, condonesm int, condonesf int, lubricantesachet int, lubricantetubo int, impresos int, fechaprueba datetime, motivo int, prueba int, preprueba int, postprueba int, resultado int, loconoce int, referido int, comentario varchar(255))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}