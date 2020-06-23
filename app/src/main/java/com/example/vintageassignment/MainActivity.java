package com.example.vintageassignment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static android.graphics.Color.GRAY;

public class MainActivity extends AppCompatActivity {

    private static View view1, view2, view3, view4= null;
    final static int INTERVAL = 1000; // 1000=1sec
    final static int INTERVAL_ = 1000;

    boolean whichColor = true;
    boolean changeColor = true;
    private TextView getScoreTv;
    public int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = findViewById(R.id.View1);
        view2 = findViewById(R.id.View2);
        view3 = findViewById(R.id.View3);
        view4 = findViewById(R.id.View4);

        getScoreTv = findViewById(R.id.GetScoreTV);

        gameObjective();
        gameObjective_();
        gameCondition();
    }

    private void gameObjective() {
        view1.setBackgroundColor(Color.RED);
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    updateColor();
                    changeColor = !changeColor;
                }
            }
        }).start();
    }


    private void updateColor() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (changeColor)
                    view1.setBackgroundColor(Color.GRAY);
                else
                    view1.setBackgroundColor(Color.RED);

                if (view2.getVisibility() == View.VISIBLE) {
                    view2.setVisibility(View.INVISIBLE);
                } else {
                    view2.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private void gameObjective_() {
        view3.setBackgroundColor(Color.YELLOW);
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(INTERVAL_);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    updateColor_();
                    whichColor = !whichColor;
                }
            }
        }).start();
    }

    private void updateColor_() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (whichColor)
                    view3.setBackgroundColor(Color.GREEN);
                else
                    view3.setBackgroundColor(Color.YELLOW);

                if (whichColor)
                    view4.setBackgroundColor(Color.YELLOW);
                else
                    view4.setBackgroundColor(Color.GREEN);

            }
        });
    }

    private void gameCondition() {
        if (changeColor) {
            view1.setBackgroundColor(GRAY);
            view1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getScoreTv.setText(String.valueOf(count));
                    count++;
                }
            });

            view2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getScoreTv.setText(String.valueOf(count));
                    count++;
                }
            });
        }

    }

}