// Copyright 2020 Gabor Kokeny and contributors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.vaadin.addon.leaflet4vaadin.layer.map.functions;

import com.vaadin.addon.leaflet4vaadin.layer.Identifiable;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public interface ExecutableFunctions extends Identifiable {

  default void executeJs(String functionName, Serializable... arguments) {
    executeJs(this, functionName, arguments);
  }

  void executeJs(Identifiable target, String functionName, Serializable... arguments);

  default <T extends Serializable> CompletableFuture<T> call(String functionName,
      Class<T> resultType,
      Serializable... arguments) {
    return call(this, functionName, resultType, arguments);
  }

  <T extends Serializable> CompletableFuture<T> call(Identifiable target, String functionName,
      Class<T> resultType,
      Serializable... arguments);

}