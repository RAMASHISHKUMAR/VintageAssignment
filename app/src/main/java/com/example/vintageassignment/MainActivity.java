package com.example.vintageassignment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static View view1, view2, view3, view4 = null;
    final static int INTERVAL = 1000; // 1000=1sec
    boolean whichColor = true;
    boolean changeColor = true;
    private TextView getScoreTv;
    public int count = 0;

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
        gameCondition();

    }


    private void gameObjective() { // set initial colour
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
                    view1.setBackgroundColor(Color.RED);
                else
                    view1.setBackgroundColor(Color.GRAY);

                if (changeColor) {
                    view2.setBackgroundColor(Color.BLUE);
                } else {
                    view2.setBackgroundColor(Color.GRAY);
                }

                if (changeColor) {
                    view3.setBackgroundColor(Color.YELLOW);
                } else {
                    view3.setBackgroundColor(Color.GRAY);
                }

                if (changeColor) {
                    view4.setBackgroundColor(Color.GREEN);
                } else {
                    view4.setBackgroundColor(Color.GRAY);
               }

            }

        });
    }

    private void gameCondition() {
        if (changeColor) {
            view1.setBackgroundColor(Color.GRAY);
            view1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getScoreTv.setText(String.valueOf(count));
                    count++;
                }
            });

        }
    }




}