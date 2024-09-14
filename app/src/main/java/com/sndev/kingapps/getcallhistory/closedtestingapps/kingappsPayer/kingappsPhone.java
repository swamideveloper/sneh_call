package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsPayer;

import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_MerchantCODE;
import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_MerchantUPI;
import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_Ticket_Bronze;
import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_Ticket_Gold;
import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_Ticket_Silver;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsThanks;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsInit.kingappsPref;
import com.sndev.kingapps.getcallhistory.closedtestingapps.R;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsKey.kingappsPhpe;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsKey.kingappsKeytool;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Base64;


public class kingappsPhone extends AppCompatActivity {

    private String glob_premium_key_type = "";
    private String KEY_GOLD = "in_app_gold";
    private String KEY_SILVER = "in_app_silver";
    private String KEY_BRONZE = "in_app_bronze";


    public Uri M = null;
    public String elephant_TagName;
    public String O = "";
    public String elephant_Price = "";
    public String Q;
    public Bitmap R_bitmap;
    public String elephant_MRP;
    public String T = "";


    public static View lastview_fata;
    TextView off1;
    TextView off2;
    TextView off3;
    TextView txtBronze;
    TextView txtGold;
    TextView txtSilver;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kingappspayer);

        initView();
    }


    private void initView() {
        txtSilver = (TextView) findViewById(R.id.txtSilver);
        txtGold = (TextView) findViewById(R.id.txtGold);
        txtBronze = (TextView) findViewById(R.id.txtBronz);
        off1 = (TextView) findViewById(R.id.off1);
        off2 = (TextView) findViewById(R.id.off2);
        off3 = (TextView) findViewById(R.id.off3);

        txtSilver.setText("₹ " + key_Ticket_Silver);
        txtGold.setText("₹ " + key_Ticket_Gold);
        txtBronze.setText("₹ " + key_Ticket_Bronze);

        Scalee(findViewById(R.id.rl_silver), this);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.zoomout);
        findViewById(R.id.rl_bronze).startAnimation(loadAnimation);
        findViewById(R.id.rl_gold).startAnimation(loadAnimation);

        off1.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off2.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off3.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtGold.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtSilver.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtBronze.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off2.setBackgroundColor(getResources().getColor(R.color.packgerselect_bg));
        txtSilver.setBackgroundColor(getResources().getColor(R.color.packgerselect_bg));

        //def
        elephant_TagName = "Silver Plan";
        elephant_Price = key_Ticket_Silver;
        elephant_MRP = key_Ticket_Silver;
        glob_premium_key_type = KEY_SILVER;


        findViewById(R.id.rl_gold).setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                glob_premium_key_type = KEY_GOLD;
                m4106x9ba54bf2(view);
            }
        });
        findViewById(R.id.rl_silver).setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                glob_premium_key_type = KEY_SILVER;
                m4107x7998b1d1(view);
            }
        });
        findViewById(R.id.rl_bronze).setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                glob_premium_key_type = KEY_BRONZE;
                m4108x578c17b0(view);
            }
        });

        findViewById(R.id.btnUpgrade_to_premium).setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                inApp();
            }
        });
    }

    private void inApp() {
        if (glob_premium_key_type.equalsIgnoreCase(KEY_BRONZE)) {
            if (!V(kingappsPhone.this)) {
                Toast.makeText(kingappsPhone.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
            } else if (kingappsPhpe.skipDirectPayMode().equals("yes")) {
                Toast.makeText(kingappsPhone.this, "Coming Soon....", Toast.LENGTH_SHORT).show();
            } else {
                elephant_TagName = "Bronze Plan";
                elephant_Price = key_Ticket_Bronze;
                elephant_MRP = key_Ticket_Bronze;
                X(S(Double.parseDouble(key_Ticket_Bronze)).replaceAll("\\.0*$", ""));
            }
        } else if (glob_premium_key_type.equalsIgnoreCase(KEY_SILVER)) {
            if (!V(kingappsPhone.this)) {
                Toast.makeText(kingappsPhone.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
            } else if (kingappsPhpe.skipDirectPayMode().equals("yes")) {
                Toast.makeText(kingappsPhone.this, "Coming Soon....", Toast.LENGTH_SHORT).show();
            } else {

                elephant_TagName = "Silver Plan";
                elephant_Price = key_Ticket_Silver;
                elephant_MRP = key_Ticket_Silver;
                X(S(Double.parseDouble(key_Ticket_Silver)).replaceAll("\\.0*$", ""));
            }
        } else if (glob_premium_key_type.equalsIgnoreCase(KEY_GOLD)) {
            if (!V(kingappsPhone.this)) {
                Toast.makeText(kingappsPhone.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
            } else if (kingappsPhpe.skipDirectPayMode().equals("yes")) {
                Toast.makeText(kingappsPhone.this, "Coming Soon....", Toast.LENGTH_SHORT).show();
            } else {
                elephant_TagName = "Gold Plan";
                elephant_Price = key_Ticket_Gold;
                elephant_MRP = key_Ticket_Gold;
                X(S(Double.parseDouble(key_Ticket_Gold)).replaceAll("\\.0*$", ""));
            }
        } else {
            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    public void m4106x9ba54bf2(View view) {
        off1.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off2.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off3.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtGold.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtSilver.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtBronze.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off3.setBackgroundColor(getResources().getColor(R.color.packgerselect_bg));
        txtGold.setBackgroundColor(getResources().getColor(R.color.packgerselect_bg));
        Scalee(findViewById(R.id.rl_gold), this);
    }

    public void m4107x7998b1d1(View view) {
        off1.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off2.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off3.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtGold.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtSilver.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtBronze.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off2.setBackgroundColor(getResources().getColor(R.color.packgerselect_bg));
        txtSilver.setBackgroundColor(getResources().getColor(R.color.packgerselect_bg));
        Scalee(findViewById(R.id.rl_silver), this);
    }


    public void m4108x578c17b0(View view) {
        off1.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off2.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off3.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtGold.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtSilver.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        txtBronze.setBackgroundColor(getResources().getColor(R.color.theme_blue));
        off1.setBackgroundColor(getResources().getColor(R.color.packgerselect_bg));
        txtBronze.setBackgroundColor(getResources().getColor(R.color.packgerselect_bg));
        Scalee(findViewById(R.id.rl_bronze), this);
    }


    public void Scalee(View view, Context context) {
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.zoomin));
        try {
            lastview_fata.startAnimation(AnimationUtils.loadAnimation(context, R.anim.zoomout));
        } catch (Exception e) {
            e.printStackTrace();
        }
        lastview_fata = view;
    }


    public final void W() {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View inflate = LayoutInflater.from(this).inflate(R.layout.kingappsdialogpay, (ViewGroup) null, false);
        bottomSheetDialog.setContentView(inflate);

        inflate.findViewById(R.id.close_di_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        if (key_MerchantCODE.equals("100")) {
            inflate.findViewById(R.id.radhe_g_pay).setVisibility(View.VISIBLE);
            inflate.findViewById(R.id.radhe_phonepay).setVisibility(View.GONE);
            inflate.findViewById(R.id.radhe_other_app).setVisibility(View.GONE);
        } else if (key_MerchantCODE.equals("001")) {
            inflate.findViewById(R.id.radhe_g_pay).setVisibility(View.GONE);
            inflate.findViewById(R.id.radhe_phonepay).setVisibility(View.GONE);
            inflate.findViewById(R.id.radhe_other_app).setVisibility(View.VISIBLE);
        } else if (key_MerchantCODE.equals("000")) {
            inflate.findViewById(R.id.radhe_g_pay).setVisibility(View.GONE);
            inflate.findViewById(R.id.radhe_phonepay).setVisibility(View.GONE);
            inflate.findViewById(R.id.radhe_other_app).setVisibility(View.GONE);
        } else if (key_MerchantCODE.equals("111")) {
            inflate.findViewById(R.id.radhe_g_pay).setVisibility(View.VISIBLE);
            inflate.findViewById(R.id.radhe_phonepay).setVisibility(View.VISIBLE);
            inflate.findViewById(R.id.radhe_other_app).setVisibility(View.VISIBLE);
        } else if (key_MerchantCODE.equals("010")) {
            inflate.findViewById(R.id.radhe_g_pay).setVisibility(View.GONE);
            inflate.findViewById(R.id.radhe_phonepay).setVisibility(View.VISIBLE);
            inflate.findViewById(R.id.radhe_other_app).setVisibility(View.GONE);
        } else if (key_MerchantCODE.equals("110")) {
            inflate.findViewById(R.id.radhe_g_pay).setVisibility(View.VISIBLE);
            inflate.findViewById(R.id.radhe_phonepay).setVisibility(View.VISIBLE);
            inflate.findViewById(R.id.radhe_other_app).setVisibility(View.GONE);
        } else if (key_MerchantCODE.equals("101")) {
            inflate.findViewById(R.id.radhe_g_pay).setVisibility(View.VISIBLE);
            inflate.findViewById(R.id.radhe_phonepay).setVisibility(View.GONE);
            inflate.findViewById(R.id.radhe_other_app).setVisibility(View.VISIBLE);
        } else if (key_MerchantCODE.equals("011")) {
            inflate.findViewById(R.id.radhe_g_pay).setVisibility(View.GONE);
            inflate.findViewById(R.id.radhe_phonepay).setVisibility(View.VISIBLE);
            inflate.findViewById(R.id.radhe_other_app).setVisibility(View.VISIBLE);
        }

        inflate.findViewById(R.id.radhe_g_pay).setOnClickListener(new mGpay(bottomSheetDialog));
        inflate.findViewById(R.id.radhe_phonepay).setOnClickListener(new mPhonePay(bottomSheetDialog));
        inflate.findViewById(R.id.radhe_other_app).setOnClickListener(new mOtherApps(bottomSheetDialog));
//        create.show();
        bottomSheetDialog.show();
        Window window = bottomSheetDialog.getWindow();
        window.setLayout(-1, -2);
        window.setBackgroundDrawable(new ColorDrawable(0));
        bottomSheetDialog.setCancelable(false);
    }

    public final void X(String str) {
        elephant_MRP = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pa", key_MerchantUPI);
            jSONObject.put("pn", elephant_TagName);
            jSONObject.put("am", str);
            jSONObject.put("cu", T("INR"));
            jSONObject.put("tn", Z("Unlock VIP Pass"));
            jSONObject.put("tr", Q);
            jSONObject.put("mc", new kingappsKeytool(this).I());
            Uri build = new Uri.Builder().scheme("upi").authority("pay").appendQueryParameter("pa", key_MerchantUPI).appendQueryParameter("pn", elephant_TagName).appendQueryParameter("mc", new kingappsKeytool(this).I()).appendQueryParameter("tr", Q).appendQueryParameter("tn", Z("Unlock VIP Pass")).appendQueryParameter("am", str).appendQueryParameter("cu", T("INR")).appendQueryParameter("sign", a0(jSONObject.toString())).build();
            M = build;
            R_bitmap = b0(build.toString());
            W();
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Bitmap b0(String str) {
        try {
            Bitmap bitmap = generateQRCode(str, 512, 512);
            return bitmap;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private Bitmap generateQRCode(String text, int width, int height) throws WriterException {
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        BitMatrix bitMatrix = barcodeEncoder.encode(text, BarcodeFormat.QR_CODE, width, height);
        return barcodeEncoder.createBitmap(bitMatrix);
    }

    public Uri c0(Context context, File file) {
        return FileProvider.getUriForFile(context, getPackageName() + ".provider", file);
    }

    public void d0(Bitmap bitmap) {
        Uri c0 = c0(this, e0(bitmap));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.putExtra("android.intent.extra.STREAM", c0);
        intent.putExtra("android.intent.extra.SUBJECT", "Payment QR Code");
        intent.putExtra("android.intent.extra.TEXT", "Scan this QR code to make payment");
        intent.setPackage("com.google.android.apps.nbu.paisa.user");
        Intent createChooser = Intent.createChooser(intent, "Pay with");

        if (createChooser.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(intent, GOOGLE_PAY_REQUEST_CODE);
            startActivityForResult(createChooser, 7);
        } else {
            Toast.makeText(this, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show();
        }
    }

    public File e0(Bitmap bitmap) {
        File file = new File(getCacheDir(), "qr_codes");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "qr_code.png");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return file2;
    }

    public class mGpay implements View.OnClickListener {
        public final BottomSheetDialog c;

        public mGpay(BottomSheetDialog bottomSheetDialog) {
            c = bottomSheetDialog;
        }

        public void onClick(View view) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pa", key_MerchantUPI);
                jSONObject.put("pn", elephant_TagName);
                jSONObject.put("am", elephant_MRP);
                jSONObject.put("cu", T("INR"));
                jSONObject.put("tn", Z("Unlock VIP Pass"));
                jSONObject.put("tr", Q);
                jSONObject.put("mc", new kingappsKeytool(kingappsPhone.this).I());
                M = new Uri.Builder().scheme("upi").authority("pay").appendQueryParameter("pa", key_MerchantUPI).appendQueryParameter("pn", elephant_TagName).appendQueryParameter("mc", new kingappsKeytool(kingappsPhone.this).I()).appendQueryParameter("tr", Q).appendQueryParameter("tn", Z("Unlock VIP Pass")).appendQueryParameter("am", elephant_MRP).appendQueryParameter("cu", T("INR")).appendQueryParameter("sign", a0(jSONObject.toString())).build();
                kingappsPhone elephantStudio = kingappsPhone.this;
                elephantStudio.R_bitmap = elephantStudio.b0(elephantStudio.M.toString());
                c.dismiss();
                kingappsPhone elephantStudio2 = kingappsPhone.this;
                Bitmap bitmap = elephantStudio2.R_bitmap;
                if (bitmap != null) {
//                    Log.e("@@TAG", "bitmap != null");
                    elephantStudio2.d0(bitmap);
                } else {
//                    Log.e("@@TAG", "bitmap == null");
                }

            } catch (JSONException e) {
//                Log.e("@@TAG", "Gpay error: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public class mPhonePay implements View.OnClickListener {
        public final BottomSheetDialog c;

        public mPhonePay(BottomSheetDialog bottomSheetDialog) {
            c = bottomSheetDialog;
        }

        public void onClick(View view) {
            c.dismiss();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(M);
            intent.setPackage(kingappsPhpe.j());
            Intent createChooser = Intent.createChooser(intent, "Pay with");
            if (createChooser.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(createChooser, 7);
            } else {
                Toast.makeText(kingappsPhone.this, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class mOtherApps implements View.OnClickListener {
        public final BottomSheetDialog c;

        public mOtherApps(BottomSheetDialog bottomSheetDialog) {
            c = bottomSheetDialog;
        }

        public void onClick(View view) {
            c.dismiss();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(M);
            Intent createChooser = Intent.createChooser(intent, "Pay with");
            if (createChooser.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(createChooser, 7);
            } else {
                Toast.makeText(kingappsPhone.this, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static String S(double d2) {
        return new DecimalFormat("0.00").format(d2).replaceAll("\\.0*$", "");
    }

    public static String T(String str) {
        if (str == null) {
            return "INR";
        }
        String upperCase = str.trim().toUpperCase();
        if (upperCase.length() != 3) {
            return "INR";
        }
        return upperCase;
    }

    public static boolean V(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() || !activeNetworkInfo.isConnectedOrConnecting() || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }

    public static String Z(String str) {
        if (str == null) {
            return "Payment";
        }
        String trim = str.trim();
        if (trim.length() > 70) {
            return trim.substring(0, 70);
        }
        return trim;
    }

    public static String a0(String str) {
        Throwable e2;
        String str2;
        byte[] bArr;
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(2048);
            PrivateKey privateKey = instance.generateKeyPair().getPrivate();
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                str2 = Base64.getEncoder().encodeToString(privateKey.getEncoded());
            } else {
                str2 = android.util.Base64.encodeToString(privateKey.getEncoded(), 0);
            }
            PrintStream printStream = System.out;
            printStream.println("Base64 Encoded Private Key: " + str2);
            if (i >= 26) {
                bArr = Base64.getDecoder().decode(str2);
            } else {
                bArr = android.util.Base64.decode(str2, 0);
            }
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr));
            Signature instance2 = Signature.getInstance("SHA256withRSA");
            instance2.initSign(generatePrivate);
            instance2.update(str.getBytes());
            byte[] sign = instance2.sign();
            if (i >= 26) {
                return Base64.getEncoder().encodeToString(sign);
            }
            return android.util.Base64.encodeToString(sign, 0);
        } catch (NoSuchAlgorithmException e3) {
            e2 = e3;
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e4) {
            e2 = e4;
            throw new RuntimeException(e2);
        } catch (InvalidKeyException e5) {
            e2 = e5;
            throw new RuntimeException(e2);
        } catch (SignatureException e6) {
            e2 = e6;
            throw new RuntimeException(e2);
        }
    }


    private void successPay() {
        new kingappsPref().setPremiumUser(true);
        startActivity(new Intent(kingappsPhone.this, kingappsThanks.class));
        finish();
    }


    public final void mOutput(ArrayList arrayList) {

//        for (int i = 0; i < arrayList.size(); i++) {
//            Log.e("@@TAG", "mOutput arrayList: " + arrayList.get(i));
//        }

        String[] split;
        if (V(this)) {
            String str = (String) arrayList.get(0);
            if (str == null) {
                str = "discard";
            }
//            Log.e("paumentd", str);
            String str2 = "";
            for (String str3 : str.split("&")) {
                String[] split2 = str3.split("=");
                if (split2.length < 2) {
                    str2 = "Payment cancelled by user.";
                } else if (split2[0].toLowerCase().equals("Status".toLowerCase())) {
                    this.O = split2[1].toLowerCase();
                } else if (split2[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || split2[0].toLowerCase().equals("txnRef".toLowerCase())) {
                    this.T = split2[1];
                }
            }

            if (this.O.equals("success")) {
                successPay();
                this.O = "success";
                Toast.makeText(this, "Transaction successful.", Toast.LENGTH_SHORT).show();
            } else if ("Payment cancelled by user.".equals(str2)) {
                this.O = "Payment cancelled by user.";
                Toast.makeText(this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
            } else {
                this.O = "Transaction failed.Please try again";
                Toast.makeText(this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 7) {
//            Log.e("@@TAG", "onActivityResult: if");
            if (-1 != i2 && i2 != 11) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("nothing");
                mOutput(arrayList);

//                Log.e("@@TAG", "onActivityResult: if-1");

            } else if (intent != null) {
                String stringExtra = intent.getStringExtra("response");
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(stringExtra);
                mOutput(arrayList2);


                //gpay only (new)
                handleGooglePayResponse(stringExtra);

//                Log.e("@@TAG", "onActivityResult: if-2");

            } else {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add("nothing");
                mOutput(arrayList3);

//                Log.e("@@TAG", "onActivityResult: if-3");
            }
        } else {
//            Log.e("@@TAG", "onActivityResult: else");
        }
    }


    private void handleGooglePayResponse(String response) {
        if (response == null) {
            return;
        }

        // Parsing the response
        try {
            JSONObject responseObject = new JSONObject(response);
            String status = responseObject.getString("Status");
            String approvalRefNo = responseObject.getString("ApprovalRefNo");

            if (status.equals("SUCCESS")) {
                // Payment was successful
                // Do something with the approval reference number
//                Log.e("@@TAG", "GPay Response: SUCCESS");
            } else {
                // Payment failed
                // Handle failure case
//                Log.e("@@TAG", "GPay Response: Payment failed!");
            }
        } catch (JSONException e) {
//            Log.e("@@TAG", "GPay Response: JSONException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


