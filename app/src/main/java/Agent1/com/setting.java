package Agent1.com;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;

public class setting extends Activity {
    private BackPressCloseHandler backPressCloseHandler;
    public final String PREFERENCE = " ";
    NotificationManager notificationManager;
    PendingIntent intent;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        Button reset = (Button)findViewById(R.id.reset);

        backPressCloseHandler = new BackPressCloseHandler(this);


    }
    public void reset(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setTitle("초기화")        // 제목 설정

                .setMessage("설정을 초기화 하시겠습니까?")        // 메세지 설정

                .setCancelable(false)        // 뒤로 버튼 클릭시 취소 가능 설정

                .setPositiveButton("확인", new DialogInterface.OnClickListener(){

                    // 확인 버튼 클릭시 설정

                    public void onClick(DialogInterface dialog, int whichButton){
                        asd();
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    // 취소 버튼 클릭시 설정
                    public void onClick(DialogInterface dialog, int whichButton){

                        dialog.cancel();
                    }
                });

        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기



    }

public void asd(){

    SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
    SharedPreferences.Editor editor = pref.edit();
    editor.clear();
    editor.commit();
    Intent intent = new Intent(this,startday.class);
    startActivity(intent);
    finish();
}

    public void setPreferenceClear(){

    }

    @Override public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }
}
