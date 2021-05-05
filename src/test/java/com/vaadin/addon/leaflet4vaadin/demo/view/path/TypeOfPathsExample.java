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

package com.vaadin.addon.leaflet4vaadin.demo.view.path;

import static com.vaadin.addon.leaflet4vaadin.types.LatLng.latlng;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.demo.LeafletDemoApp;
import com.vaadin.addon.leaflet4vaadin.demo.components.ExampleContainer;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.vectors.Circle;
import com.vaadin.addon.leaflet4vaadin.layer.vectors.CircleMarker;
import com.vaadin.addon.leaflet4vaadin.layer.vectors.Path;
import com.vaadin.addon.leaflet4vaadin.layer.vectors.Polygon;
import com.vaadin.addon.leaflet4vaadin.layer.vectors.Polyline;
import com.vaadin.addon.leaflet4vaadin.layer.vectors.Rectangle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.function.Supplier;

@PageTitle("Type of paths")
@Route(value = "path/types", layout = LeafletDemoApp.class)
public class TypeOfPathsExample extends ExampleContainer {

  private Path currentPath;

  @Override
  protected void initDemo() {
    MapOptions options = new DefaultMapOptions();
    options.setCenter(latlng(47.070121823, 19.2041015625));
    options.setZoom(7);
    LeafletMap leafletMap = new LeafletMap(options);
    leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

    addToSidebar(createButton(Polyline.class, this::polyline, leafletMap));
    addToSidebar(createButton(Polygon.class, this::polygon, leafletMap));
    addToSidebar(createButton(Rectangle.class, this::rectangle, leafletMap));
    addToSidebar(createButton(Circle.class, this::circle, leafletMap));
    addToSidebar(createButton(CircleMarker.class, this::circleMarker, leafletMap));

    addToContent(leafletMap);
  }

  private <T extends Path> Button createButton(Class<T> type, Supplier<Path> suplier,
      LeafletMap leafletMap) {
    Button btn = new Button(type.getSimpleName());
    btn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    btn.addClickListener((event) -> {
      if (currentPath != null) {
        currentPath.remove();
      }
      currentPath = suplier.get();
      currentPath.bindTooltip("Hi, I'am a " + currentPath.getClass().getSimpleName());
      currentPath.addTo(leafletMap);
    });
    return btn;
  }

  public Polyline polyline() {
    return new Polyline(latlng(47.2, 18.3), latlng(47.3, 17.42));
  }

  public Polygon polygon() {
    Polygon polygon = new Polygon(latlng(47.0, 17.3), latlng(47.3, 18.42), latlng(47.3, 18.82),
        latlng(47.5, 17.82),
        latlng(47.0, 17.3));
    polygon.setFillColor("red");
    polygon.setColor("red");
    polygon.setWeight(1.5);
    return polygon;
  }

  public Rectangle rectangle() {
    Rectangle rectangle = new Rectangle(latlng(45.5, 18.3), latlng(46.3, 18.92));
    rectangle.setFillColor("green");
    rectangle.setColor("green");
    rectangle.setWeight(1);
    return rectangle;
  }

  public Circle circle() {
    Circle circle = new Circle(latlng(47.070121823, 19.2041015625), 100_000); // radius in meters
    circle.setFillColor("yellow");
    circle.setColor("yellow");
    circle.setDashArray("5, 10");
    return circle;
  }

  public CircleMarker circleMarker() {
    return new CircleMarker(latlng(47.070121823, 19.2041015625), 100); // radius in pixels
  }
}
