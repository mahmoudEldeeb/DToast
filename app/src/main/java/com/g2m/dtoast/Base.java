package com.g2m.dtoast;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Base extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
findViewById(R.id.but).setOnClickListener(new View.OnClickListener() {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {

//        new DStyleToast.Bulider(getBaseContext()).setText("aaah h bj hjhhh aa")
//                .setStrokeColor(Color.BLACK)
//                .setStrokeWidth(6)
//                .setCornerRadius(100)
//                .setBackgroundColor(Color.BLUE).show();

        DStyleToast.makeToast(getBaseContext(),"ssss",R.style.mytoast).show();
    }
});




    }
}
