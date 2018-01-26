package loginDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user.db";
    private static final String TABLE_NAME = "users";
    private static final int SCHEMA_VERSION = 1;

    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT, email TEXT, password TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //EMPTY METHOD
    }

    public void addUser(User user) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE name = '" + user.getName() +
                        "' AND email = '" + user.getEmail() + "' AND password = '" + user.getPassword() +
                        "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(name, email, password) VALUES('" +
                    user.getName() + "', '" +
                    user.getEmail() + "', '" +
                    user.getPassword() + "');");
        }
        cursor.close();
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    User user = new User(
                            cursor.getString(cursor.getColumnIndex("name")),
                            cursor.getString(cursor.getColumnIndex("email")),
                            cursor.getString(cursor.getColumnIndex("password")));
                    userList.add(user);
                } while (cursor.moveToNext());
            }
        }
        return userList;
    }

    public User getUserAuth(String email, String password) {
        User user = null;
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE email = '" + email + "' AND password = '" + password +
                        "';", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                user = new User(
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("email")),
                        cursor.getString(cursor.getColumnIndex("password")));
            }
            return user;
        }
        return null;
    }

    public User getUserName(String name){
        User user = null;
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE name = '" + name +
                        "';", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                user = new User(
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("email")),
                        cursor.getString(cursor.getColumnIndex("password")));
            }
            return user;
        }
        return null;
    }
}
