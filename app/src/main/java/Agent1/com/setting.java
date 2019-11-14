package Agent1.com;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class setting extends Activity {

    public final String PREFERENCE = " ";
    NotificationManager notificationManager;
    PendingIntent intent;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        Button reset = (Button)findViewById(R.id.reset);
        Button create = (Button)findViewById(R.id.create);



    }
    public void reset(View v){
        setPreferenceClear();
        Intent intent = new Intent(this,startday.class);
        startActivity(intent);
        finish();
    }

    public void setPreferenceClear(){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
