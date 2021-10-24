
package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.ciclo3.ciclo3.repository.ClientCrudRepository;

/**
 *
 * @author lina1
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    public List<Client> getAll(){
        return(List<Client>)clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
    return clientCrudRepository.findById(id);
    }    

    public Client save(Client client){
    return clientCrudRepository.save(client);
    }
    
    public void delete(Client client){
    clientCrudRepository.delete(client); 
    }
    

}


