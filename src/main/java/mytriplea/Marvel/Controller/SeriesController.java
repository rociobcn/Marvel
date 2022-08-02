package mytriplea.Marvel.Controller;

import mytriplea.Marvel.Dto.PersonajeDTO;
import mytriplea.Marvel.Dto.SeriesDTO;
import mytriplea.Marvel.Model.Personaje;
import mytriplea.Marvel.Model.Series;
import mytriplea.Marvel.Service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.event.PaintEvent;
import java.util.List;

@RestController
@RequestMapping("api/series/")
public class SeriesController {

    @Autowired
    SeriesService seriesService;

    @GetMapping("all") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public List<Series> getAllSeries() {
        return seriesService.findAllSeries();
    }

    @GetMapping("{id}") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public Series getSeries(@PathVariable long id) {
        return seriesService.findByIdSeries(id);
    }

    @PostMapping("add") @CrossOrigin()
    @ResponseStatus(HttpStatus.CREATED)
    public Series addSeries(@RequestBody @Valid SeriesDTO seriesDTO) {
        return seriesService.addSeries(seriesDTO);
    }

    @DeleteMapping("{id}") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public void deleteSeries(@PathVariable long id) {
        seriesService.deleteSeries(id);
    }

    @GetMapping("list/{id}") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public List<Personaje> getAllSeries(@PathVariable long id) {
        return seriesService.getListPersonajes(id);
    }
}
