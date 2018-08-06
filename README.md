# ARCHIVE Meetup

**Francais :**

Archive du Projet du site Web "meetup".

Ceci était un de mes projets perso ayant pour but de à mon équipe de paintball de valider la présence des différents membre lors de nos different rassemblement et me permettre de manipuler différente techno.

Le site n'est pas vraiment terminé et ne devrait pas l'être, le besoin n'est plus la, les sources reste ici pour archive. 

C'est une spring boot, Front angularJs, avec une base MongoDB.
L'approche la plus simple possible est priviligiée. 
Le site étant supposé rester privé à l'origne, tout n'est pas forcément concus pour un quelqu'un externe, désolé, il n'est pas prévus de revenir dessus.


**English**

Archive for the website "meetup".

It was one of my pet project that I used to help my paintball team to organize meetup and play with different idea and/or technologie at that time.

It's not under current development anymore, nor it is visible on the web, we don't really need it anymoren, source code is here to be shared and be available.

Most of the comment or concept are in French, it may be a little bit tricky to understand if you don't speak french at all.

It's a springboot application, Front angularJs, MongoDB.
The simplest solutions are preferred throughout the application over maybe better but more complicated solutions.
As the source code was supposed to stay private, everything may not be obvious for someone not familiar with the project and its history, sorry about that but it well may never change.

# OLD README
## Tuto/proc d'install

### Reload spring boot / IntelliJ

* Devtools
* Soit "Make" à la main, soit forcer la compilation auto (explication ici : https://patrickgrimard.io/2016/01/18/spring-boot-devtools-first-look/)
 
## Base de donées

### Install mongo

* Install : `sudo apt-get install mongodb`
* **/!\ Limiter la taille du journal : **
    * Editer `/etc/mongodb.conf` pour ajouter `smallfiles=true`
    * Via CL : `echo smallfiles=true >> /etc/mongodb.conf`
* Démmarrage : ``

### Créer la base 
