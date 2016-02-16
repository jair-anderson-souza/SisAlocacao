///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package io.github.jass2125.sistema.alocacao.core.commands.holiday;
//
//import br.edu.ifpb.sisloc.core.business.Feriado;
//import br.edu.ifpb.sisloc.core.dao.IFeriadoDao;
//import br.edu.ifpb.sisloc.core.factory.Factory;
//import br.edu.ifpb.sisloc.core.factory.FactoryImpl;
//import br.edu.ifpb.sisloc.core.exceptions.RegexException;
//import br.edu.ifpb.sisloc.core.business.Usuario;
//import br.edu.ifpb.sisloc.core.util.ValidacaoFeriado;
//import br.edu.ifpb.sisloc.core.util.ValidacaoFeriadoTemplate;
//import java.sql.SQLException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Classe que efetua a edição de um feriado
// * @author Anderson Souza
// * @since 2015
// */
//public class EditarFeriado implements Action {
//    private ValidacaoFeriadoTemplate validacao;
//
//    public EditarFeriado() {
//        validacao = new ValidacaoFeriado();
//    }
//    
//    
//    /**
//     * Método que executa a operação de edição de um usuario
//     * @param request Request
//     * @param response Response
//     * @return String Retorna a pagina para qual a aplicação será encaminhada
//     */
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        try{
//            Integer idFeriado = Integer.parseInt(request.getParameter("id_feriado"));
//            String descricao = request.getParameter("descricao");
//            String dataDeFeriado = request.getParameter("data");
//        
//            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
//        
//            Feriado feriado = new Feriado(idFeriado, descricao, dataDeFeriado, usuario.getId());
//            this.validacao.validacaoFeriado(feriado);
//            
//            Factory factory = new FactoryImpl();
//            IFeriadoDao dao = factory.createFeriadoDao();
//            dao.edit(feriado);
//            request.setAttribute("edicao", "Feriado cadastrado com sucesso");
//            return "/pages/home";
//            
//        }catch(SQLException | NumberFormatException e){
//            request.setAttribute("error", "Ocorreu um problema. Volte e tente novamente.");
//            return "/pages/home";
//        }catch(RegexException e){
//            request.setAttribute("error", e.getMessage());
//            return "/pages/home";
//        }
//    }
//        
//
//}
