package ru.ilyushkin.javaee.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import ru.ilyushkin.javaee.service.AuthorService;
import ru.ilyushkin.javaee.service.AuthorServiceBean;
import ru.ilyushkin.javaee.service.BookService;
import ru.ilyushkin.javaee.service.BookServiceBean;

/**
 * @author Alex Ilyushkin
 */
@Configuration
public class RmiServerConfig {

    private static final String AUTHOR_SERVICE_URL = "/httpInvoker/authorService";
    private static final String BOOK_SERVICE_URL = "/httpInvoker/bookService";

    @Autowired
    @Qualifier(AuthorServiceBean.NAME)
    AuthorService authorService;

    @Autowired
    @Qualifier(BookServiceBean.NAME)
    BookService bookService;

    @Bean(name = AUTHOR_SERVICE_URL)
    public HttpInvokerServiceExporter authorServiceHttpInvokerServiceExporter() {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(authorService);
        httpInvokerServiceExporter.setServiceInterface(AuthorService.class);
        httpInvokerServiceExporter.afterPropertiesSet();
        return httpInvokerServiceExporter;
    }

    @Bean(name = BOOK_SERVICE_URL)
    public HttpInvokerServiceExporter bookServiceHttpInvokerServiceExporter() {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(bookService);
        httpInvokerServiceExporter.setServiceInterface(BookService.class);
        httpInvokerServiceExporter.afterPropertiesSet();
        return httpInvokerServiceExporter;
    }
}
