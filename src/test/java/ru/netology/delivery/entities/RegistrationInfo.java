package ru.netology.delivery.entities;

import lombok.Value;

// Data - класс - содержит поля и простейшие методы для доступа к полям
// Это просто контейнеры для данных, используемых другими классами
// entities.Registration - информация для регистрации
@Value
public class RegistrationInfo {
    public final String city;
    public final String name;
    public final String phone;

}


