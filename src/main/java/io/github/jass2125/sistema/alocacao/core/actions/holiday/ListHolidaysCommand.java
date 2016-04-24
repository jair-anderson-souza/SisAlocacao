/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.holiday;

import io.github.jass2125.sistema.alocacao.core.business.Holiday;
import io.github.jass2125.sistema.alocacao.core.dao.HolidayDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Command;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe que efetua a busca por os feriados
 *
 * @author Anderson Souza
 * @since 2015
 */
public class ListHolidaysCommand implements Command {

    /**
     * Método que efetua a busca por todos os feriados
     *
     * @param request RequisiçãoI
     * @param response Resposta
     * @return String Retorna a pagina para qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Factory factory = new FactoryDao();
            HolidayDao dao = factory.createHolidayDao();
            List<Holiday> list = dao.list();
            HttpSession session = request.getSession();
            session.setAttribute("listHolidays", list);
            return "administrador/gerenciarferiado.jsp";
        } catch (SQLException e) {
            return "error.jsp";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListHolidaysCommand.class.getName()).log(Level.SEVERE, null, ex);
            return "error.jsp";
        }
    }

}
