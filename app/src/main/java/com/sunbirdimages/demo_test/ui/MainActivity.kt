package com.sunbirdimages.demo_test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.sunbirdimages.demo_test.R
import dagger.hilt.android.AndroidEntryPoint

/**
 *  Demo Day Application Challenge
 *
 *  Tasks: You will be creating an app which shows images from a NASA's "A Picture a Day" API in between the noted date range up to today.
 *  Architecture: MVVM
 *  Endpoint: https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2021-08-04
 *  Tips: Most libraries have been supplied, however feel free to adjust the versions or add ones yourself
 *  Programming Language: Kotlin
 *  Time Frame: 3 Hours
 *
 *  **IMPORTANT BEFORE STARTING**
 *  #1 If you do not feel comfortable trying out Koin (dependency injection), please feel free to avoid this, however
 *  it will be useful in upcoming projects.
 *  #2 Not all tasks must be completed in the given time frame
 *  #3 Design is absolutely not important!! Waste no time here, and keep the default color scheme ;)
 *
 *  TODO List:
 *  #1 Setup two fragments (AstrologyPictureListFragment and  AstrologyPictureDetailsFragment)
 *  #2 Setup these two fragments up to work with jetpack navigation, and include this in MainActivity
 *  #3 Fetch data from provided endpoint and deliver it to the UI, don't worry about saving it in a local Room database, this would take to long
 *  #3 Setup an application class using Koin, and include desired modules, inject viewModels in appropriate activities/fragments where needed
    #4 AstrologyPicturesListFragment will contain a list of images where media_type == "image", as well as max two lines of the "explanation"
        Please constraint the images to a 4:3 ratio using ConstraintLayout
    #5 AstrologyPictureDetailsFragment will show the image as well the date and explanation, upon clicking on an item from
    #6 EXTRA: Do not program this, just think about what would need to be done:
    If you wanted to use the same project to turn this Astrology app into two apps, maybe Astrology App Lite and Astrology App Full, how would you go about doing that?

 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_main) as NavHostFragment
        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}