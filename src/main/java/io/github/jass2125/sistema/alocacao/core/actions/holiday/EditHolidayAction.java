/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.actions.holiday;

import io.github.jass2125.sistema.alocacao.core.business.Holiday;
import io.github.jass2125.sistema.alocacao.core.dao.IHolidayDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Classe que efetua a edição de um feriado
 * @author Anderson Souza
 * @since 2015
 */
public class EditHolidayAction implements Action {
//    private ValidacaoFeriadoTemplate validacao;

    public EditHolidayAction() {
//        validacao = new ValidacaoFeriado();
    }
    
    
    /**
     * Método que executa a operação de edição de um usuario
     * @param request Request
     * @param response Response
     * @return String Retorna a pagina para qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try{
            Integer idFeriado = Integer.parseInt(request.getParameter("idHoliday"));
            String descricao = request.getParameter("description");
            String dataDeFeriado = request.getParameter("date");
        
            Holiday holiday = new Holiday(idFeriado, descricao, dataDeFeriado);
//            this.validacao.validacaoFeriado(holiday);
            
            Factory factory = new FactoryDao();
            IHolidayDao dao = factory.createHolidayDao();
            dao.edit(holiday);
            request.getSession().setAttribute("listHolidays", dao.list());
            request.setAttribute("edicao", "Feriado cadastrado com sucesso");
            
            return "administrador/gerenciarferiado.jsp";
            
        }catch(SQLException | NumberFormatException | ClassNotFoundException e){
            request.setAttribute("error", "Ocorreu um problema. Volte e tente novamente.");
            return "error.jsp";
        }
    }
        

}
