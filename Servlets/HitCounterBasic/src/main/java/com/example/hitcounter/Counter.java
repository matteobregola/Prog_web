package com.example.hitcounter;

import java.util.Calendar;

public class Counter {
    int count = 0;
    Calendar timeStamp = Calendar.getInstance();

    public void increase() {
        count++;
        timeStamp = Calendar.getInstance();
    }

    @Override
    public String toString() {
        StringBuffer s = null;
        if (count == 0) s = new StringBuffer("<p>no hits yet</p>");
        else {
            s = new StringBuffer("<p>hits = ");
            s.append(count).append("<br>last hit on ").append(timeStamp.getTime().toString());
        }
        return s.toString();
    }
}