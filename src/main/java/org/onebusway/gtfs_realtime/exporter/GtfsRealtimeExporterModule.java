/**
 * Copyright (C) 2012 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusway.gtfs_realtime.exporter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class GtfsRealtimeExporterModule extends AbstractModule {

  public static final String NAME_EXECUTOR = "org.onebusway.gtfs_realtime.exporter.GtfsRealtimeExporterModule.executor";

  @Override
  protected void configure() {
    bind(AlertsFileWriter.class);
    bind(TripUpdatesFileWriter.class);
    bind(VehiclePositionsFileWriter.class);
    bind(AlertsServlet.class);
    bind(TripUpdatesServlet.class);
    bind(VehiclePositionsServlet.class);
    bind(ScheduledExecutorService.class).annotatedWith(
        Names.named(NAME_EXECUTOR)).toInstance(
        Executors.newSingleThreadScheduledExecutor());
  }
}
