package gameControl.initialization;

import android.widget.Button;
import android.widget.ImageView;

import com.example.a4501assignment.R;

import java.util.ArrayList;

public class setCardBackground {


    public static void setCardBackground(ArrayList<ImageView> buttons){
        for(int i = 0; i < buttons.size(); i++){
            buttons.get(i).setBackgroundResource(R.drawable.back);
        }
    }
}
