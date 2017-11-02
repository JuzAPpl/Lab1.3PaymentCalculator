package my.edu.tarc.lab13paymentcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewMonthlyPayment, textViewStatus;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewMonthlyPayment = (TextView)findViewById(R.id.textViewMonthlyPayment);
        textViewStatus=(TextView)findViewById(R.id.textViewStatus);
        imageViewResult = (ImageView)findViewById(R.id.imageViewResult);

        //To get the intent
        Intent intent = getIntent(); //Asking "who called me?"
        double payment = intent.getDoubleExtra(MainActivity.LOAN_PAYMENT, 0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);

        //TODO: display outputs
        textViewMonthlyPayment.setText(textViewMonthlyPayment.getText() + " " + payment);
        textViewStatus.setText(textViewStatus.getText() + " " + status);
        if(!status.equals("Approved"))
            imageViewResult.setImageResource(R.drawable.down);
        imageViewResult.setVisibility(View.VISIBLE);
    }

    public void closeActivity(View view){
        //Terminate activiry
        finish();
    }
}
