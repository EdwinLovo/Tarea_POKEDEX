package com.example.acer.pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.pokedex.utils.AppConstant;

public class InfoActivity extends AppCompatActivity {

    private TextView tx;
    private ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tx=findViewById(R.id.textViewPoke_info);
        im = findViewById(R.id.ImageViewPoke_info);

        Intent intent = getIntent();
        if(intent!=null){
            tx.setText(intent.getStringExtra(AppConstant.NAME));

        }

    }
}
