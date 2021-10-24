
package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Room;
import com.usa.ciclo3.ciclo3.repository.crud.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lina1
 */

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;
    
    public List<Room> getAll(){
        return roomRepository.getAll();
    }
    
    public Optional<Room> getRoom(int roomId){
        return roomRepository.getRoom(roomId);
    }
    
    public Room save(Room room){
        if(room.getId()==null){
            return roomRepository.save(room);
            
        }else{
            Optional<Room> roomAux=roomRepository.getRoom(room.getId());
            if(roomAux.isEmpty()){
            return roomRepository.save(room);
        }else{
                return room;
            }
        }
    }
    
    public Room update(Room room){
        if(room.getId()!=null){
            Optional<Room> roomAux=roomRepository.getRoom(room.getId());
            if(!roomAux.isEmpty()){
                if(room.getName()!=null){
                    roomAux.get().setName(room.getName());
                }
                if(room.getStars()!=null){
                    roomAux.get().setStars(room.getStars());
                }
                if(room.getHotel()!=null){
                   roomAux.get().setHotel(room.getHotel());
                }
                if(room.getDescription()!=null){
                   roomAux.get().setDescription(room.getDescription()); 
                }
                 if(room.getCategory()!=null){
                   roomAux.get().setCategory(room.getCategory()); 
                }
                roomRepository.save(roomAux.get());
                return roomAux.get();
                }else{
                return room;
                }            
            }else{
              return room;
        }
    }
        public boolean deleteRoom(int RoomId){
            Boolean aBoolean = getRoom(RoomId).map(room -> {
             roomRepository.delete(room);
             return true;
            }).orElse(false);
            return aBoolean;
        }
    }

