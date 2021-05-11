package sg.edu.rp.c346.id20017476.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit, btnReset;
    TextView tvShowName, tvDetail, tvContact;
    EditText etName, etNum, etGrp;
    TimePicker tp;
    DatePicker dp;
    CheckBox cbSmoke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.buttonSubmit);
        btnReset = findViewById(R.id.buttonReset);
        tvShowName = findViewById(R.id.textViewName);
        tvDetail = findViewById(R.id.textViewDetail);
        tvContact = findViewById(R.id.textViewContact);
        etName = findViewById(R.id.editTextName);
        etNum = findViewById(R.id.editTextPhone);
        etGrp = findViewById(R.id.editTextSize);
        tp = findViewById(R.id.TimePicker);
        dp = findViewById(R.id.DatePicker);
        cbSmoke = findViewById(R.id.checkBoxSmoking);

        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.updateDate(2021, 05,01);




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvShowName.setText("Hi "+ etName.getText()+"! Thank you for booking a reservation with us.");

                if(cbSmoke.isChecked()){
                  String message = "It will be on "+dp.getDayOfMonth() +"/"+(dp.getMonth()+1)+"/"+dp.getYear()+ ", at "+tp.getCurrentHour()+" : "+String.format("%02d",tp.getCurrentMinute())
                          +", group of "+etGrp.getText()+". Do note that it is a non-smoking area.";
                    tvDetail.setText(message);
                }else{
                   String message = "It will be on "+dp.getDayOfMonth() +"/"+(dp.getMonth()+1)+"/"+dp.getYear()+ ", at "+tp.getCurrentHour()+" : "+String.format("%02d",tp.getCurrentMinute())
                           +", group of "+etGrp.getText()+". Do note that it is a smoking area.";
                    tvDetail.setText(message);
                }
                tvContact.setText("We will be contacting you via "+etNum.getText()+" shorty after we updated your reservation with us. We hope you have a pleasant day ahead!");


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etNum.setText("");
                etGrp.setText("");
                tvShowName.setText("");
                tvDetail.setText("");
                tvContact.setText("");
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2021, 05,01);
            }
        });


    }
}