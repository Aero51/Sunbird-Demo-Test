package com.sunbirdimages.demo_test.di

import com.sunbirdimages.demo_test.ui.AstrologyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        AstrologyViewModel(get())
    }
}