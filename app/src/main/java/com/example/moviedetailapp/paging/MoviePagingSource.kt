package com.example.moviedetailapp.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviedetailapp.app.Constants
import com.example.moviedetailapp.repository.MovieApiRepository
import com.example.moviedetailapp.rest.response.MoviesListResponse
import retrofit2.HttpException

class MoviePagingSource (private val movieApiRepository :MovieApiRepository): PagingSource<Int, MoviesListResponse.Result>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesListResponse.Result> {
        return try {
            val currentPage = params.key ?: 1
            val response = movieApiRepository.getMovieList(Constants.API_KEY,"en",currentPage, "US")
            val data = response.body()!!.results
            val responseData = mutableListOf<MoviesListResponse.Result>()
            responseData.addAll(data)
            Log.i("data", "responseData.addAll(data)")
            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MoviesListResponse.Result>): Int? {
        return null
    }
}