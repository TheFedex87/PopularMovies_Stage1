package com.udacity.popularmovies1.popularmovies_stage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.popularmovies1.popularmovies_stage1.model.Movie;

public class MovieDetailsActivity extends AppCompatActivity {
    private final String URL_BASE_MOVIE_BANNER = "http://image.tmdb.org/t/p/w185";

    private ImageView poster;
    private TextView movieTitle;
    private TextView movieReleaseDate;
    private TextView movieVoteAverage;
    private TextView movieOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        poster = findViewById(R.id.movie_poster);
        movieTitle = findViewById(R.id.movie_title);
        movieReleaseDate = findViewById(R.id.movie_release_date);
        movieVoteAverage = findViewById(R.id.movie_vote_average);
        movieOverview = findViewById(R.id.movie_overview);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            Movie movie = (Movie)b.getParcelable(Movie.CLASS_STRING_EXTRA);
            Toast.makeText(this, movie.getTitle(), Toast.LENGTH_LONG).show();

            String imageUrl = URL_BASE_MOVIE_BANNER + movie.getBackdropPath();
            Picasso.with(this).load(imageUrl).into(poster);

            movieTitle.setText(movie.getTitle());
            movieReleaseDate.setText(movie.getReleaseDate());
            movieVoteAverage.setText(String.valueOf(movie.getVoteAverage()));
            movieOverview.setText(movie.getOverview());
        }
    }
}
