package com.example.formation2.firstappandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {

    private Button buttonDial,buttonMail;

    private  View.OnClickListener onClickDial = v -> {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0066666666"));
            startActivity(intent);
        };

    private  View.OnClickListener onClickMail = v -> {

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:emailaddress@emailaddress.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        buttonDial = findViewById(R.id.button_dial);
        buttonMail = findViewById(R.id.button_mail);

        buttonMail.setOnClickListener(onClickMail);
        buttonDial.setOnClickListener(onClickDial);
    }

}
