package com.example.moviedetailapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.moviedetailapp.paging.MoviePagingSource
import com.example.moviedetailapp.repository.MovieApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val repository: MovieApiRepository) : ViewModel(){

    val loading = MutableLiveData<Boolean>()

    val moviesList = Pager(PagingConfig(1)) {
        MoviePagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}