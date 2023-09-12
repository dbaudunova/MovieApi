package com.example.movieapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapi.data.remote.model.Movie
import com.example.movieapi.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getMovie(movieName: String): LiveData<Movie> {
        return repository.getMovie(movieName)
    }
}