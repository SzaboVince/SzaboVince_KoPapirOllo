package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView jatekosval;
    private ImageView comval;
    private TextView eredmeny;
    private Button rock;
    private Button paper;
    private Button scissor;
    private int jatekospont;
    private int compont;
    private int rnd;
    private AlertDialog.Builder alert_gameszkonakvege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekosval.setImageResource(R.drawable.rock);
                Random random=new Random();
                rnd=random.nextInt(3);
                if (rnd==0){
                    comval.setImageResource(R.drawable.rock);
                    dontetlen();
                } else if (rnd==1) {
                    comval.setImageResource(R.drawable.paper);
                    comgyozelem();
                } else if (rnd==2) {
                    comval.setImageResource(R.drawable.scissors);
                    jatekosgyozelem();
                }
                if(compont==3){
                    alert_gameszkonakvege.setTitle("Vereség");
                    alert_gameszkonakvege.show();
                } else if (jatekospont==3) {
                    alert_gameszkonakvege.setTitle("Győzelem");
                    alert_gameszkonakvege.show();
                }
            }



        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekosval.setImageResource(R.drawable.paper);
                Random random=new Random();
                rnd=random.nextInt(3);
                if (rnd==0){
                    comval.setImageResource(R.drawable.rock);
                    jatekosgyozelem();
                } else if (rnd==1) {
                    comval.setImageResource(R.drawable.paper);
                    dontetlen();
                } else if (rnd==2) {
                    comval.setImageResource(R.drawable.scissors);
                    comgyozelem();
                }
                if(compont==3){
                    alert_gameszkonakvege.setTitle("Vereség");
                    alert_gameszkonakvege.show();
                } else if (jatekospont==3) {
                    alert_gameszkonakvege.setTitle("Győzelem");
                    alert_gameszkonakvege.show();
                }
            }



        });
        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekosval.setImageResource(R.drawable.scissors);
                Random random=new Random();
                rnd=random.nextInt(3);
                if (rnd==0){
                    comval.setImageResource(R.drawable.rock);
                    comgyozelem();
                } else if (rnd==1) {
                    comval.setImageResource(R.drawable.paper);
                    jatekosgyozelem();
                } else if (rnd==2) {
                    comval.setImageResource(R.drawable.scissors);
                    dontetlen();
                }
                if(compont==3){
                    alert_gameszkonakvege.setTitle("Vereség");
                    alert_gameszkonakvege.show();
                } else if (jatekospont==3) {
                    alert_gameszkonakvege.setTitle("Győzelem");
                    alert_gameszkonakvege.show();
                }
            }



        });
    }

    public void init(){
        jatekosval=findViewById(R.id.Player);
        comval=findViewById(R.id.Com);
        eredmeny=findViewById(R.id.Eredmeny);
        rock=findViewById(R.id.ko);
        paper=findViewById(R.id.papir);
        scissor=findViewById(R.id.ollo);
        jatekospont=0;
        compont=0;
        alert_gameszkonakvege=new AlertDialog.Builder(MainActivity.this);
        alert_gameszkonakvege.setTitle("Győzelem");
        alert_gameszkonakvege.setMessage("Szeretne új játékot játszani?");
        alert_gameszkonakvege.setNegativeButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                newgame();
            }
        });
        alert_gameszkonakvege.setPositiveButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert_gameszkonakvege.setCancelable(false);
        alert_gameszkonakvege.create();
    }
    public void newgame(){
        jatekosval.setImageResource(R.drawable.rock);
        comval.setImageResource(R.drawable.rock);
        init();
        eredmeny.setText("Eredmény: Ember: "+jatekospont +" Computer: "+compont);
    }
    public void dontetlen(){
        Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
    }
    public void comgyozelem(){
        Toast.makeText(MainActivity.this,"Elveszítetted a kört.",Toast.LENGTH_SHORT).show();
        compont++;
        eredmeny.setText("Eredmény: Ember: "+jatekospont +" Computer: "+compont);
    }
    public void jatekosgyozelem(){
        Toast.makeText(MainActivity.this,"Megnyerted a kört.",Toast.LENGTH_SHORT).show();
        jatekospont++;
        eredmeny.setText("Eredmény: Ember: "+jatekospont +" Computer: "+compont);
    }
}