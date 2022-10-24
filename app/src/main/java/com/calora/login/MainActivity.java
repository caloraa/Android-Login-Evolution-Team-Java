package com.calora.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Html;
import android.text.InputFilter;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private String FloatingPermision = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
    private final String PASS = "PASS";
    private int REQUEST_CODE = 100;
    private final String USER = "USER";
    Button init;
    EditText mail;
    CheckBox mtLogin;
    EditText pass;
    private Prefs prefs;
    public String sGameActivity = "com.evolution.team.MainActivity2";
    CheckBox svLogin;

    static {
		//  System.loadLibrary("il2cpp");
    }

    private void SetupForm() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#F2F3F4"));
        gradientDrawable.setStroke(2, Color.parseColor("#3B444B"));
        gradientDrawable.setCornerRadius(1.0f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(Color.parseColor("#AF008B8B"));
        gradientDrawable2.setStroke(1, Color.parseColor("#000000"));
        gradientDrawable2.setCornerRadius(25.0f);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(convertDipToPixels(400.0f), -2);
        rlp.addRule(13);
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setOrientation(0);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(rlp);
        linearLayout2.setBackground(gradientDrawable);
        LinearLayout.LayoutParams rlp1 = new LinearLayout.LayoutParams(-1, -2);
        rlp1.setMargins(0, 20, 0, 0);
        LinearLayout.LayoutParams rlp2 = new LinearLayout.LayoutParams(-1, -2);
        rlp2.setMargins(50, 0, 50, 0);
        LinearLayout.LayoutParams rlp4 = new LinearLayout.LayoutParams(-1, -2);
        rlp4.setMargins(80, 0, 80, 0);
        TextView nameMod = new TextView(this);
        nameMod.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        nameMod.setText("EVOLUTION TEAM");
        nameMod.setTextSize(25.0f);
        nameMod.setGravity(17);
        nameMod.setTypeface(Typeface.DEFAULT_BOLD);
        nameMod.setTextColor(Color.parseColor("#3B444B"));
        nameMod.setLayoutParams(rlp1);
        nameMod.setPadding(convertDipToPixels(15.0f), convertDipToPixels(15.0f), convertDipToPixels(15.0f), convertDipToPixels(15.0f));
        EditText editText = new EditText(this);
        this.mail = editText;
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mail.setHint("Usuario:");
        this.mail.setHintTextColor(Color.parseColor("#AF3B444B"));
        this.mail.setTextColor(Color.parseColor("#3B444B"));
        this.mail.setSingleLine(true);
        this.mail.setLayoutParams(rlp2);
        GradientDrawable gradientDrawable3 = gradientDrawable;
        RelativeLayout.LayoutParams layoutParams = rlp;
        this.mail.setPadding(convertDipToPixels(15.0f), convertDipToPixels(15.0f), convertDipToPixels(15.0f), convertDipToPixels(15.0f));
        this.mail.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
        EditText editText2 = new EditText(this);
        this.pass = editText2;
        editText2.setHint("Senha:");
        this.pass.setHintTextColor(Color.parseColor("#AF3B444B"));
        this.pass.setTextColor(Color.parseColor("#3B444B"));
        this.pass.setSingleLine(true);
        this.pass.setLayoutParams(rlp2);
        this.pass.setPadding(convertDipToPixels(15.0f), convertDipToPixels(15.0f), convertDipToPixels(15.0f), convertDipToPixels(15.0f));
        this.pass.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        this.pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        Button button = new Button(this);
        this.init = button;
        button.setBackground(gradientDrawable2);
        this.init.setText("Login");
        this.init.setTextSize(10.0f);
        this.init.setTextColor(-16777216);
        LinearLayout.LayoutParams rlp3 = new LinearLayout.LayoutParams(-2, -2);
        rlp3.gravity = 17;
        this.init.setLayoutParams(rlp3);
        LinearLayout.LayoutParams mtLg = new LinearLayout.LayoutParams(-2, -2);
        mtLg.setMargins(0, 0, 10, 0);
        LinearLayout ln1 = new LinearLayout(this);
        ln1.setLayoutParams(rlp4);
        ln1.setOrientation(0);
        LinearLayout ln2 = new LinearLayout(this);
        ln2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ln2.setOrientation(0);
        ln2.setGravity(5);
        CheckBox checkBox = new CheckBox(this);
        this.svLogin = checkBox;
        checkBox.setText("Salvar login");
        this.svLogin.setTextSize(10.0f);
        this.svLogin.setGravity(17);
        this.svLogin.setTextColor(-16777216);
        this.svLogin.setOnClickListener(new View.OnClickListener() {
				public void onClick(View p1) {
					if (MainActivity.this.prefs.read("SVL").equals("ativado")) {
						MainActivity.this.prefs.write("SLV", "desativado");
					} else {
						MainActivity.this.prefs.write("SVL", "ativado");
					}
				}
			});
        CheckBox checkBox2 = new CheckBox(this);
        this.mtLogin = checkBox2;
        checkBox2.setLayoutParams(mtLg);
        this.mtLogin.setText("Mostrar senha");
        this.mtLogin.setTextSize(10.0f);
        this.mtLogin.setGravity(17);
        this.mtLogin.setTextColor(-16777216);
        this.mtLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton p1, boolean p2) {
					if (p2) {
						MainActivity.this.pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
					} else {
						MainActivity.this.pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
					}
				}
			});
        ln1.addView(this.svLogin);
        ln1.addView(ln2);
        ln2.addView(this.mtLogin);
        linearLayout2.addView(nameMod);
        linearLayout2.addView(this.mail);
        linearLayout2.addView(this.pass);
        linearLayout2.addView(ln1);
        linearLayout2.addView(this.init);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
        TryLoginPHP();
    }

    private void TryLoginPHP() {
        if (this.prefs.read("SVL").equals("ativado")) {
            this.mail.setText(this.prefs.read("USER", ""));
            this.pass.setText(this.prefs.read("PASS", ""));
            this.svLogin.setChecked(true);
        }
        this.init.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					new Intent(MainActivity.this.getApplicationContext(), Auth.class).putExtra("user", MainActivity.this.pass.getText().toString());
					if (!MainActivity.this.mail.getText().toString().isEmpty() && !MainActivity.this.pass.getText().toString().isEmpty()) {
						MainActivity.this.prefs.write("USER", MainActivity.this.mail.getText().toString());
						MainActivity.this.prefs.write("PASS", MainActivity.this.pass.getText().toString());
						new Auth(MainActivity.this).execute(new String[]{MainActivity.this.mail.getText().toString(), MainActivity.this.pass.getText().toString()});
					}
					if (MainActivity.this.mail.getText().toString().isEmpty() && MainActivity.this.pass.getText().toString().isEmpty()) {
						MainActivity.this.mail.setError("Usuario requirido!");
						MainActivity.this.pass.setError("Senha requirida!");
					}
					if (MainActivity.this.mail.getText().toString().isEmpty()) {
						MainActivity.this.mail.setError("Usuario Requirido!");
					}
					if (MainActivity.this.pass.getText().toString().isEmpty()) {
						MainActivity.this.pass.setError("Senha requirida!");
					}
				}
			});
    }

    private int convertDipToPixels(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    private void Permissions() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE", "android.permission.RECORD_AUDIO", "android.permission.MODIFY_AUDIO_SETTINGS"}, this.REQUEST_CODE);
        }
    }

    private void ADDPermision() {
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this)) {
            Permissions();
            SetupForm();
            return;
        }
        startActivity(new Intent(this.FloatingPermision, Uri.parse("package:" + getPackageName())));
        finish();
    }

    private void clearLoaderFiles(Context ctx) {
    }


    /* access modifiers changed from: protected */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		System.loadLibrary("SecurityCalora");
        this.prefs = Prefs.with(this);
        ADDPermision();
        byte[] icoalert = Base64.decode("", 0);
        AlertDialog.Builder vendedores = new AlertDialog.Builder(this);
        vendedores.setTitle("Aviso!");
        vendedores.setMessage(Html.fromHtml(((((((((((("<div style='text-align: center'><h2>Vendedores Oficiais</h2>\n\n<div style='text-align: center'>\n\n<div style='text-align: center'>" + "<b>ADM: JOELITON MODS</b>\n<p><b><a href='https://www.google.com.br/'>+55 73 99845-0095</a></p></b></div><div style='text-align: center'>") + "<b>ADM: DUAL GAMES</b>\n<p><b><a href='https://www.google.com.br/'>+55 87 8127-1040</a></p></b></div><div style='text-align: center'>") + "<b>SUPER MODS</b>\n<p><b><a href='https://www.google.com.br/'>+55 11 96514-7822</a></p></b></div><div style='text-align: center'>") + "<b>VÊNUS OFICIAL</b>\n<p><b><a href='https://www.google.com.br/'>+55 16 99195-7618</a></p></b></div><div style='text-align: center'>") + "<b>NETO MODS</b>\n<p><b><a href='https://www.google.com.br/'>+55 61 9401-8705</a></p></b></div><div style='text-align: center'>") + "<b>MADAME MODS</b>\n<p><b><a href='https://www.google.com.br/'>+55 65 9952-4152</a></p></b></div><div style='text-align: center'>") + "<b>RAVENA MODS</b>\n<p><b><a href='https://www.google.com.br/'>+55 13 99763-3280</a></p></b></div><div style='text-align: center'>") + "<b>SAMUKA MODS</b>\n<p><b><a href='https://www.google.com.br/'>+55 43 9873-1720</a></p></b></div><div style='text-align: center'>") + "<b>ROGER MODS</b>\n<p><b><a href='https://www.google.com.br/'>+55 51 99788-8204</a></p></b></div><div style='text-align: center'>") + "<b>FAVELA MODS</b>\n<p><b><a href='https://www.google.com.br/'>+55 73 8209-5438</a></p></b></div><div style='text-align: center'>") + "<b>PERNA LONGA</b>\n<p><b><a href='https://www.google.com.br/'>+55 34 9998-8512</a></p></b></div><div style='text-align: center'>") + "<b>JOAO</b>\n<p><b><a href='Wa.me/+5516991957618/'>+55 43 9963-3115</a></p></b></div>"));
        vendedores.setIcon(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(icoalert, 0, icoalert.length)));
        vendedores.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
				}
			}).show();
    }
}


