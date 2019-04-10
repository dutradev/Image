package com.ductran.image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ductran.image.data.Images;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rclImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initData();
    }

    private void initViews() {
        rclImage = findViewById(R.id.rclImage);
        rclImage.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rclImage.setLayoutManager(layoutManager);

    }

    private void initData() {
        ArrayList<ImageData> imageList = prepareData();
        ImageAdapter adapter = new ImageAdapter(this, imageList);
        rclImage.setAdapter(adapter);
    }

    private ArrayList<ImageData> prepareData() {

        ArrayList<ImageData> imageList = new ArrayList<>();
        for (int i = 0; i < Images.getImageUrlList().size(); i++) {
            ImageData imageData = new ImageData();
            imageData.setImageContent(Images.getImageContent().get(i));
            imageData.setImageUrl(Images.getImageUrlList().get(i));
            imageList.add(imageData);
        }
        return imageList;
    }

}
