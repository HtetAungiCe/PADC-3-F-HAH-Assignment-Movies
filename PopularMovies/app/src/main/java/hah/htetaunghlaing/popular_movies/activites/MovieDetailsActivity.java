package hah.htetaunghlaing.popular_movies.activites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import butterknife.BindView;
import butterknife.ButterKnife;
import hah.htetaunghlaing.popular_movies.R;
import hah.htetaunghlaing.popular_movies.adapter.MovieDetailsAdapter;
import hah.htetaunghlaing.popular_movies.delegates.MoviesItemDelegates;


/**
 * Created by Htet Aung Hlaing on 12/15/2017.
 */


public class MovieDetailsActivity extends AppCompatActivity implements MoviesItemDelegates{

@BindView(R.id.rv_for_movie_details)
    RecyclerView recyclerView;

public MovieDetailsAdapter movieDetailsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_movie_details);
        ButterKnife.bind(this,this);
        movieDetailsAdapter=new MovieDetailsAdapter(this);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplication(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(movieDetailsAdapter);

    }

    @Override
    public void onTapMoviesItem() {

    }
}
