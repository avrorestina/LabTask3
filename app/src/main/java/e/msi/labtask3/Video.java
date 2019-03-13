package e.msi.labtask3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    Button btnPlay;                     //Declare button btnPlay
    Button btnNext;                     //Declare button btnNext
    VideoView video;                    //Declare VideoView video
    MediaController mp;                 //Declare Mediacontroller mp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //Find Buttons in Design
        btnPlay = (Button) findViewById(R.id.buttonPlay);
        btnNext = (Button) findViewById(R.id.button8);

        //Find videoview in design
        video = (VideoView)findViewById(R.id.videoView);

        //set mediacontroller class
        mp = new MediaController(this);

        //set mediacontroller anchor to videoview
        mp.setAnchorView(video);

        //set videoview mediacontroller to mp
        video.setMediaController(mp);

        //btnPlay OnClick
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = "android.resource://e.msi.labtask3/"+ R.raw.seal;         //Path to video file

                Uri u = Uri.parse(path);                                                //Set video path URI

                video.setVideoURI(u);                                                   //Set video path in videoView

                video.start();                                                          //Start Video
            }
        });

        //btnNext OnClick
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyBiodata.class);
                startActivity(intent);
            }
        });



    }
}
