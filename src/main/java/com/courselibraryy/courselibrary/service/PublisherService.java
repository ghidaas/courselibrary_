package com.courselibraryy.courselibrary.service;

import com.courselibraryy.courselibrary.entity.Publishers;
import com.courselibraryy.courselibrary.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.Flow;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

      public List<Publishers> findAllPublishers(){
        return publisherRepository.findAll();
    }
    public Publishers findPublishersById(int publisherId){
        Publishers publisher = publisherRepository.findById(publisherId).orElseThrow(()->new RuntimeException("Publisher not found"));
        return publisher;
    }
    public void cretePublisher(Publishers publisher){

        publisherRepository.save(publisher);
    }
    public void updatePublisher(Publishers publisher){
        publisherRepository.save(publisher);
    }
    public void deletePublisher(int id){
        Publishers publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
        publisherRepository.deleteById(publisher.getId());
    }
}
