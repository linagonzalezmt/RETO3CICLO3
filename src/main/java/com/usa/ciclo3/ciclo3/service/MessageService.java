
package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Message;
import com.usa.ciclo3.ciclo3.repository.crud.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lina1
 */

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int messageId){
        return messageRepository.getMessage(messageId);
    }
    
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
            
        }else{
            Optional<Message> messageAux=messageRepository.getMessage(message.getIdMessage());
            if(messageAux.isEmpty()){
            return messageRepository.save(message);
        }else{
                return message;
            }
        }
    }
    
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> messageAux=messageRepository.getMessage(message.getIdMessage());
            if(!messageAux.isEmpty()){
                if(message.getMessageText()!=null){
                    messageAux.get().setMessageText(message.getMessageText());
                }
               messageRepository.save(messageAux.get());
               return messageAux.get();
                           
            }else{
              return message;
        }
    }else{
            return message;
        }
    }
        public boolean deleteMessage(int messageId){
            Boolean aBoolean = getMessage(messageId).map(message -> {
             messageRepository.delete(message);
             return true;
            }).orElse(false);
            return aBoolean;
        }
    }

