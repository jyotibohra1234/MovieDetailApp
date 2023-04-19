package com.example.moviedetailapp.repository

import com.example.moviedetailapp.rest.api.MovieApiService
import javax.inject.Inject

class MovieApiRepository @Inject constructor(private  val movieApiService: MovieApiService) {

    suspend fun getMovieList(api_key :String , language : String, page: Int, region : String) = movieApiService.getMovieList(api_key,language,page,region)
}