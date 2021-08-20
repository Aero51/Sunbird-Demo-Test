package com.sunbirdimages.demo_test.di


import com.sunbirdimages.demo_test.data.AstrologyRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        AstrologyRepository(provideAstrologyApi(provideRetrofit()), provideDatabase(get()))
    }
}