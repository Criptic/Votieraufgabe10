package designtest.davidweik.substitutioncipher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView key;
    private TextView cipher;
    private TextView plain;
    private CheckBox decryptBox;
    private char p[]  = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        key = (TextView) findViewById(R.id.key);
        cipher = (TextView) findViewById(R.id.cipher_text);
        plain = (TextView) findViewById(R.id.plaint_text);
        decryptBox = (CheckBox) findViewById(R.id.decrypt);
    }

    public void changeCryptionState(View v) {
        boolean decrypt = decryptBox.isChecked();
        if(decrypt) {
            System.out.println(doDecryption());
            plain.setText(doDecryption());
        } else {
            cipher.setText(doEncryption());
        }
    }

    public String doEncryption() {
        String keyText = key.getText().toString();
        String plainText = plain.getText().toString();

        char c[] = new char[(plainText.length())];
        for (int i = 0; i < plainText.length(); i++) {
            for(int j = 0; j<26;j++) {
                if (p[j] == plainText.charAt(i)) {
                    System.out.println("Test");
                    c[i] = keyText.charAt(j);
                    break;
                }
            }
        }
        return (new String(c));
    }

    public String doDecryption() {
        String cipherText = cipher.getText().toString();
        String keyText = key.getText().toString();

        char c[] = new char[(cipherText.length())];
        for (int i = 0; i<cipherText.length();i++) {
            for (int j = 0; j<26; j++) {
                if (keyText.charAt(j) == cipherText.charAt(i)) {
                    c[i] = p[j];
                    break;
                }
            }
        }
        return (new String(c));
    }
}
