package com.example.horac.flashcardapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.MinusButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);
                AddCardActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        findViewById(R.id.SaveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newQuestion = ((EditText)findViewById(R.id.editText)).getText().toString();
                String newAnswer = ((EditText)findViewById(R.id.editText2)).getText().toString();
                Intent data = new Intent();
                data.putExtra("string1", newQuestion);
                data.putExtra("string2", newAnswer);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }

}
