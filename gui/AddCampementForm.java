/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entites.Campement;
import com.mycompany.myapp.services.ServiceCampement;

/**
 *
 * @author bhk
 */
public class AddCampementForm extends Form{

    public AddCampementForm(Form previous) {
        setTitle("Add a new task");
        setLayout(BoxLayout.y());
        
        TextField tfnom = new TextField("","nom");
        TextField tfdescription = new TextField("","description");
        TextField tftfSpayepaye= new TextField("", "pays");
        TextField tflongitude= new TextField("", "longitude");
        TextField tflatitude= new TextField("", "latitude");
        TextField tfpaye= new TextField("", "paye");
        Button btnValider = new Button("Add Campement");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfdescription.getText().length()==0)||(tflongitude.getText().length()==0)||(tflatitude.getText().length()==0)||(tftfSpayepaye.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Campement c =new Campement(tfnom.getText(), Double.parseDouble(tflongitude.getText()), Double.parseDouble(tflatitude.getText()), tfdescription.getText(), tfpaye.getText());
                       // Campement t = new Campement(Integer.parseInt(tfStatus.getText()), tfName.getText());
                        if( ServiceCampement.getInstance().addCampement(c))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfnom,tfdescription,tftfSpayepaye,tflongitude,tflatitude,tfpaye,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
    
}
