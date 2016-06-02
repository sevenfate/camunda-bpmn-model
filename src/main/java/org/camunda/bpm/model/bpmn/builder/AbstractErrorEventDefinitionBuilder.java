/*
 * Copyright 2016 camunda services GmbH.
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
package org.camunda.bpm.model.bpmn.builder;

import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.ErrorEventDefinition;
import org.camunda.bpm.model.bpmn.instance.Event;
import org.camunda.bpm.model.bpmn.instance.Definitions;
import org.camunda.bpm.model.bpmn.instance.Error;

/**
 *
 * @author Deivarayan Azhagappan
 */

public abstract class AbstractErrorEventDefinitionBuilder<B extends AbstractErrorEventDefinitionBuilder<B>> extends AbstractRootElementBuilder<B, ErrorEventDefinition>{

  public AbstractErrorEventDefinitionBuilder(BpmnModelInstance modelInstance, ErrorEventDefinition element, Class<?> selfType) {
    super(modelInstance, element, selfType);
  }

  @Override
  public B id(String identifier) {
    return super.id(identifier);
  }

  /**
   * Sets the error code variable attribute.
   */
  public B errorCodeVariable(String errorCodeVariable) {
    element.setCamundaErrorCodeVariable(errorCodeVariable);
    return myself;
  }

  /**
   * Sets the error message variable attribute.
   */
  public B errorMessageVariable(String errorMessageVariable) {
    element.setCamundaErrorMessageVariable(errorMessageVariable);
    return myself;
  }

  /**
   * Sets the error message variable attribute.
   */
  public B error(String errorCode, String errorMessage) {
    Definitions definitions = modelInstance.getDefinitions();
    Error error = createChild(definitions,Error.class);
    error.setErrorCode(errorCode);
    error.setErrorMessage(errorMessage);
    element.setError(error);
    return myself;
  }

  /**
   * Finishes the building of a error event definition.
   *
   * @param <T>
   * @return the parent event builder
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public <T extends AbstractFlowNodeBuilder> T errorEventDefinitionDone() {
    return (T) ((Event) element.getParentElement()).builder();
  }
}