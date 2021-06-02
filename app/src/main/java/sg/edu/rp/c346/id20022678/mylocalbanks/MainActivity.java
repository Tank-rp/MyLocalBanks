package sg.edu.rp.c346.id20022678.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String worldClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(R.string.DBS);
            tvOCBC.setText(R.string.OCBC);
            tvUOB.setText(R.string.UOB);
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(R.string.星展银行);
            tvOCBC.setText(R.string.华侨银行);
            tvUOB.setText(R.string.大华银行);
            return true;
        } else {
            tvDBS.setText(R.string.Errortranslation);
            tvOCBC.setText(R.string.Errortranslation);
            tvUOB.setText(R.string.Errortranslation);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v == tvDBS){
            worldClicked = "DBS";
        }
        else if(v == tvOCBC){
            worldClicked = "OCBC";
        }
        else if(v == tvUOB){
            worldClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()== 1 ) {
            Toast.makeText(MainActivity.this, "Contact the bank is chosen", Toast.LENGTH_SHORT).show();
            if (worldClicked.equalsIgnoreCase("DBS")){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +"18001111111"));
                startActivity(i);
            }
            else if (worldClicked.equalsIgnoreCase("OCBC")){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(i);
            }
            else if(worldClicked.equalsIgnoreCase("UOB")){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +"18002222121"));
                startActivity(i);
            }
            return true;
        }
        else if(item.getItemId()== 0 ) {
            Toast.makeText(MainActivity.this, "Website is chosen", Toast.LENGTH_SHORT).show();
            if (worldClicked.equalsIgnoreCase("DBS")) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);
            }
            else if (worldClicked.equalsIgnoreCase("OCBC")) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(i);
            }
            else if (worldClicked.equalsIgnoreCase("UOB")) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(i);
            }

        }
        return super.onContextItemSelected(item);
    }
}