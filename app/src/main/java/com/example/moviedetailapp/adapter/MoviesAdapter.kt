package com.example.moviedetailapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.moviedetailapp.R
import com.example.moviedetailapp.app.Constants.POSTER_BASE_URL
import com.example.moviedetailapp.databinding.ItemsMoviesListBinding
import com.example.moviedetailapp.rest.response.MoviesListResponse
import javax.inject.Inject

class MoviesAdapter @Inject() constructor() :
    PagingDataAdapter<MoviesListResponse.Result, MoviesAdapter.ViewHolder>(differCallback) {

    private lateinit var binding: ItemsMoviesListBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemsMoviesListBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        holder.setIsRecyclable(false)
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: MoviesListResponse.Result) {
            binding.apply {
                tvMovieName.text = item.title
                tvReleaseDate.text = item.releaseDate
                tvOverView.text = item.overview
                textVote.text=item.voteAverage.toString().plus("%")
                val moviePosterURL = POSTER_BASE_URL + item?.posterPath
                imgMovie.load(moviePosterURL){
                    crossfade(true)
                    placeholder(R.drawable.poster_placeholder)
                    scale(Scale.FILL)
                }
            }
        }
    }

       companion object {
        val differCallback = object : DiffUtil.ItemCallback<MoviesListResponse.Result>() {
            override fun areItemsTheSame(oldItem: MoviesListResponse.Result, newItem: MoviesListResponse.Result): Boolean {
                return oldItem.id == oldItem.id
            }

            override fun areContentsTheSame(oldItem: MoviesListResponse.Result, newItem: MoviesListResponse.Result): Boolean {
                return oldItem == newItem
            }
        }
    }
}
