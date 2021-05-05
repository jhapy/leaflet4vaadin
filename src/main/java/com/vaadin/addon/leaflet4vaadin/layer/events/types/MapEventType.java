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

package com.vaadin.addon.leaflet4vaadin.layer.events.types;

public enum MapEventType implements LeafletEventType {

  /**
   * Fired when the number of zoomlevels on the map is changed due to adding or removing a layer.
   */
  zoomlevelschange,

  /**
   * Fired when the map is resized.
   */
  resize,

  /**
   * Fired when the map is destroyed with remove method.
   */
  unload,

  /**
   * Fired when the map needs to redraw its content (this usually happens on map zoom or load). Very
   * useful for creating custom overlays.
   */
  viewreset,

  /**
   * Fired when the map is initialized (when its center and zoom are set for the first time).
   */
  load,

  /**
   * Fired when the map zoom is about to change (e.g. before zoom animation).
   */
  zoomstart,

  /**
   * Fired when the view of the map starts changing (e.g. user starts dragging the map).
   */
  movestart,

  /**
   * Fired repeatedly during any change in zoom level, including zoom and fly animations.
   */
  zoom,

  /**
   * Fired at least once per zoom animation. For continuous zoom, like pinch zooming, fired once per
   * frame during zoom.
   */
  zoomanim,

  /**
   * Fired repeatedly during any movement of the map, including pan and fly animations.
   */
  move,

  /**
   * Fired when the map has changed, after any animations.
   */
  zoomend,

  /**
   * Fired when the center of the map stops changing (e.g. user stopped dragging the map).
   */
  moveend;

  @Override
  public String getLeafletEvent() {
    return name();
  }

}
