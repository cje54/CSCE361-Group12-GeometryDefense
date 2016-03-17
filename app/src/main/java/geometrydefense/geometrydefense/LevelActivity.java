package geometrydefense.geometrydefense;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class LevelActivity extends AppCompatActivity {

    private Level level;

    public void onCreate(Bundle savedInstaceState){
        //no title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstaceState);
        //fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.level_layout);

        //add Level surfaceView to frame in layout
        level = new Level(this);
        ((FrameLayout)findViewById(R.id.level_screen)).addView(level);
        ((LinearLayout)findViewById(R.id.topUI)).getLayoutParams().height= 180;
        //set listener for clicking the send wave button
        ((Button)findViewById(R.id.send_now_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level.sendWave();
            }
        });

        //set listeners for the buy and sell button
        final Button buy=(Button)findViewById(R.id.buy_btn);
        final Button sell=(Button)findViewById(R.id.sell_btn);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set Color to green if in buy mode or gray else
                if(buy.getCurrentTextColor()==Color.GREEN){
                    buy.setTextColor(Color.WHITE);
                }else{
                    buy.setTextColor(Color.GREEN);
                }
                //reset sell color if it was never turned off
                sell.setTextColor(Color.WHITE);
                level.buyBtn();
            }
        });

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set Color to red if in sell mode or gray else
                if(sell.getCurrentTextColor()==Color.RED){
                    sell.setTextColor(Color.WHITE);
                }else{
                    sell.setTextColor(Color.RED);
                }
                //reset buy color if it was never turned off
                buy.setTextColor(Color.WHITE);
                level.sellBtn();
            }
        });

        ((ImageView)findViewById(R.id.next_enemy)).setImageResource(R.drawable.normal_enemy_sprite);

    }

    public void updateText(int id, final String text){
        final TextView textView = (TextView)findViewById(id);
        textView.post(new Runnable() {
            public void run() {
                textView.setText(text);
            }
        });
    }


}
