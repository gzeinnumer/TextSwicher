package com.zein.textswicher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private TextSwitcher textSwitcher;
    private Button prev, next;
    private static final String[] TEXT = {"Hay", "I","Am", "Zein"};
    private int mPosotion = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSwitcher = findViewById(R.id.textSwitcher);
        prev = findViewById(R.id.btnPrev);
        next = findViewById(R.id.btnNext);

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(18);
                return textView;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPosotion<TEXT.length-1){
                    mPosotion=mPosotion+1;
                    textSwitcher.setText(TEXT[mPosotion]);
                }
            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPosotion>0){
                    mPosotion=mPosotion-1;
                    textSwitcher.setText(TEXT[mPosotion]);
                }
            }
        });
    }
}
