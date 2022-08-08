package mytriplea.Marvel.Model;

import mytriplea.Marvel.Dto.SeriesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

import java.util.List;

@Entity
public class Personaje {
    @Id
    private long id;

    private String name;

    @Column(length = 2000)
    private String description;

    private String thumbnailPath;

    private String thumbnailExtension;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name = "personajes_series",
            joinColumns = @JoinColumn(name = "personajeId"),
            inverseJoinColumns = @JoinColumn(name = "seriesId"))
    private List<Series> seriesList = new ArrayList<Series>();

    public Personaje() {}

    public Personaje(long id, String name, String description, String thumbnailPath, String thumbnailExtension) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailPath = thumbnailPath;
        this.thumbnailExtension = thumbnailExtension;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getThumbnailExtension() {
        return thumbnailExtension;
    }

    public void setThumbnailExtension(String thumbnailExtension) {
        this.thumbnailExtension = thumbnailExtension;
    }

    public List<Series> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<Series> seriesList) {
        this.seriesList = seriesList;
    }

    public void addSeries(Series series) {
        System.err.println(series.getStartYearPublication());
        this.seriesList.add(series);
        series.getPersonajesList().add(this);
    }
    public int sizeList(List <Series> lista){
        int size = lista.size();
        return size;
    }

}
