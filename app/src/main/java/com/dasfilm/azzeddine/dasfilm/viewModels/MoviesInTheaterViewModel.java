package com.dasfilm.azzeddine.dasfilm.viewModels;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.util.Log;

import com.dasfilm.azzeddine.dasfilm.APIUtils.NetworkState;
import com.dasfilm.azzeddine.dasfilm.APIUtils.ServiceGenerator;
import com.dasfilm.azzeddine.dasfilm.DataSource.MoviesInTheaterDataSourceFactory;
import com.dasfilm.azzeddine.dasfilm.DataSource.MoviesInTheaterDataSource;
import com.dasfilm.azzeddine.dasfilm.Entities.Movie;
import com.dasfilm.azzeddine.dasfilm.dataModels.TMDBWebService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by azeddine on 3/29/18.
 */

public class MoviesInTheaterViewModel extends ViewModel {
    private static final String TAG = "TheaterViewModel";
    private LiveData<PagedList<Movie>> moviesInTheaterList;
    private LiveData<NetworkState> networkStateLiveData;
    private Executor executor;
    private LiveData<MoviesInTheaterDataSource> dataSource;


    public MoviesInTheaterViewModel() {
        Log.d(TAG, "MoviesInTheaterViewModel: ");
        executor = Executors.newFixedThreadPool(5);
        TMDBWebService webService = ServiceGenerator.createService(TMDBWebService.class);
        MoviesInTheaterDataSourceFactory factory = new MoviesInTheaterDataSourceFactory(executor,webService);
        dataSource =  factory.getMutableLiveData();

        networkStateLiveData = Transformations.switchMap(factory.getMutableLiveData(), new Function<MoviesInTheaterDataSource, LiveData<NetworkState>>() {
            @Override
            public LiveData<NetworkState> apply(MoviesInTheaterDataSource source) {
                Log.d(TAG, "apply: network change");
                return source.getNetworkState();
            }
        });

        PagedList.Config pageConfig = (new PagedList.Config.Builder())
                                                .setEnablePlaceholders(true)
                                                .setInitialLoadSizeHint(10)
                                                .setPageSize(20).build();

        moviesInTheaterList = (new LivePagedListBuilder<Long,Movie>(factory,pageConfig))
                                                    .setBackgroundThreadExecutor(executor)
                                                    .build();

    }

    public LiveData<PagedList<Movie>> getMoviesInTheaterList() {
        Log.d(TAG, "getMoviesInTheaterList: ");
        return moviesInTheaterList;
    }

    public LiveData<NetworkState> getNetworkStateLiveData() {
        return networkStateLiveData;
    }
}

