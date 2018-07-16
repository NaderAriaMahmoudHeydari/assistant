package com.nader.aria.assistant.dao.idea_repository;

import com.nader.aria.assistant.entities.idea.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Calendar;
import java.util.List;

public interface IdeaRepository extends JpaRepository<Idea,Long> {

    public Idea findByTitle(@Param("title") String title);
    public Idea findBySubject(@Param("subject") String subject);
    public Idea findByDescription(@Param("description") String description);
    public List<Idea> findAllByTechnologyField(@Param("technologyField") String technologyField);
    public List<Idea> findAllByComeToMindDate(@Param("comeToMindDate") Calendar comeToMindDate);
    public List<Idea> findAllByChanceToBeDone(@Param("chanceToBeDone") Integer chanceToBeDone);
    public List<Idea> findAllByBuildTime(@Param("buildTime") Calendar buildTime);
    public List<Idea> findAllByNeededCapitalBetween(@Param("neededCapitalFrom") Integer neededCapitalFrom ,
                                                    @Param("neededCapitalDestine") Integer neededCapitalDestine);
    public List<Idea> findAllByDependency(@Param("dependency") Idea dependency);

}
