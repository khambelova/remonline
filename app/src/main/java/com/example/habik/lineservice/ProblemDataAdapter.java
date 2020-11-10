package com.example.habik.lineservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProblemDataAdapter extends RecyclerView.Adapter<ProblemDataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Problem> problemList;

    public ProblemDataAdapter(Context context, List<Problem> problemList) {
        this.problemList = problemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ProblemDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.problem_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProblemDataAdapter.ViewHolder viewHolder, int i) {
        Problem problem = problemList.get(i);
        viewHolder.problemName.setText(problem.getProblemName());
        viewHolder.problemCost.setText(problem.getProblemCost());
    }

    @Override
    public int getItemCount() {
        return problemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView problemName,problemCost;
        ViewHolder(View view){
            super(view);
            problemName = (TextView) view.findViewById(R.id.problemName);
            problemCost = (TextView) view.findViewById(R.id.problemCost);
        }
    }
}