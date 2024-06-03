package com.example.myapplication.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.myapplication.data.local.converter.EpisodeConverter
import com.example.myapplication.data.local.converter.LocationConverter
import com.example.myapplication.data.local.converter.OriginConverter
import com.example.myapplication.data.local.dao.CharacterDao
import com.example.myapplication.data.local.entity.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    exportSchema = false,
    version = 1,
)
@TypeConverters(LocationConverter::class, OriginConverter::class, EpisodeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val characterDao: CharacterDao
}