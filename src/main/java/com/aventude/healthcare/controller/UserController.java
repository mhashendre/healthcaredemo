package com.aventude.healthcare.controller;

import com.aventude.healthcare.constants.HttpConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.aventude.healthcare.constants.UtilConstants.BASE_API_USER;

@RestController
@RequestMapping(value = BASE_API_USER, produces = HttpConstants.APPLICATION_JSON)
public class UserController {
}
