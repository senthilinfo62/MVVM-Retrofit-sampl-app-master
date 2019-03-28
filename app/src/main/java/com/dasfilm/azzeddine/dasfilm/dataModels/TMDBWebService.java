package com.dasfilm.azzeddine.dasfilm.dataModels;

import com.dasfilm.azzeddine.dasfilm.Entities.Actor;
import com.dasfilm.azzeddine.dasfilm.Entities.Movie;
import com.dasfilm.azzeddine.dasfilm.Entities.Review;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by azeddine on 3/27/18.
 */

public interface TMDBWebService {


    /**
     * Get a list of movies in theatres.
     */
    @GET("movie/now_playing")
    Call<ResponseBody> getMoviesInTheater(@Query("page") long pageNumber);


    /**
     * Get a list of upcoming movies in theatres.
     */

    @GET("movie/upcoming")
    Call<Movie> getUpcomingMovies();

    /**
     * Get the most newly created movie.
     */
    @GET("movie/latest")
    Call<Movie> getLatestMovies();

    /**
     * Get the primary information about a movie.
     */
    @GET("movie/{movie_id}")
    Call<Movie> getMovieDetailsById(@Path("movie_id") int id);

    /**
     * Get the cast and crew for a movie.
     */
    @GET("movie/{movie_id}/credits")
    Call<Actor> getMovieCredits(@Path("movie_id") int id);
    /**
     * Get the videos that have been added to a movie.
     */
    @GET("movie/{movie_id}/videos")
    Call<ResponseBody> getMovieVideo(@Path("movie_id") int id);

    /**
     * Get a list of the current popular movies on TMDb.
     */
    @GET("movie/popular")
    Call<Movie> getPopularMovies();

    /**
     * Get the top rated movies on TMDb.
     */
    @GET("movie/top_rated")
    Call<Movie> getTopRatedMovies();

    /**
     * Get the user reviews for a movie.
     */
    @GET("movie/{movie_id}/reviews")
    Call<Review> getMovieUserReview(@Path("movie_id") int id);

    /**
     * Get the primary person details by id.
     */
    @GET("person/{person_id}")
    Call<Actor> getPersonDetailsById(@Path("person_id") int id);

    /**
     * Get the movie credits for a person.
     */
    @GET("person/{person_id}/movie_credits")
    Call<Movie> getPersonMovieCredits(@Path("person_id") int id);

    /**
     * Get the images that this person has been tagged in.
     */
    @GET("person/{person_id}/tagged_images")
    Call<ResponseBody> getPersonTaggedImages(@Path("person_id") int id);

}
