package hah.htetaunghlaing.popular_movies.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import hah.htetaunghlaing.popular_movies.PopularMoviesApp;
import hah.htetaunghlaing.popular_movies.R;
import hah.htetaunghlaing.popular_movies.adapter.PopularMoviesAdapter;
import hah.htetaunghlaing.popular_movies.data.models.MoviesModel;
import hah.htetaunghlaing.popular_movies.delegates.MoviesItemDelegates;
import hah.htetaunghlaing.popular_movies.events.LoadMoviesEvent;
import hah.htetaunghlaing.popular_movies.network.MoviesDataAgent;

public class MainActivity extends AppCompatActivity implements MoviesItemDelegates{

    @BindView(R.id.rv_popular_movies)RecyclerView rvMovies;



    @BindView(R.id.toolbar)Toolbar toolbar;

    private PopularMoviesAdapter popularMoviesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        popularMoviesAdapter=new PopularMoviesAdapter(this);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvMovies.setLayoutManager(layoutManager);
        rvMovies.setAdapter(popularMoviesAdapter);

        MoviesModel.getObjInstance().loadMovies();



    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onTapMoviesItem() {
        Intent intent=new Intent(getApplicationContext(),MovieDetailsActivity.class);
        startActivity(intent);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadMoviesEvent event){
        Log.d(PopularMoviesApp.Log_Tap,"onNewsLoaded : "+event.getNewsList());
        popularMoviesAdapter.setMovies(event.getNewsList());

    }
}
