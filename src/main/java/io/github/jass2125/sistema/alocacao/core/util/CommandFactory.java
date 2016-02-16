/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.util;


import io.github.jass2125.sistema.alocacao.core.commands.holiday.DeleteHolidayCommand;
import io.github.jass2125.sistema.alocacao.core.commands.user.DeleteUserCommand;
import io.github.jass2125.sistema.alocacao.core.commands.user.EditUserCommand;
import io.github.jass2125.sistema.alocacao.core.commands.holiday.ListHolidaysCommand;
import io.github.jass2125.sistema.alocacao.core.commands.user.ListUsersCommand;
import io.github.jass2125.sistema.alocacao.core.commands.user.LoadUserEditionCommand;
import io.github.jass2125.sistema.alocacao.core.commands.user.LoginUserCommand;
import io.github.jass2125.sistema.alocacao.core.commands.user.LogoutUserCommand;
import io.github.jass2125.sistema.alocacao.core.commands.user.RegisterUserCommand;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Classe que atua como fabrica de commands
 * @author Anderson Souza
 * @since 2015
 */
public class CommandFactory {
    private static Map<String, Command> commands;
    
    public CommandFactory() {}
     /**
     * Método estatico retornar o command específica
     * @param request Requisição do usuario
     * @return commands Comando a ser executado
     */
    public static Command getCommand(HttpServletRequest request){
        commands = new HashMap<>();
        commands.put("login", new LoginUserCommand());
        commands.put("logout", new LogoutUserCommand());
        commands.put("listUsers", new ListUsersCommand());
        commands.put("registerUser", new RegisterUserCommand());
        commands.put("loadUser", new LoadUserEditionCommand());
        commands.put("editUser", new EditUserCommand());
        commands.put("deleteUser", new DeleteUserCommand());
//        commands.put("readerCsvFile", new ReaderCsvFileCommand());
        commands.put("listHolidays", new ListHolidaysCommand());
        commands.put("deleteHoliday", new DeleteHolidayCommand());
        
        return commands.get(request.getParameter("command"));
    }

}
