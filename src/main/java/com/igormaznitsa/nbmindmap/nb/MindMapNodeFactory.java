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
package com.igormaznitsa.nbmindmap.nb;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.Node;

@NodeFactory.Registration(projectType = {
  "org-netbeans-modules-ant-freeform",
  "org-netbeans-modules-apisupport-project",
  "org-netbeans-modules-apisupport-project-suite",
  "org-netbeans-modules-apisupport-project-suite-jnlp",
  "org-netbeans-modules-apisupport-project-suite-osgi",
  "org-netbeans-modules-apisupport-project-suite-package",
  "org-netbeans-modules-autoproject",
  "org-netbeans-modules-bpel-project",
  "org-netbeans-modules-java-j2seproject",
  "org-netbeans-modules-j2ee-clientproject",
  "org-netbeans-modules-j2ee-earproject",
  "org-netbeans-modules-j2ee-ejbjarproject",
  "org-netbeans-modules-java-j2seproject",
  "org-netbeans-modules-javacard-project",
  "org-netbeans-modules-javaee-project",
  "org-netbeans-modules-javafx2-project",
  "org-netbeans-modules-maven",
  "org-netbeans-modules-php-project",
  "org-netbeans-modules-ruby-project",
  "org-netbeans-modules-sql-project",
  "org-netbeans-modules-web-project",
  "org-netbeans-modules-xslt-project",
  "org-netbeans-modules-groovy-grailsproject",
  "org-netbeans-modules-gradle-project",
  "org-netbeans-modules-scala-project"
},position = 10000)
public class MindMapNodeFactory implements NodeFactory, FilenameFilter {

  private static final String LCASED_EXTENSION = '.'+MMDDataObject.MMD_EXT.toLowerCase(Locale.ENGLISH);
  
  @Override
  public NodeList<?> createNodes(final Project p) {
    final File dir = FileUtil.toFile(p.getProjectDirectory());
    final File[] listFiles = dir.listFiles(this);
    if (listFiles == null || listFiles.length == 0) {
      return NodeFactorySupport.fixedNodeList();
    }
    final List<Node> foundNodes = new ArrayList<Node>(listFiles.length);
    for (final File f : listFiles) {
      final FileObject fileObject = FileUtil.toFileObject(FileUtil.normalizeFile(f));

      final DataObject dataObject;
      try {
        dataObject = DataObject.find(fileObject);
      }
      catch (DataObjectNotFoundException ex) {
        continue;
      }
      final Node cloned = dataObject.getNodeDelegate().cloneNode();
      if (cloned != null) {
        foundNodes.add(cloned);
      }
    }

    return NodeFactorySupport.fixedNodeList(foundNodes.toArray(new Node[foundNodes.size()]));
  }

  @Override
  public boolean accept(final File dir, final String name) {
    return name.toLowerCase(Locale.ENGLISH).endsWith(LCASED_EXTENSION);
  }

}
