# FAImageView

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FAImageView-green.svg?style=flat)](https://android-arsenal.com/details/1/2682)

FAImageView is a Frame Animation ImageView for Android. You can set multiple frame images and start frame animation like UIImageView in iOS. You can animate multiple image like below!

![](FAImageView.gif)

## Setup Gradle

```groovy
dependencies {
	...
    compile 'kr.pe.burt.android.lib:faimageview:0.0.8'
}
```

## Usages

Declare FAImageView widget in the layout xml file.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:orientation="vertical"
    tools:context=".MainActivity"
    >

    <kr.pe.burt.android.lib.faimageview.FAImageView
        android:id="@+id/faimageview1"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"/>


    <kr.pe.burt.android.lib.faimageview.FAImageView
        android:id="@+id/faimageview2"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"/>
</LinearLayout>
```

Set the options whatever you want

```java
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
```
## Callbacks

FAImageView provides some listeners for animation event.

 * for listening to animation start.
  * OnStartAnimationListener
 * for listening to animation completion.
  * OnFinishAnimationListener
 * for listening to animation frame change event
  * OnFrameChangedListener

```java
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
```  	

## APIs

* setInterval(int milli)
 * set frame interval for animation in milli seconds
* addImageFrame(int resId)
* addImageFrame(Drawable drawable)
* addImageFrame(Bitmap bitmap)
 * add an Image Frame
* setLoop(boolean loop)
 * If you want to animate infinitely set true or false. Default value is false.
* setRestoreFirstFrameWhenFinishAnimation(boolean restore)
 * If you want to restore the first frame when animation is finished, set true or false.
* setAnimationRepeatCount(int animationRepeatCount)
 * Only If your animation is not infinity, this value is valuable.       
* startAnimation()
 * start animation
* stopAnimation
 * stop animation
* isAnimating
 * check it's now animating   
* reset
 * clear all resources and stop animation.

   
## MIT License

The MIT License

Copyright © 2015 Sungcheol Kim, http://github.com/skyfe79/FAImageView

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
