package com.codingblocks.tododb.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codingblocks.tododb.model.Task;

import java.util.ArrayList;

import static com.codingblocks.tododb.db.TableTask.*;

/**
 * Created by harshit on 14/07/17.
 */

public class TaskDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tasks.db";

    public static final int VERSION = 1;


    public TaskDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = CREATE + TABLE_NAME
                + LBR + COLUMN_ID + INT_PK_AUTOIC
                + COMMA
                + COLUMN_TASK + TYPE_TEXT + COMMA
                + COLUMN_IS_DONE + TYPE_INTEGER + RBR
                + TERMINATE;

        db.execSQL(CREATE_TABLE);
    }

    public long insertTask(Task task) {

        SQLiteDatabase sqlDb = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TASK, task.getTaskName());
        cv.put(COLUMN_IS_DONE, task.isDone());

        return sqlDb.insert(
                TABLE_NAME,
                null,
                cv
        );

    }

    public Task getTask(long id) {
        //// TODO: 14/07/17
        return null;
    }

    public ArrayList<Task> getAllTasks() {

        ArrayList<Task> tasks = new ArrayList<>();

        SQLiteDatabase database = getReadableDatabase();

        Cursor c = database.query(TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                COLUMN_ID + " DESC ");


        while (c.moveToNext()){
            String task;
            int id;
            boolean status;

            int taskColumn = c.getColumnIndex(COLUMN_TASK);
            int idColumn = c.getColumnIndex(COLUMN_ID);
            int idStatus = c.getColumnIndex(COLUMN_IS_DONE);

            task = c.getString(taskColumn);
            id = c.getInt(idColumn);
            status = (1 == c.getInt(idStatus));

            tasks.add(new Task(task,id,status));

        }
        c.close();
        return tasks;
    }

    public void deleteTask(long id){
        getWritableDatabase().delete(TABLE_NAME,
                COLUMN_ID + " = ? ",
                new String[]{String.valueOf(id)});
    }

    public void updateRow(long id, ContentValues cv){
        getWritableDatabase().update(TABLE_NAME,
                cv,
                COLUMN_ID + " = ? ",
                new String[]{String.valueOf(id)});

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(WHEN_UPGRADING_FROM_1_2);
    }
}
