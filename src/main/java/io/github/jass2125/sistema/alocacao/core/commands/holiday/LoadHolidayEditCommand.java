/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.commands.holiday;

import io.github.jass2125.sistema.alocacao.core.business.Holiday;
import io.github.jass2125.sistema.alocacao.core.dao.IHolidayDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Command;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe que recupera da base de dados o feriado vindo da requisição
 * @author Anderson Souza
 * @since 2015, Feb 1, 2016
 */
public class LoadHolidayEditCommand implements Command {
    
    /**
     * Método por executar a ação de carregar feriado pra edição
     * @param request Requisição
     * @param response Resposta
     * @return String Retorna o nome da pagina a qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("idHoliday");
            int idHoliday = Integer.parseInt(id);
            Factory factory = new FactoryDao();
            IHolidayDao dao = factory.createHolidayDao();
            Holiday holiday = dao.findById(idHoliday);
            
            if (holiday != null) {
                request.getSession().setAttribute("holidayEdit", holiday);
                request.getSession().setAttribute("listHolidays", dao.list());
                return "administrador/editarferiado.jsp";
            } else {
                request.setAttribute("error", "Ocorreu um problema. Verifique os campos e tente novamente.");
                return "error.jsp";
            }
        } catch (SQLException e) {
            request.setAttribute("error", "Ocorreu um problema. Verifique os campos e tente novamente.");
            return "error.jsp";
        }
    }

}
