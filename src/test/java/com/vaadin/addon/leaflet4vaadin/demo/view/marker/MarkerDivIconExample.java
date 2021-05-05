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

package com.vaadin.addon.leaflet4vaadin.demo.view.marker;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.demo.LeafletDemoApp;
import com.vaadin.addon.leaflet4vaadin.demo.components.ExampleContainer;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.ui.marker.Marker;
import com.vaadin.addon.leaflet4vaadin.types.DivIcon;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("DivIcon example")
@Route(value = "marker/divicon", layout = LeafletDemoApp.class)
public class MarkerDivIconExample extends ExampleContainer {

  @Override
  protected void initDemo() {

    MapOptions options = new DefaultMapOptions();
    options.setCenter(new LatLng(47.070121823, 19.2041015625));
    options.setZoom(7);
    LeafletMap leafletMap = new LeafletMap(options);
    leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

    Marker marker = new Marker(options.getCenter());
    marker.setIcon(new DivIcon());
    marker.setDraggable(true);
    marker.bindPopup("Hey, I'm a DivIcon, drag me if you want");
    marker.onClick((e) -> {
      Notification.show("You click the marker.", 3000, Position.TOP_CENTER);
    });

    marker.addTo(leafletMap);

    addToContent(leafletMap);
  }
}
