package cucompanionteam.news;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;
import io.fabric.sdk.android.Fabric;




public class news extends ListActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "vGNHifQS3nYEy7mYAfTvzJSMq";
    private static final String TWITTER_SECRET = "RTqZ4RCWAklp0aCaGPegJE6J97oQaWI6fVwXk3FWd8F9Y93QaP";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("covcampus")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();

        setListAdapter(adapter);
    }

    }

