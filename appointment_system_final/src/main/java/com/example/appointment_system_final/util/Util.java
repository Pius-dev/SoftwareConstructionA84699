package com.example.appointment_system_final.util;

import java.sql.Timestamp;
import java.util.Date;

public class Util {

    public static Timestamp dateToTimestamp(Date date){
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }
}

