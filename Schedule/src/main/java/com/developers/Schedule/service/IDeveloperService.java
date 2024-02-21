package com.developers.Schedule.service;

import com.developers.Schedule.entity.Developer;

import java.util.List;

public interface IDeveloperService {
    public List<Developer> getAllDevs();

    public Developer getDevById(Integer idDev);

    public Developer putDevById(Integer idDev, Developer dev) throws Exception;

    public Developer postDev(Developer dev) throws Exception;

    public void deleteDev(Integer idDev) throws Exception;
}
