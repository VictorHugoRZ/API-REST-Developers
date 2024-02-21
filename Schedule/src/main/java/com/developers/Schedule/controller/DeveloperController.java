package com.developers.Schedule.controller;

import com.developers.Schedule.entity.Developer;
import com.developers.Schedule.service.DeveloperService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/devs/api/v1")
@CrossOrigin("http://localhost:4200")
@Slf4j // <- Annotation to use a logger
public class DeveloperController {

    @Autowired
    DeveloperService developerService;

    @GetMapping //All Devs
    public ResponseEntity<?> getAllDevs() {
        List<Developer> developers = developerService.getAllDevs();
        log.info("Developers: " + developers.toString());
        return ResponseEntity.status(HttpStatus.OK).body(developers);
    }

    @GetMapping("/{id}") //Just one Dev
    public ResponseEntity<?> getDevById(@PathVariable Integer id) {
        Developer developer = developerService.getDevById(id);
        log.info("Developer searched by Id: " + developer.toString());
        return ResponseEntity.status(HttpStatus.OK).body(developer);
    }

    @PostMapping //Create a Dev
    public ResponseEntity<?> postDev(@RequestBody Developer dev) throws Exception {
        Developer developer = developerService.postDev(dev);
        return ResponseEntity.status(HttpStatus.OK).body(developer);
    }

    @PutMapping("/{id}") //Update a Dev
    public ResponseEntity<?> putDevById(@PathVariable Integer id, @RequestBody Developer dev) throws Exception{
        Developer developer = developerService.putDevById(id, dev);
        return ResponseEntity.status(HttpStatus.OK).body(developer);
    }

    @DeleteMapping("/delete/{id}") //Delete a Dev
    public ResponseEntity<?> deleteDev(@PathVariable Integer id) throws Exception {
        developerService.deleteDev(id);
        return ResponseEntity.status(HttpStatus.OK).body("The Developer was successfully removed.");
    }

    /*@GetMapping("/discontinuedRoute")  <-  This is an example of a discontinued route
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "This route is discontinued.")
    public void discontinuedRoute() {}*/
}
