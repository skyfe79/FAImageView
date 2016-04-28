package kr.pe.burt.countexample;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        faImageView.setRestoreFirstFrameWhenFinishAnimation(false);
        faImageView.addImageFrame(R.drawable.number01);
        faImageView.addImageFrame(R.drawable.number02);
        faImageView.addImageFrame(R.drawable.number03);

        faImageView.setOnStartAnimationListener(new FAImageView.OnStartAnimationListener() {
            @Override
            public void onStartAnimation() {
                Log.v("FAImageView", "Animation started");
            }
        });

        faImageView.setOnFinishAnimationListener(new FAImageView.OnFinishAnimationListener() {
            @Override
            public void onFinishAnimation(boolean isLoopAnimation) {
                if(isLoopAnimation) {
                    Log.v("FAImageView", "finished an animation cycle.");
                } else {
                    Log.v("FAImageView", "Animation is completed");
                }
            }
        });

        faImageView.setOnFrameChangedListener(new FAImageView.OnFrameChangedListener() {
            @Override
            public void onFrameChanged(int index) {
                Log.v("FAImageView", String.format("frameIndex : %d", index));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    void onStartButtonClicked(View sender) {
        faImageView.startAnimation();
    }

    void onStopButtonClicked(View sender) {
        faImageView.stopAnimation();
    }
}
