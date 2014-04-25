/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.srti.gbb.bean.PrakrutiQuestionAnsBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.MU;
import com.srti.gbb.utils.UIUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen17Controller implements  Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    @FXML
    private Button submitDataBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //setVisibilityOfSubmitButton();
    }
    
     @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    @FXML
    private void goToPreviousScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen11ID);
    }

    @FXML
    private void submitDataAndShowReport(ActionEvent event) 
    {
        //if net // if data submitted // then go to next screen and show prakruti report
        
        if(isHandshakeSuccessful())
        {
            //submit data
            submitDataToService();
            
            //show constitution
            showPrakrutiConstitution();
            navigateToNextScreen();
        }
        else
        {
            UIUtils.showAlert("sc17_msg_no_inet_available", GlobalConstants.Lbl_Alert);
        }
    }

    
    private static final String V="V";
    private static final String P="P";
    private static final String K="K";
    
    private void showPrakrutiConstitution() {
        //vpk denotes vata, pitta and kafa
        int vCount=0;
        int pCount=0;
        int kCount=0;
        List<PrakrutiQuestionAnsBean> prakrutiQuestionAnsList=navigator.getUserInfo().getPrakrutiQuestionAnsList();
        
        if(prakrutiQuestionAnsList!=null)
        {
            for (PrakrutiQuestionAnsBean bean : prakrutiQuestionAnsList) 
            {
                if(bean.isOpt1Checked())
                {
                    vCount++;
                }

                if(bean.isOpt2Checked())
                {
                    pCount++;
                }

                if(bean.isOpt3Checked())
                {
                    kCount++;
                }            
            }
        }
        
        


//        int key=0;
//        int count=0;
        String firstLetter=GlobalConstants.emptyString;
        String secondLetter=GlobalConstants.emptyString;
//        
//        //for sorting vpk
//        TreeMap<Integer,String> ts = new TreeMap<Integer,String>();
//        
//        ts.put(vCount,V);
//        ts.put(pCount,P);
//        ts.put(kCount,K);
//        
//        System.out.println("***ts="+ts);
//        
//        Set<Integer> decendingKeySet = ts.descendingKeySet();
//        System.out.println("***decendingKeySet="+decendingKeySet);
//        Iterator<Integer> itr = decendingKeySet.iterator();
//        
//        if(itr.hasNext())
//        {
//            key = itr.next();
//            firstLetter=ts.get(key);
//        }
//
//        if(itr.hasNext())
//        {
//            key = itr.next();
//            secondLetter=ts.get(key);
//        }
        
        
        if (vCount > pCount && vCount > kCount) {
            firstLetter=V;
            
            if(pCount>kCount)
            {
                secondLetter=P;
            }
            else
            {
                secondLetter=K;
            }
        }

        else if (pCount > vCount && pCount > kCount) {
            firstLetter=P;
            
            if(vCount > kCount)
            {
                secondLetter=V;
            }
            else
            {
                secondLetter=K;
            }
        }

        else if (kCount > vCount && kCount > pCount) {
            firstLetter=K;
            
            if(vCount > pCount)
            {
                secondLetter=V;
            }
            else
            {
                secondLetter=P;
            }
            
        }
        else
        {
            firstLetter=V;
            secondLetter=P;
        }
        
        
        System.out.println("******firstLettersecondLetter="+firstLetter+secondLetter);
        File f = new File(GlobalConstants.emptyString);
        String projectFolder=GlobalConstants.emptyString;
        try {
            projectFolder = f.getCanonicalPath();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        File pdfFile = new File(projectFolder+File.separatorChar+"Prakruti"+File.separatorChar+firstLetter+secondLetter+File.separatorChar+"Prakruti.pdf");
		
        if (pdfFile.exists()) 
        {

            navigator.getUserInfo().setHealthReportPath(pdfFile.getAbsolutePath());
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(pdfFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Awt Desktop is not supported!");
            }

        }
        else
        {
             UIUtils.showAlert("sc17_msg_report_does_not_exists", GlobalConstants.Lbl_Alert);
        }
    }

    
    private boolean isHandshakeSuccessful()
    {
        boolean isAvailable=false;
        try 
        {
            Client client = Client.create();
            WebResource webResource = client.resource(MU.getMsg(GlobalConstants.handshakeUrl));
            
            ClientResponse response = webResource.type(GlobalConstants.application_json)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(ClientResponse.class);

            System.out.println("***response="+response.getStatus());
            if(response.getStatus()==200)
            {
                JSONObject outJson = null;
                outJson = response.getEntity(JSONObject.class);
                System.out.println("outJson=" + outJson);
                if(outJson.getString("Status").equalsIgnoreCase("Handshake-Success"))
                {
                    isAvailable= true;
                }
            }
//            String output = response.getEntity(String.class);
//            outJson = new JSONObject(output);
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        System.out.println("***isAvailable="+isAvailable);
        return isAvailable;
    }
//    private boolean isInternetAvailable()
//    {
//        boolean isAvailable=false;
//        try {
//            final URL url = new URL("http://www.google.com");
//            final URLConnection conn = url.openConnection();
//            conn.setConnectTimeout(5000);
//            conn.connect();
//            isAvailable= true;
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("***isAvailable="+isAvailable);
//        return isAvailable;
//    }

//    private static final String dataSubmitUrl="http://localhost:8084/gbb/services/UserResource/saveUserDetails";
//    private static final String handshakeUrl="http://localhost:8084/gbb/services/UserResource/handshake";
   
    
    private void submitDataToService() {
        
        try 
        {
            Client client = Client.create();
            //WebResource webResource = client.resource(GlobalConstants.getProperty(dataSubmitUrl));
            WebResource webResource = client.resource(MU.getMsg(GlobalConstants.dataSubmitUrl));
            //String input = "{\"userName\":\"raj\",\"password\":\"FadeToBlack\"}";
            JSONObject inputJson = new JSONObject();
            
            Gson gson=  new GsonBuilder().setDateFormat(GlobalConstants.gsonTimeFormat).create();       
            String json = gson.toJson(navigator.getUserInfo());
            
            try 
            {
                           
            
                inputJson.put(GlobalConstants.userInfoObject, json);
                System.out.println("*********inputJson="+inputJson);
            } catch (JSONException ex) {
                ex.printStackTrace();
            }

            ClientResponse response = webResource.type(GlobalConstants.application_json)
                    .accept(MediaType.APPLICATION_JSON)
                    
                    .post(ClientResponse.class, inputJson);

          
            JSONObject outJson = null;
//            String output = response.getEntity(String.class);
//            outJson = new JSONObject(output);
            outJson = response.getEntity(JSONObject.class);

            System.out.println("outJson="+outJson);
            
//            Type listType = new TypeToken<ArrayList<String>>() {
//            }.getType();
//            
//             noticeList=new Gson().fromJson(outNObject.getString(""), listType);
            
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        navigator.getUserInfo().setDataSubmittedSuccessfully(true);
    }

    private void navigateToNextScreen() {
         navigator.navigateTo(ScreensFramework.ThankyouSceneId);
    }

    
    private void setVisibilityOfSubmitButton() {
        if(!navigator.getUserInfo().isDataSubmittedSuccessfully())
        {
            submitDataBtn.setDisable(false);
        }
        else
        {
            submitDataBtn.setDisable(true);
        }
    }
}
