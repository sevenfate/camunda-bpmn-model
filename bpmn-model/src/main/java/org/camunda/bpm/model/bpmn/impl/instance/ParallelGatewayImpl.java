/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.model.bpmn.impl.instance;

import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.builder.AbstractBaseElementBuilder;
import org.camunda.bpm.model.bpmn.builder.AbstractFlowNodeBuilder;
import org.camunda.bpm.model.bpmn.builder.ParallelGatewayBuilder;
import org.camunda.bpm.model.bpmn.instance.Gateway;
import org.camunda.bpm.model.bpmn.instance.ParallelGateway;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;

import static org.camunda.bpm.model.bpmn.impl.BpmnModelConstants.BPMN20_NS;
import static org.camunda.bpm.model.bpmn.impl.BpmnModelConstants.BPMN_ELEMENT_PARALLEL_GATEWAY;
import static org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN parallelGateway element
 *
 * @author Sebastian Menski
 */
public class ParallelGatewayImpl extends GatewayImpl implements ParallelGateway {

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(ParallelGateway.class, BPMN_ELEMENT_PARALLEL_GATEWAY)
      .namespaceUri(BPMN20_NS)
      .extendsType(Gateway.class)
      .instanceProvider(new ModelTypeInstanceProvider<ParallelGateway>() {
        public ParallelGateway newInstance(ModelTypeInstanceContext instanceContext) {
          return new ParallelGatewayImpl(instanceContext);
        }
      });

    typeBuilder.build();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends AbstractBaseElementBuilder> T builder() {
    return (T) new ParallelGatewayBuilder((BpmnModelInstance) modelInstance, this);
  }

  public ParallelGatewayImpl(ModelTypeInstanceContext context) {
    super(context);
  }

}