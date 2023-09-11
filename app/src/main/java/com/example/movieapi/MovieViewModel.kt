package com.example.movieapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getMovie(movieName: String): LiveData<Movie> {
        return repository.getMovie(movieName)
    }
}