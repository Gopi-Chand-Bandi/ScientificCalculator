package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CharMatcher;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainActivity extends AppCompatActivity {

    private TextView Input,Output,RadText,DegText,InvText;

    private boolean inv=false;

    private String inputText="",outputText="";

    private ImageButton SinButton,CosButton,TanButton,radButton,degButton,logButton,lnButton,openBraceButton,closedBraceButton,
            invButton,notButton,CButton,modButton,CancelButton,DivideButton,PowButton,SevenButton,EightButton,
            NineButton,MultiplyButton,SqRootButton,FourButton,FiveButton,SixButton,MinusButton,PiButton,OneButton,
            TwoButton,ThreeButton,AddButton,eButton,DoubleZeroButton,ZeroButton,DecimalButton,EqualButton;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadText = findViewById(R.id.rad_text);
        DegText = findViewById(R.id.degText);
        InvText = findViewById(R.id.inv_text);



        SinButton = findViewById(R.id.sin_button);
        CosButton = findViewById(R.id.cos_button);
        TanButton = findViewById(R.id.tan_button);
        radButton = findViewById(R.id.rad_button);
        degButton = findViewById(R.id.deg_button);
        logButton = findViewById(R.id.log_button);
        lnButton = findViewById(R.id.ln_button);
        openBraceButton = findViewById(R.id.openBrace_button);
        closedBraceButton = findViewById(R.id.closeBrace_button);
        invButton = findViewById(R.id.inv_button);
        notButton = findViewById(R.id.not_button);
        CButton = findViewById(R.id.C_button);
        modButton = findViewById(R.id.Percentage_button);
        CancelButton = findViewById(R.id.Cancel_button);
        DivideButton = findViewById(R.id.divide_button);
        PowButton = findViewById(R.id.power_button);
        SevenButton = findViewById(R.id.seven_button);
        EightButton = findViewById(R.id.eight_button);
        NineButton = findViewById(R.id.nine_button);
        MultiplyButton = findViewById(R.id.multiply_button);
        SqRootButton = findViewById(R.id.sqRoot_button);
        FourButton = findViewById(R.id.four_button);
        FiveButton = findViewById(R.id.five_button);
        SixButton = findViewById(R.id.six_button);
        MinusButton = findViewById(R.id.minus_button);
        PiButton = findViewById(R.id.pi_button);
        OneButton = findViewById(R.id.one_button);
        TwoButton = findViewById(R.id.two_button);
        ThreeButton = findViewById(R.id.three_button);
        AddButton = findViewById(R.id.plus_button);
        eButton = findViewById(R.id.e_button);
        DoubleZeroButton = findViewById(R.id.double_zero_button);
        ZeroButton = findViewById(R.id.zero_button);
        DecimalButton = findViewById(R.id.decimal_button);
        EqualButton = findViewById(R.id.equal_button);

        Input = findViewById(R.id.input_text);
        Input.setText(inputText);
        Output = findViewById(R.id.output_text);
        Output.setText(outputText);

        Input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used in this example
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not used in this example
            }

            @Override
            public void afterTextChanged(Editable s) {
                moveFirstCharacterIfNeeded(Input);
            }
        });

        SinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "sin(";
                Input.setText(inputText);
            }
        });

        CosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "cos(";
                Input.setText(inputText);
            }
        });

        TanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "tan(";
                Input.setText(inputText);
            }
        });

        radButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadText.setTextColor(Color.parseColor("#FFFF7848"));
                DegText.setTextColor(Color.parseColor("#989898"));
                equalOperation(inputText);
            }
        });

        degButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadText.setTextColor(Color.parseColor("#FF989898"));
                DegText.setTextColor(Color.parseColor("#FFFF7848"));
                equalOperation(inputText);
            }
        });

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "log(";
                Input.setText(inputText);
            }
        });

        lnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "ln(";
                Input.setText(inputText);
            }
        });

        openBraceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "(";
                Input.setText(inputText);
            }
        });

        closedBraceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + ")";
                Input.setText(inputText);
            }
        });

