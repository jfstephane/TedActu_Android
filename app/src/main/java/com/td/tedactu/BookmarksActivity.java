package com.td.tedactu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.td.tedactu.models.Thumbnail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class BookmarksActivity extends YouTubeBaseActivity
{
    RecyclerView recyclerView;
    YoutubeAdapter youtubeAdapter;
    ArrayList<Thumbnail> videoIds;
    public static String title;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_bookmarks);

        recyclerView = findViewById(R.id.recyclerBookmarks);

        videoIds = new ArrayList<>();


        videoIds.add(new Thumbnail("tfr1VOUq1sA","Men pri kèk pwodui premye nesesite an Ayiti (jiyè 2020) | Ted’Actu"));
        videoIds.add(new Thumbnail("UftZhK_9IF0","Abitan koray ak Jerusalem ap rele anmwe pou leta ayisyen"));
        videoIds.add(new Thumbnail("tarRAraOE_o","Asasina, Vòl ak Kidnaping : vil Okay espesyalman « Nan Savann », yon gwo danje ?| Repòtaj Ted’Actu"));
        videoIds.add(new Thumbnail("zzdCFYGLWjk","Retour sur le passage des sélections nationales amputées en terre dominicaine"));
        videoIds.add(new Thumbnail("B2QITLt-lyQ","Plizyè dizèn milye moun debake devan ONU pou mande depa prezidan Jovenel Moise | Ted’Actu"));
        videoIds.add(new Thumbnail("skOhQGj9xXM","Polisye ki revoke yo pa dakò diskite ak Komisyon CSPN fòme a. Poukisa ? | Ted’Actu"));
        videoIds.add(new Thumbnail("0eFYsjsMy8M","Vizit lakay yon fanmi 8 moun nan Pòtoprens k ap viv de dlo ak sèl epi k ap manje tè | Ted'Actu"));
        videoIds.add(new Thumbnail("jfDK58lr65s","Manifestasyon : plizyè militan ap denonse move konpòtman polisye k ap maspinen yo | Ted’Actu"));
        videoIds.add(new Thumbnail("FRQJF7RJC3w","« Chèf yo tire sou mwen, tout kò m kraze, yo vòlè moto m (…) m pèdi lavi m ». | Ted’Actu"));
        videoIds.add(new Thumbnail("ndsktMs3DfE","Kèk Dirijan Politik pase al bay soutyen yo nan Baz 47 aprè asasina Badou"));
        videoIds.add(new Thumbnail("I4c1g6goUpM","Ted’Actu Vlog 001 - Vwayaj nan Chili ak BelO, BIC ak Jeanjean Roosevelt."));
        videoIds.add(new Thumbnail("Eol8OlOQJOg","Gwoup 17 Pati Politik alye Prezidan Jovenel Moise pran pozisyon l sou jounen 18 novanm nan"));
        videoIds.add(new Thumbnail("8h8rCrYo_KM","Chita pale ak Eudes Lajoie, Direktè Jeneral Ofis Nasyonal Migrasyon (ONM)"));
        videoIds.add(new Thumbnail("Y44TdZkmjJo","Mach Petwokaribe Nan Pòtoprens (Dimanch 9 sept 2018)"));
        videoIds.add(new Thumbnail("n9qf1VK8Al0","Lancement de DEZOD le tout nouveau-né de Power Surge"));
        videoIds.add(new Thumbnail("O8qVJlSawio","Diskou Prezidan Repiblik la, Jovenel Moïse, nan kad reouvèti lekòl la."));

        youtubeAdapter = new YoutubeAdapter(videoIds, BookmarksActivity.this);

        recyclerView.setLayoutManager(new LinearLayoutManager(BookmarksActivity.this));
        recyclerView.setAdapter(youtubeAdapter);


        toolbar = findViewById(R.id.toolbarfrag);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
    }

//    public String getVideoTitle(String id)
//    {
//
//        String videoURL = "https://www.googleapis.com/youtube/v3/videos?part=snippet&id=" + id +"&type=video&videoCaption=closedCaption&key=" + YoutubeConfig.getApiKey();
//
//        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
//        asyncHttpClient.get(videoURL, new JsonHttpResponseHandler(){
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                try
//                {
//                    JSONArray items = response.getJSONArray("items");
//                    JSONObject object = items.getJSONObject(0);
//                    title = object.getJSONObject("snippet").get("title").toString();
//
//                }
//                catch (JSONException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                Toast.makeText(getApplicationContext(), "Error: " + errorResponse, Toast.LENGTH_LONG).show();
//            }
//        });
//        return title;
//    }
/*
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

 */


}
