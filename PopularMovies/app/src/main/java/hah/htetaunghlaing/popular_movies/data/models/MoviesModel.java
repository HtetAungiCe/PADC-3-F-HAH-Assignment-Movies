package hah.htetaunghlaing.popular_movies.data.models;

import hah.htetaunghlaing.popular_movies.network.HttpUrlConnectionDataAgent;
import hah.htetaunghlaing.popular_movies.network.MoviesDataAgent;

/**
 * Created by Htet Aung Hlaing on 1/4/2018.
 */

public class MoviesModel {

    private static MoviesModel sObjInstance;

    private MoviesDataAgent mMoviesDataAgent;

    private MoviesModel() {
        mMoviesDataAgent= HttpUrlConnectionDataAgent.getObjInstance();
    }

    public static MoviesModel getObjInstance(){

        if(sObjInstance==null){
            sObjInstance=new MoviesModel();
        }
        return sObjInstance;
    }

    /**
     * load movies from network api
     */
    public void loadMovies(){
        mMoviesDataAgent.loadMovies();

    }
}
