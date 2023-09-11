package com.example.movieapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapi.databinding.FragmentMovieSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieSearchFragment : Fragment() {

    private lateinit var binding: FragmentMovieSearchBinding
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.btnSearch.setOnClickListener {
            viewModel.getMovie(
                binding.etSearch.text.toString()
            ).observe(viewLifecycleOwner) {
                Log.e("ololo", "initListener:${it}")
                findNavController().navigate(R.id.movieInfoFragment, bundleOf("result" to it))
            }
        }
    }
}