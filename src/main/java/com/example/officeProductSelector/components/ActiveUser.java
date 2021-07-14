package com.example.officeProductSelector.components;

import com.example.officeProductSelector.model.User;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Data
public class ActiveUser {



    User user;

    boolean isActive;
}
