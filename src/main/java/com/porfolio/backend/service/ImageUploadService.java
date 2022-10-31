package com.porfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.backend.model.ImageModel;
import com.porfolio.backend.repository.Imagen2Repository;

@Service
public class ImageUploadService implements IimageUploadService{
	

	@Autowired //anotation que genera una dependencia
	public Imagen2Repository ImgRepository;

	@Override
	public List<ImageModel> getnombres() {
		List<ImageModel>listanombres=ImgRepository.findAll();
		return listanombres;
	}
	
	
	
	
	
	
}
