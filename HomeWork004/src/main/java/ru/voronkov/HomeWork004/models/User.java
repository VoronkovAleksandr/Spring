package ru.voronkov.HomeWork004.models;

import lombok.Data;

// Lombok @Data дает геттеры для всех полей, сеттеры для всех нефинальных полей,
// правильные реализации toString, equals и hashCode, охватывающие все поля класса,
// а также конструктор для всех финальных полей
@Data
public class User {
    private int id;

    private String firstName;

    private String lastName;

}
