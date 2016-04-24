/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.controller;

import io.github.jass2125.sistema.alocacao.core.actions.events.ListEventsCommand;
import io.github.jass2125.sistema.alocacao.core.actions.events.RegisterEventCommand;
import io.github.jass2125.sistema.alocacao.core.actions.floor.DeleteFloorCommand;
import io.github.jass2125.sistema.alocacao.core.actions.floor.EditFloorCommand;
import io.github.jass2125.sistema.alocacao.core.actions.floor.ListFloorCommand;
import io.github.jass2125.sistema.alocacao.core.actions.floor.LoadFloorToEditCommand;
import io.github.jass2125.sistema.alocacao.core.actions.floor.RegisterFloorCommand;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.DeleteHolidayCommand;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.EditHolidayCommand;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.ListHolidaysCommand;
import io.github.jass2125.sistema.alocacao.core.actions.holiday.LoadHolidayEditCommand;
import io.github.jass2125.sistema.alocacao.core.actions.material.DeleteMaterialCommand;
import io.github.jass2125.sistema.alocacao.core.actions.material.EditMaterialCommand;
import io.github.jass2125.sistema.alocacao.core.actions.material.ListMaterialCommand;
import io.github.jass2125.sistema.alocacao.core.actions.material.LoadMaterialToEditCommand;
import io.github.jass2125.sistema.alocacao.core.actions.material.RegisterMaterialCommand;
import io.github.jass2125.sistema.alocacao.core.actions.room.DeleteRoomCommand;
import io.github.jass2125.sistema.alocacao.core.actions.room.EditRoomCommand;
import io.github.jass2125.sistema.alocacao.core.actions.room.ListRoomsCommand;
import io.github.jass2125.sistema.alocacao.core.actions.room.LoadRoomToEditCommand;
import io.github.jass2125.sistema.alocacao.core.actions.room.RegisterRoomCommand;
import io.github.jass2125.sistema.alocacao.core.actions.user.DeleteUserCommand;
import io.github.jass2125.sistema.alocacao.core.actions.user.EditUserCommand;
import io.github.jass2125.sistema.alocacao.core.actions.user.ListUsersCommand;
import io.github.jass2125.sistema.alocacao.core.actions.user.LoadUserEditionCommand;
import io.github.jass2125.sistema.alocacao.core.actions.user.LoginUserCommand;
import io.github.jass2125.sistema.alocacao.core.actions.user.LogoutUserCommand;
import io.github.jass2125.sistema.alocacao.core.actions.user.RegisterUserCommand;
import io.github.jass2125.sistema.alocacao.core.util.Command;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Classe que atua como fabrica de commands
 *
 * @author Anderson Souza
 * @since 2015
 */
public final class CommandFactory {

    private static Map<String, Command> actions;

    public CommandFactory() {
    }

    /**
     * Método estatico retornar o command específica
     *
     * @param request Requisição do usuario
     * @return commands Comando a ser executado
     */
    public static Command getCommand(HttpServletRequest request) {
        
        //Fazer um lazy loading aqui
        actions = new HashMap<>();
        actions.put("login", new LoginUserCommand());
        actions.put("logout", new LogoutUserCommand());
        actions.put("listUsers", new ListUsersCommand());
        actions.put("registerUser", new RegisterUserCommand());
        actions.put("loadUser", new LoadUserEditionCommand());
        actions.put("editUser", new EditUserCommand());
        actions.put("deleteUser", new DeleteUserCommand());
//        commands.put("readerCsvFile", new ReaderCsvFileCommand());
        actions.put("listHolidays", new ListHolidaysCommand());
        actions.put("deleteHoliday", new DeleteHolidayCommand());
        actions.put("loadHoliday", new LoadHolidayEditCommand());
        actions.put("editHoliday", new EditHolidayCommand());
        
        /* Material Actions */
        actions.put("listMaterial", new ListMaterialCommand());
        actions.put("registerMaterial", new RegisterMaterialCommand());
        actions.put("loadMaterialToEdit", new LoadMaterialToEditCommand());
        actions.put("updateMaterial", new EditMaterialCommand());
        actions.put("deleteMaterial", new DeleteMaterialCommand());
        
        actions.put("listMaterials", new ListMaterialCommand());
        
        /* Blocos*/
        actions.put("listFloors", new ListFloorCommand());
        actions.put("registerFloor", new RegisterFloorCommand());
        actions.put("loadFloorToEdit", new LoadFloorToEditCommand());
        actions.put("editFloor", new EditFloorCommand());
        actions.put("deleteFloor", new DeleteFloorCommand());
        actions.put("registerFloor", new RegisterFloorCommand());
        
        /* Salas */
        actions.put("listRooms", new ListRoomsCommand());
        actions.put("registerRoom", new RegisterRoomCommand());
        actions.put("loadRoom", new LoadRoomToEditCommand());
        actions.put("editRoom", new EditRoomCommand());
        actions.put("deleteRoom", new DeleteRoomCommand());
        
        /* Eventos */
        actions.put("listEvents", new ListEventsCommand());
        actions.put("registerEvent", new RegisterEventCommand());
        
        return actions.get(request.getParameter("action"));
    }

}
