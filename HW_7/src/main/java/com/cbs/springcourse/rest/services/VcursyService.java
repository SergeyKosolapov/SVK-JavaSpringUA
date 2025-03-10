package com.cbs.springcourse.rest.services;

import com.cbs.springcourse.rest.models.ValCursy;
import com.cbs.springcourse.rest.repositories.VcursyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class VcursyService {

    private final VcursyRepository vcursyRepository;

    @Autowired
    public VcursyService(VcursyRepository vcursyRepository) {
        this.vcursyRepository = vcursyRepository;
    }

    public List<ValCursy> findAll() {
        return vcursyRepository.findAll();
    }

    public ValCursy findOne(int id) {
        Optional<ValCursy> foundVcursy = vcursyRepository.findById(id);
        return foundVcursy.orElse(null);
    }
}
