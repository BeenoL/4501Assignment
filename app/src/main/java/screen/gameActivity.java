package screen;
import gameControl.checkFinish;
import gameControl.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a4501assignment.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cardControl.card;

public class gameActivity extends AppCompatActivity {

    TextView tv_time, tv_step;
    Button button1, button2, button3, button4, button5, button6, button7, button8;
    ArrayList<Button> buttonList = new ArrayList<>();
    ArrayList<Integer> buttonTag = new ArrayList<>();
    int step = 1;
    int matched = 0;
    card card1, card2;
    ArrayList<Drawable> imageList = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        tv_time = findViewById(R.id.tv_time);
        tv_step = findViewById(R.id.tv_step);
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
        imageList.add(R.drawable.ic_launcher_background);
        for(int i  = 0; i < 8; i++){
            if(i >4) {
                buttonTag.add(i / 2);
            }else{
                buttonTag.add(i);
            }
        }
        Collections.shuffle(buttonTag);
        setTag();
        setImage();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card card = new card(1);
                setCard(card);
                button1.setEnabled(false);
            }
        });
    }

    public void setTag(){
        Random random = new Random();
        for(int n = 0; n < buttonList.size(); n++){
            buttonList.get(n).setTag(buttonTag.get(n));
        }
    }

    public void setImage(){
        for(int n = 0; n < buttonList.size(); n++){
            if((Integer)buttonList.get(n).getTag() == 1){
                buttonList.get(n).setBackground(imageList.get(n));
            }
        }
    }

    public void setCard(card card){
        if(card1 == null){
            card1 = card;
        }else if(card2 == null){
            card2 = card;
            isMatchorNot(card1, card2);

        }
    }

    public void isMatchorNot(card card1, card card2){
        if(isMatch.isMatch(card1, card2)){
            matched++;
            if(checkFinish.checkFinish(matched)){

            }
        }else{

        }
    }
}