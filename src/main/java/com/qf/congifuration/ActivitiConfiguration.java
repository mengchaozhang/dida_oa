package com.qf.congifuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfiguration {


//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private PlatformTransactionManager platformTransactionManager;
//
//    @Bean
//    public SpringProcessEngineConfiguration springProcessEngineConfiguration() {
//        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
//        springProcessEngineConfiguration.setDataSource(dataSource);
//        springProcessEngineConfiguration.setTransactionManager(platformTransactionManager);
//        springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
//        Resource[] resources = new Resource[0];
//        try {
//            resources = new PathMatchingResourcePatternResolver().getResources("classpath*:bpmn/*/bpmn");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        springProcessEngineConfiguration.setDeploymentResources(resources);
//        return springProcessEngineConfiguration;
//    }
//
//    @Bean
//    public ProcessEngineFactoryBean processEngineFactory() {
//        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
//        processEngineFactoryBean.setProcessEngineConfiguration(springProcessEngineConfiguration());
//        return processEngineFactoryBean;
//    }
//
//    @Bean
//    public RepositoryService repositoryService() {
//        try {
//            return processEngineFactory().getObject().getRepositoryService();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Bean
//    public RuntimeService runtimeService() {
//        try {
//            return processEngineFactory().getObject().getRuntimeService();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Bean
//    public TaskService taskService() {
//        try {
//            return processEngineFactory().getObject().getTaskService();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Bean
//    public HistoryService historyService() {
//        try {
//            return processEngineFactory().getObject().getHistoryService();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
