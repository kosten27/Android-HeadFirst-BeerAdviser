package ua.sten.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

        final Spinner color = (Spinner) findViewById(R.id.color);
        Button findBeer = (Button) findViewById(R.id.find_beer);
        final TextView brands = (TextView) findViewById(R.id.brands);

        findBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> brandsL = new BeerExpert().getBrands(color.getSelectedItem().toString());
                String brandsStr = "";
                for(int i = 0; i < brandsL.size(); i++) {
                    brandsStr += brandsL.get(i) + "\n";
                }
                brands.setText(brandsStr);
            }
        });
    }
}
