package com.Lab.RegistrationManager.controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMsg = "An error occurred";

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            errorMsg = "Error " + statusCode;
        }

        model.addAttribute("errorMessage", errorMsg);
        return "error";
    }
}