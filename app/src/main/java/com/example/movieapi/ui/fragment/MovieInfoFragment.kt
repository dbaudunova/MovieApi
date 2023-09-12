package com.example.movieapi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.movieapi.data.remote.model.Movie
import com.example.movieapi.databinding.FragmentMovieInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieInfoFragment : Fragment() {

    private lateinit var binding: FragmentMovieInfoBinding

  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
    }

    private fun result() {
        val result = arguments?.getSerializable("result") as Movie
        binding.tvCountry.text = result.Country
        binding.tvGenre.text = result.Genre
        binding.tvYear.text = result.Year
        binding.tvLanguage.text = result.Language
        binding.tvReleased.text = result.Released
        Glide.with(requireContext()).load(result.Poster).into(binding.ivPoster)
    }
}