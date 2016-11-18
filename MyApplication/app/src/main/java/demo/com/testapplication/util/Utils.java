package demo.com.testapplication.util;

/**
 * Created by Rock on 6/16/2016.
 */


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.InputStream;
import java.io.OutputStream;


public class Utils {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    ProgressDialog progressDialog;

    public Utils(Context con) {
        if (con != null) {
            context = con;
            preferences = con.getSharedPreferences(
                    "MyAppSettings", Context.MODE_PRIVATE);
            editor = preferences.edit();

        }
    }



    public static void Toast(Context context, String msg) {
        try {
            Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_HORIZONTAL);
            toast.show();
        } catch (Exception ex) {
        }
    }

    public void Toast(String msg) {
        try {
            Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_HORIZONTAL);
            toast.show();
        } catch (Exception ex) {
        }
    }

    /***
     * This function is use to display toast msg
     * in alrertDialog box
     * Use when the toast msg is to long and user not
     * readble simple toast show time to small.
     *
     * @param context context
     * @param msg     dialog message for display
     */
    @SuppressWarnings("deprecation")
    public static void DisplayDialogForToastMsg(Context context, String msg) {
        try {
            final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setMessage(msg);
            alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, final int which) {
                    alertDialog.cancel();

                }
            });


            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.show();

        } catch (Exception ex) {

        }
    }

    public static void ToastByTime(Context context, String msg, int timeduration) {
        try {


            final Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_HORIZONTAL);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, timeduration);


        } catch (Exception ex) {

        }
    }


    public void removeAllPrefrences() {

        editor.clear().commit();
    }

    public void removePrefrence(String key) {
        editor.remove(key).commit();
    }

    public void setPrefrences(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getPreferences(String key) {
        return preferences.getString(key, null);
    }

    public void setBooleanPreferences(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBooleanPreferences(String key) {
        return preferences.getBoolean(key, false);
    }

    public void setIntPreferences(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getIntPreferences(String key) {
        return preferences.getInt(key, 0);
    }

    public void setLongPrefrences(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLongPreferences(String key) {
        return preferences.getLong(key, 0);
    }


    public static void setText(String msg, TextView textView) {
        if (textView != null) {
            if (msg != null && !TextUtils.isEmpty(msg) && !msg.equalsIgnoreCase("null")) {
                textView.setText(msg);
            } else {
                textView.setText("");
            }
        }
    }



    public boolean isEditTextValid(EditText editText) {
        if (editText != null) {
            if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public void displayProgressBar(final Context context) {
        try {
            new Runnable() {
                @Override
                public void run() {
                    progressDialog = new ProgressDialog(context);

                    if (!((Activity) context).isFinishing()) {
                        if (progressDialog != null || !progressDialog.isShowing()) {
                            progressDialog.setCancelable(true);
                            progressDialog.setMessage("Please wait...");
                            progressDialog.show();
                            Log.d("Loading...", "displayProgressBar: === start");
                        }
                    }
                }
            }.run();
        } catch (Exception ex) {

        }
    }

    public void dismissProgressBar() {
        try {
            Log.d("Loading...", "displayProgressBar: === stop");
            new Runnable() {
                @Override
                public void run() {
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                        Log.d("Loading...", "displayProgressBar: === stop inside");

                    }
                }
            }.run();
        } catch (Exception ex) {

        }

    }


}