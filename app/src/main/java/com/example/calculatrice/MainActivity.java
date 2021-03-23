package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView SCREEN;
    private String input,Answer;
    private Button UN,DEUX,TROIS,QUATRE,CINQ,SIX,SEPT,HUIT,NEUF,MUL,PLUS,MOINS,ZERO,EGAL,M,MR,DIV,POINT,BACK,PLUSOUMOINS;
    String T[]={"0","1","2","3","4","5","6","7","8","9"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SCREEN=findViewById(R.id.screen);
        UN=findViewById(R.id.un);
        DEUX=findViewById(R.id.deux);
        TROIS=findViewById(R.id.trois);
        QUATRE=findViewById(R.id.quatre);
        CINQ=findViewById(R.id.cinq);
        SIX=findViewById(R.id.six);
        SEPT=findViewById(R.id.sept);
        HUIT=findViewById(R.id.huit);
        NEUF=findViewById(R.id.neuf);
        M=findViewById(R.id.m);
        MUL=findViewById(R.id.mul);
        PLUS=findViewById(R.id.plus);
        MOINS=findViewById(R.id.moins);
        MR=findViewById(R.id.mr);
        EGAL=findViewById(R.id.equal);
        POINT=findViewById(R.id.point);
        PLUSOUMOINS=findViewById(R.id.plusoumoins);
        DIV=findViewById(R.id.div);
        ZERO=findViewById(R.id.zero);
        BACK=findViewById(R.id.back);
    }
    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){

            case"sup":
                String newText=input.substring(0,input.length()-1);
                input=newText;
                break;
            case"=":
                Solve();
                Answer=input;
                break;
            case"*":
                Solve();
                input+="*";
                break;
            case"+":
                Solve();
                input+="+";
                break;
            case"/":
                Solve();
                input+="/";
                break;
            case".":
                Solve();
                input+=".";
            case"-":
                Solve();
                input+="-";
                break;

            default:
                if(input==null){
                    input="";
                }
                for(int i=0; i<T.length;i++) {
                    if (data.equals(T[i]) ) {
                        input += data;
                    }
                }

        }
        SCREEN.setText(input);
    }
    private void Solve(){
        if((input.split("\\*")).length==2){
           String number[]=input.split("\\*");
           try {
               double mul=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
               input=mul+"";
           }
           catch (Exception e){
            //Toggle error
             }
        }
        else if((input.split("\\+")).length==2){
            String number[]=input.split("\\+");
            try {
                double sum=Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input=sum+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }
        else if((input.split("/")).length==2){
            String[] number =input.split("/");
            try {
                double div=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input=div+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }
        else if(input.split("-").length==2){
            String number[]=input.split("-");
            if ( number[0]=="" && (number.length)==2){
              number[0]=0+"";
            }
            try {
                double sub=Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                input=sub+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }
    }
}
