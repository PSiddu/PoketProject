package com.example.poketproject;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private List<FruitItem> fruits;

    public FruitAdapter(List<FruitItem> fruits) {
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new FruitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        FruitItem fruitItem = fruits.get(position);
        holder.fruitName.setText(fruitItem.getDisplayName());
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    static class FruitViewHolder extends RecyclerView.ViewHolder {
        TextView fruitName;

        FruitViewHolder(View itemView) {
            super(itemView);
            fruitName = itemView.findViewById(android.R.id.text1);
        }
    }
}

