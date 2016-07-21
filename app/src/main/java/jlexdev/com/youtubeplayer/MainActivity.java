package jlexdev.com.youtubeplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


/** Fuentes:
 *  http://stacktips.com/tutorials/android/youtube-android-player-api-example
 *  https://www.youtube.com/watch?v=a4NT5iBFuZs
 *
 *  Terminal:
 *  (Get Certificate fingerprints  "SHA1:"  )
 *  keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android
 */

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;

    public static final String API_KEY = "AIzaSyCWvH8Ra-GjbN854haDdFfhHfieS5SFpHg";
    public static final String VIDEO_6_GRANDES_HEROES = "VlArN9hyfBU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtube_video);
        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (null == youTubePlayer) return;
        // Start Buffering
        if (!b){
            youTubePlayer.cueVideo(VIDEO_6_GRANDES_HEROES);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Toast.makeText(this, "Falló al Inicializar", Toast.LENGTH_LONG).show();
    }
}
