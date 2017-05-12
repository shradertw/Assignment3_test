package lwtech.itad230.assignment3;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.ACTION_SET_ALARM;
import static android.provider.AlarmClock.EXTRA_HOUR;
import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static android.provider.AlarmClock.EXTRA_MINUTES;

public class startAlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_alarm);
    }

    public void submit(View v) {
        //Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);

        EditText hourText = (EditText) findViewById(R.id.editText);
        EditText minuteText = (EditText) findViewById(R.id.editText2);
        EditText nameText = (EditText) findViewById(R.id.editText3);

        String hourString = hourText.getText().toString(); // get the hours as a string
        String minuteString = minuteText.getText().toString(); // get the minutes as a string
        String nameString = nameText.getText().toString(); // get the seconds as a string

        // if the length of any string is less that 1, set that value to 0
        if (hourString.length() < 1)
            hourString = "0";
        if (minuteString.length() < 1)
            minuteString = "0";
        //if(nameString.length() < 1)
        //    nameString = "";

        int hourInt = Integer.parseInt(hourString); // convert the hours string to an int, and convert to seconds
        int minuteInt = Integer.parseInt(minuteString); // convert the minutes string to an int, and convert to seconds

        if (hourInt > 23)
            hourInt = 23;
        else if (hourInt < 0)
            hourInt = 0;
        if (minuteInt > 59)
            minuteInt = 59;
        else if (minuteInt < 0)
            minuteInt = 0;

        Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(EXTRA_HOUR, hourInt)
                .putExtra(EXTRA_MINUTES, minuteInt)
                .putExtra(EXTRA_MESSAGE, nameString);

        if (alarmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(alarmIntent);
        }
    }
}
