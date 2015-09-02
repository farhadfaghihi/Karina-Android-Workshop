package com.greenreportpos.support.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.greenreportpos.support.model.data.database.CurrentUser;
import com.greenreportpos.support.model.data.database.Customer;
import com.greenreportpos.support.model.data.database.Terminal;
import com.greenreportpos.support.model.data.response.Pos;
import com.greenreportpos.support.network.login.LoginResponse;
import com.greenreportpos.support.utils.Consts;
import com.greenreportpos.support.utils.ToastUtils;

import java.util.ArrayList;

/**
 * Created by Farhad Faghihi on 4/16/2015.
 */
public class DBTerminalHelper
{
    private static DBHelper dbMaster ;
    private static Context context ;
    private static DBTerminalHelper instance ;

    private DBTerminalHelper(Context ctx)
    {
        context = ctx ;
        dbMaster = new DBHelper(context);
    }

    public static DBTerminalHelper getInstance(Context context)
    {
        if(instance == null)
            instance = new DBTerminalHelper(context);

        return instance ;
    }

    public ArrayList<Terminal> getAllTerminals()
    {
        String selectQuery = "SELECT  * FROM " + Consts.TABLE_TERMINAL;

        ArrayList<Terminal> listTerminal = new ArrayList<>();

        Cursor cursor = dbMaster.getDbReadable().rawQuery(selectQuery,null);

        if(cursor.moveToFirst())
        {
            do
            {
                Terminal terminal = new Terminal();

                terminal.setId(cursor.getInt(0));
                terminal.setCustomerId(cursor.getInt(1));
                terminal.setTerminalCode(cursor.getString(2));
                terminal.setSerial(cursor.getString(3));

                listTerminal.add(terminal);

            }
            while (cursor.moveToNext());
        }

        return listTerminal ;
    }

    public void addTerminal(Terminal terminal)
    {
        ContentValues values = new ContentValues();

        values.put(Consts.TERMINAL_COLUMN_CUSTOMERID,terminal.getCustomerId());
        values.put(Consts.TERMINAL_COLUMN_TERMINALCODE,terminal.getTerminalCode());
        values.put(Consts.TERMINAL_COLUMN_SERIAL,terminal.getSerial());

        dbMaster.getDbWriteable().insertOrThrow(Consts.TABLE_TERMINAL,null,values);

        dbMaster.close();

    }

    public void updateTerminal(Terminal terminal)
    {
        ContentValues values = new ContentValues();

        values.put(Consts.TERMINAL_COLUMN_CUSTOMERID,terminal.getCustomerId());
        values.put(Consts.TERMINAL_COLUMN_TERMINALCODE,terminal.getTerminalCode());
        values.put(Consts.TERMINAL_COLUMN_SERIAL,terminal.getSerial());

        dbMaster.getDbWriteable().update(Consts.TABLE_TERMINAL, values,
                Consts.TERMINAL_COLUMN_ID + " = ?",
                new String[]{String.valueOf(terminal.getId())});

        dbMaster.close();
    }

    public void deleteTerminal(Terminal terminal)
    {
        dbMaster.getDbWriteable().delete(Consts.TABLE_TERMINAL,Consts.TERMINAL_COLUMN_ID + " =?",new String[]{String.valueOf(terminal.getId())});

        dbMaster.close();
    }

    public void deleteAllTerminalData()
    {
        String deleteQuery = "delete from "+ Consts.TABLE_TERMINAL ;

        dbMaster.getDbWriteable().execSQL(deleteQuery);

        dbMaster.close();
    }
        try
        {
            Pos[][] posArray = response.getPos();

            ArrayList<Customer> listCustomers = DBCustomerHelper.getInstance(context).getAllCustomers();

            for(int i=0 ; i<listCustomers.size() ; i++)
            {
                int countPos = posArray[i].length ;

                int customerId = listCustomers.get(i).getId();

                for(int j=0 ; j< countPos ; j++)
                {
                    if( posArray[i][j].getSerial_no()!= null &&
                       !posArray[i][j].getSerial_no().equals("") &&
                        posArray[i][j].getTerminal_no()!= null &&
                       !posArray[i][j].getTerminal_no().equals("") )
                    {
                        Terminal terminal = new Terminal();

                        terminal.setCustomerId(customerId);
                        terminal.setSerial(posArray[i][j].getSerial_no());
                        terminal.setTerminalCode(posArray[i][j].getTerminal_no());

                        DBTerminalHelper.getInstance(context).addTerminal(terminal);
                    }
                }

            }
        }

        catch (SQLiteConstraintException sqlExc)
        {

        }

        catch (SQLiteException sqlExc)
        {

        }

        catch (Exception exc)
        {

        }

    }
        Terminal terminal = new Terminal();

        ArrayList<Terminal> listItems = getAllTerminals();

        for(Terminal item : listItems)
        {
            if(item.getId() == terminalId)
            {
                terminal = item ;
                break;
            }

        }

        return terminal ;
    }
}
