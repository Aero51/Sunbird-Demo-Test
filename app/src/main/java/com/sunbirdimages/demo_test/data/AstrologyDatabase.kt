package com.sunbirdimages.demo_test.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AstrologyData::class], version = 1)
abstract class AstrologyDatabase : RoomDatabase() {

    abstract fun astrologyDao(): AstrologyDao
}