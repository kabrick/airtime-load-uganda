package com.kabricks.loadairtimeuganda.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kabricks.loadairtimeuganda.R;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.kabricks.loadairtimeuganda.core.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScanAirtime extends AppCompatActivity {

    String network_name, pincode, networkcode;
    @BindView(R.id.auto_focus) CompoundButton autoFocus;
    @BindView(R.id.use_flash) CompoundButton useFlash;
    @BindView(R.id.cameraButton) Button cameraButton;
    @BindView(R.id.network_name) TextView net_name;
    @BindView(R.id.voucher_number) TextView voucher_number;
    int cameraResult = 0;
    private static final int RC_OCR_CAPTURE = 9003;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        network_name = bundle.getString("network_name");

        setContentView(R.layout.activity_scan_airtime);
        ButterKnife.bind(this);
        setCameraButton();

        assert network_name != null;
        switch (network_name){
            case "airtel":
                setNetworkName("Airtel Uganda");
                networkcode = "*130*";
                break;
            case "mtn":
                setNetworkName("MTN Uganda");
                networkcode = "*130*";
                break;
            case "africell":
                setNetworkName("Africell Uganda");
                networkcode = "*130*";
                break;
            case "utl":
                setNetworkName("UTL Uganda");
                networkcode = "*130*";
                break;
            case "vodafone":
                setNetworkName("Vodafone Uganda");
                networkcode = "*130*";
                break;
            case "smart":
                setNetworkName("Smart Telecom");
                networkcode = "*130*";
                break;
        }
    }

    public void setCameraButton(){
        if(cameraResult == 0){
            cameraButton.setText("Scan Airtime Voucher");
        } else {
            cameraButton.setText("Retry Scan");
        }
    }

    public void takePhoto(View view){
        Intent intent = new Intent(this, OcrCaptureActivity.class);
        intent.putExtra(OcrCaptureActivity.AutoFocus, autoFocus.isChecked());
        intent.putExtra(OcrCaptureActivity.UseFlash, useFlash.isChecked());

        startActivityForResult(intent, RC_OCR_CAPTURE);
    }

    public void sendUssd(View view){
        //check if values are all there and submit
        if(pincode != null){
            Util.callUssd(this, pincode, networkcode);
        } else {
            Toast.makeText(this, "Please complete scan to proceed", Toast.LENGTH_SHORT).show();
        }
    }

    public void setNetworkName(String name){
        net_name.setText(name);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RC_OCR_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    pincode = data.getStringExtra(OcrCaptureActivity.TextBlockObject);
                    voucher_number.setText(pincode);
                    cameraResult = 1;
                    setCameraButton();
                }
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
