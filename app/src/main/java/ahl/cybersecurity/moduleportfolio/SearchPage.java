package ahl.cybersecurity.moduleportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SearchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);
        Button searchbut = (Button) findViewById(R.id.search_button);
        TextView text = (TextView) findViewById(R.id.search_results);
        text.setText("YEEEE");
        searchbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestFSAData(v);
            }
        });
    }

    public void requestFSAData(View view){
        TextView text = (TextView) findViewById(R.id.search_results);
        text.setText("NUUUU");
        RequestQueue request = Volley.newRequestQueue(getApplicationContext());
        final String dataurl = "http://api.ratings.food.gov.uk/Regions";
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, dataurl,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("result", (String.valueOf(response)));
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("DAFUC", (String.valueOf(error)));
                    }
                }){
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("x-api-version", "2");
                headers.put("accept", "application/json");
                headers.put("content-type", "application/json");
                return headers;
            }
        };
        request.add(getRequest);
    }
}
