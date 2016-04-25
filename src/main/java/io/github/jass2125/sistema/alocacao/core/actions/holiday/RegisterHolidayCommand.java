/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.holiday;

import io.github.jass2125.sistema.alocacao.core.business.Holiday;
import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.HolidayDao;
import io.github.jass2125.sistema.alocacao.core.exceptions.FieldEmptyException;
import io.github.jass2125.sistema.alocacao.core.exceptions.RegexException;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Command;
import io.github.jass2125.sistema.alocacao.core.util.ValidationHoliday;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe que efetua o cadastro de feriado
 *
 * @author Anderson Souza
 * @since 2015
 */
public class RegisterHolidayCommand implements Command {

    private ValidationHoliday validation;
    private Factory factory;
    private HolidayDao dao;
    private String role;

    public RegisterHolidayCommand() {
        validation = new ValidationHoliday();
        factory = new FactoryDao();
        dao = factory.createHolidayDao();
    }

    /**
     * Action que efetua o cadastro de feriado
     *
     * @param request Requisição
     * @param response Resposta
     * @return String Retorna a pagina para qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        this.role = user.getRole();
        try {
            String description = request.getParameter("description");
            String date = request.getParameter("date");

            validation.validationDescription(description);
            validation.validationDate(date);
            Holiday hol = dao.findByDate(date);
            if (hol == null) {
                Holiday holiday = new Holiday(description, date);
                dao.add(holiday);
            } else {
                dao.edit(hol);
            }
            request.getSession().setAttribute("listHolidays", dao.list());
            return this.role + "/gerenciarferiado.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            session.setAttribute("error", "Ocorreu um erro, por favor tente novamente.");
            return this.role + "/home.jsp";
        } catch (FieldEmptyException | RegexException e) {
            e.printStackTrace();
            session.setAttribute("error", e.getMessage());
            return this.role + "/home.jsp";
        }

    }

}
