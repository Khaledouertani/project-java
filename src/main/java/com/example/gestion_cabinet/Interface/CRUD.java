package com.example.gestion_cabinet.Interface;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CRUD<T> {
    void add(T t ) throws SQLException;
    ArrayList<T> getAll() throws SQLException;
    void update (T t) throws SQLException;
    void delete (String t) throws SQLException;
}