
package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Room;
import com.usa.ciclo3.ciclo3.repository.RoomCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lina1
 */
@Repository
public class RoomRepository {
    
    @Autowired
    private RoomCrudRepository roomCrudRepository;
    
    public List<Room> getAll(){
        return(List<Room>)roomCrudRepository.findAll();
    }

    public Optional<Room> getRoom(int id){
    return roomCrudRepository.findById(id);
    }    

    public Room save(Room room){
    return roomCrudRepository.save(room);
    }
    
    public void delete(Room room){
    roomCrudRepository.delete(room);
    }

}


