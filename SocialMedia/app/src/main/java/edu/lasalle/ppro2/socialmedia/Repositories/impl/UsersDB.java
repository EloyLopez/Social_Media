package edu.lasalle.ppro2.socialmedia.Repositories.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.lasalle.ppro2.socialmedia.Repositories.UsersDBRepo;
import edu.lasalle.ppro2.socialmedia.model.User;
import edu.lasalle.ppro2.socialmedia.ultis.DatabaseHelper;

/**
 * Created by eloy on 24-05-2017.
 */

public class UsersDB implements UsersDBRepo {

    private static final  String TABLE_NAME="friends";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_GENDER="gender";
    private static final String COLUMN_BORTHDATE="birthdate";
    private static final String COLUMN_SURNAME="surname";
    private static final String COLUMN_STUDIES="studies";
    private static final String COLUMN_FRIENDS="friend";
    private Context context;

    public UsersDB(Context context)
    {
        this.context=context;
    }
    @Override
    public void addUser(User u) {
        DatabaseHelper helper=DatabaseHelper.getInstance(context);
        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME,u.getName());
        values.put(COLUMN_SURNAME,u.getSurname());
        values.put(COLUMN_GENDER,u.getGender());
        values.put(COLUMN_BORTHDATE,u.getBirthdate());
        values.put(COLUMN_STUDIES,u.getStudies());
        values.put(COLUMN_FRIENDS,u.getFriend());
        helper.getWritableDatabase().insert(TABLE_NAME,null,values);

    }

    @Override
    public List<User> getAllusers() {
        List<User> list = new ArrayList<>();

        DatabaseHelper helper = DatabaseHelper.getInstance(context);

        String[] selectColumns = null;

        Cursor cursor = helper.getReadableDatabase().
                query(TABLE_NAME, selectColumns, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String personName = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                    String personSurname = cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME));
                    String personGender = cursor.getString(cursor.getColumnIndex(COLUMN_GENDER));
                    String personBirthdate = cursor.getString(cursor.getColumnIndex(COLUMN_BORTHDATE));
                    String personStudies = cursor.getString(cursor.getColumnIndex(COLUMN_STUDIES));
                    int personFriend= cursor.getInt(cursor.getColumnIndex(COLUMN_FRIENDS));

                    list.add(new User(personName, personSurname,personGender,personBirthdate,personStudies,personFriend));

                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        return list;
    }

    @Override
    public void update(String name,String surname,int value){
        DatabaseHelper helper = DatabaseHelper.getInstance(context);
        ContentValues values = new ContentValues();
        values.put(COLUMN_FRIENDS,value);
        String whereClause = COLUMN_NAME + "=? and " + COLUMN_SURNAME + "=?";
        String[] whereArgs = {name, surname};
        helper.getWritableDatabase().update(TABLE_NAME, values, whereClause, whereArgs);
    }


}

