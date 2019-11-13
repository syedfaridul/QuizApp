package com.dorvis.quizapp.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CommonUtils {
    String getMonth,getDay;
    private ProgressDialog mProgressDialog;
    static Toast mToast;
    private Context context;
    public ProgressDialog startProgressBarDialog(Context context, String message) {

        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        return mProgressDialog;
    }
    public void stopProgressBarDialog() {
        mProgressDialog.dismiss();
    }

    public static void showToast(Context context, String statusMsg){
        if(mToast != null) mToast.cancel();
        mToast = Toast.makeText(context,statusMsg, Toast.LENGTH_SHORT);
        mToast.show();
    }


    public String showTimeWishes(Context context){
        String datainfo;
        Calendar calendars = Calendar.getInstance();
        int timeOfDay = calendars.get(Calendar.HOUR_OF_DAY);
        if (timeOfDay >= 0 && timeOfDay < 12){
            datainfo ="Good Morning";
        }else if (timeOfDay >=12 && timeOfDay < 16){
            datainfo  ="Good Afternoon";
        }else if (timeOfDay >= 16 && timeOfDay < 21){
            datainfo ="Good Evening";
        }else if (timeOfDay >= 21 && timeOfDay < 24){
            datainfo ="Good Night";
        }else {
            datainfo= "Have a Nice Time";
        }
        return datainfo;
    }

    public static Date getCurrentDateTime(){
        Date currentDate =  Calendar.getInstance().getTime();
        return currentDate;
    }

    public static String getFormattedDateString(Date date) {

        try {

            SimpleDateFormat spf = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
            String dateString = spf.format(date);

            Date newDate = spf.parse(dateString);
            spf= new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
            return spf.format(newDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String generateHash(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            String base64 = Base64.encodeToString(byteData, Base64.NO_WRAP);
            return base64;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void showMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void openKeyboard(final Context context) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                }
            }
        }, 500);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(Objects.requireNonNull(activity.getCurrentFocus()).getWindowToken(), 0);
    }

    //file create
    public  boolean checkSettingFile(String file_path, String file_name) {
        try {
            File file = new File(file_path + "/" + file_name);
            return file.exists();
        } catch (Exception e) {
            return false;
        }
    }

    public  void copyAssets(Context context, String FileName, String folderName) {
        try {
            File settingFilePath = new File(folderName);
            if (!settingFilePath.exists()) {
                //noinspection ResultOfMethodCallIgnored
                settingFilePath.mkdirs();
            }
        } catch (Exception e) {
            Log.e("tag", "Failed to create folder.", e);
        }
        AssetManager assetManager = context.getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("tag", "Failed to get asset file list.", e);
        }
        if (files != null) {
            for (String filename : files) {
                if (filename.equals(FileName)) {
                    InputStream in = null;
                    OutputStream out = null;
                    try {
                        in = assetManager.open(filename);
                        File outFile = new File(folderName + "/", filename);
                        out = new FileOutputStream(outFile);
                        copyFile(in, out);
                    } catch (IOException e) {
                        Log.e("tag", "Failed to copy asset file: " + filename, e);
                    } finally {
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (out != null) {
                            //noinspection EmptyCatchBlock
                            try {
                                out.close();
                            } catch (IOException e) {
                            }
                        }
                    }
                }
            }
        }
    }

    private  void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }


}
