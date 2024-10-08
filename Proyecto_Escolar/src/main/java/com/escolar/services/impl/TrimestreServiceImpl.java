package com.escolar.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.entity.Trimestre;
import com.escolar.repository.ITrimestreRepository;
import com.escolar.services.TrimestreService;

@Service
public class TrimestreServiceImpl implements TrimestreService {

	@Autowired
	private ITrimestreRepository trimeRepo;
	
	@Override
	public List<Trimestre> findAll() {
		return trimeRepo.findAll();
	}

	@Override
	public Optional<Trimestre> findById(int id) {
		return trimeRepo.findById(id);
	}

}
