package com.autowave.controller.impl;

import com.autowave.base.controller.impl.AbstractCrudController;
import com.autowave.controller.IUserController;
import com.autowave.dto.list.UserListDTO;
import com.autowave.dto.request.UserRequestDTO;
import com.autowave.dto.response.UserResponseDTO;
import com.autowave.entities.User;
import com.autowave.mapper.UserMapper;
import com.autowave.service.impl.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/user")
public class UserController extends AbstractCrudController<UserRequestDTO, UserResponseDTO, UserListDTO, User, UserService, UserMapper, Long>
        implements IUserController {
}
