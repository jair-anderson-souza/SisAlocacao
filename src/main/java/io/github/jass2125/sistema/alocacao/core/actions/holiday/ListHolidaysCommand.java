/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.holiday;

import io.github.jass2125.sistema.alocacao.core.business.Holiday;
import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.HolidayDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Command;
import java.sql.SQLException;
import java.util.List;
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
    private String role;
    private Factory factory;
    private HolidayDao dao;

    public ListHolidaysCommand() {
        factory = new FactoryDao();
        dao = factory.createHolidayDao();
    }
    
    
    /**
     * Método que efetua a busca por todos os feriados
     *
     * @param request RequisiçãoI
     * @param response Resposta
     * @return String Retorna a pagina para qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        this.role = (String) ((User) session.getAttribute("user")).getRole();
        try {
            List<Holiday> list = dao.list();
            session.setAttribute("listHolidays", list);
            return this.role + "/gerenciarferiado.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            session.setAttribute("error", "Ocorreu um problema. Tente novamente.");
            return this.role + "/home.jsp";
        }
    }

}
