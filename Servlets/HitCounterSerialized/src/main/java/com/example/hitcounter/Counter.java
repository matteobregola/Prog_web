package com.example.hitcounter;

import java.io.*;
import java.util.Calendar;

public class Counter implements Serializable {

    protected int count;
    protected Calendar timeStamp;
    private static final String FILE_PATH = "./data.ser";

    public Counter(){
        this.count=0;
        this.timeStamp=Calendar.getInstance();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Calendar getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Calendar timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void increase() throws IOException, ClassNotFoundException {

        // update the Counter value and writes it in the file
        this.setCount(++count);
        this.setTimeStamp(Calendar.getInstance());

        ObjectOutputStream in= new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        in.writeObject(this);
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