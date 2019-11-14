package Agent1.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class main extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textViewp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView)findViewById(R.id.textview);
        textView1 = (TextView)findViewById(R.id.textview1);
        textViewp = (TextView)findViewById(R.id.TextViewp);

        SharedPreferences pref1 = getSharedPreferences("PREFERENCE2",Activity.MODE_PRIVATE);
        String b = pref1.getString("key02",String.valueOf(0));
        textView1.setText("D - "+b);

        SharedPreferences pref = getSharedPreferences("PREFERENCE", Activity.MODE_PRIVATE);
        String a =  pref.getString("key01", String.valueOf(0));
        textView.setText("총 복무일"+ a + "일");

        int p = Integer.parseInt(a);
        int percent = (int) ((double) p / (double) 666 * 100.0);

        String pp = Integer.toString(percent);

        textViewp.setText(pp +"%");



    //-------------------------알림생성---------------------------
        String channelId = "channel";
        String channelName = "Channel Name";
        NotificationManager notifManager = (NotificationManager) getSystemService  (Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(channelId, channelName, importance);
            notifManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelId);
        Intent notificationIntent = new Intent(getApplicationContext(), main.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);

        int requestID = (int) System.currentTimeMillis();

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), requestID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentTitle("소집해제") // required
                .setContentText(pp + "% / "+ "D - "+b)  // required
                .setDefaults(Notification.DEFAULT_ALL) // 알림, 사운드 진동 설정
              //.setAutoCancel(true) // 알림 터치시 반응 후 삭제
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setSmallIcon(android.R.drawable.btn_star).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                .setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)
                .setContentIntent(pendingIntent);

        builder.setOngoing(true);


        notifManager.notify(0, builder.build());



    }



}