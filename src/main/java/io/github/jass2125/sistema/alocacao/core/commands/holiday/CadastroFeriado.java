///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package io.github.jass2125.sistema.alocacao.core.commands.holiday;
//
//import br.edu.ifpb.sisloc.core.business.Feriado;
//import br.edu.ifpb.sisloc.core.dao.FeriadoDao;
//import br.edu.ifpb.sisloc.core.dao.IFeriadoDao;
//import br.edu.ifpb.sisloc.core.exceptions.RegexException;
//import br.edu.ifpb.sisloc.core.business.Usuario;
//import br.edu.ifpb.sisloc.core.util.ValidacaoFeriadoTemplate;
//import java.sql.SQLException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
// * Classe que efetua o cadastro de feriado
// * @author Anderson Souza
// * @since 2015
// */
//public class CadastroFeriado implements Action {
//    private ValidacaoFeriadoTemplate validacao;
//
//    public CadastroFeriado() {
////        validacao = new ValidacaoFeriado();
//    }
//    
//    /**
//     * Action que efetua o cadastro de feriado
//     * @param request Requisição
//     * @param response Resposta
//     * @return String Retorna a pagina para qual a aplicação será encaminhada
//     */
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        try{
//            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
//            String descricao = request.getParameter("descricao");
//            String dataDeFeriado = request.getParameter("data");
//            
//            Feriado feriado = new Feriado(dataDeFeriado, descricao, usuario.getId());
//            validacao.validacaoFeriado(feriado);
//            
//            IFeriadoDao dao = new FeriadoDao();
//            dao.add(feriado);
//            //dados validados segundo padrão requerido
//            request.setAttribute("insercao", "O feriado foi cadastrado com sucesso");
//            return "/pages/home";   
//        }catch(SQLException e){
//            request.setAttribute("error", "Ocorreu um problema. Volte e tente novamente.");
//            return "/pages/home";
//            //e.printStackTrace();
//        }catch(RegexException e){
//            request.setAttribute("error", e.getMessage());
//            return "/pages/home";
//            //e.printStackTrace();
//        }
//    }
//}
