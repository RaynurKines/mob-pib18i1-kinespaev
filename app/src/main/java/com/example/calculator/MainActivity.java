package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    public String Memory;
    public String resultString;
    public String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
    }

    public void updateText(String strToAdd, int indent){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else if(indent==1){
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
        else if(indent==2){
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 2);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + indent);
        }
    }

    public void zeroBTN(View view){
        updateText("0", 1);
    }

    public void oneBTN(View view){
        updateText("1", 1);
    }

    public void twoBTN(View view){
        updateText("2", 1);
    }

    public void threeBTN(View view){
        updateText("3", 1);
    }

    public void fourBTN(View view){
        updateText("4", 1);
    }

    public void fiveBTN(View view){
        updateText("5", 1);
    }

    public void sixBTN(View view){
        updateText("6", 1);
    }

    public void sevenBTN(View view){
        updateText("7", 1);
    }

    public void eightBTN(View view){
        updateText("8", 1);
    }

    public void nineBTN(View view){
        updateText("9", 1);
    }

    public void pointBTN(View view){
        updateText(".", 1);
    }

    public void addBTN(View view){
        updateText("+", 1);
    }

    public void substractBTN(View view){
        updateText("-", 1);
    }

    public void multiplyBTN(View view){
        updateText("*", 1);
    }

    public void divideBTN(View view) { updateText("/", 1); }

    public void equalsBTN(View view) throws ScriptException {
        //display.setText(engine.eval(text).toString());
        String s = display.getText().toString();
        s = s.replaceAll("√" , "Math.sqrt");
        double resultDouble = calc(s);
        if (resultDouble % 1 == 0) {
            int resultInt = (int) resultDouble;
            resultString = Integer.toString(resultInt);
        }
        else{
            resultString = Double.toString(resultDouble);
        }
        display.setText("");
        updateText(resultString, resultString.length());
        //display.setText(resultString);
    }

    public double calc(String input) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("rhino");
        return (Double)engine.eval(input);
    }

    public void plusMinusBTN(View view){
        StringBuilder builder = new StringBuilder(display.getText());
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        final boolean b = leftStr.lastIndexOf("+") != -1 || leftStr.lastIndexOf("-") != -1;
        if(b && leftStr.lastIndexOf("+")>leftStr.lastIndexOf("-")){
            if(leftStr.lastIndexOf("+") != -1) {
                int index = builder.lastIndexOf("+", cursorPos - 1);
                builder.replace(index, index+1, "-");
                display.setText("");
                updateText(builder.toString(), leftStr.length());
            }
            else if(leftStr.lastIndexOf("-") != -1){
                int index = builder.lastIndexOf("-", cursorPos - 1);
                builder.replace(index, index+1, "+");
                display.setText("");
                updateText(builder.toString(), leftStr.length());
            }
        }
        else if(b && leftStr.lastIndexOf("+")<leftStr.lastIndexOf("-")){
            if(leftStr.lastIndexOf("-") != -1){
                int index = builder.lastIndexOf("-", cursorPos - 1);
                builder.replace(index, index+1, "+");
                display.setText("");
                updateText(builder.toString(), leftStr.length());
            }
            else if(leftStr.lastIndexOf("+") != -1) {
                int index = builder.lastIndexOf("+", cursorPos - 1);
                builder.replace(index, index+1, "-");
                display.setText("");
                updateText(builder.toString(), leftStr.length());
            }
        }

    }

    public void rootBTN(View view){
        updateText("√()", 2);
    }

    public void onedivideXBTN(View view){
        text = display.getText().toString();
        display.setText("");
        resultString = "1/("+text+")";
        updateText(resultString, resultString.length());
    }

    public void clearTN(View view){
        display.setText("");
    }

    public void cleareOneBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos -1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }

    public void MRBTN(View view) throws ScriptException {
        if(Memory != null){
            double resultDouble;
            resultDouble = calc(Memory);
            if (resultDouble % 1 == 0) {
                int resultInt = (int) resultDouble;
                Memory = Integer.toString(resultInt);
            }
            else{
                Memory = Double.toString(resultDouble);
            }
                updateText(Memory, Memory.length());
        }
    }

    public void MCBTN(View view){
        Memory = null;
    }

    public void MSBTN(View view) throws ScriptException {
        Memory = display.getText().toString();
    }

    public void MplusBTN(View view){
        if(Memory != null)
            Memory=Memory + "+(" + display.getText().toString() + ")";
    }

    public void MminusBTN(View view){
        if(Memory != null)
            Memory=Memory + "-(" + display.getText().toString() + ")";
    }
}