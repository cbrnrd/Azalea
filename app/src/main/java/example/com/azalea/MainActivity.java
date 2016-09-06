package example.com.azalea;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView prettyBear;
    TextView landonAzFestHome;
    Button goBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goBtn = (Button) findViewById(R.id.goBtn);

        //sets flower bear size
        prettyBear = (ImageView) findViewById(R.id.azaleaBearHomeScreenImg);
        ViewGroup.LayoutParams params = prettyBear.getLayoutParams();
        params.height = 700;
        params.width = 700;
        prettyBear.setLayoutParams(params);

        //sets Landon text size and font
        landonAzFestHome = (TextView) findViewById(R.id.LandonHomeScreen);
        ViewGroup.LayoutParams landonHomeParams = landonAzFestHome.getLayoutParams();
        landonHomeParams.height = 300;
        landonHomeParams.width = 1000;
        landonAzFestHome.setLayoutParams(landonHomeParams);
        Typeface face = Typeface.createFromAsset(getAssets(),"AndadaSC-Bold.otf");
        landonAzFestHome.setTypeface(face);

        //creates a new intent to go to home menu
        final Intent homeMenu = new Intent(MainActivity.this, homeMenuActivity.class);

        //button press action
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(homeMenu);
            }
        });

    }
}
