package android.apphelper.dimens;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.apphelper.demens.test;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test.main("sdfdfsd");
    }
}