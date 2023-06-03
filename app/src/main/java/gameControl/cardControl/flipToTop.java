package gameControl.cardControl;

import android.widget.ImageView;

import com.example.a4501assignment.R;

public class flipToTop {

    public static void flipToTop(ImageView card){
        if((int)card.getTag() == 1){
            card.setBackgroundResource(R.drawable.back);
        }else if((int)card.getTag() == 2){
            card.setBackgroundResource(R.drawable.back);
        }else if((int)card.getTag() == 3){
            card.setBackgroundResource(R.drawable.back);
        }else if((int)card.getTag() == 4){
            card.setBackgroundResource(R.drawable.back);
        }    }
}
