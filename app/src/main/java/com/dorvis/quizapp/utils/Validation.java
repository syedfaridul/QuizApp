package com.dorvis.quizapp.utils;

import android.content.Context;
import android.graphics.Color;
import android.telephony.PhoneNumberUtils;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_REGEX = "^[789]\\d{9}$";
    private static final String EMAIL_MSG = "invalid email";
    private static final String PASSWORD_MSG = "Password should be 8 or less than 16 character";
    private static final String PHONE_MSG = "invalid number";
    private static final String errMsg = "Enter 10 digit Number";
    private static final String REQUIRED_MSG = "cannot be empty";
    private static final String NAMEERROR_MSG = "Name should be 8 character";
    private static final String ERROR_MSG = "Name should be 10 character";
    private static final String DEBIT_CARD = "^(?:(?4[0-9]{12}(?:[0-9]{3})?)|\n" +
            "\t\t(?5[1-5][0-9]{14})|\n" +
            "\t\t(?6(?:011|5[0-9]{2})[0-9]{12})|\n" +
            "\t\t(?3[47][0-9]{13})|\n" +
            "\t\t(?3(?:0[0-5]|[68][0-9])?[0-9]{11})|\n" +
            "\t\t(?(?:2131|1800|35[0-9]{3})[0-9]{11}))$";


    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);
        editText.setFocusable(true);
        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }


    public static boolean isValidPassword(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);
        editText.setFocusable(true);
        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }else if(text.length()<8||text.length()>16) {
            editText.setError(PASSWORD_MSG);
            return false;
        }
        return true;
    }


    public static boolean isEmailAddress(EditText editText, boolean required) {
        return isValid(editText, EMAIL_REGEX, EMAIL_MSG, required);
    }


    public static boolean hasTextForTextView(TextView editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);
        editText.setFocusable(true);
        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }


    public static boolean checkLength(EditText editText)
    {
        boolean check;
        String errMsg = "Enter 10 digit Number";

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        if(text.length() < 10 || text.length() > 13)
        {
            editText.setError(errMsg);
            check = false;
        }
        else
        {
            check = true;
        }
        return check;
    }



    public static boolean hasActText(AutoCompleteTextView autoCompleteTextView) {

        String text = autoCompleteTextView.getText().toString().trim();
        autoCompleteTextView.setError(null);
        autoCompleteTextView.setFocusable(true);
        // length 0 means there is no text
        if (text.length() == 0) {
            autoCompleteTextView.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }

    public static boolean isPhoneNumber(EditText editText, boolean required) {
        return isValid(editText, PHONE_REGEX, PHONE_MSG, required);
    }

    private static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if (required && !hasText(editText)) return false;
        if (regex.equalsIgnoreCase(PHONE_REGEX)) {
            return PhoneNumberUtils.isGlobalPhoneNumber(editText.getText().toString().trim());
        } else {

            // pattern doesn't match so returning false
            if (required && !Pattern.matches(regex, text)) {
                editText.setError(errMsg);
                return false;
            }
        }

        return true;
    }

    public static boolean selectedFood(Spinner spinner, Context context) {
        boolean ret = true;
        if (spinner.getSelectedItem() != null) {
            if (spinner.getSelectedItem().toString().equals("Select Category")) {
                TextView errorText = (TextView) spinner.getSelectedView();
                errorText.setError("");
                errorText.setTextColor(Color.RED);
                String message = "Select Category";
                errorText.setText(message);
                ret = false;
            }
        } else {
            Toast.makeText(context, "Please select Category.", Toast.LENGTH_SHORT).show();
            ret = false;
        }
        return ret;
    }

    public static boolean selectedChild(Spinner spinner, Context context) {
        boolean ret = true;
        if (spinner.getSelectedItem() != null) {
            if (spinner.getSelectedItem().toString().equals("Select Item")) {
                TextView errorText = (TextView) spinner.getSelectedView();
                errorText.setError("");
                errorText.setTextColor(Color.RED);
                String message = "Select Item";
                errorText.setText(message);
                ret = false;
            }
        } else {
            Toast.makeText(context, "Please select Category.", Toast.LENGTH_SHORT).show();
            ret = false;
        }
        return ret;
    }

    public static boolean selectedOption(Spinner spinner,Context context){
        boolean ret = true;
        if (spinner.getSelectedItem() != null) {
            if (spinner.getSelectedItem().toString().equals("Select Item")) {
                TextView errorText = (TextView) spinner.getSelectedView();
                errorText.setError("");
                errorText.setTextColor(Color.RED);
                String message = "Select Item";
                errorText.setText(message);
                ret = false;
            }
        } else {
            Toast.makeText(context, "Please select Category.", Toast.LENGTH_SHORT).show();
            ret = false;
        }
        return ret;
    }

    public static boolean selectedAnimals(Spinner spinner,Context context){
        boolean ret = true;
        if (spinner.getSelectedItem() != null) {
            if (spinner.getSelectedItem().toString().equals("Select Animal")) {
                TextView errorText = (TextView) spinner.getSelectedView();
                errorText.setError("");
                errorText.setTextColor(Color.RED);
                String message = "Select Animal";
                errorText.setText(message);
                ret = false;
            }
        } else {
            Toast.makeText(context, "Please select Category.", Toast.LENGTH_SHORT).show();
            ret = false;
        }
        return ret;
    }


    public static boolean selectedTransationID(Spinner spinner,Context context){
        boolean ret = true;
        if (spinner.getSelectedItem()!=null){
            if (spinner.getSelectedItem().toString().equals("Select Transcation ID")){
                TextView errorText = (TextView)spinner.getSelectedItem();
                errorText.setError("");
                errorText.setTextColor(Color.RED);
                String message = "Select Transcation ID";
                errorText.setText(message);
                ret = false;
            }
        }else {
            Toast.makeText(context, "Please select Transcation ID.", Toast.LENGTH_SHORT).show();
            ret = false;
        }
        return  ret;
    }
    public static boolean isValidMobile(EditText editText) {
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(editText.getText().toString().trim());
        if((m.find() && m.group().equals(editText.getText().toString().trim()))){
            return true;
        }else if(editText.getText().toString().trim().length()<10||editText.getText().toString().trim().length()>13){
            editText.setError(errMsg);
            return false;
        }else {
            editText.setError(PHONE_MSG);
            return false;
        }
    }

    public static boolean isValidName(EditText editText) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher m = p.matcher(editText.getText().toString().trim());
        if ((m.find() && m.group().equals(editText.getText().toString().trim()))) {
            return true;
        } else if (editText.getText().toString().trim().length() < 10 || editText.getText().toString().trim().length() > 25) {
            editText.setError(ERROR_MSG);
            return false;
        }  else {
            editText.setError(NAMEERROR_MSG);
            return false;
        }
    }




}

