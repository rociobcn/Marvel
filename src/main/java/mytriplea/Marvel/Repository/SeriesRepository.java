package mytriplea.Marvel.Repository;

import mytriplea.Marvel.Model.Personaje;
import mytriplea.Marvel.Model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {
    Optional<Series> findById(long id);
}
