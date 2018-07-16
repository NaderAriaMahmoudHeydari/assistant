package com.nader.aria.assistant.business.service.interfaces;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.idea.Idea;
import java.util.List;
import java.util.Optional;

public interface IdeaService {

   public  Idea addIdea( Idea idea)  throws Exception;

   public List<Idea> readAllIdea(Login login)  throws Exception;

   public Optional<Idea> readIdea(Long ideaId)  throws Exception;

   public  Idea update( Idea idea)  throws Exception;

   public  void delete( Idea idea)  throws Exception;

}
