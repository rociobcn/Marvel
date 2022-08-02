package mytriplea.Marvel;

import mytriplea.Marvel.Model.Series;
import mytriplea.Marvel.Model.Personaje;
import mytriplea.Marvel.Repository.SeriesRepository;
import mytriplea.Marvel.Repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class MarvelApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApplication.class, args);
	}
	@Autowired
	SeriesRepository seriesRepository;

	@Autowired
	PersonajeRepository personajeRepository;

	@Override
	public void run(String... args) throws Exception {

		Personaje personaje1 = personajeRepository.save(new Personaje(1011334, "3-D Man", "","http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784", "jpg"));
		Personaje personaje2 = personajeRepository.save(new Personaje(1017100, "A-Bomb (HAS)", "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ",
				"http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16", "jpg"));
		Series series1 = seriesRepository.save(new Series(3374, "Hulk (2008 - 2012)", "General Thunderbolt Ross spent years hunting the Hulk, but now he's become one himself! As the rampaging Red Hulk, Ross strives to reconcile the man he used to be with the monster he's becomes, smashing anything that moves along the way!",
				2008, "http://i.annihil.us/u/prod/marvel/i/mg/2/d0/5137710f56aa1", "jpg"));
		Series series2 = seriesRepository.save(new Series(17765, "FREE COMIC BOOK DAY 2013 1 (2013)", null, 2013, "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available", "jpg"));
		Series series3 = seriesRepository.save(new Series(2045, "Marvel Premiere (1972 - 1981)", null, 1972, "http://i.annihil.us/u/prod/marvel/i/mg/4/40/5a98437953d4e", "jpg" ));
		Series series4 = seriesRepository.save(new Series(2005, "Deadpool (1997 - 2002)", "Wade Wilson: Heartless Merc With a Mouth or...hero? Laugh, cry and applaud at full volume for the mind-bending adventures of Deadpool, exploring the psyche and crazed adventures of Marvel's most unstable personality!",
				 1997, "http://i.annihil.us/u/prod/marvel/i/mg/7/03/5130f646465e3", "jpg"));
		Series series5 = seriesRepository.save(new Series(1945, "Avengers: The Initiative (2007 - 2010)", null, 2007, "http://i.annihil.us/u/prod/marvel/i/mg/5/a0/514a2ed3302f5", "jpg"));

		personaje1.addSeries(series3);
		personaje1.addSeries(series4);
		personaje1.addSeries(series5);
		personajeRepository.save(personaje1);
		personaje2.addSeries(series1);
		personaje2.addSeries(series2);
		personajeRepository.save(personaje2);



	}
}

