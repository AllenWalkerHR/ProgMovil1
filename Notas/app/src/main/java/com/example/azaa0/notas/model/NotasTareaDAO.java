package com.example.azaa0.notas.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

/**
 * Created by alcohonsilver on 27/10/16.
 */

public class NotasTareaDAO {
    public static final String TABLE_NAME = "NotaTarea";
    public static final String[] COLUMNS =
            new String[]{"_id", "titulo", "descripcion",
                    "tipo", "fecha_hora", "fecha_hora_vencimineto"};


    SQLiteDatabase _db;

    public NotasTareaDAO (Context ctx )
    {

        _db = new ADAdapter(ctx, 1).getWritableDatabase();
    }

    public int insert(NotaTarea nt){
        ContentValues cv = new ContentValues();


        cv.put(COLUMNS[1], nt.getTitulo());
        cv.put(COLUMNS[2], nt.getDescripcion());
        cv.put(COLUMNS[3], nt.getTipo());
        cv.put(COLUMNS[4], nt.getHora_fecha());
        cv.put(COLUMNS[5], nt.getHora_fecha_vencimiento());

        return (int) _db.insert(TABLE_NAME, null, cv );

    }

    public int update (NotaTarea nt){
        ContentValues cv = new ContentValues();

        cv.put(COLUMNS[0], 0);
        cv.put(COLUMNS[1], nt.getTitulo());
        cv.put(COLUMNS[2], nt.getDescripcion());
        cv.put(COLUMNS[3], nt.getTipo());
        cv.put(COLUMNS[4], nt.getHora_fecha());
        cv.put(COLUMNS[5], nt.getHora_fecha_vencimiento());

        return   _db.update(TABLE_NAME, cv, "_id=?",
                new String[]{ String.valueOf( nt.getId())});

    }

    public int delete (int id){
        return _db.delete(TABLE_NAME,"_id=?",
                new String[]{ String.valueOf( id)});
    }

    public List<NotaTarea> getAll(){
        List<NotaTarea> result = null;

        Cursor c = _db.query(TABLE_NAME,COLUMNS,
                null,null,null,null,null);

        if (c!=null){
            if(c.moveToFirst()){
                result = new ArrayList<NotaTarea>();
                do{
                    NotaTarea item = new NotaTarea(
                            c.getInt(0),
                            c.getString(1),
                            c.getString(2),
                            c.getInt(3),
                            c.getString(4),
                            c.getInt(5)
                    );
                    result.add(item);
                }while(c.moveToNext());
            }
        }

        return result;
    }

    public NotaTarea getOneByID(int id){
        NotaTarea nt = null;

        Cursor c = _db.rawQuery("select * from " + TABLE_NAME +
                " where _id=?",
                new String[]{String.valueOf(id)});

        if (c!=null){
            if(c.moveToFirst()){

                     nt = new NotaTarea(
                            c.getInt(0),
                            c.getString(1),
                            c.getString(2),
                            c.getInt(3),
                            c.getString(4),
                            c.getInt(5)
                    );

            }
        }
        return nt;
    }


}
