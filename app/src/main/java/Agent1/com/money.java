package Agent1.com;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.appcompat.app.AppCompatActivity;

public class money extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        EditText inputInt1 = (EditText) findViewById(R.id.edit01); //출근
        EditText inputInt2 = (EditText) findViewById(R.id.edit02); //교통
        EditText inputInt3 = (EditText) findViewById(R.id.edit03); //식비
        EditText inputint4 = (EditText) findViewById(R.id.edit04); //기본급여
        Button nextbtn = (Button)findViewById(R.id.nextbtn);
        final TextView textView = (TextView) findViewById(R.id.textView3);

        String a,b,d,c;
        final int result;

        a = inputInt1.getText().toString();
        b = inputInt1.getText().toString();
        c = inputInt1.getText().toString();
        d = inputInt1.getText().toString();

        result = (Integer.parseInt(a)*Integer.parseInt(b)) + (Integer.parseInt(a) * Integer.parseInt(c)) + Integer.parseInt(d);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(result);
            }
        });





    }



}