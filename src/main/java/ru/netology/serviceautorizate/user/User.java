package ru.netology.serviceautorizate.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Size(min = 2, max = 25)
    private String user;
    @Size(min = 2, max = 100)
    private String password;

}
