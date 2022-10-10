package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRepository.getReferenceById(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //TODO: check for children records before deleting
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        // A PUT will replace all the attributes of the record that you are updating -> A new object is created.
        // A PATCH will allow us to update only a portion of the record              -> An existing object is modified.
        // Because it is a PUT, we expect all attributes to be passed in. If they're not, they will be updated with null
        // A PATCH would only need data about the part that we are updating.

        // TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload error

        Speaker existingSpeaker = speakerRepository.getReferenceById(id);

        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        // 3rd param: we don't want to replace/overwrite speaker_id (PK) field of the existingSpeaker

        return speakerRepository.saveAndFlush(existingSpeaker);
    }


}
