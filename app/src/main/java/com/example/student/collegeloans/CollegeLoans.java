package com.example.student.collegeloans;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.text.Editable;
import android.util.Log;


public class CollegeLoans extends ActionBarActivity {

    private double loanAmount;
    private double loanRate;
    private EditText loanAmountEditText;
    private EditText loanRateEditText;
    private EditText fiveYearsEditText;
    private EditText tenYearsEditText;
    private EditText fifteenYearsEditText;
    private EditText twentyYearsEditText;
    private EditText twentyFiveYearsEditText;
    private EditText thirtyYearsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_loans);

        //get references to EditTexts
        //getting the view from the layout assigned in setContentView() above
        loanAmountEditText = (EditText)findViewById(R.id.loanAmountEditText);
        loanRateEditText = (EditText)findViewById(R.id.loanRateEditText);
        fiveYearsEditText = (EditText)findViewById(R.id.fiveYearsEditText);
        tenYearsEditText = (EditText)findViewById(R.id.tenYearsEditText);
        fifteenYearsEditText = (EditText)findViewById(R.id.fifteenYearsEditText);
        twentyYearsEditText = (EditText)findViewById(R.id.twentyYearsEditText);
        twentyFiveYearsEditText = (EditText)findViewById(R.id.twentyFiveYearsEditText);
        thirtyYearsEditText = (EditText)findViewById(R.id.thirtyYearsEditText);

        // handle onTextChanged event in loanAmount
        loanAmountEditText.addTextChangedListener(loanAmountTextWatcher);

        // handle onTextChanged event in loanRate
        loanRateEditText.addTextChangedListener(loanRateTextWatcher);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_college_loans, menu);
        return true;
    }

    //calculate loan total given loanAmount and loanRate
    private double calculateLoanTotal(double loanAmount, double loanRate, double years)
    {
        double p = loanAmount;
        double r = loanRate/1200;
        double n = years;
        double exp = Math.pow( (1+r), n);

        double loanTotal = (p * r * exp) / (exp -1);

//        double loanTotal = ( (loanAmount * (loanRate/1200) * Math.pow((1+loanRate), 12*years) ) / ( Math.pow((1+loanRate), 12*years) -1) );
        System.out.println("LOAN AMOUNT : " + loanAmount);
        System.out.println("LOAN RATE: " + loanRate);
        System.out.println("LOAN YEARS: " + years);
        System.out.println("LOAN TOTAL CALCULATED: " + loanTotal);
        return loanTotal;

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

    private TextWatcher loanAmountTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // convert fiveYearsEditText, tenYearsEditText, fifteenYearsEditText, etc to double
            // only using parameter "s" which contains a copy of the text
            // the other parameters indicate "count" characters starting at "start"
            // replaced previous text of length before

            // calculate total with 5 years loan
            try {
                loanAmount = Double.parseDouble((s.toString()));
                loanRate = Double.parseDouble(loanRateEditText.getText().toString());
            } catch (NumberFormatException e) {
                loanAmount = 1;
                loanRate = .1;
            }

            //calculate 5 Years Loan Total
            double fiveYearLoan = calculateLoanTotal(loanAmount, loanRate, 5.0);
            fiveYearsEditText.setText(String.format("$%.02f", fiveYearLoan));

            //calculate 10 Years Loan Total
            double tenYearLoan = calculateLoanTotal(loanAmount, loanRate, 10.0);
            tenYearsEditText.setText(String.format("$%.02f", tenYearLoan));

            //calculate 15 Years Loan Total
            double fifteenYearLoan = calculateLoanTotal(loanAmount, loanRate, 15.0);
            fifteenYearsEditText.setText(String.format("$%.02f", fifteenYearLoan));

            //calculate 20 Years Loan Total
            double twentyYearLoan = calculateLoanTotal(loanAmount, loanRate, 20.0);
            twentyYearsEditText.setText(String.format("$%.02f", twentyYearLoan));

            //calculate 25 Years Loan Total
            double twentyFiveYearLoan = calculateLoanTotal(loanAmount, loanRate, 25.0);
            twentyFiveYearsEditText.setText(String.format("$%.02f", twentyFiveYearLoan));

            //calculate 30 Years Loan Total
            double thirtyYearLoan = calculateLoanTotal(loanAmount, loanRate, 30.0);
            thirtyYearsEditText.setText(String.format("$%.02f", thirtyYearLoan));

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher loanRateTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // convert fiveYearsEditText, tenYearsEditText, fifteenYearsEditText, etc to double
            // only using parameter "s" which contains a copy of the text
            // the other parameters indicate "count" characters starting at "start"
            // replaced previous text of length before

            // calculate total with 5 years loan
            try {
                loanAmount = Double.parseDouble(loanAmountEditText.getText().toString());
                loanRate = Double.parseDouble((s.toString()));
            } catch (NumberFormatException e) {
                loanAmount = 1;
                loanRate = .1;
            }

            //calculate 5 Years Loan Total
            double fiveYearLoan = calculateLoanTotal(loanAmount, loanRate, 5.0);
            fiveYearsEditText.setText(String.format("$%.2f", fiveYearLoan));

            //calculate 10 Years Loan Total
            double tenYearLoan = calculateLoanTotal(loanAmount, loanRate, 10.0);
            tenYearsEditText.setText(String.format("$%.2f", tenYearLoan));

            //calculate 15 Years Loan Total
            double fifteenYearLoan = calculateLoanTotal(loanAmount, loanRate, 15.0);
            fifteenYearsEditText.setText(String.format("$%.02f", fifteenYearLoan));

            //calculate 20 Years Loan Total
            double twentyYearLoan = calculateLoanTotal(loanAmount, loanRate, 20.0);
            twentyYearsEditText.setText(String.format("$%.02f", twentyYearLoan));

            //calculate 25 Years Loan Total
            double twentyFiveYearLoan = calculateLoanTotal(loanAmount, loanRate, 25.0);
            twentyFiveYearsEditText.setText(String.format("$%.02f", twentyFiveYearLoan));

            //calculate 30 Years Loan Total
            double thirtyYearLoan = calculateLoanTotal(loanAmount, loanRate, 30.0);
            thirtyYearsEditText.setText(String.format("$%.02f", thirtyYearLoan));

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
