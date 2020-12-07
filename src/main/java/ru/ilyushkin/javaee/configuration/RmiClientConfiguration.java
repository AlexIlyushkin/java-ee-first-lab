package ru.ilyushkin.javaee.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import ru.ilyushkin.javaee.service.AuthorService;
import ru.ilyushkin.javaee.service.BookService;

/**
 * @author Alex Ilyushkin
 */
@Configuration
public class RmiClientConfiguration {

    public static final String AUTHOR_SERVICE_RMI_BEAN_NAME = "rmiAuthorService";
    public static final String BOOK_SERVICE_RMI_BEAN_NAME = "rmiBookService";

    @Bean(AUTHOR_SERVICE_RMI_BEAN_NAME)
    AuthorService rmiAuthorService() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceInterface(AuthorService.class);
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:8080/httpInvoker/authorService");
        httpInvokerProxyFactoryBean.afterPropertiesSet();
        return (AuthorService) httpInvokerProxyFactoryBean.getObject();
    }

    @Bean(BOOK_SERVICE_RMI_BEAN_NAME)
    BookService rmiBookService() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceInterface(BookService.class);
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:8080/httpInvoker/bookService");
        httpInvokerProxyFactoryBean.afterPropertiesSet();
        return (BookService) httpInvokerProxyFactoryBean.getObject();
    }
}
