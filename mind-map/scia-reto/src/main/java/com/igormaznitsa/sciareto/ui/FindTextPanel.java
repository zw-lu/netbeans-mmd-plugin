/*
 * Copyright 2016 Igor Maznitsa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igormaznitsa.sciareto.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FocusTraversalPolicy;
import java.awt.event.KeyEvent;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.igormaznitsa.sciareto.Context;

public class FindTextPanel extends javax.swing.JPanel {

  private static final long serialVersionUID = -2286996344502363552L;

  private final Context context;
  
  private static final int TEXT_FIELD_WIDTH = 300;
  
  public FindTextPanel(@Nonnull final Context context, @Nullable final String text) {
    initComponents();
    
    this.textFieldSearchText.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, this.textFieldSearchText.getPreferredSize().height));
    this.textFieldSearchText.setMinimumSize(new Dimension(TEXT_FIELD_WIDTH, this.textFieldSearchText.getMinimumSize().height));
    this.textFieldSearchText.setMaximumSize(new Dimension(TEXT_FIELD_WIDTH, this.textFieldSearchText.getMaximumSize().height));
    
    this.context = context;

    this.textFieldSearchText.setText(text == null ? "": text);
  
    this.textFieldSearchText.setFocusTraversalPolicy(new FocusTraversalPolicy() {
      @Override
      @Nonnull
      public Component getComponentAfter(@Nonnull final Container aContainer, @Nonnull final Component aComponent) {
        return textFieldSearchText;
      }

      @Override
      @Nonnull
      public Component getComponentBefore(@Nonnull final Container aContainer, @Nonnull final Component aComponent) {
        return textFieldSearchText;
      }

      @Override
      @Nonnull
      public Component getFirstComponent(@Nonnull final Container aContainer) {
        return textFieldSearchText;
      }

      @Override
      @Nonnull
      public Component getLastComponent(@Nonnull final Container aContainer) {
        return textFieldSearchText;
      }

      @Override
      @Nonnull
      public Component getDefaultComponent(@Nonnull final Container aContainer) {
        return textFieldSearchText;
      }
    });
  }
  
  @Override
  public void requestFocus(){
    this.textFieldSearchText.requestFocus();
  }
  
  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form
   * Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    labelTitle = new javax.swing.JLabel();
    textFieldSearchText = new javax.swing.JTextField();
    buttonPrev = new javax.swing.JButton();
    buttonNext = new javax.swing.JButton();
    labelClose = new javax.swing.JLabel();
    filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

    setLayout(new java.awt.GridBagLayout());

    labelTitle.setText("Find:");
    labelTitle.setFocusable(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 10.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 8);
    add(labelTitle, gridBagConstraints);

    textFieldSearchText.setFocusTraversalPolicyProvider(true);
    textFieldSearchText.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        textFieldSearchTextKeyPressed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
    add(textFieldSearchText, gridBagConstraints);

    buttonPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/resultset_previous.png"))); // NOI18N
    buttonPrev.setFocusable(false);
    buttonPrev.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonPrevActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 10.0;
    add(buttonPrev, gridBagConstraints);

    buttonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/resultset_next.png"))); // NOI18N
    buttonNext.setFocusable(false);
    buttonNext.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonNextActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 10.0;
    add(buttonNext, gridBagConstraints);

    labelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    labelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/nimbusCloseFrame.png"))); // NOI18N
    labelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    labelClose.setFocusable(false);
    labelClose.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        labelCloseMouseClicked(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
    add(labelClose, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 100000.0;
    add(filler1, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void textFieldSearchTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldSearchTextKeyPressed
    switch(evt.getKeyCode()){
      case KeyEvent.VK_ESCAPE : {
        this.context.hideFindTextPane();
        evt.consume();
      }break;
      case KeyEvent.VK_ENTER : {
        if (evt.isShiftDown()){
          findPrev();
        }else{
          findNext();
        }
        evt.consume();
      }break;
    }
  }//GEN-LAST:event_textFieldSearchTextKeyPressed

  private void findNext(){
    final String text = this.textFieldSearchText.getText();
    if (!text.isEmpty()){
      this.context.getFocusedTab().getProvider().findNext(text);
    }
  }
  
  private void findPrev(){
    final String text = this.textFieldSearchText.getText();
    if (!text.isEmpty()) {
      this.context.getFocusedTab().getProvider().findPrev(text);
    }
  }
  
  private void labelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCloseMouseClicked
    this.context.hideFindTextPane();
  }//GEN-LAST:event_labelCloseMouseClicked

  private void buttonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrevActionPerformed
    findPrev();
  }//GEN-LAST:event_buttonPrevActionPerformed

  private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
    findNext();
  }//GEN-LAST:event_buttonNextActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonNext;
  private javax.swing.JButton buttonPrev;
  private javax.swing.Box.Filler filler1;
  private javax.swing.JLabel labelClose;
  private javax.swing.JLabel labelTitle;
  private javax.swing.JTextField textFieldSearchText;
  // End of variables declaration//GEN-END:variables
}