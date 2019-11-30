package Agent1.com;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.NotificationCompat;

        import android.app.Activity;
        import android.app.AlarmManager;
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
        import android.util.Log;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.w3c.dom.Text;

        import java.util.Calendar;

public class main extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textViewp;

    long today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView)findViewById(R.id.textview);
        textView1 = (TextView)findViewById(R.id.textview1);
        textViewp = (TextView)findViewById(R.id.TextViewp);



        /* 오늘 날짜 구하기 */
        Calendar calendar = Calendar.getInstance();
        int tYear=calendar.get(Calendar.YEAR);
        int tMonth=calendar.get(Calendar.MONTH);
        int tDay=calendar.get(Calendar.DAY_OF_MONTH);

        today=calendar.getTimeInMillis()/(24*60*60*1000);
        int r1 = (int)(long) today;// 현재날짜 int로 변환
        //-------------------------------------------------------------------------------------
        //소집해재날 가져오기
        SharedPreferences pref1 = getSharedPreferences("PREFERENCE2",Activity.MODE_PRIVATE);
        String b = pref1.getString("key02",String.valueOf(0));
        int Finishr = Integer.parseInt(b); //r==소집해제 선택날 (r-현재)
        int result = Finishr-r1;
        String result1 = Integer.toString(result); //텍스트뷰에 넣기위해 결과값 스트링으로 변환
        textView1.setText("D - "+result);

        //입소날 가져오기
        SharedPreferences pref = getSharedPreferences("PREFERENCE", Activity.MODE_PRIVATE);
        String a =  pref.getString("key01", String.valueOf(0));
        int Startr = Integer.parseInt(a);
        int Startresult = r1 - Startr;
        textView.setText( Startresult + "일");

        // int p = Integer.parseInt(a);
        int percent = (int) ((double) Startresult / (double) 666 * 100.0);

        String pp = Integer.toString(percent);

        textViewp.setText(pp+"/100(%)" );

        setPreference("key03",pp);
        setPreference("key04",result1); //디데이


        try {
            // 문자열을 숫자로 변환.
            int value = Integer.parseInt(pp);
            // 변환된 값을 프로그레스바에 적용.
            ProgressBar progress = (ProgressBar) findViewById(R.id.progress) ;
            progress.setProgress(value) ;

        } catch (Exception e) {
            // 토스트(Toast) 메시지 표시.
            Toast toast = Toast.makeText(main.this, "Invalid number format",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
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
        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);

        int requestID = (int) System.currentTimeMillis();

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), requestID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentTitle("소집해제") // required
                .setContentText(pp + "% / "+ "D - "+result)  // required
                .setDefaults(Notification.DEFAULT_ALL) // 알림, 사운드 진동 설정
                //.setAutoCancel(true) // 알림 터치시 반응 후 삭제
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setSmallIcon(android.R.drawable.btn_star).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                .setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)
                .setContentIntent(pendingIntent);

        builder.setOngoing(true);


        notifManager.notify(0, builder.build());


    }

    public void setPreference(String key, String value) {
        SharedPreferences pref = getSharedPreferences("PREFERENCE03", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }


}