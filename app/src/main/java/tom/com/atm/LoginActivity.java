package tom.com.atm;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v){
        EditText edUserid = findViewById(R.id.ed_userid);
        EditText edPasswd = findViewById(R.id.ed_passwd);
        String uid = edUserid.getText().toString();
        String pw = edPasswd.getText().toString();

        if(uid.equals("jack") && pw.equals("1234")){ //登錄成功
            SharedPreferences setting = getSharedPreferences("atm", MODE_PRIVATE);
            setting.edit()
                    .putString("PREF_USERID", uid)
                    .apply();

            Toast.makeText(this, "登錄成功", Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_USERID", uid);
            getIntent().putExtra("LOGIN_PASSWD", pw);
            setResult(RESULT_OK, getIntent());
            finish();
        } else { //失敗
            new AlertDialog.Builder(this)
                    .setTitle("Atm")
                    .setMessage("登錄失敗")
                    .setPositiveButton("ok", null)
                    .show();
        }
    }

    public void cancel(View v){

    }
}
