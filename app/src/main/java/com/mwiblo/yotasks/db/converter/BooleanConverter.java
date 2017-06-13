package com.mwiblo.yotasks.db.converter;

import android.arch.persistence.room.TypeConverter;

/**
 * Converts a boolean to an integer (false = 0, true = 1)
 * @author Vincent
 */

public class BooleanConverter {

    @TypeConverter
    public static int toInteger(boolean bool){
        return bool? 1 : 0;
    }

    @TypeConverter
    public static boolean toBoolean(int i){
        return i == 1;
    }
}
