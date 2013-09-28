package bruno.imagemdodianasa;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.os.AsyncTask;

public class RssService extends AsyncTask<RssHandler, Void, RssItem>{
	private ActivityPrincipal activity;

	public RssService(ActivityPrincipal activity){
	
	}

	@Override
	protected RssItem doInBackground(RssHandler... arg0) {
		RssHandler handler = arg0[0];
		RssItem item = null;
		
		try{
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			
			xr.setContentHandler(handler);
			xr.parse(new InputSource(activity.getAssets().open("iotd.xml")));
			
			item = handler.getItem();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
