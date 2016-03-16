/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.controller;

import io.github.jass2125.sistema.alocacao.core.actions.material.ListMaterialAction;
import io.github.jass2125.sistema.alocacao.core.actions.material.RegisterMaterial;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.DeleteHolidayAction;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.EditHolidayAction;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.ListHolidaysAction;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.LoadHolidayEditAction;
import io.github.jass2125.sistema.alocacao.core.actions.material.EditMaterialAction;
import io.github.jass2125.sistema.alocacao.core.actions.material.LoadMaterialToEditAction;
import io.github.jass2125.sistema.alocacao.core.actions.user.DeleteUserAction;
import io.github.jass2125.sistema.alocacao.core.actions.user.EditUserAction;
import io.github.jass2125.sistema.alocacao.core.actions.user.ListUsersAction;
import io.github.jass2125.sistema.alocacao.core.actions.user.LoadUserEditionAction;
import io.github.jass2125.sistema.alocacao.core.actions.user.LoginUserAction;
import io.github.jass2125.sistema.alocacao.core.actions.user.LogoutUserAction;
import io.github.jass2125.sistema.alocacao.core.actions.user.RegisterUserAction;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Classe que atua como fabrica de commands
 *
 * @author Anderson Souza
 * @since 2015
 */
public class ActionFactory {

    private static Map<String, Action> actions;

    public ActionFactory() {
    }

    /**
     * Método estatico retornar o command específica
     *
     * @param request Requisição do usuario
     * @return commands Comando a ser executado
     */
    public static Action getAction(HttpServletRequest request) {
        actions = new HashMap<>();
        actions.put("login", new LoginUserAction());
        actions.put("logout", new LogoutUserAction());
        actions.put("listUsers", new ListUsersAction());
        actions.put("registerUser", new RegisterUserAction());
        actions.put("loadUser", new LoadUserEditionAction());
        actions.put("editUser", new EditUserAction());
        actions.put("deleteUser", new DeleteUserAction());
//        commands.put("readerCsvFile", new ReaderCsvFileCommand());
        actions.put("listHolidays", new ListHolidaysAction());
        actions.put("deleteHoliday", new DeleteHolidayAction());
        actions.put("loadHoliday", new LoadHolidayEditAction());
        actions.put("editHoliday", new EditHolidayAction());
        
        actions.put("listMaterial", new ListMaterialAction());
        actions.put("registerMaterial", new RegisterMaterial());
        actions.put("loadMaterialToEdit", new LoadMaterialToEditAction());
        actions.put("updateMaterial", new EditMaterialAction());

        return actions.get(request.getParameter("action"));
    }

}
