package com.reposteria.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // La misma ruta absoluta de tu controlador  file:///
        String uploadDir = "D:/reposteria-uploads/images/";

        // Formatea la ruta para Windows (file:///C:/...)
        Path uploadPath = Paths.get(uploadDir);
        String absolutePath = uploadPath.toUri().toString();

        // CAMBIO: Mapea la ruta SIN el prefijo /api/productos
        // (porque el Gateway ya lo quitó gracias a StripPrefix=2)
        registry.addResourceHandler("/images/**")
                .addResourceLocations(absolutePath);
    }
}