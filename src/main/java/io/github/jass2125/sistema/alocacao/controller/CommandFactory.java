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

    private Map<String, Command> commands;

    public CommandFactory() {
        commands = new HashMap<>();
        /* Usuario */
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
        commands.put("loadHoliday", new LoadHolidayEditCommand());
        commands.put("editHoliday", new EditHolidayCommand());

        /* Material Actions */
        commands.put("listMaterial", new ListMaterialCommand());
        commands.put("registerMaterial", new RegisterMaterialCommand());
        commands.put("loadMaterialToEdit", new LoadMaterialToEditCommand());
        commands.put("updateMaterial", new EditMaterialCommand());
        commands.put("deleteMaterial", new DeleteMaterialCommand());

        commands.put("listMaterials", new ListMaterialCommand());

        /* Blocos*/
        commands.put("listFloors", new ListFloorCommand());
        commands.put("registerFloor", new RegisterFloorCommand());
        commands.put("loadFloorToEdit", new LoadFloorToEditCommand());
        commands.put("editFloor", new EditFloorCommand());
        commands.put("deleteFloor", new DeleteFloorCommand());
        commands.put("registerFloor", new RegisterFloorCommand());

        /* Salas */
        commands.put("listRooms", new ListRoomsCommand());
        commands.put("registerRoom", new RegisterRoomCommand());
        commands.put("loadRoom", new LoadRoomToEditCommand());
        commands.put("editRoom", new EditRoomCommand());
        commands.put("deleteRoom", new DeleteRoomCommand());

        /* Eventos */
        commands.put("listEvents", new ListEventsCommand());
        commands.put("registerEvent", new RegisterEventCommand());
    }

    /**
     * Método estatico retornar o command específica
     *
     * @param request Requisição do usuario
     * @return commands Comando a ser executado
     */
    public Command getCommand(HttpServletRequest request) {
        return commands.get(request.getParameter("command"));
    }

}
