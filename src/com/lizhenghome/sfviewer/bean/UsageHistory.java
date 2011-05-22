package com.lizhenghome.sfviewer.bean;

/**
 * Created by IntelliJ IDEA.
 * User: lizheng
 * Date: 11/05/22
 * Time: 17:01
 * To change this template use File | Settings | File Templates.
 */
public class UsageHistory {

    private int type;

    private int amount;

    private String from;

    public int getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    private String to;
}
