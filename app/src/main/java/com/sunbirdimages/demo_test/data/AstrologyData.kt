package com.sunbirdimages.demo_test.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "astrology_data")
@Parcelize
data class AstrologyData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val copyright: String?,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String,
): Parcelable