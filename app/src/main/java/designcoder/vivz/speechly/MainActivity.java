package designcoder.vivz.speechly;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private TextView mTextTime;
    private android.os.Handler handler;
    private long timeRemaining = 50000;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(this);
        handler =  new android.os.Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.d("DREW", "run was called");
                timeRemaining = timeRemaining - 1000;
                if(timeRemaining > 0){
                    handler.postDelayed(this,1000);
                }

            }
        };

        handler.postDelayed(runnable,1000);


    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked)
        {
            Toast.makeText(this,"ON",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"OFF",Toast.LENGTH_SHORT).show();
        }
    }
}
