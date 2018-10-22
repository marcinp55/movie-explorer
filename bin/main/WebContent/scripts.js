$(document).ready(function() { 
    var apiRoot = 'https://agile-temple-78913.herokuapp.com/movies/';
    var movieDbImgBaseUrl = 'http://image.tmdb.org/t/p/';

    $('[data-movie-search-id-button]').on('click', searchById);

    function searchById() {
        var movieId = $('[data-movie-search-id-input]').val();
        
        $('[data-movie-core-info-container]').children().html('');
        $('[data-movie-basic-info-list]').children().html('');
        $('[data-movie-additional-info-list]').children().html('');

        $.ajax({
            url: apiRoot + movieId,
            method: 'GET',
            dataType: 'json',
            success: function(data) {
                $('[data-movie-title]').html(data.title);
                $('[data-movie-poster]').attr('src', movieDbImgBaseUrl + 'w185/' + data.poster_path);
                $('[data-movie-id]').html('#' + data.id);
                $('[data-movie-original-language]').append('Original language: ' + data.original_language);
                $('[data-movie-budget]').append('Budget: ' + data.budget);
                $('[data-movie-revenue]').append('Revenue: ' + data.revenue);
                $('[data-movie-status]').append('Status: ' + data.status);
                $('[data-movie-original-title]').append('Original title: ' + data.original_title);
                $('[data-movie-popularity]').append('Popularity: ' + data.popularity);
                $('[data-movie-homepage-link]').attr('href', data.homepage);
                $('[data-movie-release-date]').append('Release date: ' + data.release_date);
                $('[data-movie-vote-count]').append('Vote count: ' + data.vote_count);
                $('[data-movie-vote-average]').append('Vote average: ' + data.vote_average);
    
                if(data.adult === false) {
                    $('[data-movie-adult]').html('All ages');
                } else {
                    $('[data-movie-adult]').html('+18');
                }
    
                if(data.tagline !== null && data.tagline !== '') {
                    $('[data-movie-tagline]').append(data.tagline);
                } else {
                    $('[data-movie-tagline]').hide();
                }
    
                if(data.imbd_id !== null && data.imbd_id !== '') {
                    $('[data-movie-imdb-id]').append('IMDB ID: ' + data.imdb_id);
                } else {
                    $('[data-movie-imdb-id]').hide();
                }
    
                if(data.overview !== null && data.overview !== '') {
                    $('[data-movie-overview]').append('Overview: ' + data.overview);
                } else {
                    $('[data-movie-overview]').hide();
                }
    
                if(data.homepage !== null && data.homepage !== '') {
                    $('[data-movie-homepage-link]').html('Home page: ' + data.homepage);
                } else {
                    $('[data-movie-homepage]').hide();
                }
                
                if(data.runtime !== null && data.runtime !== 0) {
                    $('[data-movie-runtime]').html(data.runtime + ' minutes');
                } else {
                    $('[data-movie-runtime]').hide();
                }
    
                $('[data-movie-genres]').append('Genres: ');

                $.each(data.genres, function(index) {
                    $('[data-movie-genres]').append(this.name);
                    if(index !== data.genres.length - 1) {
                        $('[data-movie-genres]').append(', ');
                    }
                })

                $('[data-movie-spoken-languages]').append('Spoken languages: ');
    
                $.each(data.spoken_languages, function(index) {
                    $('[data-movie-spoken-languages]').append(this.name);
                    if(index !== data.spoken_languages.length - 1) {
                        $('[data-movie-spoken-languages]').append(', ');
                    }
                })
    
                $('[data-movie-production-countries]').append('Production countries: ');

                $.each(data.production_countries, function(index) {
                    $('[data-movie-production-countries]').append(this.name);
                    if(index !== data.production_countries.length - 1) {
                        $('[data-movie-production-countries]').append(', ');
                    }
                })
    
                $('[data-movie-production-companies]').append('Production companies: ');

                $.each(data.production_companies, function(index) {
                    $('[data-movie-production-companies]').append(this.name);
                    if(index !== data.production_companies.length - 1) {
                        $('[data-movie-production-companies]').append(', ');
                    }
                })
            }
        });
    }
});