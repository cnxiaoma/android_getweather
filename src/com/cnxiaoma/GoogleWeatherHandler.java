package com.cnxiaoma;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * GoogleWeatherHandler:用户从Google Weather API返回的XML中提取当前天气信息
 */
public class GoogleWeatherHandler extends DefaultHandler {
     private boolean in_forecast_information = false;
     private boolean in_current_conditions = false;
     private boolean in_forecast_conditions = false;
     
     private String current_city;
     private Integer current_temp;
     private String current_condition;
     private String current_hum;
     private String current_wind;
     private String iconURL;
     
     private boolean usingSITemperature = false; // false为华氏度，true为摄氏度

	public String getCurrentWind() {
		return current_wind;
	}
	public void setCurrentWind(String current_wind) {
		this.current_wind = current_wind;
	}
	public String getCurrentCity(){
    	 return this.current_city;
     }
     public Integer getCurrentTemp(){
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
     public void setCurrentTemp(Integer temp) {
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
          // 'Outer' Tags
          if (localName.equals("forecast_information")) {
               this.in_forecast_information = true;
          } else if (localName.equals("current_conditions")) {
               this.in_current_conditions = true;
          } else if (localName.equals("forecast_conditions")) {
               this.in_forecast_conditions = true;
          } else {
               String dataAttribute = atts.getValue("data");
               // 'Inner' Tags of "<forecast_information>"
               if (localName.equals("city")) {
            	   this.setCurrentCity(dataAttribute);
               } else if (localName.equals("postal_code")) {
               } else if (localName.equals("latitude_e6")) {
                    /* One could use this to convert city-name to Lat/Long. */
               } else if (localName.equals("longitude_e6")) {
                    /* One could use this to convert city-name to Lat/Long. */
               } else if (localName.equals("forecast_date")) {
               } else if (localName.equals("current_date_time")) {
            	   
               } else if (localName.equals("unit_system")) {
                    if (dataAttribute.equals("SI"))
                         this.usingSITemperature = true;
               }
               // SHARED(!) 'Inner' Tags within "<current_conditions>" AND
               // "<forecast_conditions>"
               else if (localName.equals("day_of_week")) {
                    if (this.in_current_conditions) {
                        //可扩展
                    } else if (this.in_forecast_conditions) {
                        //可扩展
                    }
               } else if (localName.equals("icon")) {
                    if (this.in_current_conditions) {
                        this.setIconURL(dataAttribute);
                    } else if (this.in_forecast_conditions) {
                    	//可扩展
                    }
               } else if (localName.equals("condition")) {
                    if (this.in_current_conditions) {
                        this.setCurrentCondition(dataAttribute);
                    } else if (this.in_forecast_conditions) {
                    	//可扩展
                    }
               }
               // 'Inner' Tags within "<current_conditions>"
               else if (localName.equals("temp_f")) {
                    //this.setCurrentTemp(Integer.parseInt(dataAttribute));
               } else if (localName.equals("temp_c")) {
            	    this.setCurrentTemp(Integer.parseInt(dataAttribute));
               } else if (localName.equals("humidity")) {
                    this.setCurrentHum(dataAttribute);
               } else if (localName.equals("wind_condition")) {
                    //可扩展     
            	   this.setCurrentWind(dataAttribute);
               }
               // 'Inner' Tags within "<forecast_conditions>"
               else if (localName.equals("low")) {
                    int temp = Integer.parseInt(dataAttribute);
                    if (this.usingSITemperature) {
                    	//可扩展  
                    } else {
                    	//可扩展  
                    }
               } else if (localName.equals("high")) {
                    //int temp = Integer.parseInt(dataAttribute);
                    if (this.usingSITemperature) {
                    	//可扩展  
                    } else {
                    	//可扩展  
                    }
               }
          }
     }

     @Override
     public void endElement(String namespaceURI, String localName, String qName)
               throws SAXException {
          if (localName.equals("forecast_information")) {
               this.in_forecast_information = false;
          } else if (localName.equals("current_conditions")) {
               this.in_current_conditions = false;
          } else if (localName.equals("forecast_conditions")) {
               this.in_forecast_conditions = false;
          }
     }

     @Override
     public void characters(char ch[], int start, int length) {
          /*
           * 可扩展 <element>characters</element>
           */
     }
}