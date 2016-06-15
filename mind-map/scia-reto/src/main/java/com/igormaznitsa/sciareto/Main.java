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
package com.igormaznitsa.sciareto;

import com.igormaznitsa.sciareto.ui.MainFrame;
import javax.annotation.Nonnull;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import com.igormaznitsa.meta.annotation.MustNotContainNull;
import com.igormaznitsa.mindmap.plugins.MindMapPluginRegistry;
import com.igormaznitsa.sciareto.plugins.PrinterPlugin;

public class Main {

  private static MainFrame MAIN_FRAME;

  @Nonnull
  public static MainFrame getApplicationFrame(){
    return MAIN_FRAME;
  }
  
  public static void main(@Nonnull @MustNotContainNull final String ... args){
    try {
      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("nimbus".equalsIgnoreCase(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("Can't use NIMBUS");
    }

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        MindMapPluginRegistry.getInstance().registerPlugin(new PrinterPlugin());
        MAIN_FRAME = new MainFrame();
        MAIN_FRAME.pack();
        MAIN_FRAME.setVisible(true);
      }
    });
  }
}
