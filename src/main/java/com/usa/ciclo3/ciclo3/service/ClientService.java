
package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.repository.crud.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lina1
 */

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int clientId){
        return clientRepository.getClient(clientId);
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
            
        }else{
            Optional<Client> clientAux= clientRepository.getClient(client.getIdClient());
            if(clientAux.isEmpty()){
            return clientRepository.save(client);
        }else{
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> clientAux=clientRepository.getClient(client.getIdClient());
            if(!clientAux.isEmpty()){
                if(client.getName()!=null){
                    clientAux.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    clientAux.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                   clientAux.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                   clientAux.get().setAge(client.getAge()); 
                }
                clientRepository.save(clientAux.get());
                return clientAux.get();
                }else{
                return client;
                }            
            }else{
              return client;
        }
    }
        public boolean deleteClient(int ClientId){
            Boolean aBoolean = getClient(ClientId).map(client -> {
             clientRepository.delete(client);
             return true;
            }).orElse(false);
            return aBoolean;
        }
    }

