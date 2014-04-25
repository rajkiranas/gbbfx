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
    public static final String Height_Feets_Values="Height_Feets_Values";
    public static final String Zero_To_Seven_WeekDays="Zero_To_Seven_WeekDays";
    public static final String Zero_Number="0";
    public static final String Zero="Zero";
    public static final String Twelve="Twelve";
    public static final String TwentyFour="TwentyFour";
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
    public static final String None="Lbl_None";
    public static final String Addiction_Frequency_Options="Addiction_Frequency_Options";
    public static final String hash="#";
    public static final String dollar="$";
    public static final String Lbl_Father="Lbl_Father";
    public static final String Lbl_Mother="Lbl_Mother";
    public static final String Lbl_Brother="Lbl_Brother";
    public static final String Lbl_Housewife="Lbl_Housewife";
    public static final String Lbl_Female="Lbl_Female";
    public static final String Lbl_Male="Lbl_Male";
    //public static final String Lbl_Alert="Lbl_Alert";
    public static final String twoOptionQuestions="twoOptionQuestions";
    public static final String threeOptionQuestions="threeOptionQuestions";
    public static final String femaleOnlyQuestions="femaleOnlyQuestions";
    public static final String Lbl_Marital_Status_Options="Lbl_Marital_Status_Options";
    public static final String Lbl_Single_Status="Lbl_Single_Status";
    public static final String Lbl_Spouse="Lbl_Spouse";
    public static final String Lbl_Husband="Lbl_Husband";
    public static final String Lbl_Wife="Lbl_Wife";
    
    public static final String application_json="application/json";
    public static final String userInfoObject="userInfoObject";
    public static final String gsonTimeFormat="yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String hyphen="-";
    public static final String plus="+";
    public static final String handshakeUrl="handshakeUrl";
    public static final String dataSubmitUrl="dataSubmitUrl";
            
}
