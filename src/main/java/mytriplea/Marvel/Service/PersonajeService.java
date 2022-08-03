package mytriplea.Marvel.Service;

import mytriplea.Marvel.Dto.PersonajeDTO;
import mytriplea.Marvel.Dto.SeriesDTO;
import mytriplea.Marvel.Model.Personaje;
import mytriplea.Marvel.Model.Series;
import mytriplea.Marvel.Repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;

    public List<Personaje> findAllPersonajes(){ return personajeRepository.findAll();}

    public void deletePersonaje(long id){personajeRepository.deleteById(id);}

    public Personaje findByIdPersonaje(long id){
        if (personajeRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Lo sentimos, no tenemos a este personaje en nuestra base de datos con este id.");
        }
        return personajeRepository.findById(id).get();
    }
    public Personaje addPersonaje(PersonajeDTO personajeDTO){
        if (personajeRepository.findById(personajeDTO.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Este personaje ya existe en nuestra base de datos.");
        }
        return personajeRepository.save(new Personaje(personajeDTO.getId(), personajeDTO.getName(), personajeDTO.getDescription(),
                personajeDTO.getThumbnailPath(), personajeDTO.getThumbnailExtension()));
    }
    public void addList(long id, Series series){
        if (!personajeRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Este personaje no existe en nuestra base de datos.");
        }
        personajeRepository.findById(id).get().addSeries(series);
        personajeRepository.save(personajeRepository.findById(id).get());
    }

    public List <Personaje> topOne(){
        List <Personaje> listPersonajes = personajeRepository.findAll();
        //listPersonajes.sort((a, b) -> a.getSeriesList().size().compareTo(b.getSeriesList().size()));
        //listPersonajes.sort(Comparator.comparingInt(List::size).reversed().limit(5));
        //List <List<Series>> theBests = new ArrayList<>();
        List <Personaje> theBests = new ArrayList<>();
        for (Personaje personaje: listPersonajes) {
            if(!theBests.isEmpty()){
                if(personaje.getSeriesList().size() > theBests.get(0).getSeriesList().size()){
                    theBests.remove(theBests.get(0));
                    theBests.add(personaje);

                }
            } else {
                theBests.add(personaje);
            }

        }
        return theBests;
    }
    public List <Personaje> topFive(){
        List <Personaje> listPersonajes = personajeRepository.findAll();
        List <Personaje> theBests = new ArrayList<>();
        List <Integer> size = new ArrayList<>();
        for (Personaje personaje: listPersonajes) {
           size.add(personaje.sizeList(personaje.getSeriesList()));
           Collections.sort(size, Collections.reverseOrder());
           if(personaje.getSeriesList().size() == size.get(0) || personaje.getSeriesList().size() == size.get(1)
           || personaje.getSeriesList().size() == size.get(2) || personaje.getSeriesList().size() == size.get(3)
           || personaje.getSeriesList().size() == size.get(4)) {
               theBests.add(personaje);
           };


        }
        return theBests;
    }



}
