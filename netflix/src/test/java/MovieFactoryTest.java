import fr.epsi.netflix.Movie;
import fr.epsi.netflix.MovieFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MovieFactoryTest {

    @Test
    public void testCreateMovie() {
        String[] items = {"1", "movie", "The Godfather", "Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan", "USA", "March 1 1972", "1972", "9.2", "175 min", "Crime, Drama", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."};
        MovieFactory movieFactory = MovieFactory.getInstance();
        Movie movie = movieFactory.createMovie(items);

        Assertions.assertEquals("1", movie.getId());
        Assertions.assertEquals("movie", movie.getType());
        Assertions.assertEquals("The Godfather", movie.getTitle());
        Assertions.assertEquals("Francis Ford Coppola", movie.getDirector());
        Assertions.assertEquals("Marlon Brando, Al Pacino, James Caan", movie.getCast());
        Assertions.assertEquals("USA", movie.getCountry());
        Assertions.assertEquals(LocalDate.parse("March 1 1972", movieFactory.getFormatter()), movie.getDateAdded());
        Assertions.assertEquals(1972, movie.getReleaseYear());
        Assertions.assertEquals("9.2", movie.getRating());
        Assertions.assertEquals("175 min", movie.getDuration());
        Assertions.assertEquals("Crime, Drama", movie.getListedIn());
        Assertions.assertEquals("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", movie.getDescription());
    }
}
