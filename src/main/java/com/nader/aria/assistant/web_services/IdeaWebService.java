package com.nader.aria.assistant.web_services;

import com.nader.aria.assistant.business.service.interfaces.IdeaService;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.idea.Idea;
import com.nader.aria.assistant.utils.ResponseEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/idea")
public class IdeaWebService {

    private IdeaService ideaService;

    @Autowired
    public IdeaWebService(IdeaService ideaService){
        this.ideaService = ideaService;
    }


    @PostMapping("/addIdea")
    public ResponseEntity<?> addIdea(@RequestBody Idea idea){

        if( idea != null && idea.getIdeaManager()!= null && idea.getIdeaManager().getId() != null ){
            try {

                return ResponseEntityManager.CREATED.getResponseEntity(ideaService.addIdea(idea));

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }

        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/readAllIdea")
    public ResponseEntity<?> readAllIdea(@RequestBody Login login){

        if( login != null && login.getId() != null ){
            try{

                return ResponseEntityManager.OK.getResponseEntity(ideaService.readAllIdea(login));

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/readIdea")
    public ResponseEntity<?> readIdea(@RequestBody Long ideaId){

        if( ideaId != null ){

            try{

                Optional<Idea> optional = ideaService.readIdea(ideaId);
                return ( optional.isPresent() )?
                        ResponseEntityManager.OK.getResponseEntity(optional.get()):
                        ResponseEntityManager.NOT_FOUND.getResponseEntity();
            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/updateIdea")
    public ResponseEntity<?> update(@RequestBody Idea idea){

        if( idea != null && idea.getId() != null ){

            try{

                return ResponseEntityManager.OK.getResponseEntity(ideaService.update(idea));

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteIdea")
    public ResponseEntity<?> delete(@RequestBody Idea idea){

        if( idea != null && idea.getId() != null ){

            try{

                ideaService.delete(idea);
                return ResponseEntityManager.OK.getResponseEntity();

            }catch (Exception e){

            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

}

