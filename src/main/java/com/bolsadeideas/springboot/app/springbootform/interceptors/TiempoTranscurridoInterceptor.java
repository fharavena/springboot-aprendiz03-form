package com.bolsadeideas.springboot.app.springbootform.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (request.getMethod().equalsIgnoreCase("post")) {
            return true;
        }

        if (handler instanceof HandlerMethod) {
            HandlerMethod metodo = (HandlerMethod) handler;
            logger.info("es un metodo del controlador: " + metodo.getMethod().getName());

        }

        logger.info("TiempoTranscurridoInterceptor: preHandler() entrando ....");
        logger.info("Interceptando Handler " + handler);
        long tiempoinicio = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoinicio);

        Random random = new Random();
        Integer demora = random.nextInt(500);
        Thread.sleep(demora);
        
        return true;

        // response.sendRedirect(request.getContextPath().concat("/login"));
        // return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        if (request.getMethod().equalsIgnoreCase("post")) {
            return;
        }

        long tiempofin = System.currentTimeMillis();
        long tiempoinicio = (Long) request.getAttribute("tiempoInicio");
        long tiempoTranscurrido = tiempofin - tiempoinicio;

        if (handler instanceof HandlerMethod && modelAndView != null) {
            modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
        }
        logger.info("Tiempo Transcurrido: " + tiempoTranscurrido + " milisegundos");
        logger.info("TiempoTranscurridoInterceptor: postHandler() saliendo ....");

    }

}
