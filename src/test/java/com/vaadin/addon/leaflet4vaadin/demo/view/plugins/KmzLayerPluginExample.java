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

package com.vaadin.addon.leaflet4vaadin.demo.view.plugins;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.controls.LayersControl;
import com.vaadin.addon.leaflet4vaadin.demo.LeafletDemoApp;
import com.vaadin.addon.leaflet4vaadin.demo.components.ExampleContainer;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.plugins.kmz.KmzLayer;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("KMZ example")
@Route(value = "plugins/kmz", layout = LeafletDemoApp.class)
public class KmzLayerPluginExample extends ExampleContainer {

  @Override
  protected void initDemo() {
    MapOptions options = new DefaultMapOptions();
    options.setCenter(new LatLng(47.070121823, 19.204101562500004));
    options.setPreferCanvas(true);
    options.setZoom(4);

    LeafletMap leafletMap = new LeafletMap(options);
    leafletMap.setBaseUrl("https://{s}.tile.opentopomap.org/{z}/{x}/{y}.png");

    LayersControl layersControl = new LayersControl();
    layersControl.addTo(leafletMap);

    KmzLayer kmz = new KmzLayer("kmz/capitals.kmz");
    kmz.onLoad((event) -> {
      layersControl.addOverlay(event.getTarget(), "Capitals");
    });
    kmz.addTo(leafletMap);

    addToContent(leafletMap);

    Anchor pluginRepository = new Anchor();
    pluginRepository.setHref("https://github.com/Raruto/leaflet-kmz");
    pluginRepository.setText("leaflet-kmz plugin: https://github.com/Raruto/leaflet-kmz");
    pluginRepository.setTarget("_blank");
    addToContent(pluginRepository);
  }

}
