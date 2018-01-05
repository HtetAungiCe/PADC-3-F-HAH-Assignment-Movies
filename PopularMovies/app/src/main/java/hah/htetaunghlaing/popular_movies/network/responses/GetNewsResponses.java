package hah.htetaunghlaing.popular_movies.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import hah.htetaunghlaing.popular_movies.data.vo.MoviesVO;

/**
 * Created by Htet Aung Hlaing on 1/5/2018.
 */

public class GetNewsResponses {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    @SerializedName("popular-movies")
    private List<MoviesVO> popularMovies;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<MoviesVO> getPopularMovies() {
        return popularMovies;
    }
    }

