package com.example.moviedetailapp.rest.response

import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    @SerializedName("page")
    val page: Int, // 2
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int, // 13
    @SerializedName("total_results")
    val totalResults: Int // 256
) {
    data class Result(
        @SerializedName("adult")
        val adult: Boolean, // false
        @SerializedName("backdrop_path")
        val backdropPath: String, // //kfKW0HBObLAd4Lj27XX5QoLWmGe.jpg
        @SerializedName("genre_ids")
        val genreIds: List<Int>,
        @SerializedName("id")
        val id: Int, // 649609
        @SerializedName("original_language")
        val originalLanguage: String, // en
        @SerializedName("original_title")
        val originalTitle: String, // Renfield
        @SerializedName("overview")
        val overview: String, // Having grown sick and tired of his centuries as Dracula's lackey,
        // Renfield finds a new lease on life — and maybe even redemption — when he falls for feisty, perennially angry traffic cop Rebecca Quincy.
        @SerializedName("popularity")
        val popularity: Double, // 174.04
        @SerializedName("poster_path")
        val posterPath: String, // //2OaprROMZZeiWsydjGUIkXrv2Z3.jpg
        @SerializedName("release_date")
        val releaseDate: String, // 2023-04-14
        @SerializedName("title")
        val title: String, // Renfield
        @SerializedName("video")
        val video: Boolean, // false
        @SerializedName("vote_average")
        val voteAverage: Double, // 6.6
        @SerializedName("vote_count")
        val voteCount: Int // 35
    )
}