package lwtech.itad230.assignment3;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_LENGTH;

public class startTimer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_timer);
    }

    public void submit(View v) {
        //Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_TIMER);

        EditText hoursText = (EditText) findViewById(R.id.editText);
        EditText minutesText = (EditText) findViewById(R.id.editText2);
        EditText secondsText = (EditText) findViewById(R.id.editText3);

        String hoursString = hoursText.getText().toString(); // get the hours as a string
        String minutesString = minutesText.getText().toString(); // get the minutes as a string
        String secondsString = secondsText.getText().toString(); // get the seconds as a string

        // if the length of any string is less that 1, set that value to 0
        if (hoursString.length() < 1)
            hoursString = "0";
        if (minutesString.length() < 1)
            minutesString = "0";
        if (secondsString.length() < 1)
            secondsString = "0";

        int hoursInt = Integer.parseInt(hoursString) * 60 * 60; // convert the hours string to an int, and convert to seconds
        int minutesInt = Integer.parseInt(minutesString) * 60; // convert the minutes string to an int, and convert to seconds
        int secondsInt = Integer.parseInt(secondsString); // convert the seconds string to an int

        int timerLength = hoursInt + minutesInt + secondsInt;

        Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(EXTRA_LENGTH, timerLength); // input the total timer length in seconds (up to 24 hours)

        if (alarmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(alarmIntent);
        }
    }
}
