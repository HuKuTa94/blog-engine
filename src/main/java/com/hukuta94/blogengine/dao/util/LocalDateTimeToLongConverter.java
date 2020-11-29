package com.hukuta94.blogengine.dao.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

abstract public class LocalDateTimeToLongConverter
{
    public static long toMinutes( LocalDateTime date ) {
        return date.atZone( ZoneId.of( "UTC" ))
                .toInstant()
                .toEpochMilli() / 1000;
    }
}
