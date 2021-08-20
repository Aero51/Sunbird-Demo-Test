package com.sunbirdimages.demo_test.ui

import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.View
import androidx.core.view.isVisible

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunbirdimages.demo_test.R
import com.sunbirdimages.demo_test.data.AstrologyData
import com.sunbirdimages.demo_test.databinding.FragmentAstrologyPictureListBinding
import com.sunbirdimages.demo_test.util.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel


class AstrologyPictureListFragment : Fragment(R.layout.fragment_astrology_picture_list),
    AstrologyRecyclerViewAdapter.OnItemClickListener {

    private val viewModel: AstrologyViewModel by viewModel()
    private var _binding: FragmentAstrologyPictureListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentAstrologyPictureListBinding.bind(view)

        val astrologyAdapter = AstrologyRecyclerViewAdapter(this)

        binding.apply {
            recyclerView.apply {
                setHasFixedSize(true)
                adapter = astrologyAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

        viewModel.astrologyData.observe(viewLifecycleOwner) { result ->

            astrologyAdapter.submitList(result.data)

            binding.apply {
                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                textViewError.text = result.error?.localizedMessage
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(astrologyDataItem: AstrologyData) {
        val action =
            AstrologyPictureListFragmentDirections.actionAstrologyPictureListFragmentToAstrologyPictureDetailsFragment(
                astrologyDataItem
            )
        findNavController().navigate(action)
    }

}