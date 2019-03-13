package e.msi.labtask3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView txtshowName;               //Declare textview txtshowName
    TextView txtshowMatrix;             //Declare textview txtshowMatrix
    Button btnChicken;                  //Declare button for chicken
    Button btnBurger;                   //Declare button for burger
    Button btnPizza;                    //Declare button for pizza

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Get the intent value from LoginPage
        String getName = getIntent().getStringExtra("Name");
        String getMatrix = getIntent().getStringExtra("Matrix");

        //Find both textview in Design
        txtshowName = (TextView) findViewById(R.id.txtshowName);
        txtshowMatrix = (TextView) findViewById(R.id.txtshowMatrix);

        //Set the textview value equals to their string
        txtshowName.setText(getName);
        txtshowMatrix.setText(getMatrix);

        //Find buttons in Design
        btnChicken = (Button) findViewById(R.id.button2);
        btnBurger = (Button) findViewById(R.id.button3);
        btnPizza = (Button) findViewById(R.id.button4);

        //Button chicken OnClick
        btnChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Food.class);        //Start intent to go to next page
                Boolean Chicken = true;                                                 //Declare a boolean Chicken equals to True
                intent.putExtra("boolChicken",Chicken);                           //Put the boolean inside intent
                startActivity(intent);                                                  //Start intent
            }
        });

        //button burger OnClick
        btnBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Food.class);        //Declare a boolean Burger equals to True
                Boolean Burger = true;                                                  //Put the boolean inside intent
                intent.putExtra("boolBurger",Burger);
                startActivity(intent);
            }
        });

        //button pizza OnClick
        btnPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Food.class);        //Declare a boolean Pizza equals to True
                Boolean Pizza = true;                                                   //Put the boolean inside intent
                intent.putExtra("boolPizza",Pizza);
                startActivity(intent);
            }
        });
    }
}
