/*
 * Copyright 2015 Igor Maznitsa.
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
package com.igormaznitsa.nbmindmap.nb.swing;

import com.igormaznitsa.mindmap.model.logger.Logger;
import com.igormaznitsa.mindmap.model.logger.LoggerFactory;
import com.igormaznitsa.sciareto.ui.JHtmlLabel;
import java.net.URI;
import java.util.Properties;
import com.igormaznitsa.mindmap.plugins.api.MindMapPlugin;
import com.igormaznitsa.sciareto.ui.UiUtils;

public final class AboutPanel extends javax.swing.JPanel implements JHtmlLabel.LinkListener {

  private static final long serialVersionUID = -3231534203788095969L;

  private static final Logger LOGGER = LoggerFactory.getLogger(AboutPanel.class);
  
  public AboutPanel() {
    initComponents();

    final String version = MindMapPlugin.API.toString();

    final Properties props = new Properties();
    props.setProperty("version", version);
    this.textLabel.replaceMacroses(props);
    this.textLabel.addLinkListener(this);
    this.textLabel.setShowLinkAddressInTooltip(true);
  }

  @Override
  public void onLinkActivated(final JHtmlLabel source, final String href) {
    try{
      UiUtils.browseURI(new URI(href), false);
    }catch(Exception ex){
      LOGGER.error("Can't process link in 'About'", ex);
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    labelIcon = new javax.swing.JLabel();
    textLabel = new com.igormaznitsa.sciareto.ui.JHtmlLabel();

    labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/igormaznitsa/nbmindmap/icons/logo/logo.png"))); // NOI18N

    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/igormaznitsa/nbmindmap/i18n/Bundle"); // NOI18N
    textLabel.setText(bundle.getString("AboutText")); // NOI18N
    textLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    textLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelIcon)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(textLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(labelIcon)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel labelIcon;
  private com.igormaznitsa.sciareto.ui.JHtmlLabel textLabel;
  // End of variables declaration//GEN-END:variables
}
