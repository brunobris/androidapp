package com.minhaapp.helloandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TelaInicial extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_inicial, menu);
        return true;
    }
    
    public void onButtonClicked(View view) {
    	TextView texto = (TextView)findViewById(R.id.textView1);
    	
    	texto.setVisibility(TextView.VISIBLE);
    	
    	
    	new AlertDialog.Builder(this).setTitle("Aviso").setMessage(R.string.Message).
    	setNeutralButton("Clique aqui!", new DialogInterface.OnClickListener()
    	{
    		@Override
    		public void onClick(DialogInterface arg0, int arg1){
    			Toast.makeText(TelaInicial.this, getText(R.string.Message), Toast.LENGTH_LONG).show();		
    		}
    		
    		
    	}
    			
    			).show();
    }
    
}
