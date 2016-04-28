package kr.pe.burt.countexample;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.pe.burt.android.lib.faimageview.FAImageView;

public class MainActivity extends AppCompatActivity {

    FAImageView faImageView;
    Boolean didStartedAnimation = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        faImageView = (FAImageView) findViewById(R.id.faimageview);
        faImageView.setInterval(1000);
        faImageView.setLoop(true);
        faImageView.addImageFrame(R.drawable.number01);
        faImageView.addImageFrame(R.drawable.number02);
        faImageView.addImageFrame(R.drawable.number03);

    }

    @Override
    protected void onResume() {
        super.onResume();
        faImageView.startAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        faImageView.stopAnimaion();
    }
}
