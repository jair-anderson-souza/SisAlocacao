/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.actions.holiday;

import io.github.jass2125.sistema.alocacao.core.business.Holiday;
import io.github.jass2125.sistema.alocacao.core.dao.HolidayDao;
import io.github.jass2125.sistema.alocacao.core.dao.IHolidayDao;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Classe que efetua o cadastro de feriado
 * @author Anderson Souza
 * @since 2015
 */
public class RegisterHolidayAction implements Action {
//    private ValidacaoFeriadoTemplate validacao;

    public RegisterHolidayAction() {
//        validacao = new ValidacaoFeriado();
    }
    
    /**
     * Action que efetua o cadastro de feriado
     * @param request Requisição
     * @param response Resposta
     * @return String Retorna a pagina para qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try{
            String description = request.getParameter("description");
            String date = request.getParameter("date");
            
            Holiday holiday  = new Holiday(description, date);
//            validacao.validacaoFeriado(feriado);
            
            IHolidayDao dao = new HolidayDao();
            dao.add(holiday);
            //dados validados segundo padrão requerido
            request.getSession().setAttribute("listHolidays", dao.list());
            return "administrador/home.jsp";   
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return "error.jsp";
            
        }
    }

}
