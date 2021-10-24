
package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.repository.crud.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lina1
 */

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int reservationId){
        return reservationRepository.getReservation(reservationId);
    }
    
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
            
        }else{
            Optional<Reservation> reservationAux=reservationRepository.getReservation(reservation.getIdReservation());
            if(reservationAux.isEmpty()){
            return reservationRepository.save(reservation);
        }else{
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> reservationAux=reservationRepository.getReservation(reservation.getIdReservation());
            if(!reservationAux.isEmpty()){
                if(reservation.getStartDate()!=null){
                    reservationAux.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    reservationAux.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                   reservationAux.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(reservationAux.get());
                return reservationAux.get();
                }else{
                return reservation;
                }            
            }else{
              return reservation;
        }
    }
        public boolean deleteReservation(int ReservationId){
            Boolean aBoolean = getReservation(ReservationId).map(reservation -> {
             reservationRepository.delete(reservation);
             return true;
            }).orElse(false);
            return aBoolean;
        }
    }

