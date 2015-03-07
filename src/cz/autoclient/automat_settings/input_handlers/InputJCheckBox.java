/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.autoclient.automat_settings.input_handlers;

import cz.autoclient.automat_settings.Input;
import cz.autoclient.automat_settings.SettingsInputVerifier;
import cz.autoclient.automat_settings.ValueChanged;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

/**
 *
 * @author Jakub
 */
public class InputJCheckBox implements Input {
  private final JCheckBox field;
  private final ValueChanged onchange;
  private SettingsInputVerifier<Object> verifier;
  

  //Indicate whether events have been bound to input
  private boolean bound = false;
  public InputJCheckBox(JCheckBox input, ValueChanged onchange, SettingsInputVerifier<Object> subverifier) {
    field = input;
    this.onchange = onchange;
    verifier = subverifier;
  }
  /**
   * Binds the events to the field using InputVerifier
   */
  @Override
  public void bind() {
    bound = true;
    //Internal verifier
    final SettingsInputVerifier<Object> verif = this.verifier;
    //Event to be called if new value is valid
    final ValueChanged onchange = this.onchange;
    //Only works when you leave the field
    /*field.setInputVerifier(new InputVerifier() {
      @Override
      public boolean verify(JComponent in) {
        if(verif==null) {
          onchange.changed((Boolean)((JCheckBox)in).isSelected());
          return true;
        }
        //If verification fails, return false and ignore the value
        if(!verif.verify(in))
          return false;
        //Sucessful verification means we get the value and update it
        onchange.changed(verif.value(in));
        return true;
      }
    });*/
    final JCheckBox in = field;
    field.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
        if(verif==null) {
          onchange.changed((Boolean)field.isSelected());
          return;
        }
        //If verification fails, return false and ignore the value
        if(!verif.verify(in))
          return;
        //Sucessful verification means we get the value and update it
        onchange.changed(verif.value(in));
      }
    });
  }
  @Override
  public JComponent getField() {
    return field;
  }

  @Override
  public Object getValue() {
    if(verifier==null)
      return field.isSelected();
    else if(validate())
      return verifier.value(field);
    else
      return null;
  }
  @Override
  public void setValue(Object value) {
    if(value instanceof Boolean) 
      field.setSelected((Boolean) value);
    else
      field.setSelected(value!=null);
  }

  @Override
  public boolean validate() {
    return verifier!=null?verifier.verify(field):true;
  }

  @Override
  public SettingsInputVerifier<Object> getVerifier() {
    return verifier;
  }
  /**
   * Change the internal verifier.
   */
  @Override
  public void setVerifier(SettingsInputVerifier<Object> ver) {
    verifier = ver;
    if(bound) {
      //Re-bind the event listener
      bind();
    }
  }
  
  
  @Override
  public void unbind() {
    bound = false;
    field.setInputVerifier(null);
  }


  
}