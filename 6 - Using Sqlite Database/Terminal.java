package com.greenreportpos.support.model.data.database;

/**
 * Created by Farhad Faghihi on 4/14/2015.
 */
public class Terminal
{
    private int id ;
    private int customerId ;
    private String terminalCode ;
    private String serial ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
