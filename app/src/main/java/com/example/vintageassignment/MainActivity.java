package com.example.vintageassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static View view1, view2, view3, view4 = null;
    final static int INTERVAL = 1000; // 1000=1sec
    // private static View myView = null;
    boolean whichColor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = findViewById(R.id.View1);
        view2 = findViewById(R.id.View2);
        view3 = findViewById(R.id.View3);
        view4 = findViewById(R.id.View4);

        gameObjective();

    }

    private void gameObjective() { // set initial colour
        view1.setBackgroundColor(Color.RED);
        view2.setBackgroundColor(Color.BLUE);
        view3.setBackgroundColor(Color.YELLOW);
        view4.setBackgroundColor(Color.GREEN);

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    updateColor();
                    whichColor = !whichColor;
                }
            }
        }).start();
    }

    private void updateColor() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (whichColor)
                    view1.setBackgroundColor(Color.RED);
                else
                    view1.setBackgroundColor(Color.GRAY);

//                if (whichColor) {
//                    view2.setBackgroundColor(Color.BLUE);
//                } else {
//                    view2.setBackgroundColor(Color.GRAY);
//                }
//
//                if (whichColor) {
//                    view3.setBackgroundColor(Color.YELLOW);
//                } else {
//                    view3.setBackgroundColor(Color.GRAY);
//                }
//
//                if (whichColor) {
//                    view4.setBackgroundColor(Color.GREEN);
//                } else {
//                    view4.setBackgroundColor(Color.GRAY);
//                }


            }
        });
    }

}
