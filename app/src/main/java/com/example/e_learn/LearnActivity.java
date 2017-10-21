package com.example.e_learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Gama on 6/4/17.
 */

public class LearnActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    Button nextWord;
    Button star;
    int starCount=0;
    Animation animation1;
    Animation animation2;
    TextView Explain;
    TextView Example;
    TextView spell1;
    TextView spell2;
    String Explain1;
    String Explain2;
    String Example1;
    String Example2;
    String spell11;
    String spell12;
    String spell21;
    String spell22;
    TextView word;
    int Number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        Intent intent = getIntent();
        String SceneName=intent.getStringExtra("SceneName");
        TextView Title = (TextView) findViewById(R.id.TitleText);
        Title.getBackground().setAlpha(125);
        Title.setGravity(Gravity.CENTER);
        Title.setText("当前场景："+SceneName);
        word = (TextView) findViewById(R.id.word);
        word.setText("school");
        star = (Button) findViewById(R.id.star);
        star.setOnClickListener(this);

        spell1 = (TextView) findViewById(R.id.spell1);
        spell2 = (TextView) findViewById(R.id.spell2);

        nextWord = (Button) findViewById(R.id.next);
        nextWord.setOnClickListener(this);
        nextWord.setOnTouchListener(this);
        animation1 = AnimationUtils.loadAnimation(LearnActivity.this, R.anim.up);
        animation2 = AnimationUtils.loadAnimation(LearnActivity.this, R.anim.down);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                nextWord.startAnimation(animation2);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                nextWord.startAnimation(animation1);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        nextWord.startAnimation(animation1);

        Explain = (TextView) findViewById(R.id.explain);
        Explain.setText("  n. 学校；学院；学派；鱼群\n  vt. 教育");

        Example = (TextView) findViewById(R.id.example);
        Example.setText("∆ School is a place where the students is educated.\n\n∆ Even the good students say homework is what they most dislike about school.");

        Explain1 = new String("  n. 教室；课堂");
        Explain2 = Explain.getText().toString();

        Example1 = new String("∆ The boy bounced out of the classroom.\n\n∆ Students learned the practical application of the theory they had learned in the classroom.");
        Example2 = Example.getText().toString();

        spell11 = spell1.getText().toString();
        spell12 = spell2.getText().toString();

        spell21 = new String("英[ˈklɑ:sru:m]");
        spell22 = new String("美[ˈklæsru:m]");

        Number = 1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.star:
                if (starCount == 0) {
                    star.setBackgroundResource(R.drawable.star2);
                    starCount = 1;
                } else if (starCount == 1) {
                    star.setBackgroundResource(R.drawable.star);
                    starCount = 0;
                }
                break;
            case R.id.next:
                nextWord.startAnimation(animation1);
                if (Number==1) {
                    Explain.setText(Explain1);
                    Example.setText(Example1);
                    spell1.setText(spell21);
                    spell2.setText(spell22);
                    word.setText("classroom");
                    Number = 2;
                } else if (Number == 2) {
                    Explain.setText(Explain2);
                    Example.setText(Example2);
                    spell1.setText(spell11);
                    spell2.setText(spell12);
                    word.setText("school");
                    Number = 1;
                }
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {

        }
        return false;
    }
}
