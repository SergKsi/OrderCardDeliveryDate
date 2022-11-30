package entities;

import lombok.Data;
// Data - класс - содержит поля и простейшие методы для доступа к полям
// Это просто контейнеры для данных, используемых другими классами
// entities.Registration - информация для регистрации
@Data
public class RegistrationInfo {
    public final String city;
    public final String name;
    public final String phone;

//    public RegistrationInfo(String city, String name, String phone) {
//        this.city = city;
//        this.name = name;
//        this.phone = phone;
//    }
//
//    public RegistrationInfo() {
//    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}


