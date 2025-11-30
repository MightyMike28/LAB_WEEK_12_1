package com.example.test_lab_week_12

import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "f9bc93f440d85017111b0d11e7945088"

    // Flow version — clean
    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            val result = movieService.getPopularMovies(apiKey).results
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}