//        invButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int currentColor = InvText.getCurrentTextColor();
//                String hexCode = "#" + Integer.toHexString(currentColor).substring(2);
//
//                if (hexCode.equalsIgnoreCase("#FFFF7848")){
//
//                }else {
//                    InvText.setTextColor(Color.parseColor("#FFFF7848"));
//
//
//                }
//                InvText.setTextColor(Color.parseColor(""));
//            }
//        });

        notButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "!";
                Input.setText(inputText);
            }
        });

        CButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = "";
                Input.setText(inputText);
                outputText = "";
                Output.setText(outputText);
            }
        });

        modButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "%";
                Input.setText(inputText);
            }
        });

        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder(inputText);

                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }

                inputText = stringBuilder.toString();
                Input.setText(inputText);}
        });

        DivideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters="+-*%/!^√ ";
                if(inputText.charAt(inputText.length()-1) == characters.charAt(0)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(1)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(2)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(4)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(6)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(7)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(8)){

                }else {
                    inputText = inputText + "/";
                    Input.setText(inputText);
                }
            }
        });

        PowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters="+-*%/!^√ ";
                if(inputText.charAt(inputText.length()-1) == characters.charAt(0)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(1)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(2)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(4)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(6)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(7)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(8)){

                }else {
                    inputText = inputText + "^";
                    Input.setText(inputText);
                }

            }
        });

        SevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "7";
                Input.setText(inputText);
            }
        });

        EightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "8";
                Input.setText(inputText);
            }
        });

        NineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "9";
                Input.setText(inputText);
            }
        });

        MultiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters="+-*%/!^√ ";
                if(inputText.charAt(inputText.length()-1) == characters.charAt(0)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(1)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(2)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(4)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(6)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(7)||
                        inputText.charAt(inputText.length()-1) == characters.charAt(8)){

                }else {
                    inputText = inputText + "*";
                    Input.setText(inputText);
                }

            }
        });

        SqRootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters="1234567890!^√";
                if (inputText.length() > 0 && characters.indexOf(inputText.charAt(inputText.length() - 1)) != -1) {
                    // The last character is already a special character, do nothing
                }else {
                    inputText = inputText + "√";
                    Input.setText(inputText);
                }

            }
        });

        FourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "4";
                Input.setText(inputText);
            }
        });

        FiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "5";
                Input.setText(inputText);
            }
        });

        SixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "6";
                Input.setText(inputText);
            }
        });

        MinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters="+-*/√ ";
                if (inputText.length() > 0 && characters.indexOf(inputText.charAt(inputText.length() - 1)) != -1) {
                    // The last character is already a special character, do nothing
                }else {
                    inputText = inputText + "-";
                    Input.setText(inputText);
                }

            }
        });

        PiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters="π";
                if (inputText.length() > 0 && characters.indexOf(inputText.charAt(inputText.length() - 1)) != -1) {
                    // The last character is already a special character, do nothing
                }else {
                    inputText = inputText + "π";
                    Input.setText(inputText);
                }

            }
        });

        OneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "1";
                Input.setText(inputText);
            }
        });

        TwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "2";
                Input.setText(inputText);
            }
        });

        ThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "3";
                Input.setText(inputText);
            }
        });

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters="+-*/^√ ";
                if (inputText.length() > 0 && characters.indexOf(inputText.charAt(inputText.length() - 1)) != -1) {
                    // The last character is already a special character, do nothing
                }else {
                    inputText = inputText + "+";
                    Input.setText(inputText);
                }

            }
        });

        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters="e";
                if (inputText.length() > 0 && characters.indexOf(inputText.charAt(inputText.length() - 1)) != -1) {
                    // The last character is already a special character, do nothing
                }else {
                    inputText = inputText + "e";
                    Input.setText(inputText);
                }

            }
        });

        DoubleZeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "00";
                Input.setText(inputText);
            }
        });

        ZeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = inputText + "0";
                Input.setText(inputText);
            }
        });

        DecimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters="+-*%/!^√. ";
                if (inputText.length() > 0 && characters.indexOf(inputText.charAt(inputText.length() - 1)) != -1) {
                    // The last character is already a special character, do nothing
                } else {
                    inputText = inputText + ".";
                    Input.setText(inputText);
                }
            }
        });

        EqualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText.replaceAll("π",String.valueOf(Math.PI));
                inputText.replaceAll("e",String.valueOf(Math.E));
                equalOperation(inputText);
            }
        });

    }
    private void moveFirstCharacterIfNeeded(TextView textView) {
        String text = textView.getText().toString();
        int viewWidth = textView.getWidth();
        Paint paint = textView.getPaint();
        float textWidth = paint.measureText(text);

        if (textWidth > viewWidth) {
            int startIndex = 0;
            int endIndex = text.length();

            while (startIndex < endIndex && paint.measureText(text, startIndex, endIndex) > viewWidth) {
                startIndex++;
            }

            textView.setText(text.substring(startIndex));
        }
    }

    private float equalOperation(String inputText){

        if (inputText.length()==0){
            return 1;
        }

        if(inputText.contains("sin(")){
            Pattern pattern = Pattern.compile("sin\\\\(((?:[-+*/^!\\\\d.√]+)|\\\\([^()]*\\\\))*\\\\)");
            Matcher matcher = pattern.matcher(inputText);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String sinExpression = matcher.group(1);
                double sinValue = evaluateExpression(sinExpression);
                double sinResultValue = Math.toDegrees(Math.sin(Math.toRadians(sinValue)));
                matcher.appendReplacement(result, String.valueOf(sinResultValue));
            }

            matcher.appendTail(result);
            inputText = result.toString();

        }

        if(inputText.contains("tan(")){
            Pattern pattern = Pattern.compile("sin\\\\(((?:[-+*/^!\\\\d.√]+)|\\\\([^()]*\\\\))*\\\\)");
            Matcher matcher = pattern.matcher(inputText);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String tanExpression = matcher.group(1);
                double tanValue = evaluateExpression(tanExpression);
                double tanResultValue = Math.toDegrees(Math.tan(Math.toRadians(tanValue)));
                matcher.appendReplacement(result, String.valueOf(tanResultValue));
            }

            matcher.appendTail(result);
            inputText = result.toString();

        }

        if(inputText.contains("cos(")){
            Pattern pattern = Pattern.compile("sin\\\\(((?:[-+*/^!\\\\d.√]+)|\\\\([^()]*\\\\))*\\\\)");
            Matcher matcher = pattern.matcher(inputText);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String cosExpression = matcher.group(1);
                double cosValue = evaluateExpression(cosExpression);
                double cosResultValue = Math.cos(cosValue);
                matcher.appendReplacement(result, String.valueOf(cosResultValue));
            }

            matcher.appendTail(result);
            inputText = result.toString();

        }

        if(inputText.contains("log(")){
            Pattern pattern = Pattern.compile("sin\\\\(((?:[-+*/^!\\\\d.√]+)|\\\\([^()]*\\\\))*\\\\)");
            Matcher matcher = pattern.matcher(inputText);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String logExpression = matcher.group(1);
                double logValue = evaluateExpression(logExpression);
                double logResultValue = Math.log10(logValue);
                matcher.appendReplacement(result, String.valueOf(logResultValue));
            }

            matcher.appendTail(result);
            inputText = result.toString();

        }

        if(inputText.contains("ln(")){
            Pattern pattern = Pattern.compile("sin\\\\(((?:[-+*/^!\\\\d.√]+)|\\\\([^()]*\\\\))*\\\\)");
            Matcher matcher = pattern.matcher(inputText);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String lnExpression = matcher.group(1);
                double lnValue = evaluateExpression(lnExpression);
                double lnResultValue = Math.E * Math.log10(lnValue);
                matcher.appendReplacement(result, String.valueOf(lnResultValue));
            }

            matcher.appendTail(result);
            inputText = result.toString();

        }

        if (inputText.contains("!")){
            Pattern pattern = Pattern.compile("(\\d+)!");
            Matcher matcher = pattern.matcher(inputText);
            StringBuffer result = new StringBuffer();

            while (matcher.find()){
                int number = Integer.parseInt(matcher.group(1));
                int factorial = calculateFactorial(number);
                matcher.appendReplacement(result, String.valueOf(factorial));
            }

            matcher.appendTail(result);
            inputText = result.toString();

        }

        if (inputText.contains("√")){

            Pattern pattern = Pattern.compile("√(\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                double number = Double.parseDouble(matcher.group(1));
                double squareRoot = Math.sqrt(number);
                matcher.appendReplacement(result, String.valueOf(squareRoot));
            }

            matcher.appendTail(result);
            inputText = result.toString();

        }

        if (inputText.contains("^")){
            Pattern pattern = Pattern.compile("(\\\\d+)\\\\^(\\\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                int base = Integer.parseInt(matcher.group(1));
                int exponent = Integer.parseInt(matcher.group(2));
                int value = (int) Math.pow(base, exponent);
                matcher.appendReplacement(result, String.valueOf(value));
            }

            matcher.appendTail(result);
            inputText = result.toString();
        }

        Expression expression = new ExpressionBuilder(inputText)
                            .build();

        ValidationResult validationResult = expression.validate();
        if (validationResult.isValid()) {
            try {
                double result = expression.evaluate();
                if (result % 1 == 0) {
                    int resultInt = (int) result;
                    String resultString = Integer.toString(resultInt);
                    Output.setText(resultString);
                } else {
                    String resultString = Double.toString(result);
                    Output.setText(resultString);
                }

            } catch (ArithmeticException e) {
                Output.setText("Expression Error");
            }
        } else {
            Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show();
        }

        return 1;
    }

    private double evaluateExpression(String Expression) {

        if(Expression.contains("sin(")){
            Pattern pattern = Pattern.compile("sin\\\\(((?:[-+*/^!\\\\d.√]+)|\\\\([^()]*\\\\))*\\\\)");
            Matcher matcher = pattern.matcher(Expression);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String sinExpression = matcher.group(1);
                double sinValue = evaluateExpression(sinExpression);
                double sinResultValue = Math.sin(sinValue);
                matcher.appendReplacement(result, String.valueOf(sinResultValue));
            }

            matcher.appendTail(result);
            Expression = result.toString();

        }

        if(Expression.contains("tan(")){
            Pattern pattern = Pattern.compile("tan\\\\(((?:[-+*/^!\\\\d.√]+)|\\\\([^()]*\\\\))*\\\\)");
            Matcher matcher = pattern.matcher(Expression);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String tanExpression = matcher.group(1);
                double tanValue = evaluateExpression(tanExpression);
                double tanResultValue = Math.tan(tanValue);
                matcher.appendReplacement(result, String.valueOf(tanResultValue));
            }

            matcher.appendTail(result);
            Expression = result.toString();

        }

        if(Expression.contains("cos(")){
            Pattern pattern = Pattern.compile("cos\\\\(((?:[-+*/^!\\\\d.√]+)|\\\\([^()]*\\\\))*\\\\)");
            Matcher matcher = pattern.matcher(Expression);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String cosExpression = matcher.group(1);
                double cosValue = evaluateExpression(cosExpression);
                double cosResultValue = Math.cos(cosValue);
                matcher.appendReplacement(result, String.valueOf(cosResultValue));
            }

            matcher.appendTail(result);
            Expression = result.toString();

        }

        if(Expression.contains("log(")){
            Pattern pattern = Pattern.compile("log\\\\(((?:[-+*/^!\\\\d.√]+)|\\\\([^()]*\\\\))*\\\\)");
            Matcher matcher = pattern.matcher(Expression);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String logExpression = matcher.group(1);
                double logValue = evaluateExpression(logExpression);
                double logResultValue = Math.log10(logValue);
                matcher.appendReplacement(result, String.valueOf(logResultValue));
            }

            matcher.appendTail(result);
            Expression = result.toString();

        }

        if(Expression.contains("ln(")){
            Pattern pattern = Pattern.compile("ln\\\\(((?:[-+*/^!\\\\d.√]+)|\\\\([^()]*\\\\))*\\\\)");
            Matcher matcher = pattern.matcher(Expression);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String lnExpression = matcher.group(1);
                double lnValue = evaluateExpression(lnExpression);
                double lnResultValue = Math.E * Math.log10(lnValue);
                matcher.appendReplacement(result, String.valueOf(lnResultValue));
            }

            matcher.appendTail(result);
            Expression = result.toString();

        }

        if (Expression.contains("!")){
            Pattern pattern = Pattern.compile("(\\d+)!");
            Matcher matcher = pattern.matcher(Expression);
            StringBuffer result = new StringBuffer();

            while (matcher.find()){
                int number = Integer.parseInt(matcher.group(1));
                int factorial = calculateFactorial(number);
                matcher.appendReplacement(result, String.valueOf(factorial));
            }

            matcher.appendTail(result);
            Expression = result.toString();

        }

        if (Expression.contains("√")){

            Pattern pattern = Pattern.compile("√(\\d+)");
            Matcher matcher = pattern.matcher(Expression);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                double number = Double.parseDouble(matcher.group(1));
                double squareRoot = Math.sqrt(number);
                matcher.appendReplacement(result, String.valueOf(squareRoot));
            }

            matcher.appendTail(result);
            Expression = result.toString();

        }

        if (Expression.contains("^")){
            Pattern pattern = Pattern.compile("(\\\\d+)\\\\^(\\\\d+)");
            Matcher matcher = pattern.matcher(Expression);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                int base = Integer.parseInt(matcher.group(1));
                int exponent = Integer.parseInt(matcher.group(2));
                int value = (int) Math.pow(base, exponent);
                matcher.appendReplacement(result, String.valueOf(value));
            }

            matcher.appendTail(result);
            Expression = result.toString();
        }

        Expression expression = new ExpressionBuilder(Expression)
                .build();

        ValidationResult validationResult = expression.validate();
        if (validationResult.isValid()) {
            try {
                double result = expression.evaluate();
//                if (result % 1 == 0) {
//                    int resultInt = (int) result;
//                    String resultString = Integer.toString(resultInt);
//                    //Output.setText(resultString);
//                } else {
//                    String resultString = Double.toString(result);
//                    //Output.setText(resultString);
//                }
                return result;

            } catch (ArithmeticException e) {
                //Output.setText("Expression Error");
            }
        } else {
            Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show();
        }

        return 1.0;

    }

    private static int calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int countOccurrences(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}