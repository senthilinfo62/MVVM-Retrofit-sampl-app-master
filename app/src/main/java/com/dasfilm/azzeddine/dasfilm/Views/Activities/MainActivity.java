package com.dasfilm.azzeddine.dasfilm.Views.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dasfilm.azzeddine.dasfilm.APIUtils.NetworkState;
import com.dasfilm.azzeddine.dasfilm.Entities.Movie;
import com.dasfilm.azzeddine.dasfilm.R;
import com.dasfilm.azzeddine.dasfilm.Views.Adapters.MoviesInTheaterAdapter;
import com.dasfilm.azzeddine.dasfilm.viewModels.MoviesInTheaterViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MoviesInTheaterViewModel mMoviesViewModel;
    private RecyclerView mRecyclerView;
    private MoviesInTheaterAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.list);

        adapter = new MoviesInTheaterAdapter(this);

        mMoviesViewModel = ViewModelProviders.of(this).get(MoviesInTheaterViewModel.class);
        mMoviesViewModel.getMoviesInTheaterList().observe(this, new Observer<PagedList<Movie>>() {
            @Override
            public void onChanged(@Nullable PagedList<Movie> movies) {
                Log.d(TAG, "onChanged: "+movies.size());
                adapter.submitList(movies);
            }
        });
        mMoviesViewModel.getNetworkStateLiveData().observe(this, new Observer<NetworkState>() {
            @Override
            public void onChanged(@Nullable NetworkState networkState) {
                Log.d(TAG, "onChanged: network state changed");
                adapter.setNetworkState(networkState);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mRecyclerView.setAdapter(adapter);
    }
}
