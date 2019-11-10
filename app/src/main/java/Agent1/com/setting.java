package Agent1.com;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setting extends Activity {

    public final String PREFERENCE = " ";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        Button reset = (Button)findViewById(R.id.reset);
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
