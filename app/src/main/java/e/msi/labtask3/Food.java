package e.msi.labtask3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Food extends AppCompatActivity {

    TextView txtTitle;          //Declare textview txtTitle
    ImageView imgFood;          //Declare ImageView imgFood
    Button btnHome;             //Declare button for button home
    Button btnAudio;            //Declare button for button audio
    Button btnNext;             //Declare button for button next
    MediaPlayer mpChicken;      //Declare a mediaplayer for chicken
    MediaPlayer mpBurger;       //Declare a mediaplayer for burger
    MediaPlayer mpPizza;        //Declare a mediaplayer for pizza

    Toast toast;                //Declare a Toast popup

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        //Initialize mediaplayers for each mp
        mpChicken = MediaPlayer.create(this, R.raw.chickensound);
        mpBurger = MediaPlayer.create(this, R.raw.burgersound);
        mpPizza = MediaPlayer.create(this, R.raw.pizzasound);

        //Find textview in design
        txtTitle = (TextView) findViewById(R.id.txtTitle);

        //Find ImageView in design
        imgFood = (ImageView) findViewById(R.id.imgFood);

        //Find buttons in design
        btnHome = (Button) findViewById(R.id.button6);
        btnAudio = (Button) findViewById(R.id.button5);
        btnNext = (Button) findViewById(R.id.button7);

        //Set a bundle to get intent from previous class
        Bundle getBools = getIntent().getExtras();

        //Get the booleans from previous intent
        Boolean Chicken = getBools.getBoolean("boolChicken");
        Boolean Burger = getBools.getBoolean("boolBurger");
        Boolean Pizza = getBools.getBoolean("boolPizza");

        //button home OnClick
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Welcome.class);
                startActivity(intent);
            }
        });

        //Chicken if statement
        if(Chicken)
        {
            imgFood.setImageResource(R.drawable.chicken);                                               //set image to chicken
            txtTitle.append("Fried Chicken");                                                           //set title to Fried Chicken
            Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);               //set animation class from xml file
            imgFood.startAnimation(zoomin);                                                             //start the animation
            btnAudio.setOnClickListener(new View.OnClickListener() {                                    //button audio OnClick
                @Override
                public void onClick(View v) {
                    mpChicken.start();                                                                  //start mediaplauer

                    toast = Toast.makeText(getApplicationContext(), "FRIEEEDDD CHICKENNN!!!!", Toast.LENGTH_LONG);      //set toast settings
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, -400);                     //set toast position
                    toast.show();                                                                           //show toast
                }
            });



        }

        //Burger else if statement
        else if(Burger)
        {
            imgFood.setImageResource(R.drawable.burger);
            txtTitle.append("Burger");
            Animation zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);
            imgFood.startAnimation(zoomout);
            btnAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpBurger.start();

                    toast = Toast.makeText(getApplicationContext(), "BURGERRR!!!!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, -400);           //Ubah kedudukan Toast supaya center
                    toast.show();
                }
            });
        }

        //Pizza else if statement
        else if(Pizza)
        {
            imgFood.setImageResource(R.drawable.pizza);
            txtTitle.append("Pizza");
            Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
            imgFood.startAnimation(rotate);
            btnAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpPizza.start();

                    toast = Toast.makeText(getApplicationContext(), "PIZZAA!!!!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, -400);           //Ubah kedudukan Toast supaya center
                    toast.show();
                }
            });
        }

        //button next OnClick
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Video.class);
                startActivity(intent);
                mpBurger.stop();
                mpChicken.stop();
                mpPizza.stop();
            }
        });


    }
}
