package mytriplea.Marvel.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Series {

        @Id
        private long id;
        @Column(length = 2000)
        private String title;
        @Column(length = 2000)
        private String description;

        private int startYearPublication;


        private String thumbnailPath;

        private String thumbnailExtension;

        @ManyToMany(mappedBy = "seriesList")
        @JsonIgnore
        private List<Personaje> personajesList =new ArrayList<Personaje>();

        public Series() {}

        public Series(long id, String title, String description, int startYearPublication, String thumbnailPath, String thumbnailExtension) {
                this.id = id;
                this.title = title;
                this.description = description;
                this.startYearPublication = startYearPublication;
                this.thumbnailPath = thumbnailPath;
                this.thumbnailExtension = thumbnailExtension;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public int getStartYearPublication() { return startYearPublication; }

        public void setStartYearPublication(int startYearPublication) { this.startYearPublication = startYearPublication; }

        public String getThumbnailPath() { return thumbnailPath;}

        public void setThumbnailPath(String thumbnailPath) { this.thumbnailPath = thumbnailPath; }

        public String getThumbnailExtension() { return thumbnailExtension; }

        public void setThumbnailExtension(String thumbnailExtension) { this.thumbnailExtension = thumbnailExtension; }

        public List<Personaje> getPersonajesList() { return personajesList; }

        public void setPersonajesList(List<Personaje> personajesList) { this.personajesList = personajesList; }
}
