package com.jasjotsingh.colorstatelistinbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button okButton = (Button)findViewById(R.id.okButton);

        // Show ok button state info.
        final TextView okButtonState = (TextView)findViewById(R.id.okButtonState);

        // Enable OK Button
        Button enableOkButton = (Button)findViewById(R.id.enableOkButton);
        enableOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                okButton.setEnabled(true);
                okButtonState.setText("Ok Button is enabled.");
            }
        });

        // Disable OK Button
        Button disableOkButton = (Button)findViewById(R.id.disableOkButton);
        disableOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                okButton.setEnabled(false);
                okButtonState.setText("Ok Button is disabled.");
            }
        });

        // Listen to touch event.
        okButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // Get touch action.
                int action = motionEvent.getAction();

                if(action == MotionEvent.ACTION_DOWN) {
                    // If pressed.
                    okButtonState.setText("Ok Button is pressed.");
                }else if(action == MotionEvent.ACTION_UP) {
                    // If released.
                    okButtonState.setText("Ok Button is released.");
                }
                return false;
            }
        });
    }
}
