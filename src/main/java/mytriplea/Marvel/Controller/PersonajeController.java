package mytriplea.Marvel.Controller;

import mytriplea.Marvel.Dto.PersonajeDTO;
import mytriplea.Marvel.Dto.SeriesDTO;
import mytriplea.Marvel.Model.Personaje;
import mytriplea.Marvel.Model.Series;
import mytriplea.Marvel.Service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/personaje/")
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;

    @GetMapping("all") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public List<Personaje> getAllPersonajes() {
        return personajeService.findAllPersonajes();
    }

    @GetMapping("{id}") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public Personaje getPersonaje(@PathVariable long id) {
        return personajeService.findByIdPersonaje(id);
    }

    @PostMapping("add") @CrossOrigin()
    @ResponseStatus(HttpStatus.CREATED)
    public Personaje addPersonaje(@RequestBody @Valid PersonajeDTO personajeDTO) {
        return personajeService.addPersonaje(personajeDTO);
    }

    @DeleteMapping("{id}") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public void deletePersonaje(@PathVariable long id) {
        personajeService.deletePersonaje(id);
    }

    @PostMapping("addSerie/{id}") @CrossOrigin()
    @ResponseStatus(HttpStatus.CREATED)
    public void addSerie(@PathVariable long id, @RequestBody @Valid SeriesDTO series) {
        personajeService.addSerie(id, series);
        System.out.println("estoy en la llamada---"  + series.getStartYearPublication());
    }
    @GetMapping("theBest") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public List<Personaje> theBest() {return personajeService.topOne();}
    @GetMapping("theBest5") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public List<Personaje> theBest5() {return personajeService.topFive();}

    @GetMapping("allSeries/{id}") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public List<Series> seriesList(@PathVariable long id) {return personajeService.seriesListPersonajes(id);}
}
