package com.albuquerque.david.StarWarsJavaApi.data.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "planets")
public class Planet {

    @MongoId
    @NonNull
    private Long id;

    @Field
    @NonNull
    private String name;

    @Field
    @NonNull
    private String climate;

    @Field
    @NonNull
    private String terrain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getClimate() {
        return climate;
    }

    public void setClimate(@NonNull String climate) {
        this.climate = climate;
    }

    @NonNull
    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(@NonNull String terrain) {
        this.terrain = terrain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planet planet = (Planet) o;

        return id.equals(planet.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
