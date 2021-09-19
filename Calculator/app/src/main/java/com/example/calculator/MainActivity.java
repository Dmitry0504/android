package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
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

    private MathFunction mathFunction = new MathFunction();
    private double firstNumber;
    private double secondNumber;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
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

        AC.setOnClickListener(oclAC());
        sign.setOnClickListener(oclSign());
        divide.setOnClickListener(oclDivide());
        multiply.setOnClickListener(oclMultiply());
        seven.setOnClickListener(oclSeven());
        eight.setOnClickListener(oclEight());
        nine.setOnClickListener(oclNine());
        minus.setOnClickListener(oclMinus());
        four.setOnClickListener(oclFour());
        five.setOnClickListener(oclFive());
        six.setOnClickListener(oclSix());
        plus.setOnClickListener(oclPlus());
        one.setOnClickListener(oclOne());
        two.setOnClickListener(oclTwo());
        three.setOnClickListener(oclThree());
        equals.setOnClickListener(oclEquals());
        zero.setOnClickListener(oclZero());
        sqrt.setOnClickListener(oclSqrt());
        point.setOnClickListener(oclPoint());

    }

    private void setText(String text) {
        textView.setText(text);
    }

    private void appendText(String text) {
        String temp = (String) textView.getText();
        temp += text;
        setText(temp);
    }

    private View.OnClickListener oclOne() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textView.getText().equals("0"))
                    appendText("1");
                else
                    setText("1");
            }
        };
    }

    private View.OnClickListener oclTwo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textView.getText().equals("0"))
                    appendText("2");
                else
                    setText("2");
            }
        };
    }

    private View.OnClickListener oclThree() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textView.getText().equals("0"))
                    appendText("3");
                else
                    setText("3");
            }
        };
    }

    private View.OnClickListener oclFour() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textView.getText().equals("0"))
                    appendText("4");
                else
                    setText("4");
            }
        };
    }

    private View.OnClickListener oclFive() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textView.getText().equals("0"))
                    appendText("5");
                else
                    setText("5");
            }
        };
    }

    private View.OnClickListener oclSix() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textView.getText().equals("0"))
                    appendText("1");
                else
                    setText("1");
            }
        };
    }

    private View.OnClickListener oclSeven() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textView.getText().equals("0"))
                    appendText("7");
                else
                    setText("7");
            }
        };
    }

    private View.OnClickListener oclEight() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textView.getText().equals("0"))
                    appendText("8");
                else
                    setText("8");
            }
        };
    }

    private View.OnClickListener oclNine() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textView.getText().equals("0"))
                    appendText("9");
                else
                    setText("9");
            }
        };
    }

    private View.OnClickListener oclZero() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textView.getText().equals("0"))
                    appendText("0");
            }
        };
    }

    private View.OnClickListener oclAC() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("0");
                firstNumber = 0;
                secondNumber = 0;
            }
        };
    }

    private View.OnClickListener oclSign() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().charAt(0) == '-')
                    setText((String) textView.getText().subSequence(1, textView.getText().length()));
                else if (!textView.getText().equals("0") )
                    setText("-" + textView.getText());
            }
        };
    }

    private View.OnClickListener oclDivide() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumber = Double.parseDouble((String) textView.getText());
                operation = "/";
                setText("0");
            }
        };
    }

    private View.OnClickListener oclMultiply() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumber = Double.parseDouble((String) textView.getText());
                operation = "*";
                setText("0");
            }
        };
    }

    private View.OnClickListener oclMinus() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumber = Double.parseDouble((String) textView.getText());
                operation = "-";
                setText("0");
            }
        };
    }

    private View.OnClickListener oclPlus() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumber = Double.parseDouble((String) textView.getText());
                operation = "+";
                setText("0");
            }
        };
    }

    private View.OnClickListener oclSqrt() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumber = Double.parseDouble((String) textView.getText());
                firstNumber = mathFunction.sqrt(firstNumber);
                setText(String.valueOf(firstNumber));
            }
        };
    }

    private View.OnClickListener oclPoint() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().charAt(textView.length() - 1) != '.')
                appendText(".");
            }
        };
    }

    private View.OnClickListener oclEquals() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondNumber = Double.parseDouble((String) textView.getText());
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
                setText(String.valueOf(result));
            }
        };
    }


}
