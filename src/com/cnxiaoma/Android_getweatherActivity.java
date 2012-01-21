package com.cnxiaoma;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
	  //  btn.setText("updateWeather");
		try {
			url = new URL("http://www.google.com/ig/api?weather=shanghai&hl=zh-cn");

            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();

            /* 从SAXParser得到XMLReader*/
            XMLReader xr = sp.getXMLReader();

            /*
             * 创建GoogleWeatherHandler，以便解析XML内容
             */
            GoogleWeatherHandler gwh = new GoogleWeatherHandler();
            xr.setContentHandler(gwh);

            /* 解析XML文件内容 */
            xr.parse(new InputSource(url.openStream()) );
            
			
	    	btn.setText("魔都当前温度：" + gwh.getCurrentTemp() + "摄氏度");
		    
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}