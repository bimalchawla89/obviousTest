package com.example.obvioustest.repo

import androidx.lifecycle.LiveData
import com.example.obvioustest.db.ImageDao
import com.example.obvioustest.models.ImageData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageRepository @Inject constructor(private val imageDao: ImageDao){

    suspend fun insertImages(images: List<ImageData>) {
        imageDao.insertAll(images)
    }

    fun getAllImages(): Flow<List<ImageData>> {
        return imageDao.getAllImages()
    }
}