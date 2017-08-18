package com.example.srikanth.test1;
/**
 * Created by Srikanth on 16/08/2017.
 */

//Importing packages
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //declaring variables
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager rvLayoutManager;
    private RecyclerView.Adapter rvAdapter;
    private ArrayList<String> dataSet;
    private Button b1,b2,b3;
    private ScrollView sv;
    private ViewPager viewPager;
    FragementAdapter fragmentAdapter;
    private TextView resultTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataSet=new ArrayList<>();
        for (int i = 0; i <5; i++) {
            dataSet.add("item "+(i+1));
        }

        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.redButton);
        b2=(Button)findViewById(R.id.Greenbutton);
        b3=(Button)findViewById(R.id.blueButton);
        sv=(ScrollView)findViewById(R.id.scrollView);
        resultTextView=(TextView)findViewById(R.id.outputTextView);


        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(rvLayoutManager);
        rvAdapter= new MainAdapter(dataSet,this,resultTextView);
        recyclerView.setAdapter(rvAdapter);
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewPager);
        fragmentAdapter = new FragementAdapter(getSupportFragmentManager());
        vpPager.setAdapter(fragmentAdapter);

        resultTextView.setText("hello");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv.setBackgroundColor(Color.RED);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv.setBackgroundColor(Color.GREEN);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv.setBackgroundColor(Color.BLUE);

            }
        });

    }
    public void setText(String s){
        resultTextView.setText("Please select one the items........ ");
    }

}
