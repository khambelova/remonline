package com.example.habik.lineservice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RepairCostActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText problemEditText;
    List<Problem> problemList = new ArrayList<>();
    List<Problem> appropriateProblemList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_cost);

        setInitialData();
        createRecyclerView(problemList);

        problemEditText = (EditText)findViewById(R.id.problemEditText);
        problemEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String enteredText = problemEditText.getText().toString();
                for (Problem problem : problemList) {
                    if (problem.getProblemName().contains(enteredText)){
                        appropriateProblemList.add(problem);
                        //TODO: Очищать ресайклер и сделать ту ловеркейс
                    }
                }

                createRecyclerView(appropriateProblemList);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void createRecyclerView (List<Problem> problemList){
        recyclerView = (RecyclerView)findViewById(R.id.problemRecycler);
        ProblemDataAdapter adapter = new ProblemDataAdapter(this,problemList);
        recyclerView.setAdapter(adapter);
    }

   private void setInitialData(){
        problemList.add(new Problem("Сломался телефон","1500"));
       problemList.add(new Problem("Сломалась стиральная машина","5000"));
       problemList.add(new Problem("Сломалась машина","15000"));
       problemList.add(new Problem("Сломалась посудомоечная машина","1000"));
       problemList.add(new Problem("Выключился ноутбук","2000"));
       problemList.add(new Problem("Сломался ноутбук","1500"));
       problemList.add(new Problem("Села батарейка","500"));
       problemList.add(new Problem("Плата слетела","4000"));
       problemList.add(new Problem("Сломался компьютер","2500"));
       problemList.add(new Problem("Сломался системный блок","3500"));
       problemList.add(new Problem("Сломался телефон","1500"));
       problemList.add(new Problem("Сломалась стиральная машина","5000"));
       problemList.add(new Problem("Сломалась машина","15000"));
       problemList.add(new Problem("Сломалась посудомоечная машина","1000"));
       problemList.add(new Problem("Выключился ноутбук","2000"));
       problemList.add(new Problem("Сломался ноутбук","1500"));
       problemList.add(new Problem("Села батарейка","500"));
       problemList.add(new Problem("Плата слетела","4000"));
       problemList.add(new Problem("Сломался компьютер","2500"));
       problemList.add(new Problem("Сломался системный блок","3500"));
       problemList.add(new Problem("Сломался телефон","1500"));
       problemList.add(new Problem("Сломалась стиральная машина","5000"));
       problemList.add(new Problem("Сломалась машина","15000"));
       problemList.add(new Problem("Сломалась посудомоечная машина","1000"));
       problemList.add(new Problem("Выключился ноутбук","2000"));
       problemList.add(new Problem("Сломался ноутбук","1500"));
       problemList.add(new Problem("Села батарейка","500"));
       problemList.add(new Problem("Плата слетела","4000"));
       problemList.add(new Problem("Сломался компьютер","2500"));
       problemList.add(new Problem("Сломался системный блок","3500"));

    }

}
