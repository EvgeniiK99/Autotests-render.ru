package apiTests.models;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class LoginBodyModel {
    String login, password;
}
