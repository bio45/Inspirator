package com.neek.tech.inspirator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neek.tech.inspirator.datalayer.logic.RandomGenerator;
import com.neek.tech.inspirator.model.Quote;

public class NotificationActivity extends AppCompatActivity {

    private static final String QUOTATION = "\"";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);
        ImageView closeIcon = (ImageView) findViewById(R.id.closeIcon);
        TextView messageTextView = (TextView) findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) findViewById(R.id.authorTextView);

        closeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //TODO - Fetch random message from SQLite DB and set message and author textviews.

        //For now, using mock data here.
        Quote mockQuote = Quote.getMockQuote();

        StringBuilder sb = new StringBuilder();
        sb.append(mockQuote.getMessage());
        sb.insert(0, QUOTATION);
        sb.insert(sb.length(), QUOTATION); //TODO - Move this to model class.

        messageTextView.setText(sb.toString());
        authorTextView.setText(mockQuote.getAuthor());


        rootLayout.setBackgroundColor(RandomGenerator.getRandomColorId(this));

    }


    @Override
    protected void onResume() {
        super.onResume();

        //TODO - Play sound in bg
    }

    @Override
    protected void onPause() {
        super.onPause();
        //TODO - pause sound.
    }

    @Override
    protected void onStop() {
        super.onStop();
        //TODO - stop sound
    }
}
