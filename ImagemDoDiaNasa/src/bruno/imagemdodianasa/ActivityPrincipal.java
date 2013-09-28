package bruno.imagemdodianasa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;


public class ActivityPrincipal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_principal);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_principal, menu);
        return true;
    }
    
    public void displayData(RssItem Item){
    	TextView title = (TextView)findViewById(R.id.titulo);
    	TextView date = (TextView)findViewById(R.id.data);
    	ImageView image = (ImageView)findViewById(R.id.imagem);
    	TextView descricao = (TextView)findViewById(R.id.descricao);
    	
    	if (Item != null) {
    		title.setText(Item.getTitle());
    		date.setText(Item.getDate());
    		//image.setImage()
    		descricao.setText(Item.getDescription());
    	}
    }
}
