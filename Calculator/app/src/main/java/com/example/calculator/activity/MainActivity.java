package com.example.calculator.activity;

import static com.example.calculator.util.Operator.ADDITION;
import static com.example.calculator.util.Operator.DIVISION;
import static com.example.calculator.util.Operator.MULTIPLICATION;
import static com.example.calculator.util.Operator.SUBTRACTION;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.R;

public class MainActivity extends AppCompatActivity {
    TextView numberLabel;
    Button deleteButton, divisionButton, multiplicationButton, additionButton, subtractionButton, resultButton;
    Button zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eigthButton, nineButton;

    String firstNumber = "", secondNumber = "", resultOperation = "";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initDeclarationIds();
        deleteOperation();
        multiplicationButtonListener();
        divisionButtonListener();
        additionButtonListener();
        subtractionButtonListener();
        numbersButtonsListeners();
        resultOperation();
    }

    private void initDeclarationIds() {
        numberLabel = (TextView) findViewById(R.id.numberLabel);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        divisionButton = (Button) findViewById(R.id.divisionButton);
        multiplicationButton = (Button) findViewById(R.id.multiplicationButton);
        additionButton = (Button) findViewById(R.id.additionButton);
        subtractionButton = (Button) findViewById(R.id.subtractionButton);
        zeroButton = (Button) findViewById(R.id.zeroButton);
        oneButton = (Button) findViewById(R.id.oneButton);
        twoButton = (Button) findViewById(R.id.twoButton);
        threeButton = (Button) findViewById(R.id.threeButton);
        fourButton = (Button) findViewById(R.id.fourButton);
        fiveButton = (Button) findViewById(R.id.fiveButton);
        sixButton = (Button) findViewById(R.id.sixButton);
        sevenButton = (Button) findViewById(R.id.sevenButton);
        eigthButton = (Button) findViewById(R.id.eigthButton);
        nineButton = (Button) findViewById(R.id.nineButton);
        resultButton = (Button) findViewById(R.id.resultButton);
    }

    private void multiplicationButtonListener() {
        multiplicationButton.setOnClickListener(view -> {
            numberLabel.setText(this.getString(R.string.multiplication));
            operator = this.getString(R.string.multiplication);
            manageOperations(getString(R.string.multiplication));
        });
    }

    private void divisionButtonListener() {
        divisionButton.setOnClickListener(view -> {
            numberLabel.setText(this.getString(R.string.division));
            operator = this.getString(R.string.division);
            manageOperations(getString(R.string.division));
        });
    }

    private void additionButtonListener() {
        additionButton.setOnClickListener(view -> {
            numberLabel.setText(this.getString(R.string.addition));
            operator = this.getString(R.string.addition);
            manageOperations(getString(R.string.addition));
        });
    }

    private void subtractionButtonListener() {
        subtractionButton.setOnClickListener(view -> {
            numberLabel.setText(this.getString(R.string.subtraction));
            operator = this.getString(R.string.subtraction);
            manageOperations(getString(R.string.subtraction));
        });
    }

    private void deleteOperation() {
        deleteButton.setOnClickListener(view -> {
            numberLabel.setText(this.getString(R.string.zero));
            firstNumber = "";
            secondNumber = "";
            operator = "";
        });
    }

    private void resultOperation() {
        resultButton.setOnClickListener(view -> {
            manageOperations("");
        });
    }

    private void numbersButtonsListeners() {
        nineButton.setOnClickListener(view -> {
            if (operator.isEmpty()) {
                setFirstNumber(Integer.parseInt(this.getString(R.string.nine)));
                numberLabel.setText(firstNumber);
            } else {
                setSecondNumber(Integer.parseInt(this.getString(R.string.nine)));
                numberLabel.setText(secondNumber);
            }
        });

        eigthButton.setOnClickListener(view -> {
            if (operator.isEmpty()) {
                setFirstNumber(Integer.parseInt(this.getString(R.string.eight)));
                numberLabel.setText(firstNumber);
            } else {
                setSecondNumber(Integer.parseInt(this.getString(R.string.eight)));
                numberLabel.setText(secondNumber);
            }
        });

        sevenButton.setOnClickListener(view -> {
            if (operator.isEmpty()) {
                setFirstNumber(Integer.parseInt(this.getString(R.string.seven)));
                numberLabel.setText(firstNumber);
            } else {
                setSecondNumber(Integer.parseInt(this.getString(R.string.seven)));
                numberLabel.setText(secondNumber);
            }
        });

        sixButton.setOnClickListener(view -> {
            if (operator.isEmpty()) {
                setFirstNumber(Integer.parseInt(this.getString(R.string.six)));
                numberLabel.setText(firstNumber);
            } else {
                setSecondNumber(Integer.parseInt(this.getString(R.string.six)));
                numberLabel.setText(secondNumber);
            }
        });

        fiveButton.setOnClickListener(view -> {
            if (operator.isEmpty()) {
                setFirstNumber(Integer.parseInt(this.getString(R.string.five)));
                numberLabel.setText(firstNumber);
            } else {
                setSecondNumber(Integer.parseInt(this.getString(R.string.five)));
                numberLabel.setText(secondNumber);
            }
        });

        fourButton.setOnClickListener(view -> {
            if (operator.isEmpty()) {
                setFirstNumber(Integer.parseInt(this.getString(R.string.four)));
                numberLabel.setText(firstNumber);
            } else {
                setSecondNumber(Integer.parseInt(this.getString(R.string.four)));
                numberLabel.setText(secondNumber);
            }
        });

        threeButton.setOnClickListener(view -> {
            if (operator.isEmpty()) {
                setFirstNumber(Integer.parseInt(this.getString(R.string.three)));
                numberLabel.setText(firstNumber);
            } else {
                setSecondNumber(Integer.parseInt(this.getString(R.string.three)));
                numberLabel.setText(secondNumber);
            }
        });

        twoButton.setOnClickListener(view -> {
            if (operator.isEmpty()) {
                setFirstNumber(Integer.parseInt(this.getString(R.string.two)));
                numberLabel.setText(firstNumber);
            } else {
                setSecondNumber(Integer.parseInt(this.getString(R.string.two)));
                numberLabel.setText(secondNumber);
            }
        });

        oneButton.setOnClickListener(view -> {
            if (operator.isEmpty()) {
                setFirstNumber(Integer.parseInt(this.getString(R.string.one)));
                numberLabel.setText(firstNumber);
            } else {
                setSecondNumber(Integer.parseInt(this.getString(R.string.one)));
                numberLabel.setText(secondNumber);
            }
        });

        zeroButton.setOnClickListener(view -> {
            if (operator.isEmpty()) {
                if (numberLabel.getText().toString().equals(getString(R.string.zero))) {
                    firstNumber = getString(R.string.zero);
                } else {
                    setFirstNumber(Integer.parseInt(this.getString(R.string.zero)));
                    numberLabel.setText(firstNumber);
                }
            } else {
                if (numberLabel.getText().toString().equals(getString(R.string.zero))) {
                    secondNumber = getString(R.string.zero);
                } else {
                    setSecondNumber(Integer.parseInt(this.getString(R.string.zero)));
                    numberLabel.setText(secondNumber);
                }

            }
        });
    }

    private void manageOperations(String operatorParam) {
        switch (operator) {
            case MULTIPLICATION:
                operation(MULTIPLICATION, operatorParam);
                break;
            case DIVISION:
                operation(DIVISION, operatorParam);
                break;
            case ADDITION:
                operation(ADDITION, operatorParam);
                break;
            case SUBTRACTION:
                operation(SUBTRACTION, operatorParam);
                break;
            default:
                break;
        }
    }

    private void operation(String typeOperator, String operatorParam) {
        if (!secondNumber.isEmpty()) {
            if (typeOperator.equals(MULTIPLICATION)) {
                resultOperation = String.valueOf(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
            } else if (typeOperator.equals(DIVISION)) {
                resultOperation = String.valueOf(Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber));
            } else if (typeOperator.equals(ADDITION)) {
                resultOperation = String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
            } else {
                resultOperation = String.valueOf(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
            }

            firstNumber = resultOperation;
            secondNumber = "";
            operator = operatorParam;
            if (operatorParam.isEmpty()) {
                numberLabel.setText(resultOperation);
            } else {
                numberLabel.setText(typeOperator);
            }
        }
    }

    private void setFirstNumber(int number) {
        firstNumber = firstNumber + number;
        if(firstNumber.trim().length() > 1 && firstNumber.substring(0, 1).equals(getString(R.string.zero))) {
            firstNumber = firstNumber.replace(getString(R.string.zero), "");
        }
    }

    private void setSecondNumber(int number) {
        secondNumber = secondNumber + number;
        if(secondNumber.trim().length() > 1 && secondNumber.substring(0, 1).equals(getString(R.string.zero))) {
            secondNumber = secondNumber.replace(getString(R.string.zero), "");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        firstNumber = "";
        secondNumber = "";
        operator = "";
        numberLabel.setText(getString(R.string.zero));
    }
}