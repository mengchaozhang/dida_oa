package com.qf.congifuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.qf.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfiguration {
    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher getCredentialMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        return hashedCredentialsMatcher;
    }

    @Bean(name = "myRealm")
    public MyRealm getRealm(HashedCredentialsMatcher credentialsMatcher) {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(credentialsMatcher);
        return myRealm;
    }

    @Bean(name = "securityManager")
    public SecurityManager getSecurityManager(MyRealm myRealm) {
        return new DefaultWebSecurityManager(myRealm);
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
        HashMap<String, String> map = new HashMap<>();
        map.put("/login", "anon");
        map.put("/goLogin", "anon");
        map.put("/**", "authc");
        map.put("/logout.action", "logout");
        map.put("/css/**", "anon");
        map.put("/fonts/**", "anon");
        map.put("/img/**", "anon");
        map.put("/js/**", "anon");
        map.put("/vendor/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "shiroDialect")
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
