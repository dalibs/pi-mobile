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
import com.codename1.ui.util.Resources;
import com.codename1.uikit.pheonixui.AssociationBaseForm;

/**
 *
 * @author user
 */
public class HomeEventForm extends AssociationBaseForm {

    Form current;
    private Resources theme;

    public HomeEventForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    public HomeEventForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home Event");
        setLayout(BoxLayout.y());

        installSidemenu(resourceObjectInstance);

        add(new Label("Choose an option :"));
        Button btnAddTask = new Button("Add An Event");
        Button btnListTasks = new Button("List My Events");
        Button btnListEvents = new Button("List All Events");

        btnAddTask.addActionListener(e -> new AddEventForm(current, theme).show());
        btnListTasks.addActionListener(e -> new AfficherMyEvenement(current, theme).show());
        btnListEvents.addActionListener(e -> new AfficherAllEvents(current, theme).show());
        addAll(btnAddTask, btnListTasks, btnListEvents);

    }

}
