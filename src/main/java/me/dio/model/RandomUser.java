package me.dio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RandomUser {

    private String gender;
    public Name name;
    private Location location;
    private String email;
    private Login login;
    private Dob dob;
    private Registered registered;
    private String phone;
    private String cell;
    private ID id;
    private Picture picture;
    private String nat;

}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Street {
    private int number;
    private String name;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Coordinates {
    private String latitude;
    private String longitude;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Timezone {
    private String offset;
    private String description;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Login {
    private String uuid;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Registered {
    private String date;
    private int age;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class ID {
    private String name;
    private String value;
}

