package com.nader.aria.assistant.business.service;

import com.nader.aria.assistant.business.service.interfaces.IdeaService;
import com.nader.aria.assistant.dao.idea_repository.IdeaManagerRepository;
import com.nader.aria.assistant.dao.idea_repository.IdeaRepository;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.idea.Idea;
import com.nader.aria.assistant.entities.idea.IdeaManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class IdeaServiceImpl implements IdeaService {

    private IdeaManagerRepository ideaManagerRepository;
    private IdeaRepository ideaRepository;

    public IdeaServiceImpl(IdeaManagerRepository ideaManagerRepository,
                           IdeaRepository ideaRepository ){

        this.ideaManagerRepository = ideaManagerRepository;
        this.ideaRepository = ideaRepository;

    }

    @Override
    @Transactional
    public Idea addIdea(Idea idea)  throws Exception{

        return ideaRepository.save(idea);
    }

    @Override
    @Transactional
    public List<Idea> readAllIdea(Login login)  throws Exception{
        IdeaManager ideaManager = ideaManagerRepository.findByLogin(login);
        return ideaManager.getIdeas();
    }

    @Override
    @Transactional
    public Optional<Idea> readIdea(Long ideaId)  throws Exception{
        return ideaRepository.findById(ideaId);
    }

    @Override
    @Transactional
    public  Idea update( Idea idea)  throws Exception{
        return ideaRepository.save(idea);
    }

    @Override
    @Transactional
    public  void delete( Idea idea)  throws Exception{
        ideaRepository.delete(idea);
    }
}
