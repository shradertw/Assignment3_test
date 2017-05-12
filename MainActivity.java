package lwtech.itad230.assignment3;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;
import static android.provider.MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButtonTimer(View v)
    {
        Intent timerIntent = new Intent(this, startTimer.class);
        startActivity(timerIntent);
    }

    public void clickButtonAlarm(View v)
    {
        Intent alarmIntent = new Intent(this, startAlarmActivity.class);
        // Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
        startActivity(alarmIntent);
    }

    public void clickButtonCamera(View v)
    {
        Intent cameraIntent = new Intent(INTENT_ACTION_STILL_IMAGE_CAMERA);
        startActivity(cameraIntent);
    }
}

