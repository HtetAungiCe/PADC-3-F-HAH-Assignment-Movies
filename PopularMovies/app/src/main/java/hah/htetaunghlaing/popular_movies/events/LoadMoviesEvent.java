package hah.htetaunghlaing.popular_movies.events;

import java.util.List;

import hah.htetaunghlaing.popular_movies.data.vo.MoviesVO;

/**
 * Created by Htet Aung Hlaing on 1/5/2018.
 */

public class LoadMoviesEvent {
    private List<MoviesVO> newsList;

    public LoadMoviesEvent(List<MoviesVO> newsList) {
        this.newsList = newsList;
    }

    public List<MoviesVO> getNewsList() {
        return newsList;
    }
}
