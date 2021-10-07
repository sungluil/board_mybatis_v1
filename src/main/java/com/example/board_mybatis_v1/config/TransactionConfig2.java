//package com.example.board_mybatis_v1.config;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.aop.Advisor;
//import org.springframework.aop.aspectj.AspectJExpressionPointcut;
//import org.springframework.aop.support.DefaultPointcutAdvisor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionDefinition;
//import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
//import org.springframework.transaction.interceptor.RollbackRuleAttribute;
//import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
//import org.springframework.transaction.interceptor.TransactionInterceptor;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
//@Aspect
//@Configuration
//@Slf4j
//@RequiredArgsConstructor
//public class TransactionConfig2 {
//
//    private static final int TX_METHOD_TIMEOUT = 3;
//    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.example.board_mybatis_v1.service..*.*(..))";
//
//
//    private final PlatformTransactionManager transactionManager;
//
//
//
//    @Bean
//    public TransactionInterceptor txAdvice() {
//
//        TransactionInterceptor txAdvice = new TransactionInterceptor();
//        Properties txAttributes = new Properties();
//
//        List<RollbackRuleAttribute> rollbackRules = new ArrayList<>();
//
//
//        rollbackRules.add(new RollbackRuleAttribute(Exception.class));
//        /** If need to add additionall exceptio, add here **/
//
//        DefaultTransactionAttribute readOnlyAttribute = new DefaultTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED);
//        readOnlyAttribute.setReadOnly(true);
//        readOnlyAttribute.setTimeout(TX_METHOD_TIMEOUT);
//
//
//        RuleBasedTransactionAttribute writeAttribute = new RuleBasedTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED, rollbackRules);
//        writeAttribute.setTimeout(TX_METHOD_TIMEOUT);
//
//        String readOnlyTransactionAttributesDefinition = readOnlyAttribute.toString();
//        String writeTransactionAttributesDefinition = writeAttribute.toString();
//        log.info("Read Only Attributes :: {}", readOnlyTransactionAttributesDefinition);
//        log.info("Write Attributes :: {}", writeTransactionAttributesDefinition);
//
//
//
//
//
//        // read-only
//        txAttributes.setProperty("retrieve*", readOnlyTransactionAttributesDefinition);
//        txAttributes.setProperty("select*", readOnlyTransactionAttributesDefinition);
//        txAttributes.setProperty("get*", readOnlyTransactionAttributesDefinition);
//        txAttributes.setProperty("list*", readOnlyTransactionAttributesDefinition);
//        txAttributes.setProperty("search*", readOnlyTransactionAttributesDefinition);
//        txAttributes.setProperty("find*", readOnlyTransactionAttributesDefinition);
//        txAttributes.setProperty("count*", readOnlyTransactionAttributesDefinition);
//
//
//
//        // write rollback-rule
//
//        txAttributes.setProperty("*", writeTransactionAttributesDefinition);
//
//
//
//        txAdvice.setTransactionAttributes(txAttributes);
//
//        txAdvice.setTransactionManager(transactionManager);
//
//
//
//
//
//        return txAdvice;
//
//    }
//
//
//
//    @Bean
//
//    public Advisor txAdviceAdvisor() {
//
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//
//        pointcut.setExpression("(execution(* *..*.service..*.*(..)) || execution(* *..*.services..*.*(..)))");
//
//        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
//
//        return new DefaultPointcutAdvisor(pointcut, txAdvice());
//
//    }
//
//}