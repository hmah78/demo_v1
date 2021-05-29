package com.example.demo.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "dashController")
@ELBeanName(value = "dashController")
@Join(path = "/", to = "/User-Dashboard.jsf")
public class Dashboard {

}
