package org.example.messagewebapp.common;

public class ReqCounter {

    private int count;
    public int inc(){
        return ++count;
    }
    public int getCount(){
        return count;
    }
}
