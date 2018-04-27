package in.arpaul.googlevisionsample.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import in.arpaul.googlevisionsample.R;

import static in.arpaul.googlevisionsample.common.AppConstant.AUTOFOCUS;
import static in.arpaul.googlevisionsample.common.AppConstant.RC_OCR_CAPTURE;
import static in.arpaul.googlevisionsample.common.AppConstant.USEFLASH;

public class MainActivity extends AppCompatActivity {

    private TextView tvStatusMessage, tvValue;
    private Button btnDetect;
    private CompoundButton cbAutoFocus, cbUseFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseUiControls();

        btnDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OcrCaptureActivity.class);
                intent.putExtra(AUTOFOCUS, cbAutoFocus.isChecked());
                intent.putExtra(USEFLASH, cbUseFlash.isChecked());

                startActivityForResult(intent, RC_OCR_CAPTURE);
            }
        });
    }

    void initialiseUiControls() {
        tvStatusMessage = (TextView)findViewById(R.id.tvStatusMessage);
        tvValue = (TextView)findViewById(R.id.tvValue);

        cbAutoFocus = (CompoundButton) findViewById(R.id.cbAutoFocus);
        cbUseFlash = (CompoundButton) findViewById(R.id.cbUseFlash);

        btnDetect = (Button) findViewById(R.id.btnDetect);
    }
}
