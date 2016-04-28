package kr.pe.burt.android.lib.faimageview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.ArrayList;

import kr.pe.burt.android.lib.androidchannel.Timer;

/**
 * Created by burt on 15. 10. 22..
 */
public class FAImageView extends ImageView {

    public interface OnStartAnimationListener {
        void onStartAnimation();
    }

    public interface OnFinishAnimationListener {
        void onFinishAnimation(boolean isLoopAnimation);
    }

    public interface OnFrameChangedListener {
        void onFrameChanged(int index);
    }

    private final static int DEFAULT_INTERVAL = 1000;       // 1s

    Timer timer;
    int interval = DEFAULT_INTERVAL;

    ArrayList<Drawable> drawableList;
    int currentFrameIndex = 0;
    boolean loop = false;
    boolean didStoppedAnimation = false;
    int animationRepeatCount = 1;
    boolean restoreFirstFrameWhenFinishAnimation = true;

    private OnStartAnimationListener    startAnimationListener  = null;
    private OnFrameChangedListener      frameChangedListener    = null;
    private OnFinishAnimationListener   finishAnimationListener = null;

    public FAImageView(Context context) {
        this(context, null);
    }

    public FAImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FAImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * set inteval in milli seconds
     * @param interval
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }

    @SuppressWarnings("deprecation")
    public void addImageFrame(int resId) {

        if(drawableList == null) {
            drawableList = new ArrayList<>();
            setImageDrawable(getContext().getResources().getDrawable(resId));
        }
        drawableList.add(getContext().getResources().getDrawable(resId));

    }

    public void startAnimation() {

        if(drawableList == null || drawableList.size() == 0) {
            throw new IllegalStateException("You shoud add frame at least one frame");
        }

        didStoppedAnimation = false;

        if(startAnimationListener != null) {
            startAnimationListener.onStartAnimation();
        }

        currentFrameIndex = 0;
        setImageDrawable(drawableList.get(currentFrameIndex));


        if(timer == null) {
            timer = new Timer(interval, new Timer.OnTimer() {
                @Override
                public void onTime(Timer timer) {
                    currentFrameIndex++;
                    if(currentFrameIndex == drawableList.size()) {
                        if(loop) {
                            if(finishAnimationListener != null) {
                                finishAnimationListener.onFinishAnimation(loop);
                            }
                            currentFrameIndex = 0;
                        } else {
                            animationRepeatCount--;

                            if(animationRepeatCount == 0) {
                                currentFrameIndex = drawableList.size() - 1;

                                stopAnimaion();

                                if(finishAnimationListener != null) {
                                    finishAnimationListener.onFinishAnimation(loop);
                                }

                            } else {
                                currentFrameIndex = 0;
                            }
                        }
                    }

                    if ( didStoppedAnimation == false ) {
                        if (frameChangedListener != null) {
                            frameChangedListener.onFrameChanged(currentFrameIndex);
                        }
                        setImageDrawable(drawableList.get(currentFrameIndex));
                    } else {
                        if(restoreFirstFrameWhenFinishAnimation) {
                            currentFrameIndex = 0;
                            setImageDrawable(drawableList.get(currentFrameIndex));
                        }
                    }
                }
            });
            timer.stop();
        }
        if(timer.isAlive() == false) {
            timer.start();
        }
    }

    public void stopAnimaion() {
        if(timer != null && timer.isAlive()) {
            timer.stop();
        }
        timer = null;
        didStoppedAnimation = true;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void setRestoreFirstFrameWhenFinishAnimation(boolean restore) {
        this.restoreFirstFrameWhenFinishAnimation = restore;
    }

    public void setAnimationRepeatCount(int animationRepeatCount) {
        this.animationRepeatCount = animationRepeatCount;
    }

    public void reset() {
        stopAnimaion();
        drawableList.clear();
        drawableList = null;
    }

    public void setOnStartAnimationListener(OnStartAnimationListener listener) {
        startAnimationListener = listener;
    }

    public void setOnFrameChangedListener(OnFrameChangedListener listener) {
        frameChangedListener = listener;
    }

    public void setOnFinishAnimationListener(OnFinishAnimationListener listener) {
        finishAnimationListener = listener;
    }
}
