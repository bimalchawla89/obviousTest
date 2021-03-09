package com.example.obvioustest.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class ImageData(
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "copyright") val copyright: String? = null,
    @ColumnInfo(name = "date") val date: String? = null,
    @ColumnInfo(name = "explanation") val explanation: String? = null,
    @ColumnInfo(name = "hdurl") val hdurl: String? = null,
    @SerialName("media_type") @ColumnInfo(name = "mediaType") val mediaType: String? = null,
    @SerialName("service_version") @ColumnInfo(name = "serviceVersion") val serviceVersion: String? = null,
    @ColumnInfo(name = "url") val url: String? = null
)