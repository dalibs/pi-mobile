/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.codename1.uikit.pheonixui;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class Campement  extends BaseForm {

    public Campement() {
       this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }
    
    
    
    public Campement(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Inbox", "Title"),
                        new Label("19", "InboxNumber")
                )
        );
        
        installSidemenu(resourceObjectInstance);
        
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        
        //gui_Label_5.setShowEvenIfBlank(true);
      //  gui_Label_6.setShowEvenIfBlank(true);

      //  gui_Text_Area_1_4.setRows(2);
       // gui_Text_Area_1_4.setColumns(100);
       /// gui_Text_Area_1_4.setEditable(false);
        
        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            fab.setUIID("FloatingActionButtonClose");
            Image oldImage = fab.getIcon();
            FontImage image = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "FloatingActionButton", 3.8f);
            fab.setIcon(image);
            Dialog popup = new Dialog();
            popup.setDialogUIID("Container");
            popup.setLayout(new LayeredLayout());
            
            Button c1 = new Button(resourceObjectInstance.getImage("contact-a.png"));
            Button c2 = new Button(resourceObjectInstance.getImage("contact-b.png"));
            Button c3 = new Button(resourceObjectInstance.getImage("contact-c.png"));
            Button trans = new Button(" ");
            trans.setUIID("Container");
            c1.setUIID("Container");
            c2.setUIID("Container");
            c3.setUIID("Container");
            Style c1s = c1.getAllStyles();
            Style c2s = c2.getAllStyles();
            Style c3s = c3.getAllStyles();
            
            c1s.setMarginUnit(Style.UNIT_TYPE_DIPS);
            c2s.setMarginUnit(Style.UNIT_TYPE_DIPS);
            c3s.setMarginUnit(Style.UNIT_TYPE_DIPS);

            c1s.setMarginBottom(16);
            c1s.setMarginLeft(12);
            c1s.setMarginRight(3);

            c2s.setMarginLeft(4);
            c2s.setMarginTop(5);
            c2s.setMarginBottom(10);
            c3s.setMarginRight(14);
            
            c3s.setMarginTop(12);
            c3s.setMarginRight(16);

            popup.add(trans).
                    add(FlowLayout.encloseIn(c1)).
                    add(FlowLayout.encloseIn(c2)).
                    add(FlowLayout.encloseIn(c3));
            
            ActionListener a = ee -> popup.dispose();
            
            trans.addActionListener(a);
            c1.addActionListener(a);
            c2.addActionListener(a);
            c3.addActionListener(a);
            
            popup.setTransitionInAnimator(CommonTransitions.createEmpty());
            popup.setTransitionOutAnimator(CommonTransitions.createEmpty());
            popup.setDisposeWhenPointerOutOfBounds(true);
            int t = Campement.this.getTintColor();
            Campement.this.setTintColor(0);
            popup.showPopupDialog(new Rectangle(Campement.this.getWidth() - 10, Campement.this.getHeight() - 10, 10, 10));
            Campement.this.setTintColor(t);
            fab.setUIID("FloatingActionButton");
            fab.setIcon(oldImage);
        });
    }

//////////////-- DON'T EDIT BELOW THIS LINE!!!
    //protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
//    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    protected com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
//    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
//    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
//    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
//    protected com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
//    protected com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();

    protected com.codename1.ui.Container gui_Container_1_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1_4 = new com.codename1.ui.TextArea();
    //protected com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("InboxForm");
        setName("InboxForm");
   

        addComponent(gui_Container_1_4);


                gui_Container_2_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2_4.setName("Container_2_4");
                gui_Container_4_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4_4.setName("Container_4_4");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
                gui_Container_3_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3_4.setName("Container_3_4");
        gui_Container_1_4.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_4);
        gui_Label_1_4.setText("Mar 08");
        gui_Label_1_4.setUIID("SmallFontLabel");
                gui_Label_1_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1_4.setName("Label_1_4");
        gui_Container_2_4.addComponent(gui_Label_1_4);
        gui_Container_1_4.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4_4);
        gui_Label_4_4.setUIID("Padding2");
                gui_Label_4_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4_4.setName("Label_4_4");
        gui_Label_4_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
        gui_Container_4_4.addComponent(gui_Label_4_4);
        gui_Container_1_4.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3_4);
        gui_Label_3_4.setText("Twitter");
                gui_Label_3_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3_4.setName("Label_3_4");
        gui_Label_2_4.setText("Popular tweets this week");
        gui_Label_2_4.setUIID("RedLabel");
                gui_Label_2_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2_4.setName("Label_2_4");
        gui_Text_Area_1_4.setText("Hi Adrian, there is a new announcement for you from Oxford Learning  Lab. Hello we completly...");
        gui_Text_Area_1_4.setUIID("SmallFontLabel");
                gui_Text_Area_1_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area_1_4.setName("Text_Area_1_4");
        gui_Text_Area_1_4.setColumns(100);
        gui_Text_Area_1_4.setRows(2);
        gui_Container_3_4.addComponent(gui_Label_3_4);
        gui_Container_3_4.addComponent(gui_Label_2_4);
        gui_Container_3_4.addComponent(gui_Text_Area_1_4);
        //addComponent(gui_Label_5);
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
