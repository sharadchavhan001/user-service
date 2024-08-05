package com.app.product_service.mapper;

import com.app.product_service.model.User;
import java.util.List;

public interface UserMapper {
    com.app.product_service.generated.model.User toGeneratedUser(User user);

    List<com.app.product_service.generated.model.User> toGeneratedUserList(List<User> users);

    User generatedUserToUser(com.app.product_service.generated.model.User user);
}
