package com.fms.view;

import com.fms.model.service.UserService;
import com.fms.model.users.Tenants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tyler on 4/4/16.
 */
public class UserTenantAdd {
    public static void main (String args[]) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
        System.out.println("*#*#*#*#*#*#*# CONTEXT CREATED #*#*#*#*#*#*#*");
        UserService userService = (UserService) context.getBean("userService");

        System.out.println("*#*#*#*#*#*#*# CREATING TENANT #*#*#*#*#*#*#*");
        Tenants tenant = (Tenants) context.getBean("tenants");
        tenant.setFirstName("Tom");
        tenant.setLastName("Brown");
        tenant.setPrimary(true);
        tenant.setTenID(1);

        userService.addTenant(tenant);
    }
}
