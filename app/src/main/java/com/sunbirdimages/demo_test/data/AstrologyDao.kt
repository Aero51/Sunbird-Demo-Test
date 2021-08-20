package com.sunbirdimages.demo_test.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AstrologyDao {

    @Query("SELECT * FROM astrology_data")
    fun getAllData(): Flow<List<AstrologyData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAstrologyData(astrologyData: List<AstrologyData>)

    @Query("DELETE FROM astrology_data")
    suspend fun deleteAllAstrologyData()
}