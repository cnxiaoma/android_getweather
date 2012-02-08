package com.cnxiaoma;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GoogleWeatherHandler extends DefaultHandler {
     
     private String current_city;
     private String current_temp;
     private String current_condition;
     private String current_hum;
     private String current_wind;
     private String iconURL;
     
	public String getCurrentWind() {
		return current_wind;
	}
	public void setCurrentWind(String current_wind) {
		this.current_wind = current_wind;
	}
	public String getCurrentCity(){
    	 return this.current_city;
     }
     public String getCurrentTemp(){
    	 return this.current_temp;
     }
     public String getCurrentCondition(){
    	 return this.current_condition;
     }
     public String getCurrentHum(){
    	 return this.current_hum;
     }
     public String getIconURL(){
    	 return this.iconURL;
     }
     public void setCurrentCity(String city){
    	 this.current_city = city;
     }
     public void setCurrentTemp(String temp) {
         this.current_temp = temp;
     }
     public void setCurrentCondition(String condition) {
         this.current_condition = condition;
     }
     public void setCurrentHum(String hum) {
         this.current_hum = hum;
     }
     public void setIconURL(String iconURL) {
          this.iconURL = iconURL;
     }
     
     @Override
     public void startDocument() throws SAXException {
   
     }

     @Override
     public void endDocument() throws SAXException {
          
     }

     @Override
     public void startElement(String namespaceURI, String localName,
               String qName, Attributes atts) throws SAXException {
    	  if (qName.equals("city")) {
    		  this.setCurrentCity(atts.getValue("data"));
    		  } 
    	  if (qName.equals("temp_c")) {
    		  this.setCurrentTemp(atts.getValue("data"));
    		  } 
     }

     @Override
     public void endElement(String namespaceURI, String localName, String qName)
               throws SAXException {

     }

     @Override
     public void characters(char ch[], int start, int length) {
     }
}