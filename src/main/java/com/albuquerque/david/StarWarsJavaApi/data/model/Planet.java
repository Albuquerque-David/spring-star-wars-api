package com.albuquerque.david.StarWarsJavaApi.data.model;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "planets")
public class Planet {

    @MongoId(FieldType.IMPLICIT)
    @NonNull
    private String id;

    @Field
    @NonNull
    private String name;

    @Field
    @NonNull
    private String climate;

    @Field
    @NonNull
    private String terrain;

    @ApiModelProperty(hidden = true)
    @Nullable
    private List<String> films;

    public Planet(@NonNull String id, @NonNull String name, @NonNull String climate, @NonNull String terrain) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.films = new ArrayList<>();
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
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

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
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

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", climate='" + climate + '\'' +
                ", terrain='" + terrain + '\'' +
                ", films='" + films + '\'' +
                '}';
    }
}
