package org.techtown.ex0419;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonActivity extends AppCompatActivity {

    TextView tvJson;

    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        tvJson = findViewById(R.id.tvJson);

        queue = Volley.newRequestQueue(JsonActivity.this);

        int method = Request.Method.GET;
        String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220418";

        request = new StringRequest(
                method,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //1.문자열 데이터 -> JSON객체로 변환
                        //2.JSON객체에서 "boxOfficeResult"로 데이터 접근
                        //3.접근한 데이터 (JSONObject)에서 "dailyBoxOfficeList로 JSONAarray 데이터 접근
                        //4.영화 순위(rank),영화명(movieNm)를 텍스트 뷰에 출력
                        try {
                            JSONObject obj = new JSONObject(response); //alt+enter
                            JSONObject result = obj.getJSONObject("boxOfficeResult");
                            JSONArray jsonArr = result.getJSONArray("dailyBoxOfficeList");

                                String data="";
                                StringBuffer sb = new StringBuffer();

                            for(int i =0; i<jsonArr.length();i++){
                                JSONObject movie = jsonArr.getJSONObject(i);

                                String rank=movie.getString("rank");
                                String movieNm = movie.getString("movieNm");

                                //data += rank + "." + movieNm + "\n";

                                sb.append(rank);
                                sb.append(".");
                                sb.append(movieNm);
                                sb.append("\n");

                            }
                            tvJson.setText(sb.toString());//누적됐던 데이터를 한번에!

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(JsonActivity.this,
                                error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }

        );

        queue.add(request);
    }
}