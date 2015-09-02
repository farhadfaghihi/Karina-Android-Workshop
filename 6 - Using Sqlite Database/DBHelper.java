package com.greenreportpos.support.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.greenreportpos.support.utils.Consts;

/**
 * Created by Farhad Faghihi on 4/14/2015.
 */
public class DBHelper extends SQLiteOpenHelper
{

    public DBHelper(Context context)
    {
        super(context, Consts.DATABASE_NAME,null,Consts.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String create_table_user = "CREATE TABLE " + Consts.TABLE_USER + "("
                + Consts.USER_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Consts.USER_COLUMN_FIRSTNAME + " TEXT,"
                + Consts.USER_COLUMN_LASTNAME + " TEXT,"
                + Consts.USER_COLUMN_USERNAME + " TEXT,"
                + Consts.USER_COLUMN_PASSWORD + " TEXT,"
                + Consts.USER_COLUMN_ROLE + " TEXT,"
                + Consts.USER_COLUMN_RANK + " TEXT,"
                + Consts.USER_COLUMN_LAST_SYNC + " TEXT,"
                + Consts.USER_COLUMN_IMAGE_URL + " TEXT"
                +  ");";

        String create_table_customer = "CREATE TABLE " + Consts.TABLE_CUSTOMER + "("
                + Consts.CUSTOMER_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Consts.CUSTOMER_COLUMN_FIRSTNAME + " TEXT,"
                + Consts.CUSTOMER_COLUMN_LASTNAME + " TEXT,"
                + Consts.CUSTOMER_COLUMN_NATIONALCODE + " TEXT NOT NULL UNIQUE,"
                + Consts.CUSTOMER_COLUMN_STORENAME + " TEXT,"
                + Consts.CUSTOMER_COLUMN_SENF + " TEXT,"
                + Consts.CUSTOMER_COLUMN_ADDRESS + " TEXT,"
                + Consts.CUSTOMER_COLUMN_POSTALCODE + " TEXT,"
                + Consts.CUSTOMER_COLUMN_PHONE + " TEXT,"
                + Consts.CUSTOMER_COLUMN_CELLPHONE + " TEXT"
                +  ");";

        String create_table_action = "CREATE TABLE " + Consts.TABLE_ACTION + "("
                + Consts.ACTION_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Consts.ACTION_COLUMN_USERID + " INTEGER,"
                + Consts.ACTION_COLUMN_CUSTOMER_ID + " INTEGER,"
                + Consts.ACTION_COLUMN_DESCRIPTION + " TEXT,"
                + Consts.ACTION_COLUMN_DEADLINE + " TEXT,"
                + Consts.ACTION_COLUMN_DONE + " TEXT,"
                + Consts.ACTION_COLUMN_TYPE + " TEXT,"
                + Consts.ACTION_COLUMN_TASK_ID + " INTEGER NOT NULL UNIQUE,"
                + Consts.ACTION_COLUMN_TERMINAL_ID + " INTEGER"
                +  ");";

        String create_table_terminal = "CREATE TABLE " + Consts.TABLE_TERMINAL + "("
                + Consts.TERMINAL_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Consts.TERMINAL_COLUMN_CUSTOMERID + " INTEGER,"
                + Consts.TERMINAL_COLUMN_TERMINALCODE + " TEXT NOT NULL UNIQUE,"
                + Consts.TERMINAL_COLUMN_SERIAL + " TEXT"
                +  ");";

        String create_table_report_support = "CREATE TABLE " + Consts.TABLE_REPORT_SUPPORT + "("
                + Consts.REPORT_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Consts.REPORT_COLUMN_USER_ID + " INTEGER,"
                + Consts.REPORT_COLUMN_CUSTOMER_ID + " INTEGER,"
                + Consts.REPORT_COLUMN_TERMINAL_ID + " INTEGER,"
                + Consts.REPORT_COLUMN_HEALTHCHECK + " TEXT,"
                + Consts.REPORT_COLUMN_COUNT_PAPERROLL + " INTEGER,"
                + Consts.REPORT_COLUMN_COUNT_ADAPTER + " INTEGER,"
                + Consts.REPORT_COLUMN_COUNT_POS_HOLDER + " INTEGER,"
                + Consts.REPORT_COLUMN_COUNT_PHONE_CABLE + " INTEGER,"
                + Consts.REPORT_COLUMN_COUNT_COUNT_SOCKET + " INTEGER,"
                + Consts.REPORT_COLUMN_COUNT_LABEL + " INTEGER,"
                + Consts.REPORT_COLUMN_LATITUDE + " TEXT,"
                + Consts.REPORT_COLUMN_LONGITUDE + " TEXT,"
                + Consts.REPORT_COLUMN_TYPE + " TEXT,"
                + Consts.REPORT_COLUMN_DATE + " TEXT,"
                + Consts.REPORT_COLUMN_SENTSTATUS + " TEXT"
                +  ");";

        sqLiteDatabase.execSQL(create_table_user);
        sqLiteDatabase.execSQL(create_table_customer);
        sqLiteDatabase.execSQL(create_table_action);
        sqLiteDatabase.execSQL(create_table_terminal);
        sqLiteDatabase.execSQL(create_table_report_support);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Consts.TABLE_USER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Consts.TABLE_CUSTOMER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Consts.TABLE_ACTION);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Consts.TABLE_TERMINAL);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Consts.TABLE_REPORT_SUPPORT);

        onCreate(sqLiteDatabase);
    }

    public SQLiteDatabase getDbReadable()
    {
        return this.getReadableDatabase();
    }

    public SQLiteDatabase getDbWriteable()
    {
        return this.getWritableDatabase();
    }

}
