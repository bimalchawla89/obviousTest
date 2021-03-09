package com.example.obvioustest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.obvioustest.repo.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumDetailViewModel @Inject constructor(private val imageRepository: ImageRepository) :
    ViewModel() {

//    private val _albumDetailResult = MutableLiveData<Resource<AlbumDetailModel>>()
//    val genreAlbumResultLiveData = _albumDetailResult.toLiveData()
//
//    fun getAlbumDetail(name: String, artist: String) {
//        viewModelScope.launch {
//            fmRepository.getAlbumDetail(name, artist).catch { e ->
//                _albumDetailResult.postValue(Resource.Error(e.localizedMessage))
//            }.collect {
//                _albumDetailResult.postValue(Resource.Success(it))
//            }
//        }
//    }
}