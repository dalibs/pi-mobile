/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.uikit.pheonixui.AssociationBaseForm;
import com.codename1.uikit.pheonixui.BaseForm;

/**
 *
 * @author bhk
 */
public class HomeCampementForm extends AssociationBaseForm {

    public HomeCampementForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    Form current;

    public HomeCampementForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        current = this;
        setTitle(" Welcome to Association Home");
        setLayout(BoxLayout.y());
        installSidemenu(resourceObjectInstance);

        MultiButton twoLinesNoIcon = new MultiButton("Powered by "
        );

        twoLinesNoIcon.setTextLine2("Codex Team");
        //  add(twoLinesNoIcon);

        String line1 = "World Aid est une application Desktop,Web et Mobile. Ceci est la version mobile cette application a été developpé par le groupe Codex Team.Nous offrons pour la partie association plusieurs options comme la gestion des évenement avec la possibilté d'utilisation de la map et de recherche avancé, la gestion des campements pour les réfugiés et aussi l'association peut afficher les feedback pour chaque évenements. ";
        if (!Display.getInstance().isTablet()) {
            line1 = line1.replace('\n', ' ');
        }

        Container content1 = BoxLayout.encloseY(
                new Label("WorldAid", "WelcomeTitle"),
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle"),
                new SpanLabel(line1, "WelcomeBody")
        );
        Container content2 = BoxLayout.encloseY(
                // Image bla = resourceObjectInstance.getImage("codexteam.png");
                new Label(resourceObjectInstance.getImage("codexteam.png"), "WelcomeTitle")
        );

        add(content1);
        add(new Label("Powered by:"));
        add(new Label(resourceObjectInstance.getImage("calendar-separator.png"), "WelcomeTitle"));
        add(content2);
        add(new Label(resourceObjectInstance.getImage("calendar-separator.png"), "WelcomeTitle"));

    }

}
