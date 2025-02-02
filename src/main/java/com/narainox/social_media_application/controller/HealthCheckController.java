package com.narainox.social_media_application.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/healthCheck")
public class HealthCheckController {

    private MessageSource messageSource;

    public HealthCheckController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/welcome")
    public String welcome(@PathVariable String name)
    {
        return "Welcome "+name;
    }

    @GetMapping("/good-morning")
    public String goodMorning()
    {
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }
}
