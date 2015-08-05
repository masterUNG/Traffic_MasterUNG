package appewtc.masterung.traffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetailActivity extends AppCompatActivity {

    //Explicit
    private TextView showTitleTextView, showDetailTextView;
    private ImageView showTrafficImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        //Bind Widget
        bindWidget();

        //Show Widget
        showWidget();

    }   // onCreate

    private void showWidget() {

        //Receive from Intent
        int intClick = getIntent().getIntExtra("click", 0);

        //Show Title
        MyData objMyData = new MyData();
        String[] strTitle = objMyData.title();
        showTitleTextView.setText(strTitle[intClick]);

        //Show Traffic Image
        int[] intDrawable = objMyData.icon();
        showTrafficImageView.setImageResource(intDrawable[intClick]);

        //Show Detail
        String[] strDetail = getResources().getStringArray(R.array.traffic_detail);
        showDetailTextView.setText(strDetail[intClick]);


    }   // showWidget

    private void bindWidget() {
        showTitleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        showDetailTextView = (TextView) findViewById(R.id.txtDetail);
        showTrafficImageView = (ImageView) findViewById(R.id.imvTrafficDetail);
    }   // bindWidget

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_detail, menu);
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
}   // Main Class
