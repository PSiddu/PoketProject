package com.example.poketproject;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<FruitItem> fruits = new ArrayList<>();
    private String[] fruitEmojis = {"🍎", "🍌", "🍇", "🍉", "🍊", "🍓", "🍍", "🥝", "🍒", "🥭"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateFruitsOnce(); // Generate the list only once

        findViewById(R.id.showDialogButton).setOnClickListener(view -> {
            final BottomSheetDialog bottomSheet = new BottomSheetDialog(MainActivity.this);
            bottomSheet.setContentView(R.layout.bottom_sheet);

            RecyclerView recyclerView = bottomSheet.findViewById(R.id.fruitList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            FruitAdapter adapter = new FruitAdapter(fruits);
            recyclerView.setAdapter(adapter);

            bottomSheet.findViewById(R.id.closeButton).setOnClickListener(v -> bottomSheet.dismiss());

            bottomSheet.show();
        });
    }

    private void generateFruitsOnce() {
        if (fruits.isEmpty()) {
            Random random = new Random();
            for (int i = 1; i <= 100; i++) {
                String emoji = fruitEmojis[random.nextInt(fruitEmojis.length)];
                fruits.add(new FruitItem("Fruit " + i, emoji));
            }
        }
    }
}
