/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.uikit.pheonixui.AssociationBaseForm;
import com.codename1.uikit.pheonixui.BaseForm;

/**
 *
 * @author bhk
 */
public class HomeCampementForm extends AssociationBaseForm{
       public HomeCampementForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
Form current;
    public HomeCampementForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        installSidemenu(resourceObjectInstance);
        
        add(new Label("Choose an option"));
        Button btnAddTask = new Button("Add Task");
        Button btnListTasks = new Button("List Tasks");
        
        btnAddTask.addActionListener(e-> new AddCampementForm(current).show());
        btnListTasks.addActionListener(e-> new ListCapementForm(current).show());
        addAll(btnAddTask,btnListTasks);
        
        
    }
    
    
}
