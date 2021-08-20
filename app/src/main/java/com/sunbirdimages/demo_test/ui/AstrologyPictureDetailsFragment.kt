package com.sunbirdimages.demo_test.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sunbirdimages.demo_test.R
import com.sunbirdimages.demo_test.databinding.FragmentAstrologyPictureDetailsBinding


class AstrologyPictureDetailsFragment : Fragment(R.layout.fragment_astrology_picture_details) {
    private val args: AstrologyPictureDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAstrologyPictureDetailsBinding.bind(view)

        binding.apply {


            Glide.with(view)
                .load(args.data.url)
                .into(imageView)

            textViewTitle.text = args.data.title
            textViewDate.text = args.data.date
            textViewExplanation.text = args.data.explanation


        }


    }


}