package e.msi.labtask3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    TextView txtName;               //Declare name textview
    TextView txtMatrix;             //Declare matric textview
    Button buttonLogin;             //Declare button login


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //Find both textview in Design
        txtName = (TextView) findViewById(R.id.txtName);
        txtMatrix = (TextView) findViewById(R.id.txtMatrix);

        //Find button in Design
        buttonLogin = (Button) findViewById(R.id.button1);

        //Buttin OnClick function
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Welcome.class);                 //start intent to another class
                intent.putExtra("Name",txtName.getText().toString());                         //put txtName value into intent extra
                intent.putExtra("Matrix", txtMatrix.getText().toString());                    //put txtMatrix value into intent extra
                startActivity(intent);                                                              //start intent
            }
        });
    }
}
