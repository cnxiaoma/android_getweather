package com.cnxiaoma;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class Android_getweatherActivity extends Activity implements View.OnClickListener {
    /** Called when the activity is first created. */
	Button btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn = new Button(this);
        btn.setOnClickListener(this);
        updateWeather();
        setContentView(btn);
    }
    
    public void onClick(View view){
			updateWeather();
    }
    
    public void updateWeather(){
	    URL url;
	    SAXParserFactory spf = SAXParserFactory.newInstance();
	    btn.setText("updateWeather");
 		//	SAXParser sp = spf.newSAXParser();
 		//	url = new URL("http://www.google.com/ig/api?weather=shanghai&hl=zh-cn");

         //    XMLReader xr = sp.getXMLReader();

          //   GoogleWeatherHandler gwh = new GoogleWeatherHandler();
          //   xr.setContentHandler(gwh);
             
          //   InputStreamReader utf8In=new InputStreamReader(url.openStream(),"utf-8");
            
          //   xr.parse(new InputSource(utf8In));
             
	  //  	btn.setText("w" + gwh.getCurrentCity() + "");


    }
}