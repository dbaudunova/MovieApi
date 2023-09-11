package com.example.movieapi

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieapi.BuildConfig.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiService) {

    fun getMovie(movieName: String) : MutableLiveData<Movie> {
        val mutableLiveData = MutableLiveData<Movie>()
        api.getMovie(API_KEY, movieName)
            .enqueue(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    mutableLiveData.postValue(response.body())
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message} ")
                }

            })
        return mutableLiveData
    }
}