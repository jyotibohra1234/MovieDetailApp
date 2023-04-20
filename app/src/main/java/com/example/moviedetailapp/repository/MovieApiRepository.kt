package com.example.moviedetailapp.repository

import com.example.moviedetailapp.rest.api.MovieApiService
import javax.inject.Inject

class MovieApiRepository @Inject constructor(private  val movieApiService: MovieApiService) {

    suspend fun getMovieList(language : String, page: Int, region : String) = movieApiService.getMovieList(language,page,region)
}