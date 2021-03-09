package com.example.obvioustest.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.obvioustest.AppClass
import com.example.obvioustest.models.ImageData
import com.example.obvioustest.repo.ImageRepository
import com.example.obvioustest.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(private val imageRepository: ImageRepository) :
    ViewModel() {

    private val _simpleDateFormatter by lazy { SimpleDateFormat("yyyy-MM-dd", Locale.ROOT) }

    private val _jsonConfiguration by lazy {
        Json { isLenient = true; ignoreUnknownKeys = true; allowSpecialFloatingPointValues = true }
    }

    val imageListData: LiveData<List<ImageData>> = imageRepository.getAllImages().asLiveData()

    fun insertData() {
        viewModelScope.launch(Dispatchers.IO) {
            val jsonString =
                AppClass.appInstance.applicationContext.assets.open(Constants.ASSET_NAME)
                    .bufferedReader()
                    .use { it.readText() }
            val response = _jsonConfiguration.decodeFromString(
                ListSerializer(ImageData.serializer()), jsonString
            )
            val list = response.toMutableList().sortedByDescending {_simpleDateFormatter.parse(it.date).time}
            imageRepository.insertImages(list)
        }
    }

}