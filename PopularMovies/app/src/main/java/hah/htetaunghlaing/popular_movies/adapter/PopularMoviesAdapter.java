package hah.htetaunghlaing.popular_movies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hah.htetaunghlaing.popular_movies.R;
import hah.htetaunghlaing.popular_movies.data.vo.MoviesVO;
import hah.htetaunghlaing.popular_movies.delegates.MoviesItemDelegates;
import hah.htetaunghlaing.popular_movies.viewholder.MoviesViewHolder;

/**
 * Created by Htet Aung Hlaing on 12/7/2017.
 */

public class PopularMoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder>{

private MoviesItemDelegates nMoviesItemDelegates;
private List<MoviesVO> mMoviesList;
public PopularMoviesAdapter(MoviesItemDelegates moviesItemDelegates){
    nMoviesItemDelegates=moviesItemDelegates;
    mMoviesList = new ArrayList<>();

}

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View moviesView=inflater.inflate(R.layout.item_popular_movies,parent,false);
        MoviesViewHolder moviesViewHolder=new MoviesViewHolder(moviesView,nMoviesItemDelegates);



        return moviesViewHolder;
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
            holder.setMovies(mMoviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }



    public void setMovies(List<MoviesVO> moviesList){
        mMoviesList=moviesList;
        notifyDataSetChanged();

    }}
