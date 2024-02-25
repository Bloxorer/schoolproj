package com.example.schoolproject.viewmodel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;

    private static final String DatabaseName = "Words";
    private static final int DatabaseVersion = 1;

    private static final String tableName = "Words";
    private static final String columnId = "id";
    public static final  String columnTitle = "title";
    public static final String columnDescription = "description";

    public DatabaseHelper(@Nullable Context context){
        super(context, DatabaseName, null, DatabaseVersion);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tableName + " (" + columnId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + columnTitle + " TEXT, " + columnDescription + " Text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }
    public void addNotes(String title, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(columnTitle, title);
        cv.put(columnDescription, description);

        long resultValue = db.insert(tableName, null, cv);
    }

    public Cursor readNotes(){
        String query = "SELECT * FROM " + tableName;

        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = null;

        if (database != null){
            cursor = database.rawQuery(query, null);
        }
        return cursor;
    }
    public void deleteAllNotes(){
        SQLiteDatabase db  = this.getWritableDatabase();
        String query = "DELETE FROM "+ tableName;
        db.execSQL(query);
    }
    public void updateNotes(String title, String description, String id){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(columnTitle, title);
        cv.put(columnDescription, description);

        long result = database.update(tableName, cv,"id=?", new String[]{id});

    }
    public void deleteSingleItem(String id){
        SQLiteDatabase db = getWritableDatabase();

        long result = db.delete(tableName, "id=?", new String[]{id});
    }
}
