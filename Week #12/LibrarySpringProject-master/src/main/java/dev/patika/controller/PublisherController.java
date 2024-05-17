package dev.patika.controller;

import dev.patika.business.abstracts.CrudService;
import dev.patika.dto.response.PublisherResponse;
import dev.patika.entities.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {

    private final CrudService<Publisher> publisherService;
    private ModelMapper modelMapper;

    @Autowired
    public PublisherController(CrudService<Publisher> publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/{id}")
    public PublisherResponse getById(@PathVariable Long id) {
        return this.modelMapper.map(this.publisherService.getById(id), PublisherResponse.class);

    }

    @GetMapping("")
    public List<PublisherResponse> getAll() {
        return this.publisherService.getAll().stream().map(publisher ->
                this.modelMapper.map(publisher,PublisherResponse.class))
                .collect(Collectors.toList());
    }

    @PostMapping("")
    public Publisher add(@RequestBody Publisher publisher) {
        return publisherService.save(publisher);
    }

    @PutMapping("/{id}")
    public Publisher update(@PathVariable Long id, @RequestBody Publisher publisher) {
        publisher.setId(id);
        return publisherService.update(publisher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        publisherService.delete(id);
    }
}