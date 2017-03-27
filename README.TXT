
Introduction
============
Greetings!
This project is a bare-bones Spring Boot MVC website using the FreeMarker templating engine.
It is intended to be a simple (and fun) online quiz application! :-)


Build and Run
=============
The project is built with Maven with and can be packaged like so;
$ mvn clean package

The site can be run from the main class;
com.totaljobsgroup.quiz.QuizApplication

Or executed from the runnable jar;
$ java -jar quiz-0.0.1-SNAPSHOT.jar


Version Control
===============
The project is under "git" version control (only local, there is no remote), feel free to commit to the local
repository during your development.


Features to Implement
=====================
Please try adding the following features (feel free to make any code improvements / refactoring you deem necessary);

1) Feature One
As an end-user,
I want the questions given in the question repository listed on the "/questions" page,
So that I can see what questions are available in the repository.

2) Feature Two
As an end-user,
I want a text-box underneath each question with a submit button for the whole page,
So that I can enter my answers and submit them to be scored.

3) Feature Three
As an end-user,
I want my answers to be checked (on the server) and a final score displayed (e.g. "You scored 3 out of 4!"),
So that I know how many of the answers I entered are correct.


Good luck!
