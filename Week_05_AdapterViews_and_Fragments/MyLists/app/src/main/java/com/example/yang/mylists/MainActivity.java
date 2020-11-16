package com.example.yang.mylists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] candidateNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        candidateNames = getResources().getStringArray(R.array.candidateNames);

        listView = (ListView) findViewById(R.id.listViewSimple);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, candidateNames);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getBaseContext(), candidateNames[position] + ", seriously?", Toast.LENGTH_SHORT).show();
                    }
                }
        );

//        List<String> candidateNamesNew = new ArrayList<String>(Arrays.asList(candidateNames));
//        ArrayAdapter<String> arrayAdapterNew = new ArrayAdapter<String>(this, android.R.layout
//                .simple_list_item_1, candidateNamesNew);
//        listView.setAdapter(arrayAdapterNew);
//        arrayAdapterNew.add("New Someone");
//        arrayAdapter.notifyDataSetInvalidated();
    }

    public void onButtonClick(View v) {
        switch (v.getId()) {
            case R.id.complexList:
                startActivity(new Intent(this, PhotoListActivity.class));
                break;
            case R.id.gridView:
                startActivity(new Intent(this, GridActivity.class));
                break;
        }
    }
}
