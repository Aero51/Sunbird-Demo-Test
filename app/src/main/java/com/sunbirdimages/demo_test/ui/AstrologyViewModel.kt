package com.sunbirdimages.demo_test.ui


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sunbirdimages.demo_test.data.AstrologyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AstrologyViewModel @Inject constructor(
     val repository: AstrologyRepository
) : ViewModel() {

    val astrologyData = repository.getAstrologyData().asLiveData()

}