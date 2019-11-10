package Agent1.com;

import android.app.Activity;
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

public class money extends Activity {
    public int d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money);
        Button Button1 = (Button)findViewById(R.id.button);
        Button Button2 = (Button)findViewById(R.id.button2);
        Button Button3 = (Button)findViewById(R.id.button3);
        Button Button4 = (Button)findViewById(R.id.button4);


    }

    public void button1(View v){
        d=306130;
    }
    public void button2(View v){
        d=331296;
    }
    public void button3(View v){
        d=366229;
    }
    public void button4(View v){
        d=412832;
    }
    public void onClick(View v){
        EditText input1 = (EditText)findViewById(R.id.edit01);
        EditText input2 = (EditText)findViewById(R.id.edit02);
        EditText input3 = (EditText)findViewById(R.id.edit03);
        TextView result = (TextView)findViewById(R.id.textView3);
        int a = Integer.parseInt(input1.getText().toString()); //출근일수
        int b = Integer.parseInt(input2.getText().toString()); //교통비
        int c = Integer.parseInt(input3.getText().toString()); //식비
        result.setText(Integer.toString((a*b)+(a*c)+d) + "원");

    }


}