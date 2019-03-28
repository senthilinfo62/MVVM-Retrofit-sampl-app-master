package com.dasfilm.azzeddine.dasfilm.DataSource;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;
import android.util.Log;

import com.dasfilm.azzeddine.dasfilm.Entities.Movie;
import com.dasfilm.azzeddine.dasfilm.dataModels.TMDBWebService;

import java.util.concurrent.Executor;

/**
 * Created by azeddine on 3/31/18.
 */

public class MoviesInTheaterDataSourceFactory extends DataSource.Factory {
    private static final String TAG = "MoviesInTheaterDataSour";
    MoviesInTheaterDataSource moviesDataSource;
    MutableLiveData<MoviesInTheaterDataSource> mutableLiveData;
    Executor executor;
    TMDBWebService webService;

    public MoviesInTheaterDataSourceFactory(Executor executor, TMDBWebService webService) {
        
      this.executor = executor;
      this.webService = webService;
      mutableLiveData = new MutableLiveData<>();
    }

    @Override
    public DataSource create() {
        Log.d(TAG, "create: ");
                moviesDataSource = new MoviesInTheaterDataSource(executor,webService);
                mutableLiveData.postValue(moviesDataSource);
                return moviesDataSource;
    }

    public MutableLiveData<MoviesInTheaterDataSource> getMutableLiveData() {
        return mutableLiveData;
    }
}
