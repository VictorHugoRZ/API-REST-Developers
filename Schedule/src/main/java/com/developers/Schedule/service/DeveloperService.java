package com.developers.Schedule.service;

import com.developers.Schedule.entity.Developer;
import com.developers.Schedule.repository.IDeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DeveloperService implements IDeveloperService{

    @Autowired
    IDeveloperRepository developerRepository;

    @Override
    public List<Developer> getAllDevs() {
        return this.developerRepository.findAll();
    }

    @Override
    public Developer getDevById(Integer idDev) {
        return this.developerRepository.findById(idDev).orElse(null);
    }

    @Override
    public Developer postDev(Developer dev) throws Exception {
        Developer developer = new Developer();

        if (Objects.nonNull(dev.getNickname()) && !"".equalsIgnoreCase(dev.getNickname())) {
            developer.setNickname(dev.getNickname());
        } else {
            throw new Exception("NickName field is empty.");
        }
        if (Objects.nonNull(dev.getName()) && !"".equalsIgnoreCase(dev.getName())) {
            developer.setName(dev.getName());
        } else {
            throw new Exception("Name field is empty.");
        }
        if (Objects.nonNull(dev.getPhone()) && !"".equalsIgnoreCase(dev.getPhone())) {
            developer.setPhone(dev.getPhone());
        } else {
            throw new Exception("Phone field is empty.");
        }
        if (Objects.nonNull(dev.getEmail()) && !"".equalsIgnoreCase(dev.getEmail())) {
            developer.setEmail(dev.getEmail());
        } else {
            throw new Exception("Email field is empty.");
        }
        if (dev.getLanguages().isEmpty()) {
            throw new Exception("Languages field is empty.");
        } else {
            developer.setLanguages(dev.getLanguages());
        }
        if (dev.getTechnologies().isEmpty()) {
            throw new Exception("Technologies field is empty.");
        } else {
            developer.setTechnologies(dev.getTechnologies());
        }
        return developerRepository.save(developer);
    }

    @Override
    public Developer putDevById(Integer idDev, Developer dev) throws Exception {
        Developer developer = developerRepository.findById(idDev).get();

        if (Objects.nonNull(dev.getNickname()) && !"".equalsIgnoreCase(dev.getNickname())) {
            developer.setNickname(dev.getNickname());
        } else {
            throw new Exception("NickName field is empty.");
        }
        if (Objects.nonNull(dev.getName()) && !"".equalsIgnoreCase(dev.getName())) {
            developer.setName(dev.getName());
        } else {
            throw new Exception("Name field is empty.");
        }
        if (Objects.nonNull(dev.getPhone()) && !"".equalsIgnoreCase(dev.getPhone())) {
            developer.setPhone(dev.getPhone());
        } else {
            throw new Exception("Phone field is empty.");
        }
        if (Objects.nonNull(dev.getEmail()) && !"".equalsIgnoreCase(dev.getEmail())) {
            developer.setEmail(dev.getEmail());
        } else {
            throw new Exception("Email field is empty.");
        }
        if (dev.getLanguages().isEmpty()) {
            throw new Exception("Languages field is empty.");
        } else {
            developer.setLanguages(dev.getLanguages());
        }
        if (dev.getTechnologies().isEmpty()) {
            throw new Exception("Technologies field is empty.");
        } else {
            developer.setTechnologies(dev.getTechnologies());
        }
        developerRepository.save(developer);
        return developer;
    }

    @Override
    public void deleteDev(Integer idDev) throws Exception {
        Optional<Developer> developer = this.developerRepository.findById(idDev);
        if (developer.isPresent()) {
            this.developerRepository.deleteById(idDev);
        } else {
            throw new Exception("The Object you want to delete does not exist.");
        }
    }
}
