package com.example.habik.lineservice.RepairCost;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.habik.lineservice.API.NetworkService;
import com.example.habik.lineservice.Main.Constants;
import com.example.habik.lineservice.Main.MainActivity;
import com.example.habik.lineservice.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepairCostActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText problemEditText;
    List<Problem> problemList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_cost);

        getAllServices();

        problemEditText = (EditText)findViewById(R.id.problemEditText);
        problemEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<Problem> appropriateProblemList = new ArrayList<>();

                String enteredText = problemEditText.getText().toString();
                for (Problem problem : problemList) {
                    if (problem.getProblemName().toLowerCase().contains(enteredText.toLowerCase())){
                        appropriateProblemList.add(problem);
                    }
                }
                createRecyclerView(appropriateProblemList);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void createRecyclerView (List<Problem> problemListInRecycler){
        recyclerView = (RecyclerView)findViewById(R.id.problemRecycler);
        ProblemDataAdapter adapter = new ProblemDataAdapter(this,problemListInRecycler);
        recyclerView.setAdapter(adapter);
    }

    private void getAllServices(){

        NetworkService.getInstance().getJSONApi().getServicesPrices(MainActivity.currentToken).enqueue(new Callback<Services>() {
            @Override
            public void onResponse(Call<Services> call, Response<Services> response) {
                Services services = response.body();
                for (int i = 0; i < services.getData().length; i++) {
                    problemList.add(new Problem(services.getData()[i].getProblemName(),services.getData()[i].getProblemCost().replace(".0","")));
                }
                createRecyclerView(problemList);
            }

            @Override
            public void onFailure(Call<Services> call, Throwable t) {
                Toast.makeText(getApplicationContext(), Constants.NETWORK_ERROR,Toast.LENGTH_LONG).show();
            }
        });

    }

}