
import fr.epsi.netflix.HtmlFactory;
import fr.epsi.netflix.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class HtmlFactoryTest {

    @Test
    void generateDetail() {
        HtmlFactory htmlFactory = new HtmlFactory();
        Movie movie = new Movie();
        movie.setTitle("La Belle et la Bête");
        movie.setDescription("Une jeune femme tombe amoureuse d'une bête mystérieuse qui vit dans un château.");
        String expectedHtml = "<!doctype html><head> <meta charset=\"utf-8\"><title>La Belle et la Bête</title></head><body><div><p>Titre</p><p>La Belle et la Bête</p></div><div><p>Desccription</p><p>Une jeune femme tombe amoureuse d'une bête mystérieuse qui vit dans un château.</p></div></body></html>";
        Assertions.assertEquals(expectedHtml, htmlFactory.generateDetail(movie));
    }

    @Test
    void generateHtml() {
        HtmlFactory htmlFactory = new HtmlFactory();
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie();
        movie1.setId("1");
        movie1.setType("Film");
        movie1.setTitle("La Belle et la Bête");
        movie1.setDirector("Bill Condon");
        movie1.setCountry("États-Unis");
        movie1.setDateAdded(LocalDate.parse("2018-09-19", DateTimeFormatter.ISO_LOCAL_DATE));
        movies.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId("2");
        movie2.setType("Série");
        movie2.setTitle("La Casa de Papel");
        movie2.setDirector("Álex Pina");
        movie2.setCountry("Espagne");
        movie2.setDateAdded(LocalDate.parse("2021-07-02", DateTimeFormatter.ISO_LOCAL_DATE));
        movies.add(movie2);

        String expectedHtml = "<!doctype html><head> <meta charset=\"utf-8\"><title>Films/Series</title></head><body><style> table, table tr, table td, table th {border:1px solid black;border-collapse:collapse}</style><table><tr><th>id</th><th>type</th><th>titre</th><th>Réalisateur</th><th>Pays</th><th>Date</th><th>Detail</th></tr><tr><td>1</td><td>Film</td><td>La Belle et la Bête</td><td>Bill Condon</td><td>États-Unis</td><td>2018-09-19</td><td><a href='movies/1.html'>detail</td></tr><tr><td>2</td><td>Série</td><td>La Casa de Papel</td><td>Álex Pina</td><td>Espagne</td><td>2021-07-02</td><td><a href='movies/2.html'>detail</td></tr></table></body></html>";
        Assertions.assertEquals(expectedHtml, htmlFactory.generateHtml(movies));
    }
}
