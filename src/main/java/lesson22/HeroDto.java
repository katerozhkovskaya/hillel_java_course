package lesson22;

import lombok.ToString;

import java.util.List;

@ToString
public class HeroDto {
    private String name;
    private List<String> movies;

    public HeroDto(String name, List<String> movies) {
        this.name = name;
        this.movies = movies;
    }

    public HeroDto(Builder builder) {
        this.name = builder.name;
        this.movies = builder.movies;
    }

    public String getName() {
        return name;
    }

    public List<String> getMovies() {
        return movies;
    }

    public static class Builder {
        private String name;
        private List<String> movies;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder movies(List<String> movies) {
            this.movies = movies;
            return this;
        }

        public HeroDto build() {
            return new HeroDto(this);
        }
    }
}

