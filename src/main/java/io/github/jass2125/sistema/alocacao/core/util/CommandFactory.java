/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.util;


import io.github.jass2125.sistema.alocacao.core.commands.Command;
import io.github.jass2125.sistema.alocacao.core.commands.DeleteUserCommand;
import io.github.jass2125.sistema.alocacao.core.commands.EditUserCommand;
import io.github.jass2125.sistema.alocacao.core.commands.ListUsersCommand;
import io.github.jass2125.sistema.alocacao.core.commands.LoadUserEditionCommand;
import io.github.jass2125.sistema.alocacao.core.commands.LoginUserCommand;
import io.github.jass2125.sistema.alocacao.core.commands.LogoutUserCommand;
import io.github.jass2125.sistema.alocacao.core.commands.ReaderCsvFileCommand;
import io.github.jass2125.sistema.alocacao.core.commands.RegisterUserCommand;
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
//        commands.put("listHolidays", new ListHolidaysCommand());
        
        return commands.get(request.getParameter("command"));
    }

}
