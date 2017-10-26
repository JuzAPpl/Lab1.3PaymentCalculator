package my.edu.tarc.lab13paymentcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSalary, editTextPrice, editTextDownPayment, editTextIRate, editTextRepaymentMonth;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextDownPayment = (EditText)findViewById(R.id.editTextDownPayment);
        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextSalary = (EditText)findViewById(R.id.editTextSalary);
        editTextIRate = (EditText)findViewById(R.id.editTextInterestRate);
        editTextRepaymentMonth = (EditText)findViewById(R.id.editTextRepaymentMonth);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
    }

    protected void calculateMonthlyPayment(View view){
        double salary, price, downPayment, rate, month;
        double interest, totalPay, monthlyPay;

        salary = Double.parseDouble(editTextSalary.getText().toString());
        price = Double.parseDouble(editTextPrice.getText().toString());
        downPayment = Double.parseDouble(editTextDownPayment.getText().toString());
        rate = Double.parseDouble(editTextIRate.getText().toString());
        rate /=100;
        month = Double.parseDouble(editTextRepaymentMonth.getText().toString());

        interest = (price-downPayment)*rate*month/12;
        totalPay = price-downPayment+interest;
        monthlyPay = totalPay/month;

        if(monthlyPay/salary<0.3){
            textViewResult.setText(String.format("Month Payment: RM%.2f\nYou are eligible to apply for a loan.",monthlyPay ));
        }
        else {
            textViewResult.setText(String.format("Month Payment: RM%.2f\nYou are not eligible to apply for a loan because you are too poor.",monthlyPay ));
        }
    }

    protected void resetFields(View view){
        editTextDownPayment.setText("");
        editTextPrice.setText("");
        editTextSalary.setText("");
        editTextIRate.setText("");
        editTextRepaymentMonth.setText("");
        textViewResult.setText("");
    }
}
