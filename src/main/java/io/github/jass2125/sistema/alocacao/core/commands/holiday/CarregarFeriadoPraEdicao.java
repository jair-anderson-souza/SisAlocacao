///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package io.github.jass2125.sistema.alocacao.core.commands.holiday;
//
//import br.edu.ifpb.sisloc.core.business.Feriado;
//import br.edu.ifpb.sisloc.core.dao.IFeriadoDao;
//import br.edu.ifpb.sisloc.core.factory.Factory;
//import br.edu.ifpb.sisloc.core.factory.FactoryImpl;
//import java.sql.SQLException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Classe que recupera da base de dados o feriado vindo da requisição
// * @author Anderson Souza
// * @since 2015, Feb 1, 2016
// */
//public class CarregarFeriadoPraEdicao implements Action {
//    
//    /**
//     * Método por executar a ação de carregar feriado pra edição
//     * @param request Requisição
//     * @param response Resposta
//     * @return String Retorna o nome da pagina a qual a aplicação será encaminhada
//     */
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            String id = request.getParameter("idferiado");
//            int idFeriado = Integer.parseInt(id);
//            Factory factory = new FactoryImpl();
//            IFeriadoDao dao = factory.createFeriadoDao();
//            Feriado feriado = dao.find(idFeriado);
//            if (feriado != null) {
//                request.setAttribute("feriado", feriado);
//                return "/pages/editarferiado";
//            } else {
//                request.setAttribute("error", "Ocorreu um problema. Verifique os campos e tente novamente.");
//                return "/pages/home";
//            }
//        } catch (SQLException e) {
//            request.setAttribute("error", "Ocorreu um problema. Verifique os campos e tente novamente.");
//            return "/pages/home";
//        }
//    }
//
//}
