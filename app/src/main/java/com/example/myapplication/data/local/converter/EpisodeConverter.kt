package com.example.myapplication.data.local.converter

import androidx.room.TypeConverter

class EpisodeConverter {
    @TypeConverter
    fun fromEpisode(value: List<String>): String = value.joinToString("||")

    @TypeConverter
    fun toEpisode(value: String): List<String> = value.split("||")

}