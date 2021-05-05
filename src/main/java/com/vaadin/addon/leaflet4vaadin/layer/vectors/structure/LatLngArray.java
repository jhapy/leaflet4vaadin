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

package com.vaadin.addon.leaflet4vaadin.layer.vectors.structure;

import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.addon.leaflet4vaadin.types.LatLngBounds;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents list of LatLng coordinates
 *
 * @author <strong>Gabor Kokeny</strong> Email:
 * <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @version 1.0
 * @since 2020-03-23
 */
public class LatLngArray extends ArrayList<LatLng> implements GeometryStructure {

  private static final long serialVersionUID = -909287963967251959L;

  public LatLngArray(LatLng[] latlngs) {
    this(Arrays.asList(latlngs));
  }

  public LatLngArray(List<LatLng> latlngs) {
    addAll(latlngs);
  }

  @Override
  public LatLngBounds getBounds() {
    LatLngBounds bounds = new LatLngBounds(get(0));
    forEach((latlng) -> bounds.extend(latlng));
    return bounds;
  }

}
