package com.example.myapplication.data.local.converter

import androidx.room.TypeConverter
import com.example.myapplication.domain.model.Origin

class OriginConverter {
    @TypeConverter
    fun fromOrigin(value: Origin): String = "${value.name}||${value.url}"

    @TypeConverter
    fun toOrigin(value: String): Origin = Origin(
        value.split("||")[0],
        value.split("||")[1]
    )

}