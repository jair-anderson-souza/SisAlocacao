/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.util;


import io.github.jass2125.sistema.alocacao.core.commands.CadastroUsuario;
import io.github.jass2125.sistema.alocacao.core.commands.Command;
import io.github.jass2125.sistema.alocacao.core.commands.LoginUsuario;
import io.github.jass2125.sistema.alocacao.core.commands.Logout;
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
        
        //Usuarios         
        commands.put("login", new LoginUsuario());
//        actions.put("login", new LoginUsuario());
        
        commands.put("logout", new Logout());
//        actions.put("POST/logout", new Logout());
        
        commands.put("cadastrarusuario", new CadastroUsuario());
//        actions.put("POST/cadastrarusuario", new CadastroUsuario());
        
//        actions.put("GET/listar", new ListarUsuarios());
//        actions.put("POST/listar", new ListarUsuarios());
//        
//        actions.put("GET/cadastrarusuario", new CadastroUsuario());
//        actions.put("POST/cadastrarusuario", new CadastroUsuario());
//        
//        actions.put("GET/editarusuario", new EditarUsuario());
//        actions.put("POST/editarusuario", new EditarUsuario());
//        
//        actions.put("GET/editar", new CarregUsuarioEdicao());
//        actions.put("POST/editar", new CarregUsuarioEdicao());
//        
//        actions.put("GET/editarperfil", new EditarPerfil());
//        actions.put("POST/editarperfil", new EditarPerfil());
//        
//        actions.put("GET/excluir", new ExcluirUsuario());
//        actions.put("POST/excluir", new ExcluirUsuario());
//        
//        actions.put("GET/logout", new LogOut());
//        actions.put("POST/logout", new LogOut());
//        
//        actions.put("GET/upload", new LogOut());
//        actions.put("POST/upload", new LogOut());
//        
//        actions.put("GET/listarusuarios", new ListarUsuarios());
//        actions.put("POST/listarusuarios", new ListarUsuarios());
//        
//        //feriados
//        actions.put("GET/cadastrarferiado", new CadastroFeriado());
//        actions.put("POST/cadastrarferiado", new CadastroFeriado());
//        
//        actions.put("GET/editarferiado", new CarregarFeriadoPraEdicao());
//        actions.put("POST/editarferiado", new CarregarFeriadoPraEdicao());
//        
//        
//        actions.put("GET/editandoferiado", new EditarFeriado());
//        actions.put("POST/editandoferiado", new EditarFeriado());
//        
//
//        actions.put("GET/listarferiados", new ListarFeriados());
//        actions.put("POST/listarferiados", new ListarFeriados());
//        
//        actions.put("GET/excluirferiado", new ExcluirFeriado());
//        actions.put("POST/excluirferiado", new ExcluirFeriado());
//        
//        actions.put("GET/leitorcsv", new LeitorCSV());
//        actions.put("POST/leitorcsv", new LeitorCSV());
        
        return commands.get(request.getParameter("command"));
    }

}
