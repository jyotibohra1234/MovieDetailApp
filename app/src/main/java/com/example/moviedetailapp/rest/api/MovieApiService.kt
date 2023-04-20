package com.example.moviedetailapp.rest.api

import com.example.moviedetailapp.rest.response.MoviesListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/now_playing")
    suspend fun getMovieList(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): Response<MoviesListResponse>
}