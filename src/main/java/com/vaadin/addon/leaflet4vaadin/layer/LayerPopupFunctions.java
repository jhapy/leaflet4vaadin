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

package com.vaadin.addon.leaflet4vaadin.layer;

import com.vaadin.addon.leaflet4vaadin.layer.map.functions.ExecutableFunctions;
import com.vaadin.addon.leaflet4vaadin.layer.ui.popup.Popup;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import java.util.concurrent.CompletableFuture;

/**
 * A set of popup methods
 *
 * @author <strong>Gabor Kokeny</strong> Email:
 * <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @version 1.0
 * @since 2020-03-23
 */
public interface LayerPopupFunctions extends ExecutableFunctions {

  /**
   * Binds a popup to the layer with the passed content
   *
   * @param popupContent the new popup content
   */
  default void bindPopup(String popupContent) {
    executeJs("bindPopup", popupContent);
  }

  /**
   * Binds a popup to the layer with the passed content
   *
   * @param popup the new popup content
   */
  default void bindPopup(Popup popup) {
    executeJs("bindPopup", popup);
  }

  /**
   * Removes the popup previously bound with bindPopup.
   */
  default void unbindPopup() {
    executeJs("unbindPopup");
  }

  /**
   * Closes the popup bound to this layer if it is open.
   */
  default void closePopup() {
    executeJs("closePopup");
  }

  /**
   * Opens the bound popup
   */
  default void openPopup() {
    executeJs("closePopup");
  }

  /**
   * Opens the bound popup at the specified latlng or at the default popup anchor if no latlng is
   * passed.
   *
   * @param latLng the popup location
   */
  default void openPopup(LatLng latLng) {
    executeJs("closePopup", latLng);
  }

  /**
   * Opens or closes the popup bound to this layer depending on its current state.
   */
  default void togglePopup() {
    executeJs("togglePopup");
  }

  /**
   * Sets the content of the popup bound to this layer.
   *
   * @param popupContent the new popup content
   */
  default void setPopupContent(String popupContent) {
    executeJs("setPopupContent", popupContent);
  }

  /**
   * Sets the content of the popup bound to this layer.
   *
   * @param popup the new popup content
   */
  default void setPopupContent(Popup popup) {
    executeJs("setPopupContent", popup);
  }

  /**
   * Returns true if the popup bound to this layer is currently open.
   *
   * @return returns true if the is currently open
   */
  default CompletableFuture<Boolean> isPopupOpen() {
    return call("isPopupOpen", Boolean.class);
  }

  /**
   * Returns the popup bound to this layer.
   *
   * @return the popup bound to this layer.
   */
  Popup getPopup();

}
