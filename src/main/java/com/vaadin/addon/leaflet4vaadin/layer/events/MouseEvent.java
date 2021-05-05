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

package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.layer.Layer;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.MouseEventType;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.addon.leaflet4vaadin.types.Point;

public class MouseEvent extends LeafletEvent {

  private static final long serialVersionUID = 833702270303187505L;
  private final Point containerPoint;
  private final Point layerPoint;
  private final LatLng latLng;

  public MouseEvent(Layer layer, MouseEventType eventType, LatLng latLng, Point layerPoint,
      Point containerPoint) {
    super(layer, eventType);
    this.latLng = latLng;
    this.layerPoint = layerPoint;
    this.containerPoint = containerPoint;
  }

  /**
   * The geographical point where the mouse event occured.
   *
   * @return the geographical point where the mouse event occured
   */
  public LatLng getLatLng() {
    return latLng;
  }

  /**
   * Pixel coordinates of the point where the mouse event occured relative to the map layer.
   *
   * @return the pixel coordinates relative to the map layer.
   */
  public Point getLayerPoint() {
    return layerPoint;
  }

  /**
   * Pixel coordinates of the point where the mouse event occured relative to the map сontainer.
   *
   * @return the pixel coordinates relative to the map сontainer.
   */
  public Point getContainerPoint() {
    return containerPoint;
  }

  @Override
  public String toString() {
    return "MouseEvent [type=" + super.getType() + ", containerPoint=" + containerPoint
        + ", latLng=" + latLng
        + ", layerPoint=" + layerPoint + "]";
  }

}
