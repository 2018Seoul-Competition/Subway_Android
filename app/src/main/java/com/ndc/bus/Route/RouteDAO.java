package com.ndc.bus.Route;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface RouteDAO {
    @Query("SELECT routeNm FROM Route WHERE routeId IN (:routeId)")
    String getRouteNm(String routeId);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllRoutes(Route... routes);
    @Delete
    void deleteRoute(Route route);
}