/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entites.Campement;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class ServiceCampement {
        public ArrayList<Campement> Campements;
    
    public static ServiceCampement instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceCampement() {
         req = new ConnectionRequest();
    }

    public static ServiceCampement getInstance() {
        if (instance == null) {
            instance = new ServiceCampement();
        }
        return instance;
    }
        public ArrayList<Campement> parseCampement(String jsonText){
        try {
            Campements=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Campement c = new Campement();
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
                c.setNom(obj.get("nom").toString());
                c.setDescription(obj.get("description").toString());
                c.setPaye(obj.get("paye").toString());
               double longitude = Float.parseFloat(obj.get("longitude").toString());
                c.setLatitude(longitude);
               double latitude = Float.parseFloat(obj.get("latitude").toString());
                c.setLatitude(longitude);

                Campements.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
        return Campements;
    }
        public ArrayList<Campement> getAllCampement(){
        String url = Statics.BASE_URL+"/association/allmobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Campements = parseCampement(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Campements;
    }
            public boolean addCampement(Campement t) {
                String urlParameters  = "?nom="+t.getNom()+"&description="+t.getDescription()+"&latitude="+t.getLatitude()+"&longitude="+t.getLongitude()+"&pays="+t.getPaye();
        String url = Statics.BASE_URL + "/association/newmobile" +urlParameters;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }


    
}
