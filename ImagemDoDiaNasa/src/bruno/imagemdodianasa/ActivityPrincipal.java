package bruno.imagemdodianasa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
        refresh();
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
    		DateFormat pubDateFormatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",Locale.ENGLISH);
    		DateFormat localeFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    		
    		try{
    			Date dataObj = pubDateFormatter.parse(Item.getDate());
    			date.setText(localeFormatter.format(dataObj));
    		}catch(ParseException e){
    			e.printStackTrace();
    		}
    		
    		image.setImageBitmap(Item.getImage());
    		descricao.setText(Item.getDescription());
    	}
    }
    
    public void refresh() {
    	displayData(null);
    	RssService service = new RssService(this);
    	service.execute(new RssHandler());
    }
}
