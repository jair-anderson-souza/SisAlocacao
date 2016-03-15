/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.controller;

import io.github.jass2125.sistema.alocacao.core.action.material.ListMaterialAction;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.DeleteHolidayAction;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.EditHolidayAction;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.ListHolidaysAction;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.LoadHolidayEditAction;
import io.github.jass2125.sistema.alocacao.core.action.user.DeleteUserAction;
import io.github.jass2125.sistema.alocacao.core.action.user.EditUserAction;
import io.github.jass2125.sistema.alocacao.core.action.user.ListUsersAction;
import io.github.jass2125.sistema.alocacao.core.action.user.LoadUserEditionAction;
import io.github.jass2125.sistema.alocacao.core.action.user.LoginUserAction;
import io.github.jass2125.sistema.alocacao.core.action.user.LogoutUserAction;
import io.github.jass2125.sistema.alocacao.core.action.user.RegisterUserAction;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Classe que atua como fabrica de commands
 * @author Anderson Souza
 * @since 2015
 */
public class ActionFactory {
    private static Map<String, Action> commands;
    
    public ActionFactory() {}
     /**
     * Método estatico retornar o command específica
     * @param request Requisição do usuario
     * @return commands Comando a ser executado
     */
    public static Action getAction(HttpServletRequest request){
        commands = new HashMap<>();
        commands.put("login", new LoginUserAction());
        commands.put("logout", new LogoutUserAction());
        commands.put("listUsers", new ListUsersAction());
        commands.put("registerUser", new RegisterUserAction());
        commands.put("loadUser", new LoadUserEditionAction());
        commands.put("editUser", new EditUserAction());
        commands.put("deleteUser", new DeleteUserAction());
//        commands.put("readerCsvFile", new ReaderCsvFileCommand());
        commands.put("listHolidays", new ListHolidaysAction());
        commands.put("deleteHoliday", new DeleteHolidayAction());
        commands.put("loadHoliday", new LoadHolidayEditAction());
        commands.put("editHoliday", new EditHolidayAction());
        commands.put("listMaterial", new ListMaterialAction());
        
        return commands.get(request.getParameter("action"));
    }

}
