package com.sunbirdimages.demo_test.data

import androidx.room.withTransaction
import com.sunbirdimages.demo_test.api.AstrologyApi
import com.sunbirdimages.demo_test.util.networkBoundResource

import kotlinx.coroutines.delay
import javax.inject.Inject

class AstrologyRepository @Inject constructor(
    private val api: AstrologyApi,
    private val db: AstrologyDatabase
) {
    private val astrologyDao = db.astrologyDao()

    fun getAstrologyData() = networkBoundResource(
        query = {
            astrologyDao.getAllData()
        },
        fetch = {
            delay(2000)
            api.getAstrologyData()
        },
        saveFetchResult = { astrologyData ->
            db.withTransaction {
                astrologyDao.deleteAllAstrologyData()
                astrologyDao.insertAstrologyData(astrologyData)
            }
        },shouldFetch = {data ->
            data.isEmpty()
        }

    )
}