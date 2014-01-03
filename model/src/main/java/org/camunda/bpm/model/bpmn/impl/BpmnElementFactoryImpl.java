/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.camunda.bpm.model.bpmn.impl;

import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnElementFactory;
import org.camunda.bpm.model.bpmn.Definitions;
import org.camunda.bpm.model.bpmn.Import;
import org.camunda.bpm.model.xml.impl.core.XmlDocument;

/**
 * <p>Implementation of the Bpmn Element Factory</p>
 *
 * @author Daniel Meyer
 *
 */
public class BpmnElementFactoryImpl implements BpmnElementFactory {

  protected final XmlDocument xmlDocument;

  public BpmnElementFactoryImpl(XmlDocument xmlDocument) {
    this.xmlDocument = xmlDocument;
  }

  public Definitions newDefinitionsElement() {
    return crateModelElementInstance(DefinitionsImpl.ELEMENT_NAME);
  }

  public Import newImportElement() {
    return crateModelElementInstance(ImportImpl.ELEMENT_NAME);
  }

  @SuppressWarnings("unchecked")
  private <T> T crateModelElementInstance(String modelElementName) {
    return (T) xmlDocument.XML_createElement(modelElementName, Bpmn.INSTANCE.getModelPackage().getType(modelElementName));
  }

}
