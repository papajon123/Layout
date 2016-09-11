package com.cool.alex123.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editTextInput;
    private Button buttonShow;
    private RelativeLayout relativeLayoutMain;
    //запускающий метод для актвити
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }
    //инициализация компонентов
    private void initComponents() {
        initToolbar();
        initFloatingActionButton();
        initButtonShow();
        initRelativeLayout();
    }
    //инициализация тулбара
    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    // инициализация кнопки("конверта")
    private void initFloatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initRelativeLayout(){
        relativeLayoutMain = (RelativeLayout) findViewById(R.id.content_main_relative_layout_main);
        relativeLayoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello BRO", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initButtonShow (){
        buttonShow = (Button) findViewById(R.id.content_main_button_show);
        editTextInput = (EditText) findViewById(R.id.content_main_edit_text_input);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!equalsNumber(editTextInput.getText().toString())){
                    Toast.makeText(MainActivity.this, "Вы ничего не ввели...", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(MainActivity.this, editTextInput.getText(), Toast.LENGTH_SHORT).show();
                //Snackbar.make(view,editTextInput.getText(),Snackbar.LENGTH_LONG).show();
            }
        });

        /*class aClass implements View.OnClickListener{

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, editTextInput.getText(), Toast.LENGTH_SHORT).show();
                //Snackbar.make(view,editTextInput.getText(),Snackbar.LENGTH_LONG).show();
            }
        }
        aClass A = new aClass();
        buttonShow.setOnClickListener(A);*/
    }

    public boolean equalsNumber(String s){
        if (s.equals(""))
            return false;
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*switch (item.getItemId()){
            case R.id.menu_main_item_settings:
                Intent intent = new Intent(this,SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_main_item_about:
                Intent intent2 = new Intent(this,AboutActivity.class);
                startActivity(intent2);
                return true;
            case R.id.menu_main_item_asses:
                Intent intent1 = new Intent(this,AssesActivity.class);
                startActivity(intent1);
                return true;
        }*/
        Class aClass;
        switch (item.getItemId()){
            case R.id.menu_main_item_settings:
                aClass=SettingsActivity.class;
                break;
            case R.id.menu_main_item_asses:
                aClass=AssesActivity.class;
                break;
            case R.id.menu_main_item_about:
                aClass=AboutActivity.class;
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        Intent intent = new Intent(this,aClass);
        startActivity(intent);
        return true;
    }
}
