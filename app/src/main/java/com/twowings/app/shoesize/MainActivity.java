package com.twowings.app.shoesize;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.spark.submitbutton.SubmitButton;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private ImageButton zurueck;
    private EditText editText , editText2, editText3, editText4;
    private SubmitButton submit;
    private TextView fehlermel;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fehlermel = (TextView) findViewById(R.id.fehlermel);
        editText = (EditText)  findViewById(R.id.editText);
        editText2 = (EditText)  findViewById(R.id.editText2);
        editText3 = (EditText)  findViewById(R.id.editText3);
        editText4 = (EditText)  findViewById(R.id.editText4);
        zurueck = (ImageButton) findViewById(R.id.zurueck);
        zurueck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity1();
            }
        });
        submit = (SubmitButton) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void openActivity1(){

        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
        finish();
    }

    public int test()throws InterruptedException{
        double cm1,de1,uk1,us1;

        Editable a = editText.getText();
        String cm = a.toString();
        Editable b = editText2.getText();
        String de = b.toString();
        Editable c = editText3.getText();
        String uk = c.toString();
        Editable d = editText4.getText();
        String us = d.toString();

        if(!cm.equals("") && !de.equals("") && !uk.equals("") && !us.equals("")){
            fehlermel.setText("");
            editText.setText("");
            editText2.setText("");
            editText3.setText("");
            editText4.setText("");
            return -1;
        }
        else if((!cm.equals("") && !de.equals("")) || (!cm.equals("") && !uk.equals("")) || (!cm.equals("") && !us.equals("")) || (!de.equals("") && !uk.equals("")) || (!de.equals("")&& !us.equals("")) || (!uk.equals("") && !us.equals(""))){
            fehlermel.setText(R.string.eineangabe);
            editText3.setText("");
            return -1;
        }
        else if(cm.equals("") && de.equals("") && uk.equals("") && us.equals("")){
            fehlermel.setText(R.string.angabe);
            return -1;
        }

        if(!cm.equals("")) {
            try {
                cm1 = Double.parseDouble(cm);
                fehlermel.setText("");
                if (cm1 < 9 || cm1 > 20) {
                    fehlermel.setText(R.string.inputcm);
                    return -1;
                }
                double inches = (cm1 * 10) / 25.4;
                uk1 = (3* inches) -10;
                uk1 = uk1 *2;
                uk1 = Math.rint(uk1);
                uk1 = uk1 /2;
                uk = uk1+"";
                editText3.setText(uk);
                double uk_size = (3* inches) -23;

                de1 = 1.27 * (uk_size +23) +2;
                de1 = de1 *2;
                de1 = Math.rint(de1);
                de1 = de1 /2;
                de = de1 + "";
                editText2.setText(de);

                us1 = (3 * inches) -9.67;
                us1 = us1 *2;
                us1 = Math.rint(us1);
                us1 = us1 /2;
                us = us1+"";
                editText4.setText(us);

            } catch (Exception e) {
                fehlermel.setText(R.string.eingabefehler);
                return -1;
            }
        }
        else if(!de.equals("")) {
            try {
                de1 = Double.parseDouble(de);
                fehlermel.setText("");
                if (de1 < 16 || de1 > 32) {
                    fehlermel.setText(R.string.inputeu);
                    return -1;
                }
                double inches = (de1 -2) / (3*1.27);
                cm1 = inches * 2.54;
                cm1 = cm1 *2;
                cm1 = Math.rint(cm1);
                cm1 = cm1 /2;
                cm = cm1+"";
                editText.setText(cm);

                uk1 = (3* inches) -10;
                uk1 = uk1 *2;
                uk1 = Math.rint(uk1);
                uk1 = uk1 /2;
                uk = uk1+"";
                editText3.setText(uk);

                us1 = (3 * inches) -9.67;
                us1 = us1 *2;
                us1 = Math.rint(us1);
                us1 = us1 /2;
                us = us1+"";
                editText4.setText(us);

            } catch (Exception e) {
                fehlermel.setText(R.string.eingabefehler);
                return -1;
            }
        }
        else if(!uk.equals("")) {
            try {
                uk1 = Double.parseDouble(uk);
                fehlermel.setText("");
                if (uk1 < 0.5 || uk1 > 14) {
                    fehlermel.setText(R.string.inputuk);
                    return -1;
                }

                double inches = (uk1 +10)/3;

                cm1 = inches * 2.54;
                cm1 = cm1 *2;
                cm1 = Math.rint(cm1);
                cm1 = cm1 /2;
                cm = cm1+"";
                editText.setText(cm);

                double uk_size = (3* inches) -23;
                de1 = 1.27 * (uk_size +23) +2;
                de1 = de1 *2;
                de1 = Math.rint(de1);
                de1 = de1 /2;
                de = de1 + "";
                editText2.setText(de);

                us1 = (3 * inches) -9.67;
                us1 = us1 *2;
                us1 = Math.rint(us1);
                us1 = us1 /2;
                us = us1+"";
                editText4.setText(us);

            } catch (Exception e) {
                fehlermel.setText(R.string.eingabefehler);
                return -1;
            }
        }
        else if(!us.equals("")) {
            try {
                us1 = Double.parseDouble(us);
                fehlermel.setText("");
                if (us1 < 1 || us1 > 14) {
                    fehlermel.setText(R.string.inputus);
                    return -1;
                }
                double inches = (us1 + 9.67)/3;

                cm1 = inches * 2.54;
                cm1 = cm1 *2;
                cm1 = Math.rint(cm1);
                cm1 = cm1 /2;
                cm = cm1+"";
                editText.setText(cm);

                double uk_size = (3* inches) -23;
                de1 = 1.27 * (uk_size +23) +2;
                de1 = de1 *2;
                de1 = Math.rint(de1);
                de1 = de1 /2;
                de = de1 + "";
                editText2.setText(de);

                uk1 = (3* inches) -10;
                uk1 = uk1 *2;
                uk1 = Math.rint(uk1);
                uk1 = uk1 /2;
                uk = uk1+"";
                editText3.setText(uk);


            } catch (Exception e) {
                fehlermel.setText(R.string.eingabefehler);
                return -1;
            }
        }
        return 1;
    }


}
