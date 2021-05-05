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

package com.vaadin.addon.leaflet4vaadin.layer.groups;

import com.vaadin.addon.leaflet4vaadin.layer.map.functions.ExecutableFunctions;
import org.geojson.GeoJsonObject;

/**
 * GeoJSON methods
 *
 * @author <strong>Gabor Kokeny</strong> Email:
 * <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @version 1.0
 * @since 2020-03-22
 */
public interface GeoJSONFunctions extends ExecutableFunctions {

  /**
   * Adds a GeoJSON object to the layer.
   *
   * @param geoJsonObject the geojson object
   * @return the current GeoJSON layer
   */
  GeoJSON addData(GeoJsonObject geoJsonObject);

  /**
   * Resets the style of all features in the current layer is reset.
   */
  default void resetStyle() {
    executeJs("resetStyle");
  }

}
