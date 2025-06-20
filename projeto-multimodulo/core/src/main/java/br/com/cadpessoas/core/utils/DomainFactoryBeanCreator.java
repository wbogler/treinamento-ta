package br.com.cadpessoas.core.utils;

import br.com.cadpessoas.domain.enums.BeanType;
import br.com.cadpessoas.domain.enums.UseCase;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Objects;
import java.util.Set;

public class DomainFactoryBeanCreator {

    public static void postDefinitionRegistry(BeanDefinitionRegistry registry, BeanType beanType) throws BeansException {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(UseCase.class));
        Set<BeanDefinition> definitions = scanner.findCandidateComponents("br.com.cadpessoas.domain.usecase");
        definitions.stream().filter(beanDefinition -> {final UseCase annotation;
            try {
                annotation = Class.forName(beanDefinition.getBeanClassName()).getAnnotation(UseCase.class);
                return annotation.beanType() == BeanType.CORE || annotation.beanType() == beanType;
            } catch (ClassNotFoundException e) {
                return false;
            }
        })
                .forEach(beanDefinition -> registry.registerBeanDefinition(Objects.requireNonNull(beanDefinition.getBeanClassName()), beanDefinition));
    }
}
