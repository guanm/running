package top.imaomao.www.running;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private static final int ANIMATION_DURATION = 8000;
    private static final float SCALE_END = 1.2F;
    private ImageView mSplashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSplashImage = (ImageView)findViewById(R.id.background);
        animateImage();
    }

    private void animateImage() {
        //表示从1f --> 1.13f 的变化过程
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mSplashImage, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mSplashImage, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        set.start();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animateImage2();
            }
        });
    }

    private void animateImage2() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mSplashImage, "scaleX", SCALE_END, 1f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mSplashImage, "scaleY", SCALE_END, 1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        set.start();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animateImage();
            }
        });
    }
}
