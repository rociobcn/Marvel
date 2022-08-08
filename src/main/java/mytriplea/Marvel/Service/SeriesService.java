package mytriplea.Marvel.Service;

import mytriplea.Marvel.Dto.PersonajeDTO;
import mytriplea.Marvel.Dto.SeriesDTO;
import mytriplea.Marvel.Model.Personaje;
import mytriplea.Marvel.Model.Series;
import mytriplea.Marvel.Repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeriesService {

    @Autowired
    SeriesRepository seriesRepository;

    public List<Series> findAllSeries(){ return seriesRepository.findAll();}

    public void deleteSeries(long id){seriesRepository.deleteById(id);}

    public Series findByIdSeries(long id){
        if (seriesRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Lo sentimos, no existe ninguna serie en nuestra base de datos con este id.");
        }
        return seriesRepository.findById(id).get();
    }
    public Series addSeries(SeriesDTO seriesDTO){
        System.out.println(seriesDTO.getTitle());
        if (seriesRepository.findById(seriesDTO.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Esta serie ya está almacenada en nuestra base de datos.");
        }
        return seriesRepository.save(new Series(seriesDTO.getId(), seriesDTO.getTitle(), seriesDTO.getDescription(), seriesDTO.getStartYearPublication(),
                seriesDTO.getThumbnailPath(), seriesDTO.getThumbnailExtension()));
    }

    public List <Personaje> getListPersonajes(long id){
        if (seriesRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Lo sentimos, no existe ninguna serie en nuestra base de datos con este id.");
        }
        return seriesRepository.findById(id).get().getPersonajesList();
    }
    public void deleteSeriesVacias() {
        List<Series> seriesList = seriesRepository.findAll();
        for (Series serie : seriesList) {
            if (serie.getPersonajesList().isEmpty()) {
                seriesRepository.delete(serie);
            }
        }
    }

}
