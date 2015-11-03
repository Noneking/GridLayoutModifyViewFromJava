package com.example.mantenimiento.gridlayoutmodifyviewfromjava;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        añadirBotones(17);
        recorrer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void recorrer()
    {
        GridLayout gridLayout= (GridLayout) findViewById(R.id.gridLayout);
        Button b;

        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            View v;
            v=gridLayout.getChildAt(i);
            if(v.getClass().getSimpleName().equals("Button"))
            {
                b= (Button) v;
                b.setBackgroundColor(Color.rgb(i*5,i*5,i*5));
            }
        }
    }

    public void añadirBotones(int cantidad)
    {
        GridLayout gridLayout= (GridLayout) findViewById(R.id.gridLayout);
        Button b;

        for(int i=0;i<cantidad;i++)
        {
            b=new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            b.setId(View.generateViewId());

            if(i==cantidad-1)
            {
                b.setText("RESET");
            }
            else
            {
                b.setText("Boton "+i);
            }
            gridLayout.addView(b);
            b.setOnClickListener(this);
        }

    }

    public void onClick(View v)
    {
        Button b;
        if(v.getClass().getSimpleName().equals("Button"))
        {
            b= (Button) v;
            if(b.getText().equals("RESET"))
            {
                recorrer();
            }
            else
            {
                b.setBackgroundColor(Color.rgb(250,250,250));
            }
        }
    }

}
