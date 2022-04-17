package com.example.p0141_menuadv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chb1, chb2;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chb1 = (CheckBox) findViewById(R.id.checkBox);
        chb2 = (CheckBox) findViewById(R.id.checkBox2);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        final MenuItem action_mail = menu.findItem(R.id.action_mail);
        chb2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                if (chb2.isChecked()) {
                    action_mail.setVisible(true);
                } else if (!chb2.isChecked()) {
                    action_mail.setVisible(false);
                }
            }
        });


        menu.setGroupVisible(R.id.group1, chb1.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        menu.add(2, 4, 4, "item4").setCheckable(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      /*  if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, getString(R.string.action_settings), Toast.LENGTH_LONG).show();
        } else  if (id == R.id.action_item1) {
            Toast.makeText(MainActivity.this, getString(R.string.action_item1), Toast.LENGTH_LONG).show();
        } else  if (id == R.id.action_item2) {
            Toast.makeText(MainActivity.this, getString(R.string.action_item2), Toast.LENGTH_LONG).show();
        } else  if (id == R.id.action_item3) {
            Toast.makeText(MainActivity.this, getString(R.string.action_item3), Toast.LENGTH_LONG).show();
        }*/

        switch (id) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, getString(R.string.action_settings), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_item1:
                Toast.makeText(MainActivity.this, getString(R.string.action_item1), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_item2:
                Toast.makeText(MainActivity.this, getString(R.string.action_item2), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_item3:
                Toast.makeText(MainActivity.this, getString(R.string.action_item3), Toast.LENGTH_LONG).show();
                break;
            case 4:
                item.setChecked(!item.isChecked());
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
