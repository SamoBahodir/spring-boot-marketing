//package com.example.hellospring.cor.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.lang.NonNull;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.resource.PathResourceResolver;
//import org.springframework.web.servlet.resource.WebJarsResourceResolver;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//import java.util.Locale;
//
//@Configuration
//public class WebmvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**/*.html")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/")
//                .resourceChain(false)
//                .addResolver(new WebJarsResourceResolver())
//                .addResolver(new PathResourceResolver());
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//        lci.setParamName("lang");
//        return lci;
//    }
//
//    @Bean
//    public LocaleResolver localeResolver() {
//        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver() {
//            @Override
//            public void setLocale(@NonNull HttpServletRequest request, HttpServletResponse response, Locale locale) {
//                Locale resultLocale = getDefaultLocale();
//                if (getSupportedLocales().contains(locale))
//                    resultLocale = locale;
//                LocaleContextHolder.setLocale(resultLocale);
//            }
//        };
//
//        localeResolver.setSupportedLocales(List.of(
//                Locale.ENGLISH,
//                Locale.forLanguageTag("ru"),
//                Locale.forLanguageTag("uz"),
//                Locale.forLanguageTag("oz")
//        ));
//        localeResolver.setDefaultLocale(Locale.ENGLISH);
//        return localeResolver;
//    }
//
////    @Bean
////    ModelResolver modelResolver(ObjectMapper objectMapper) {
////        return new ModelResolver(objectMapper);
////    }
//}
