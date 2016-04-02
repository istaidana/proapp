package ru.mail.guessmovie;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class Videos extends Activity implements View.OnClickListener{
    TextView tw1,tw2,tw3,tw4;
    Integer ball=0;
    MediaPlayer sound,sound2;
    ImageView clock;
    ArrayList<Integer> n;
    String key="";
    int r;
    String b[];
    int r1;
    int k = 0;
    int a[] = {
            R.raw.bal,
            R.raw.ktopodstavilkrolikarodjera,
            R.raw.aladdin,
            R.raw.gadkiya,
            R.raw.dalmatinec,
            R.raw.alisavstranechudes,
            R.raw.bambi,
            R.raw.valli,
            R.raw.vverh,
            R.raw.vpoiskahnemo,
            R.raw.gerkules,
            R.raw.gorodgeroev,
            R.raw.gubkabob,
            R.raw.zemlyadonachalavremen,
            R.raw.zolushka,
            R.raw.istoryaigrushekbolshoipobeg,
            R.raw.kakpriruchitdrakona,
            R.raw.kakpriruchitdrakona2,
            R.raw.korollev,
            R.raw.korollev2,
            R.raw.korporaciamonstrov,
            R.raw.koshmarperedrojdetstvom,
            R.raw.kracavicaichudovishe,
            R.raw.kungfupanda,
            R.raw.lediibrodyaga,
            R.raw.lednikovyperiod,
            R.raw.lisipes,
            R.raw.madagaskar,
            R.raw.megamozg,
            R.raw.monstrynakanikulah,
            R.raw.mulan,
            R.raw.maryimax,
            R.raw.paranorman,
            R.raw.pesnmorya,
            R.raw.piterpen,
            R.raw.pokohontas,
            R.raw.ralf,
            R.raw.rapuncel,
            R.raw.ratatui,
            R.raw.rojdetstvenskayaistorya,
            R.raw.rusalochka,
            R.raw.semeikakruds,
            R.raw.spritdushaperiy,
            R.raw.spiashayakracavica,
            R.raw.stalnoigigant,
            R.raw.trupnevesty,
            R.raw.universitetmonstrov,
            R.raw.holodnoeserdce,
            R.raw.hranitelisnov,
            R.raw.shreck
};
    int zar[] = {
            R.raw.milya,
            R.raw.avgustrash,
            R.raw.beliyplen,
            R.raw.bolshoistan,
            R.raw.brucevsemoguchi,
            R.raw.vpogonezachastiem,
            R.raw.vanhelsing,
            R.raw.voin,
            R.raw.vremya,
            R.raw.grantorino,
            R.raw.dejavu,
            R.raw.densurka,
            R.raw.dnevnikpamyti,
            R.raw.dostuchatsyadonebes,
            R.raw.benjeminbatton,
            R.raw.zakonoposlushnigrajdanin,
            R.raw.zelenayamilya,
            R.raw.igrapochuzhimpravilam,
            R.raw.illuziaobmana,
            R.raw.ipman,
            R.raw.ishodniykod,
            R.raw.leon,
            R.raw.maiorpein,
            R.raw.malyshkanamillion,
            R.raw.misterimississmith,
            R.raw.neprikasaemiye,
            R.raw.nikogdanesdavaisya,
            R.raw.oruzheiniybaron,
            R.raw.papesnova17,
            R.raw.perlharbor,
            R.raw.pobegizshoushenka,
            R.raw.poezdnaumu,
            R.raw.pokanesygralyashik,
            R.raw.polianna,
            R.raw.poslezavtra,
            R.raw.piatyelement,
            R.raw.semjizney,
            R.raw.spasatel,
            R.raw.sudya,
            R.raw.temniyrycar,
            R.raw.trenerkarter,
            R.raw.forrestgump,
            R.raw.haticko,
            R.raw.horoshiedetineplachut,
            R.raw.hrabroeserdce,
            R.raw.huligany,
            R.raw.hancok,
            R.raw.sherlockholmes,
            R.raw.shestoechuvstvo,
            R.raw.yarobot
    };
    int ser[] = {
            R.raw.agentyshit,
            R.raw.anatomiastrasty,
            R.raw.beliyvorotnichok,
            R.raw.bludlivayakalifornya,
            R.raw.brigada,
            R.raw.vikingi,
            R.raw.gotem,
            R.raw.grimm,
            R.raw.gudini,
            R.raw.dexter,
            R.raw.dnevnikivampira,
            R.raw.doctorhouse,
            R.raw.druzya,
            R.raw.igraprestolov,
            R.raw.interny,
            R.raw.kakyavstretilvashumamu,
            R.raw.kasl,
            R.raw.klinika,
            R.raw.kontinuum,
            R.raw.kosti,
            R.raw.mentalist,
            R.raw.milyeobmanshici,
            R.raw.obmaniymenya,
            R.raw.odnajdivskazke,
            R.raw.ostatsyavjivyx,
            R.raw.ostriyekozyrki,
            R.raw.otbrosy,
            R.raw.otchayenniedomohozaiki,
            R.raw.pobegizturmi,
            R.raw.podkupolom,
            R.raw.realniepacany,
            R.raw.sverhestestvennoe,
            R.raw.simpsony,
            R.raw.sotnya,
            R.raw.spartakvoinaproklyatih,
            R.raw.spiral,
            R.raw.spletnica,
            R.raw.strela,
            R.raw.taynysmolvillia,
            R.raw.teoriabolshogovzryva,
            R.raw.tuidory,
            R.raw.uilfred,
            R.raw.univer,
            R.raw.flesh,
            R.raw.forsmazhory,
            R.raw.heiven,
            R.raw.cherniyspisok,
            R.raw.sherlock,
            R.raw.uzhniypark,
            R.raw.yazombie
    };

    int kz[] = {
            R.raw.nineninenine,
            R.raw.amangeldi,
            R.raw.angelvtubeteike,
            R.raw.anshybala,
            R.raw.baikonur,
            R.raw.baksy,
            R.raw.birjansal,
            R.raw.voiskomynbala,
            R.raw.vuzery,
            R.raw.desant,
            R.raw.zabludivshisya,
            R.raw.igla,
            R.raw.kairatchempion,
            R.raw.kek,
            R.raw.kokteildlyazvezdy,
            R.raw.kochevnik,
            R.raw.ktovygospodinka,
            R.raw.kyzjibek,
            R.raw.lave,
            R.raw.likvidator,
            R.raw.luity,
            R.raw.menyazovutkozha,
            R.raw.molokosmetanatvorog,
            R.raw.mongol,
            R.raw.mustafashokai,
            R.raw.nebomoiegodetstva,
            R.raw.obratnayastorona,
            R.raw.ogrobleniyepochimketski,
            R.raw.odnazhdyvbagajnike,
            R.raw.okinish,
            R.raw.oniona,
            R.raw.petlya,
            R.raw.pobegizaula,
            R.raw.podarokstalinu,
            R.raw.proshaigulsary,
            R.raw.pryzhokafaliny,
            R.raw.ryvok,
            R.raw.reketir,
            R.raw.seker,
            R.raw.siroty,
            R.raw.skazorozovomzayce,
            R.raw.stancyaluvbi,
            R.raw.tulpan,
            R.raw.uljan,
            R.raw.fara,
            R.raw.hodkonyem,
            R.raw.shal,
            R.raw.shiza,
            R.raw.shuga,
            R.raw.shuchu
    };
    boolean correct = false;
    Thread thread;
    ArrayList<String> Variable;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        ball = getIntent().getExtras().getInt("ball");
        TextView tw = (TextView)findViewById(R.id.ball);
        tw.setText(ball+"");
        clock = (ImageView)findViewById(R.id.clock);
        sound = MediaPlayer.create(this,R.raw.errorlar);
        sound2 = MediaPlayer.create(this,R.raw.bleepers);
        key = getIntent().getExtras().getString("Key");
        vremya();

        k = 0;
        switch (key){
            case "Mults":
                b = getResources().getStringArray(R.array.mults);
                k = 0;
                break;
            case "Zarubej":
                b = getResources().getStringArray(R.array.zarubej);
                k = 1;
                break;
            case "Serials":
               b = getResources().getStringArray(R.array.serials);
                k = 2;
                break;
           case "Kazakh":
               b = getResources().getStringArray(R.array.kazakh);
               k = 3;
               break;
}

            Variable = new ArrayList<String>();
            n = new ArrayList<Integer>();

            r1 = (int) (Math.random() * 3);

            for (int i = 0; i < a.length; i++) {
                n.add(i);
                Collections.shuffle(n);
            }
            for (int i = 0; i < a.length; i++) {
                Variable.add(b[n.get(i)]);
            }

            tw1 = (TextView) findViewById(R.id.a);
            tw2 = (TextView) findViewById(R.id.b);
            tw3 = (TextView) findViewById(R.id.c);
            tw4 = (TextView) findViewById(R.id.d);

            tw1.setOnClickListener(this);
            tw2.setOnClickListener(this);
            tw3.setOnClickListener(this);
            tw4.setOnClickListener(this);


            tw1.setText(Variable.get(0));
            tw2.setText(Variable.get(1));
            tw3.setText(Variable.get(2));
            tw4.setText(Variable.get(3));

            Random random = new Random();
            r = random.nextInt(4);

            VideoView videoView = (VideoView) findViewById(R.id.videoView);
            Uri uri = Uri.parse("");
            if (k == 0) {
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + a[n.get(r)]);
            }
            else if (k == 1) {
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + zar[n.get(r)]);
            }
            else if(k==2){
            uri =  Uri.parse("android.resource://" + getPackageName()+ "/" + ser[n.get(r)]);
            }
            else if(k==3) {
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + kz[n.get(r)]);
            }
            videoView.setVideoURI(uri);
            videoView.start();
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent intent;
                    if (correct == true) {
                        ball +=1;
                        intent = new Intent(getApplicationContext(), Videos.class);
                        intent.putExtra("Key",key);
                        intent.putExtra("ball",ball);
                    } else {
                        intent = new Intent(getApplicationContext(), Results.class);
                        intent.putExtra("Key",key);
                        intent.putExtra("ball",ball);
                    }
                    startActivity(intent);
                }
            });

        }


    private void vremya() {
        Animation anim = AnimationUtils.loadAnimation(Videos.this,R.anim.clock);
        clock.startAnimation(anim);
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Вы уверены?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
        builder.setNegativeButton("Нет",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_videos, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        String ans = "";
        switch (v.getId()){
            case R.id.a:
                ans = tw1.getText().toString();
                break;
            case R.id.b:
                ans = tw2.getText().toString();
                break;
            case R.id.c:
                ans = tw3.getText().toString();
                break;
            case R.id.d:
                ans = tw4.getText().toString();
                break;
        }
        if(ans.equals(b[n.get(r)])){
            sound2.start();
            Toast.makeText(getApplicationContext(),"ВЕРНО!!!",Toast.LENGTH_SHORT).show();
            correct = true;
        }
        else{
            sound.start();
            Toast.makeText(getApplicationContext(),"НЕ ВЕРНО!!!",Toast.LENGTH_SHORT).show();
            correct = false;
        }
        thread.start();
    }

}

