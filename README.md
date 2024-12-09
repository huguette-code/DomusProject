# Directa24 Back-End Developer Challenge 

In this challenge, the REST API contains information about a collection of movie released after the year 2010, directed by acclaimed directors.  
Given the threshold value, the goal is to use the API to get the list of the names of the directors with most movies directed. Specifically, the list of names of directors with movie count strictly greater than the given threshold.   
The list of names must be returned in alphabetical order.  

To access the collection of users perform HTTP GET request to:
https://directa24-movies.wiremockapi.cloud/api/movies/search?page=<pageNumber>
where <pageNumber> is an integer denoting the page of the results to return.

For example, GET request to:
https://directa24-movies.wiremockapi.cloud/api/movies/search?page=2
will return the second page of the collection of movies. Pages are numbered from 1, so in order to access the first page, you need to ask for page number 1.
The response to such request is a JSON with the following 5 fields:

- page: The current page of the results  
- per_page: The maximum number of movies returned per page.  
- total: The total number of movies on all pages of the result.  
- total_pages: The total number of pages with results.  
- data: An array of objects containing movies returned on the requested page  

Each movie record has the following schema:  
- Title: title of the movie  
- Year: year the movie was released  
- Rated: movie rating  
- Released: movie release date  
- Runtime: movie duration time in minutes  
- Genre: move genre  
- Director: movie director  
- Writer: movie writers  
- Actors: movie actors  


### Software Used for development
| Software      | Version           |
|---------------|-------------------|
| Eclipse		| 2024-12 (4.34.0)  |
| Maven         | 3.9.9             |
| Java JDK      | 17                |
| Springboot    | 3.4.0             |
| Postman       | 11.13.0           |
| Windows       | 11                |

### Construction instructions

    - Utilizando IDE de trabajo.
        1) Clone el repositorio de git desde la url.
        2) Importar el proyecto a alguna herramienta de desarrollo y correrlo
        3) Importar la colecction de postman ubicada en la carpeta resources del proyecto 
        4) Ejecutar el endpoint entregado.

    - Desde una terminal.
        1) Clone el repositorio de git desde la url.
        2) Correr la instruccion maven (mvn clean install)
        3) Desde una terminal y dentro de la carpeta del proyecto clonada en 1) 
        4) Ejecutar java -jar "target/domus-0.0.1-SNAPSHOT.jar"
        5) Importar la colecction de postman ubicada en la carpeta resources del proyecto 
        6) Ejecutar el endpoint entregado.


