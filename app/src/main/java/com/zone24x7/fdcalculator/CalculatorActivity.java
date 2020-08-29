package com.zone24x7.fdcalculator;

import com.zone24x7.fdcalculator.pojo.CalculationPojo;
import com.zone24x7.fdcalculator.service.BankService;
import com.zone24x7.fdcalculator.service.CalculatorService;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class CalculatorActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    private EditText amountEditView;
    private Spinner durationView;
    private TextView interestRateView;
    private TextView resultInterest;
    private TextView resultTotal;

    private double interestRate = 0.0;
    private int noOfMonths = 0;

    private BankService bankService;
    private CalculatorService calculatorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        amountEditView = findViewById(R.id.amount_editText);
        durationView = findViewById(R.id.month_spinner);
        interestRateView = findViewById(R.id.rate_view);
        resultInterest = findViewById(R.id.result_interest);
        resultTotal = findViewById(R.id.result_total);

        bankService = new BankService();

        durationView.setOnItemSelectedListener(this);

        ArrayAdapter a = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, bankService.getAvailableMonths());
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        durationView.setAdapter(a);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        noOfMonths = bankService.getAvailableMonths()[position];
        interestRate = bankService.getAvailableRates()[position];
        interestRateView.setText(String.valueOf(interestRate));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onSubmit(View view){
        int amount = Integer.parseInt(amountEditView.getText().toString());
        CalculationPojo calculationPojo = new CalculationPojo(amount,noOfMonths,interestRate);
        calculatorService = new CalculatorService(calculationPojo);

        resultInterest.setText("Your interest is : "+calculatorService.getInterest()+"/=");
        resultTotal.setText("Your total is : "+calculatorService.getTotal()+"/=");
    }
}
