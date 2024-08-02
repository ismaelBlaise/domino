package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.Discussions;
import com.projet.dominos_backend.repositories.DiscussionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionsService {

    @Autowired
    private DiscussionsRepository discussionsRepository;

    public List<Discussions> findAll() {
        return discussionsRepository.findAll();
    }

    public Optional<Discussions> findById(Integer id) {
        return discussionsRepository.findById(id);
    }

    public Discussions save(Discussions discussion) {
        return discussionsRepository.save(discussion);
    }

    public void deleteById(Integer id) {
        discussionsRepository.deleteById(id);
    }
}
