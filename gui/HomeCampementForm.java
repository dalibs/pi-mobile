/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.MultiButton;
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
public class HomeCampementForm extends AssociationBaseForm {

    public HomeCampementForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    Form current;

    public HomeCampementForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        current = this;
        setTitle("Association Home");
        setLayout(BoxLayout.y());
        installSidemenu(resourceObjectInstance);

        add(new Label("Welcome to association home"));

        MultiButton twoLinesNoIcon = new MultiButton("Powered by "
        );

        twoLinesNoIcon.setTextLine2("Codex Team");
        add(twoLinesNoIcon);
    }

}
