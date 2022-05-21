package com.android.gymtogether.tool;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JSONMapper <T> {

    public String convertToJSON(T object){
        if(object == null){
            throw new NullPointerException("Object is null, cannot convert to JSON");
        }
        return  new Gson().toJson(object);
    }

    public T convertFromJSON(String object, Class<T> tClass){

        if(object == null){
            throw new NullPointerException("Object is null, cannot convert from JSON");
        }
        return new Gson().fromJson(object, (Type) tClass);
    }
}
