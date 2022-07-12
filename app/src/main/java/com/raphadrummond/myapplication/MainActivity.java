package com.raphadrummond.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView userView, paisView, posView, percentualView,texto1View, texto2View, posicao1View, posicao2View;
    private ImageView avatar;
    private RatingBar primeiraRating, segundaRating;

    private RequestQueue queue;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        components();
        requestUser();
    }

    private void components(){
        context = this;
        userView = findViewById(R.id.tvUser);
        paisView = findViewById(R.id.tvPais);
        posView = findViewById(R.id.tvPos);
        percentualView = findViewById(R.id.tvPercentual);
        texto1View = findViewById(R.id.tvTexto1);
        texto2View = findViewById(R.id.tvTexto2);
        posicao1View = findViewById(R.id.tvPosicao1);
        posicao2View = findViewById(R.id.tvPosicao2);
        avatar = findViewById(R.id.avatar);
        primeiraRating = findViewById(R.id.rb1);
        segundaRating = findViewById(R.id.rb2);


        queue = Volley.newRequestQueue(context);

    }

    private void requestUser(){
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                U.BASE_URL ,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            User testeUser = new User (
                                    response.getString("name" ),
                                    response.getInt("percentual"),
                                    response.getString("pos"),
                                    response.getString("pais"),
                                    response.getString("Copas_do_mundo_Vencidas"),
                                    response.getString("máximo"),
                                    response.getString("pla"),
                                    response.getInt("pos"),
                                    response.getString("Copas_do_Mundo_Disputadas"),
                                    response.getString("máximo"),
                                    response.getString("pla"),
                                    response.getInt("pos"),
                                    response.getString("img")
                            );
                            setComponents(testeUser);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        );
        queue.add(request);
    }

    private void setComponents(User user){
        userView.setText(user.getName());
        percentualView.setText(""+user.getPercentual());
        posView.setText(user.getPos());
        paisView.setText(user.getPais());
        texto1View.setText(user.getVencidas());
        primeiraRating.setNumStars(Integer.parseInt(user.getMaximo1()));
        primeiraRating.setRating(Float.parseFloat(""+user.getPla1()));
        posicao1View.setText(""+user.getPos1());
        texto2View.setText(user.getDisputadas());
        segundaRating.setNumStars(Integer.parseInt(""+user.getMaximo2()));
        segundaRating.setRating(Float.parseFloat(""+user.getPla2()));
        posicao2View.setText(""+user.getPos2());

        Glide.with(context).
                load(user.getAvatarUrl()).
                centerInside().
                into(avatar);



    }


}