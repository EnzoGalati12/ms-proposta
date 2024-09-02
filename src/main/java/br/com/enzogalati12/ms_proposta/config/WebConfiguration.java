package br.com.enzogalati12.ms_proposta.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class WebConfiguration {
}
