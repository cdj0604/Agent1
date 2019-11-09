package Agent1.com;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class main extends AppCompatActivity {
    public final String key01 = "key01";
    public final String key02 = "key02";
    public final String key03 = "key03";
    public final String key04 = "key04";
    TextView textView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView)findViewById(R.id.textview);
        textView1 = (TextView)findViewById(R.id.textview1);

        SharedPreferences pref = getSharedPreferences("PREFERENCE", Activity.MODE_PRIVATE);
        String a =  pref.getString("key01", String.valueOf(0));
        textView.setText(a);

        SharedPreferences pref1 = getSharedPreferences("PREFERENCE2",Activity.MODE_PRIVATE);
        String b = pref1.getString("key02",String.valueOf(0));
        textView1.setText(b);
    }



}