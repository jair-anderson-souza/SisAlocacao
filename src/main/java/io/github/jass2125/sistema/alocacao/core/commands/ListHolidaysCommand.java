///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package io.github.jass2125.sistema.alocacao.core.commands;
//
//import io.github.jass2125.sistema.alocacao.core.business.Holiday;
//import io.github.jass2125.sistema.alocacao.core.dao.IHolidayDao;
//import io.github.jass2125.sistema.alocacao.core.factory.Factory;
//import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
//import java.sql.SQLException;
//import java.util.Set;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
// * Classe que efetua a busca por os feriados
// * @author Anderson Souza
// * @since 2015
// */
//public class ListHolidaysCommand implements Command {
//
//    /**
//     * Método que efetua a busca por todos os feriados
//     * @param request Requisição
//     * @param response Resposta
//     * @return String Retorna a pagina para qual a aplicação será encaminhada
//     */
////    @Override
////    public String execute(HttpServletRequest request, HttpServletResponse response) {
////        try{
////            Factory factory = new FactoryDao();
////            IHolidayDao dao = factory.createHolidayDao();
////            Set<Holiday> list = dao.list();
////            request.setAttribute("listaDeFeriados", list);
////            return "/pages/gerenciarferiado";
////        }catch(SQLException e){
////            request.setAttribute("error", "Occoreu um erro, retorne e tente novamente");
////            return "/pages/gerenciarferiado";
////        }
////    }
//    
//    
//
//}
