# MovieHubBackend
This is the backend for a website called Moviehub that allows users to review movies and tv shows. This is a student project for Java Web Programing. <br>
<p>To see the frontend of the project visit https://github.com/Futurespast/MovieHubFrontend </p>

<p> In order to run the website you'll need to have both the fronend and back and code. You'll need to run both in the IDE and you'll have to make sure the api is running on Port 8080.</p>

<p> I wasn't able to get the edit review to work so that's something that I would like to have implemented in the future. Another thing to improve upon is the visual look of the website. There's probably other quality of life improvements that could be implemented. </p>

<h3> Brief Explanation of the Class Structure </h3>

<p> The Reviews are dependent on the Movie class, it has a many to one relationship, where many reviews can belong to one Movie. 
This is the basis of the project and needs to be taken into consideration when doing anything to the project. The Movie entity has the following attributes: 
<br> <ul> <li> id: it's the primary key of Movie </li> <li> Title: this is the title of the movie, it's a string </li> <li> Type: this is the type, either movie or tv show
</li> <li> Genre: the genre of the movie </li> <li> Description: description of the movie </li> </ul>

The review entity has the following attributes:

<ul> <li> id: the id of the review </li> <li> Content: the content of the review </li> <li> Rating: the numbered rating of the review </li> <li> Movie Id: foreign key of the movie it belongs to </li>
</ul>

<h3> Entity Relationship Diagram </h3>


<h3> Endpoints </h3>

<ul>
<li> Get:  /api/Movies  This gets all the the movies. </li>

<li> Get: /api/Movies/id This gets the movie of that id </li>

<li> post: /api/Movies/ this adds a movie </li>

<li> put: /api/Movies/id this edits a movie of that id </li>

<li> delete: /api/Movies/id this deletes a movie of that id </li>

<li> get: /api/Movies/id/reviews this gets all the reviews of that movie </li>

<li> post: /api/Movies/id/reviews this adds a review to that movie </li>

<li> get: /api/reviews/id gets a specific review. </li>

<li> put: /api/reviews/id edits a review </li>

<li> delete /api/reviews/id deletes a review </li>

</ul>

To find a detailed explanation of the website and the frontend please refer to the read me file of this repository: https://github.com/Futurespast/MovieHubFrontend

