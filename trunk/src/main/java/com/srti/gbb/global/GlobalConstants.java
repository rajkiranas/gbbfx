/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.global;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author kishorp
 */
public class GlobalConstants {
    private static Properties properties = new Properties();
    static
    {
        try {
            loadProperties();
        } catch (IOException ex) {
          //  logger.debug("Exception occured in loadProperties() method, Exception=", ex);
          //Logger.getLogger(GlobalConstants.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    
    
    
    static class PropertyLoader {

        public InputStream getProperty() {
            InputStream l_objInputStream = getClass().getClassLoader().
                    getResourceAsStream("default_en_US.properties");
            return l_objInputStream;
        }
    }

    private static void loadProperties() throws IOException {
            GlobalConstants.PropertyLoader PL = new GlobalConstants.PropertyLoader();
            InputStream inputStream = PL.getProperty();
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
             // logger.debug("Properties File not found!");
            }
    }
 
     public static String getProperty(String key)
     {
         return properties.getProperty(key);
     }
    
    public static final String GenderList = "GenderList";
    public static final String ReligionList = "ReligionList";
    public static final String COMMA = ",";
    public static final String emptyString = "";
    public static final String MaxAge="MaxAge";
    public static final String Loose_Motions_Constipations_Values="Loose_Motions_Constipations_Values";
    public static final String Zero_To_Seven_WeekDays="Zero_To_Seven_WeekDays";
    public static final String Zero="0";
    public static final String TwentyFour="24";
    public static final String Diet_Options="Diet_Options";
    public static final String Food_Type_Options="Food_Type_Options";
    public static final String Exercise_Type_Options="Exercise_Type_Options";
    public static final String Occupation_Options="Occupation_Options";
    public static final String Income_Options="Income_Options";
    public static final String Time_Params="Time_Params";
    public static final String Addiction_Params="Addiction_Params";
    public static final String Lbl_Faculty_Stream_Options="Lbl_Faculty_Stream_Options";
    public static final String Lbl_Family_Member_Options="Lbl_Family_Member_Options";
    public static final String Lbl_Highest_Education_Options="Lbl_Highest_Education_Options";
    public static final String Profession_Options="Profession_Options";
    public static final String Lbl_Family_Member="Lbl_Family_Member";
    public static final String Lbl_Highest_Education="Lbl_Highest_Education";
    public static final String Input_Prompt_Occupation="Input_Prompt_Occupation";
    public static final String Input_Prompt_Profession="Input_Prompt_Profession";
    public static final String Input_Prompt_Income="Input_Prompt_Income";
    public static final String Hobby_Options="Hobby_Options";
    public static final String Entertainment_List="Entertainment_List";
    public static final String Lbl_Vehicle_Type_Options="Lbl_Vehicle_Type_Options";
    public static final String underscore="_";
    public static final String ONE="1";
    public static final String TWO="2";
    public static final String THREE="3";
    public static final String Country_List_Options="Country_List_Options";
    public static final String India_States="India_States";
    public static final String Total_Prakruti_Questions="Total_Prakruti_Questions";
    public static final String Lbl_Disease_Options="Lbl_Disease_Options";
    public static final String Lbl_Alert="Lbl_Alert";
    public static final String Traveling_Options="Traveling_Options";
    public static final String None="None";
    public static final String Addiction_Frequency_Options="Addiction_Frequency_Options";
}
