package com.udacity.popularmovies1.popularmovies_stage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.udacity.popularmovies1.popularmovies_stage1.model.ApiModel;
import com.udacity.popularmovies1.popularmovies_stage1.model.Movie;
import com.udacity.popularmovies1.popularmovies_stage1.retrofit.RetrofitApiInterface;
import com.udacity.popularmovies1.popularmovies_stage1.retrofit.RetrofitServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements MoviesAdapter.ListItemClickListener {

    private final String API_KEY = "";

    private final int NUMBER_OF_COLUMNS = 2;

    private Call<ApiModel> callMovies;
    private RetrofitApiInterface apiModel;
    private MoviesAdapter movieAdapter;

    private List<Movie> moviesList;

    //Views
    private ProgressBar loader;
    private RecyclerView moviesContainer;
    private TextView errorMissingApi;
    ///////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retrieve the views
        loader = (ProgressBar) findViewById(R.id.loader_pb);
        moviesContainer = (RecyclerView) findViewById(R.id.movies_gv);
        errorMissingApi = (TextView) findViewById(R.id.error_message);

        if(API_KEY != null && API_KEY != "") {

            //Create and the layout manager of the recycler view
            GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, NUMBER_OF_COLUMNS);
            moviesContainer.setLayoutManager(gridLayoutManager);

            //Create and set the adapter of the recycler view
            movieAdapter = new MoviesAdapter(this, this);
            moviesContainer.setAdapter(movieAdapter);


            //Create the retrofit, used for retrieve and parse JSON of movies
            Retrofit retrofit = RetrofitServices.getRetrofitInstance();
            apiModel = retrofit.create(RetrofitApiInterface.class);
        }
        else
        {
            showErrorMessage();
        }
    }

    /*
    Get the movies list sorted by Top Rated
     */
    private void getMoviesSortedByTopRated(){
        if (apiModel == null) return;
        setShowLoader(true);
        callMovies = apiModel.topRatedsList(API_KEY);
        retrieveMovies();
    }

    /*
    Get the movies list sorted by Popular
     */
    private void getMoviesSortedByPopular(){
        if (apiModel == null) return;
        setShowLoader(true);
        callMovies = apiModel.popularsList(API_KEY);
        retrieveMovies();
    }



    /*
    Using Retrofit enqueue method retrieve the movies list automatically on a background thread
     */
    private void retrieveMovies(){
        callMovies.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                moviesList = response.body().getResults();
                setShowLoader(false);
                //Set the retrieve list of movies into the adapter of GridView
                movieAdapter.swapMoviesList(moviesList);
            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {
                //TODO: manage errors
            }
        });
    }

    private void showErrorMessage(){
        moviesContainer.setVisibility(View.INVISIBLE);
        loader.setVisibility(View.INVISIBLE);
        errorMissingApi.setVisibility(View.VISIBLE);
    }

    /*
    When app is loading movies a progress bar is shoed and the grid is hidden, and when movies are loaded grid is visible and progress bar is hidden
     */
    private void setShowLoader(boolean shows){
        if (shows){
            loader.setVisibility(View.VISIBLE);
            moviesContainer.setVisibility(View.INVISIBLE);
        }
        else{
            loader.setVisibility(View.INVISIBLE);
            moviesContainer.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) item.getActionView();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, getResources().getStringArray(R.array.spinner_movie_sort));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sortType = adapterView.getItemAtPosition(i).toString();
                if (sortType.equals(getResources().getString(R.string.sort_popular))) {
                    getMoviesSortedByPopular();
                }
                else if(sortType.equals(getResources().getString(R.string.sort_top_rated))) {
                    getMoviesSortedByTopRated();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner.setAdapter(adapter);
        return true;
    }

    @Override
    public void onListItemClick(int positionClicked) {
        Toast.makeText(this, moviesList.get(positionClicked).getTitle(), Toast.LENGTH_LONG).show();
    }
}
