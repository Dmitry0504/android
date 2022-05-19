package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultBotTV;
    private TextView resultTopTV;
    private Button AC;
    private Button sign;
    private Button divide;
    private Button multiply;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button minus;
    private Button four;
    private Button five;
    private Button six;
    private Button plus;
    private Button one;
    private Button two;
    private Button three;
    private Button equals;
    private Button zero;
    private Button point;
    private Button sqrt;

    private MediaPlayer mp;
    private final MathFunction mathFunction = new MathFunction();
    private double firstNumber;
    private double secondNumber;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElements();
        setOnClickListeners();
    }

    private void setBotText(String text) {
        resultBotTV.setText(text);
    }

    private void setTopText(String text) {
        resultTopTV.setText(text);
    }

    private void appendText(String text) {
        String temp = (String) resultBotTV.getText();
        temp += text;
        setBotText(temp);
    }

    private View.OnClickListener mySetOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                switch (view.getId()) {
                    case R.id.one:
                        if (!resultBotTV.getText().equals("0"))
                            appendText("1");
                        else
                            setBotText("1");
                        break;
                    case R.id.two:
                        if (!resultBotTV.getText().equals("0"))
                            appendText("2");
                        else
                            setBotText("2");
                        break;
                    case R.id.three:
                        if (!resultBotTV.getText().equals("0"))
                            appendText("3");
                        else
                            setBotText("3");
                        break;
                    case R.id.four:
                        if (!resultBotTV.getText().equals("0"))
                            appendText("4");
                        else
                            setBotText("4");
                        break;
                    case R.id.five:
                        if (!resultBotTV.getText().equals("0"))
                            appendText("5");
                        else
                            setBotText("5");
                        break;
                    case R.id.six:
                        if (!resultBotTV.getText().equals("0"))
                            appendText("6");
                        else
                            setBotText("6");
                        break;
                    case R.id.seven:
                        if (!resultBotTV.getText().equals("0"))
                            appendText("7");
                        else
                            setBotText("7");
                        break;
                    case R.id.eight:
                        if (!resultBotTV.getText().equals("0"))
                            appendText("8");
                        else
                            setBotText("8");
                        break;
                    case R.id.nine:
                        if (!resultBotTV.getText().equals("0"))
                            appendText("9");
                        else
                            setBotText("9");
                        break;
                    case R.id.zero:
                        if (!resultBotTV.getText().equals("0"))
                            appendText("0");
                        break;
                    case R.id.AC:
                        setBotText("0");
                        firstNumber = 0;
                        secondNumber = 0;
                        break;
                    case R.id.sign:
                        if (resultBotTV.getText().charAt(0) == '-')
                            setBotText((String) resultBotTV.getText().subSequence(1, resultBotTV.getText().length()));
                        else if (!resultBotTV.getText().equals("0") )
                            setBotText("-" + resultBotTV.getText());
                        break;
                    case R.id.divide:
                        firstNumber = Double.parseDouble((String) resultBotTV.getText());
                        operation = "/";
                        setBotText("0");
                        break;
                    case R.id.multiply:
                        firstNumber = Double.parseDouble((String) resultBotTV.getText());
                        operation = "*";
                        setBotText("0");
                        break;
                    case R.id.minus:
                        firstNumber = Double.parseDouble((String) resultBotTV.getText());
                        operation = "-";
                        setBotText("0");
                        break;
                    case R.id.plus:
                        firstNumber = Double.parseDouble((String) resultBotTV.getText());
                        operation = "+";
                        setBotText("0");
                        break;
                    case R.id.sqrt:
                        firstNumber = Double.parseDouble((String) resultBotTV.getText());
                        firstNumber = mathFunction.sqrt(firstNumber);
                        setBotText(String.valueOf(firstNumber));
                        break;
                    case R.id.point:
                        if (resultBotTV.getText().charAt(resultBotTV.length() - 1) != '.')
                            appendText(".");
                        break;
                    case R.id.equals:
                        secondNumber = Double.parseDouble((String) resultBotTV.getText());
                        double result = 0;
                        switch (operation) {
                            case "+":
                                result = mathFunction.sum(firstNumber, secondNumber);
                                break;
                            case "-":
                                result = mathFunction.minus(firstNumber, secondNumber);
                                break;
                            case "*":
                                result = mathFunction.multiply(firstNumber, secondNumber);
                                break;
                            case "/":
                                result = mathFunction.divide(firstNumber, secondNumber);
                                break;
                        }
                        setBotText(String.valueOf(result));
                        setTopText(String.valueOf(result));
                        break;
                }
            }
        };
    }

    private void initElements() {
        resultBotTV = findViewById(R.id.resultBotTV);
        resultTopTV = findViewById(R.id.resultTopTV);
        AC = findViewById(R.id.AC);
        sign = findViewById(R.id.sign);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        minus = findViewById(R.id.minus);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        plus = findViewById(R.id.plus);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        equals = findViewById(R.id.equals);
        zero = findViewById(R.id.zero);
        point = findViewById(R.id.point);
        sqrt = findViewById(R.id.sqrt);
        mp = MediaPlayer.create(this, R.raw.beep_sound);
    }

    private void setOnClickListeners() {
        AC.setOnClickListener(mySetOnClickListener());
        sign.setOnClickListener(mySetOnClickListener());
        divide.setOnClickListener(mySetOnClickListener());
        multiply.setOnClickListener(mySetOnClickListener());
        seven.setOnClickListener(mySetOnClickListener());
        eight.setOnClickListener(mySetOnClickListener());
        nine.setOnClickListener(mySetOnClickListener());
        minus.setOnClickListener(mySetOnClickListener());
        four.setOnClickListener(mySetOnClickListener());
        five.setOnClickListener(mySetOnClickListener());
        six.setOnClickListener(mySetOnClickListener());
        plus.setOnClickListener(mySetOnClickListener());
        one.setOnClickListener(mySetOnClickListener());
        two.setOnClickListener(mySetOnClickListener());
        three.setOnClickListener(mySetOnClickListener());
        equals.setOnClickListener(mySetOnClickListener());
        zero.setOnClickListener(mySetOnClickListener());
        sqrt.setOnClickListener(mySetOnClickListener());
        point.setOnClickListener(mySetOnClickListener());
    }

}
