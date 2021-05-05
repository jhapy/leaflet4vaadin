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

package com.vaadin.addon.leaflet4vaadin.demo.view.map;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.demo.LeafletDemoApp;
import com.vaadin.addon.leaflet4vaadin.demo.components.ExampleContainer;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.options.ZoomOptions;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Map functions")
@Route(value = "map/functions", layout = LeafletDemoApp.class)
public class MapFunctionsExample extends ExampleContainer {

  @Override
  protected void initDemo() {

    Label eventLabel = new Label("Click on map to fly to a coordinate or right-click to fit World");
    eventLabel.getStyle().set("font-weight", "bold");

    final MapOptions options = new DefaultMapOptions();
    options.setCenter(new LatLng(47.070121823, 19.204101562500004));
    options.setZoom(7);
    final LeafletMap leafletMap = new LeafletMap(options);
    leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

    leafletMap.onClick((event) -> {
      leafletMap.flyTo(event.getLatLng(), options.getZoom(), new ZoomOptions());
    });
    leafletMap.onContextMenuOpened((event) -> {
      leafletMap.fitWorld();
    });

    addToContent(eventLabel, leafletMap);
  }

}
