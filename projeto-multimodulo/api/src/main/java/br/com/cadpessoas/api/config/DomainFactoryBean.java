package br.com.cadpessoas.api.config;

import br.com.cadpessoas.core.utils.DomainFactoryBeanCreator;
import br.com.cadpessoas.domain.enums.BeanType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class DomainFactoryBean implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        DomainFactoryBeanCreator.postDefinitionRegistry(registry, BeanType.API);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }
}
