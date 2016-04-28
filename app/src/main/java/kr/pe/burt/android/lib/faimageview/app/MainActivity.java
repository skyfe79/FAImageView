package kr.pe.burt.android.lib.faimageview.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.pe.burt.android.lib.faimageview.FAImageView;

public class MainActivity extends AppCompatActivity {

    FAImageView faImageView1, faImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        faImageView1 = (FAImageView)findViewById(R.id.faimageview1);
        faImageView1.setInterval(30);
        faImageView1.setLoop(true);
        faImageView1.addImageFrame(R.drawable.frame01);
        faImageView1.addImageFrame(R.drawable.frame02);
        faImageView1.addImageFrame(R.drawable.frame03);
        faImageView1.addImageFrame(R.drawable.frame04);
        faImageView1.addImageFrame(R.drawable.frame05);
        faImageView1.addImageFrame(R.drawable.frame06);
        faImageView1.addImageFrame(R.drawable.frame07);
        faImageView1.addImageFrame(R.drawable.frame08);
        faImageView1.addImageFrame(R.drawable.frame09);
        faImageView1.addImageFrame(R.drawable.frame10);


        faImageView2 = (FAImageView)findViewById(R.id.faimageview2);
        faImageView2.setInterval(100);
        faImageView2.setLoop(true);
        faImageView2.addImageFrame(R.drawable.frame01);
        faImageView2.addImageFrame(R.drawable.frame02);
        faImageView2.addImageFrame(R.drawable.frame03);
        faImageView2.addImageFrame(R.drawable.frame04);
        faImageView2.addImageFrame(R.drawable.frame05);
        faImageView2.addImageFrame(R.drawable.frame06);
        faImageView2.addImageFrame(R.drawable.frame07);
        faImageView2.addImageFrame(R.drawable.frame08);
        faImageView2.addImageFrame(R.drawable.frame09);
        faImageView2.addImageFrame(R.drawable.frame10);

    }

    @Override
    protected void onResume() {
        super.onResume();
        faImageView1.startAnimation();
        faImageView2.startAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        faImageView1.stopAnimation();
        faImageView2.stopAnimation();
    }
}
