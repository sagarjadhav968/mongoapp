package com.desire3d.progma.command.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desire3d.progma.fw.command.repository.SQLDefinationRepository;
import com.desire3d.progma.model.ModelDefination;
import com.desire3d.progma.model.NewFieldDefination;
import com.desire3d.progma.model.SQLDefination;

@RestController
@RequestMapping(value = "/sql")
public class SQLDefinationController {

	@Autowired
	private SQLDefinationRepository definationRepository;

	@PostMapping(value = "/save")
	public void save(@RequestBody SQLDefination projectDefinitionDto) {
		try {
			if (projectDefinitionDto.getId() != null) {
				SQLDefination defination = definationRepository.findById(projectDefinitionDto.getId());
				defination.setName(projectDefinitionDto.getName());
				defination.setModelDefination(defination.getModelDefination());
				defination.setParams(projectDefinitionDto.getParams());
				defination.setSql(projectDefinitionDto.getSql());
				ModelDefination modelDefination = projectDefinitionDto.getModelDefination();
				for (Iterator<NewFieldDefination> iterator = defination.getModelDefination().getNewFieldDefination()
						.iterator(); iterator.hasNext();) {
					NewFieldDefination fieldDefination = (NewFieldDefination) iterator.next();
					for (Iterator<NewFieldDefination> iterator2 = modelDefination.getNewFieldDefination()
							.iterator(); iterator2.hasNext();) {
						NewFieldDefination fieldDefination2 = (NewFieldDefination) iterator2.next();
						if (fieldDefination2.getNewfieldname().equals(fieldDefination.getNewfieldname())) {
							NewFieldDefination newFieldDefination = definationRepository
									.findByFieldId(fieldDefination.getId());
							// SET UPDATED DATA
							newFieldDefination.setNewfieldname("NEW UPDATED VALUE");
							definationRepository.saveNewFieldDefination(newFieldDefination);
						}
					}

				}
				definationRepository.saveOrUpdate(defination);
			} else {
				definationRepository.saveOrUpdate(projectDefinitionDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GetMapping(value = "/{id}")
	public SQLDefination save(@PathVariable("id") String id) {
		SQLDefination defination = null;
		try {
			defination = definationRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defination;

	}
}
