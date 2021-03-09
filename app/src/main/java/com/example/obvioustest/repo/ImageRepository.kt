package com.example.obvioustest.repo

import com.example.obvioustest.db.ImageDao
import javax.inject.Inject

class ImageRepository @Inject constructor(private val imageDao: ImageDao){
}