package edu.temple.colorfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PaletteFragment.OnFragmentInteractionListener {

    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;
    private String[] colorsHex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Color Fragment Activity");
        Resources res = this.getResources();
        final String[] colors = res.getStringArray(R.array.color_array);
        colorsHex = res.getStringArray(R.array.color_hex_array);
        paletteFragment = PaletteFragment.newInstance(colors, colorsHex);
        canvasFragment = CanvasFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, canvasFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, paletteFragment).commit();
    }

    @Override
    public void onFragmentInteraction(int position) {
        if (position > 0) {
            canvasFragment.changeBackgroundColor(colorsHex[position]);
        }
    }
}