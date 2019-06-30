package com.fse.taskmanager.domain;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fse.taskmanager.dto.ParentTaskDto;
import com.fse.taskmanager.entity.ParentTaskEO;
import com.fse.taskmanager.repository.IParentTaskRepository;

@Component
public class ParentTaskDomain implements IParentTaskDomain{

	@Autowired
	private IParentTaskRepository parentTaskRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<ParentTaskDto> getParentTasks() {
		List<ParentTaskEO> parentEo = parentTaskRepo.findAll();

		List<ParentTaskDto> list = parentEo.stream().map(eo -> {
			ParentTaskDto dto = new ParentTaskDto();
			dto.setParentId(eo.getParentId());
			dto.setParentTask(eo.getParentTask());
			return dto;
		}).collect(Collectors.toList());
		return list;
	}
	
}
