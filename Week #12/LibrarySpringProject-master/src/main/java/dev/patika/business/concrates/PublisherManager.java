package dev.patika.business.concrates;

import dev.patika.business.abstracts.CrudService;
import dev.patika.entities.Publisher;
import dev.patika.repository.IPublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherManager implements CrudService<Publisher> {

    private final IPublisherRepository ipublisherRepository;

    @Autowired
    public PublisherManager(IPublisherRepository ipublisherRepository) {
        this.ipublisherRepository = ipublisherRepository;
    }

    @Override
    public Publisher getById(Long id) {
        return ipublisherRepository.findById(id).orElse(null);
    }

    @Override
    public List<Publisher> getAll() {
        return ipublisherRepository.findAll();
    }

    @Override
    public Publisher save(Publisher entity) {
        return ipublisherRepository.save(entity);
    }

    @Override
    public Publisher update(Publisher publisher) {
        // Assuming that the entity is managed and updated elsewhere
        return ipublisherRepository.save(publisher);
    }

    @Override
    public String delete(Long id) {
        ipublisherRepository.deleteById(id);
        return null;
    }
}