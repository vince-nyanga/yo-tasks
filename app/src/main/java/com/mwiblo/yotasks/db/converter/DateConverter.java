package com.mwiblo.yotasks.db.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Converts java.util.Date to timestamp and vice versa
 * @author Vincent
 */

public class DateConverter {

    @TypeConverter
    public  static Date toDate(Long timestamp){
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date){
        return date == null? null : date.getTime();
    }
}
