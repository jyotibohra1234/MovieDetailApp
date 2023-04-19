package com.example.moviedetailapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedetailapp.R
import com.example.moviedetailapp.adapter.LoadMoreAdapter
import com.example.moviedetailapp.adapter.MoviesAdapter
import com.example.moviedetailapp.databinding.FragmentMovieListBinding
import com.example.moviedetailapp.viewModel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment : BaseFragment(R.layout.fragment_movie_list) {

    private lateinit var binding: FragmentMovieListBinding

    @Inject
    lateinit var moviesAdapter: MoviesAdapter

    private val viewModel: MovieListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieListBinding.inflate(layoutInflater)
        binding.apply {

            lifecycleScope.launchWhenCreated {
                viewModel.moviesList.collect {
                    moviesAdapter.submitData(it)
                }
            }

            lifecycleScope.launchWhenCreated {
                moviesAdapter.loadStateFlow.collect {
                    val state = it.refresh
                    prgBarMovies.isVisible = state is LoadState.Loading
                }
            }

            recyclerMovie.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = moviesAdapter
            }

            recyclerMovie.adapter = moviesAdapter.withLoadStateFooter(
                LoadMoreAdapter {
                    moviesAdapter.retry()
                }
            )

        }
    }
}