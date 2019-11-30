package Agent1.com;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class insert extends Activity {
    public final String PREFERENCE = "insert";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);



        Button nextbtn = (Button)findViewById(R.id.nextbtn);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                EditText eat=(EditText)findViewById(R.id.eat);
                EditText bus=(EditText)findViewById(R.id.bus);

                //SharedPreferences에 각 아이디를 지정하고 EditText 내용을 저장한다.
                editor.putString("insert_eat", eat.getText().toString());
                editor.putString("insert_bus", bus.getText().toString());
                // TODO : 필수 없으면 저장안됨
                editor.commit();
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
