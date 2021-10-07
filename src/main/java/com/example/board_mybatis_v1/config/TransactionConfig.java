package com.example.board_mybatis_v1.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;

@Configuration
@Slf4j
@Aspect
@RequiredArgsConstructor
@EnableTransactionManagement
public class TransactionConfig {

    private final PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor transactionAdvice() {
        log.info("transactionAdvice(");
        TransactionInterceptor txAdvice = new TransactionInterceptor();
        NameMatchTransactionAttributeSource txAttributeSource = new NameMatchTransactionAttributeSource();
        RuleBasedTransactionAttribute txAttribute = new RuleBasedTransactionAttribute();

        txAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        txAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        HashMap<String, TransactionAttribute> txMethods = new HashMap<>();
        txMethods.put("*", txAttribute);
        txAttributeSource.setNameMap(txMethods);

        txAdvice.setTransactionAttributeSource(txAttributeSource);
        txAdvice.setTransactionManager(transactionManager);

        return txAdvice;
    }

    @Bean
    public Advisor transactionAdviceAdvisor() {
        log.info("transactionAdviceAdvisor()");
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.example.board_mybatis_v1.service.*.*(..))");
        return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
    }
}
