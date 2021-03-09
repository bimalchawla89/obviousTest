package com.example.obvioustest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.obvioustest.models.ImageData

@Dao
interface ImageDao {
    @Query("SELECT * FROM ImageData")
    fun getAll(): List<ImageData>

    @Insert
    fun insertAll(vararg users: ImageData)
}