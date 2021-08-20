package com.sunbirdimages.demo_test.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

import com.sunbirdimages.demo_test.data.AstrologyRepository


class AstrologyViewModel(
    val repository: AstrologyRepository
) : ViewModel() {

    val astrologyData = repository.getAstrologyData().asLiveData()

}